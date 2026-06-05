import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class no6Flab2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        int count=0;
        int max=Integer.MIN_VALUE;
        int j=0;
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st2.nextToken());

        HashMap<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            
            if (map.containsKey(arr[i])){
                int freq=map.get(arr[i]);
                map.put(arr[i], freq+1);
                //count++;
            }
            else{
                map.put(arr[i], 1);
            }
            while (map.size()>K) {
                int freq=map.get(arr[j]);
                freq--;
                
                if (freq==0) {
                    map.remove(arr[j]);
                }
                else{map.put(arr[j],freq);}
                j++;
            }
            count=i-j+1;
            max=Math.max(max, count);
        }
        pw.println(max);
    }
}
