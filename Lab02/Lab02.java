import java.util.*;

public class Lab02 {
    private static final int WINDOW_SIZE = 4, TOTAL_PACKETS = 10;

    static void sender() {
        Queue<Integer> window = new LinkedList<>();
        int next = 0;
        while (next < TOTAL_PACKETS || !window.isEmpty()) {
            while (window.size() < WINDOW_SIZE && next < TOTAL_PACKETS) {
                window.add(next);
                System.out.println("Sent packet: " + next);
                next++;
            }
            if (!window.isEmpty()) {
                System.out.println("Acknowledgment received for packet: " + window.poll());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("All packets sent and acknowledged.");
    }

    public static void main(String[] args) {
        sender();
    }
}
