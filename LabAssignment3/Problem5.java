import java.io.*;
import java.util.StringTokenizer;

public class no5Elab3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            long res;

            if (a == 1) {
                res = n % m;
            } else {
                long num = (expo(a, n + 1, m) - a + m) % m;
                long deno = (a - 1 + m) % m;
                long inv = expo(deno, m - 2, m);
                res = (num * inv) % m;
            }

            pw.println(res);
        }

        pw.flush();
        pw.close();
        br.close();
    }

    private static long expo(long a, long b, long m) {
        long res = 1;
        a %= m;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % m;
            a = (a * a) % m;
            b >>= 1;
        }

        return res;
    }
}
