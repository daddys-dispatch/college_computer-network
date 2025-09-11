import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter File Name: ");
        String filename = sc.nextLine();
        sc.close();
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");
            while (true) {
                try (Socket socket = serverSocket.accept();
                        DataInputStream din = new DataInputStream(socket.getInputStream());
                        DataOutputStream dout = new DataOutputStream(socket.getOutputStream())) {
                    System.out.println("Connected: " + socket.getInetAddress());
                    String request = din.readUTF();
                    if (!"start".equals(request)) {
                        dout.writeUTF("Invalid request");
                        continue;
                    }
                    File file = new File(filename);
                    if (!file.exists()) {
                        dout.writeUTF("File not found");
                        continue;
                    }
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
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
        }
    }
}
