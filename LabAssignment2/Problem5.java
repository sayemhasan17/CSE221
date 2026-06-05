import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class no5Elab2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st2.nextToken());

        int left=0;
        int store=0;
        int count=0;

        int max=Integer.MIN_VALUE;

        for (int right = 0; right < arr.length; right++) {
            store += arr[right];
            
            if(store>K && left<=right){
                store -= arr[left++];
            }
            
            count=right-left+1;

            max=Math.max(count, max);
        }
        pw.println(max);
        

    }
}
