import java.util.*;

public class Lab03 {
    private int[] dist;
    private int n;
    public static final int INF = 999;

    public Lab03(int n) {
        this.n = n;
        dist = new int[n + 1];
    }

    public void shortest(int src, int[][] graph) {
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int k = 1; k < n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (graph[i][j] != INF && dist[i] + graph[i][j] < dist[j])
                        dist[j] = dist[i] + graph[i][j];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (graph[i][j] != INF && dist[i] + graph[i][j] < dist[j]) {
                    System.out.println("Graph contains a negative edge cycle");
                    return;
                }

        for (int i = 1; i <= n; i++)
            System.out.println("Distance from " + src + " to " + i + " is " + dist[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];

        System.out.println("Enter the weighted adjacency matrix:");
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                graph[i][j] = sc.nextInt();
                if (i == j)
                    graph[i][j] = 0;
                else if (graph[i][j] == 0)
                    graph[i][j] = INF;
            }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        new Lab03(n).shortest(src, graph);
        sc.close();
    }
}
