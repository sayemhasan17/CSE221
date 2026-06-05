import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.StringTokenizer;

public class no8Hlab2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        int t = Integer.parseInt(br.readLine());

        for (int j = 0; j < t; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long k = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
           
            long sum = 0;
            long a = -1;

            while (true) {
                a = sum / x; 
                long newSum = k + a; 
                if (newSum == sum) 
                    break;
                sum = newSum; 
            }

            if (sum % x == 0) {
                pw.println(sum + 1);
            } 
            else {
                pw.println(sum);
            }
        }

    }
}
