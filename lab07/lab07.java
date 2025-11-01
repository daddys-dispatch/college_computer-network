import java.util.*;

public class Lab07 {
    private static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter bucket size: ");
        int cap = sc.nextInt();

        System.out.print("Enter operation rate: ");
        int process = sc.nextInt();

        System.out.print("Enter number of seconds to simulate: ");
        int nsec = sc.nextInt();

        System.out.println();
        int[] packets = new int[nsec];
        for (int i = 0; i < nsec; i++) {
            System.out.print("Enter size of packet at second " + (i + 1) + ": ");
            packets[i] = sc.nextInt();
        }

        System.out.println("\nSec | Recv | Sent | Left | Dropped");
        System.out.println("----------------------------------");

        int count = 0, drop;
        for (int i = 0; i < nsec || count > 0; i++) {
            int recv = (i < nsec) ? packets[i] : 0;
            count += recv;
            drop = Math.max(0, count - cap);
            count = Math.min(count, cap);

            int sent = min(count, process);
            count -= sent;

            System.out.printf("%3d | %4d | %4d | %4d | %7d%n", i + 1, recv, sent, count, drop);
        }
        sc.close();
    }
}
