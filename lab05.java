import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class lab05 {
    private BigInteger p, q, N, phi, e, d;
    private int bitlength = 512;
    private Random r = new Random();

    public lab05() {
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength / 2, r);
        while (!phi.gcd(e).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);

        System.out.println("Prime p: " + p);
        System.out.println("Prime q: " + q);
        System.out.println("Public key (e): " + e);
        System.out.println("Private key (d): " + d);
    }

    public byte[] encrypt(byte[] message) {
        return new BigInteger(message).modPow(e, N).toByteArray();
    }

    public byte[] decrypt(byte[] message) {
        return new BigInteger(message).modPow(d, N).toByteArray();
    }

    private static String bytesToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) sb.append(b);
        return sb.toString();
    }

    public static void main(String[] args) {
        lab05 rsa = new lab05();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String msg = sc.nextLine();

        System.out.println("\nEncrypting: " + msg);
        System.out.println("Plaintext in bytes: " + bytesToString(msg.getBytes()));

        byte[] encrypted = rsa.encrypt(msg.getBytes());
        byte[] decrypted = rsa.decrypt(encrypted);

        System.out.println("Encrypted Bytes: " + bytesToString(encrypted));
        System.out.println("Decrypted Bytes: " + bytesToString(decrypted));
        System.out.println("Decrypted String: " + new String(decrypted));
    }
}
