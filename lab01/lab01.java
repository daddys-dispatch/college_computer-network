import java.util.*;

public class lab01 {
    void div(int a[], int k) {
        int gp[] = { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 };
        for (int i = 0; i < k; i++)
            if (a[i] == 1)
                for (int j = 0; j < gp.length; j++)
                    a[i + j] ^= gp[j];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[100], b[] = new int[100];
        System.out.print("Enter the length of Data Frame: ");
        int len = sc.nextInt();
        System.out.println("Enter the Message: ");
        for (int i = 0; i < len; i++)
            a[i] = sc.nextInt();

        int originalLen = len;
        for (int i = 0; i < 16; i++)
            a[len++] = 0;

        int k = originalLen;
        System.arraycopy(a, 0, b, 0, len);

        lab01 ob = new lab01();
        ob.div(a, k);

        System.out.print("Data to be transmitted: ");
        for (int i = 0; i < originalLen; i++)
            System.out.print(b[i]);
        for (int i = originalLen; i < len; i++)
            System.out.print(a[i]);
        System.out.println();

        System.out.println("Enter the Received Data: ");
        String received = sc.next();
        for (int i = 0; i < len; i++)
            a[i] = received.charAt(i) - '0';

        ob.div(a, k);

        int flag = 0;
        for (int i = 0; i < len; i++)
            if (a[i] != 0) {
                flag = 1;
                break;
            }

        System.out.println(flag == 1 ? "ERROR in data" : "NO ERROR");
        sc.close();
    }
}
