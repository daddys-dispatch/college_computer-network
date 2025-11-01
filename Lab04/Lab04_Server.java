import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Lab04_Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter File Name: ");
        String filename = sc.nextLine();
        sc.close();

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");
            try (Socket socket = serverSocket.accept();
                    DataInputStream din = new DataInputStream(socket.getInputStream());
                    DataOutputStream dout = new DataOutputStream(socket.getOutputStream())) {

                System.out.println("Connected: " + socket.getInetAddress());
                String request = din.readUTF();

                if (!"start".equals(request)) {
                    dout.writeUTF("Invalid request");
                } else {
                    File file = new File(filename);
                    if (!file.exists()) {
                        dout.writeUTF("File not found");
                    } else {
                        System.out.println("Sending file: " + file.getName());
                        System.out.println("File size: " + (file.length() / (1024 * 1024)) + " MB");
                        dout.writeUTF(file.getName());
                        dout.writeUTF(Long.toString(file.length()));

                        try (FileInputStream fin = new FileInputStream(file)) {
                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = fin.read(buffer)) != -1) {
                                dout.write(buffer, 0, bytesRead);
                            }
                        }
                        System.out.println("File sent successfully.");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Server exiting.");
    }
}
