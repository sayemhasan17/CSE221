import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class no2Blab2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int arr1[] = new int[N];
        int arr2[] = new int[M];

        int min=Integer.MAX_VALUE;
        int a=0;
        int b=0;
        //int q=0;
        
        for (int i = 0; i < N; i++) arr1[i] = Integer.parseInt(st2.nextToken());
        for (int i = 0; i < M; i++) arr2[i] = Integer.parseInt(st3.nextToken());
        int x=0;
        int y=M-1;
        
        while (x<N && y>=0) {
            //pw.println(q++);
            //pw.println("");
            int sum=arr1[x]+arr2[y];
            if (sum==K) {
                //pw.println("YES");
                pw.println((x+1)+" "+(y+1));
                return;
            }
            else if (sum>K) {
                y--;
                //pw.println("great");
                int diff=Math.abs(K-sum);
                if (diff<min) {
                    min=diff;
                    a=x+1;
                    b=y+2;
                }
            }
            else{
                x++;
                //pw.println("smaller");
                int diff=Math.abs(K-sum);
                if (diff<min) {
                    min=diff;
                    a=x;
                    b=y+1;
                }
            }
        }
        pw.println(a+" "+b);
    }
}
