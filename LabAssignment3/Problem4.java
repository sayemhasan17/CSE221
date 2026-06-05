import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.StringTokenizer;

public class no4Dlab3 {
    public static final long MOD = (long) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            long[][] a = new long[2][2];
            StringTokenizer st = new StringTokenizer(br.readLine());

            a[0][0] = Long.parseLong(st.nextToken());
            a[0][1] = Long.parseLong(st.nextToken());
            a[1][0] = Long.parseLong(st.nextToken());
            a[1][1] = Long.parseLong(st.nextToken());

            long X = Long.parseLong(br.readLine());

            long res[][] = power(a, X);

            sb.append(res[0][0]).append(" ").append(res[0][1]).append("\n");
            sb.append(res[1][0]).append(" ").append(res[1][1]).append("\n");

        }
        pw.print(sb);
        pw.flush();
        pw.close();
        br.close();
    }

    public static long[][] power(long a[][], long x) {
        long[][] res = { { 1, 0 }, { 0, 1 } };

        while (x > 0) {
            if ((x & 1) == 1) {
                res = multiply(res, a);
            }
            a = multiply(a, a);
            x = x >> 1;
        }
        return res;
    }

    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];

        res[0][0] = (a[0][0] * b[0][0]  + a[0][1] * b[1][0] ) % MOD;
        res[0][1] = (a[0][0] * b[0][1]  + a[0][1] * b[1][1] ) % MOD;
        res[1][0] = (a[1][0] * b[0][0]  + a[1][1] * b[1][0] ) % MOD;
        res[1][1] = (a[1][0] * b[0][1]  + a[1][1] * b[1][1] ) % MOD;

        return res;

    }

}
