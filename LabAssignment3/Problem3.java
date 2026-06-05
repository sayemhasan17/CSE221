import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class no3Clab3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a= Long.parseLong(st.nextToken());
        long b= Long.parseLong(st.nextToken());
        long sum= expo(a,b);
        pw.println(sum);
    }
    public static long expo (long a , long b){
        if (b==0) {
            return 1;
        }
        long mid=b/2;
        long y= expo(a, mid);
        long x=y*y;
        
        if (b%2==0) {
            return x %107;
        }
        else{
            return (x*a)%107;
        }
    }
}
