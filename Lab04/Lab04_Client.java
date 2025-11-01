import java.io.*;
import java.net.*;
import java.util.Scanner;

class Lab04_Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Server Address: ");
        String address = sc.nextLine();

        try (Socket s = new Socket(address, 5000);
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Type 'start' to request file...");
            String str;
            while (!(str = br.readLine()).equals("start"))
                ;

            dout.writeUTF(str);

            String filename = din.readUTF();
            if ("File not found".equals(filename) || "Invalid request".equals(filename)) {
                System.out.println("Server response: " + filename);
                return;
            }
            long size = Long.parseLong(din.readUTF());
            System.out.println("Receiving file: " + filename + " (" + (size / (1024 * 1024)) + " MB)");
            System.out.println("Saving as file: received_" + filename);

            try (FileOutputStream fos = new FileOutputStream("client_" + filename)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                long totalRead = 0;
                while ((bytesRead = din.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                    totalRead += bytesRead;
                    if (totalRead >= size)
                        break;
                }
            }
            System.out.println("File received successfully.");
        }
        sc.close();
    }
}
