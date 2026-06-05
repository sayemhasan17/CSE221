import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class no1Alab2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        //int t = Integer.parseInt(br.readLine());
        
        int arr[] = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st2.nextToken());
        }
        int x=0;
        int y=n-1;

        //pw.println((x+1)+" "+(y+1));
        
        while (x<y) {
            if (arr[x]+arr[y]==target) {
                pw.println((x+1)+" "+(y+1));
                return;
            }
            else if (arr[x]+arr[y]>target) {
                y--;
            }
            else{
                x++;
            }
        }
        pw.println("-1");
    }
}
