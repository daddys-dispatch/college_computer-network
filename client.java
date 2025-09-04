import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Server Address: ");
        String address = sc.nextLine();

        // Create socket on port 5000
        Socket s = new Socket(address, 5000);

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Send 'start' to begin...");

        String str = "";
        try {
            while (!str.equals("start")) {
                str = br.readLine();
            }

            dout.writeUTF(str);
            dout.flush();

            String filename = din.readUTF();

            if (filename.equals("File not found") || filename.equals("Invalid request")) {
                System.out.println(filename);
                din.close();
                dout.close();
                s.close();
                sc.close();
                return;
            }

            System.out.println("Receiving file: " + filename);
            filename = "client_" + filename;
            System.out.println("Saving as file: " + filename);

            long fileSize = Long.parseLong(din.readUTF());
            System.out.println("File Size: " + (fileSize / (1024 * 1024)) + " MB");

            byte[] buffer = new byte[1024];
            try (FileOutputStream fos = new FileOutputStream(new File(filename))) {
                int bytesRead;
                long totalBytesRead = 0;

                while (totalBytesRead < fileSize && (bytesRead = din.read(buffer, 0, buffer.length)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                    totalBytesRead += bytesRead;
                }
            }
            System.out.println("File received successfully.");

            din.close();
            dout.close();
            s.close();
            sc.close();
        } catch (EOFException e) {
            System.out.println("Connection closed.");
        }
    }
}
