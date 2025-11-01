import java.net.*;

public class Lab05_Server {
    public static void main(String[] args) {
        final int PORT = 6788;
        System.out.println("UDP Server running on port " + PORT + "...");

        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);

                String msg = new String(request.getData(), 0, request.getLength());
                System.out.println("Received: " + msg);

                byte[] replyData = (msg + " server processed").getBytes();
                socket.send(new DatagramPacket(replyData, replyData.length, request.getAddress(), request.getPort()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
