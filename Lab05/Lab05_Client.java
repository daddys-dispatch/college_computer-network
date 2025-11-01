import java.net.*;
import java.util.Scanner;

public class Lab05_Client {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(); Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the message: ");
            byte[] data = sc.nextLine().getBytes();
            InetAddress host = InetAddress.getByName("127.0.0.1");
            DatagramPacket request = new DatagramPacket(data, data.length, host, 6788);
            socket.send(request);

            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            socket.receive(reply);

            System.out.println("Sent: " + new String(request.getData(), 0, request.getLength()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
