import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class no3Clab2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int arr[] = new int[Integer.parseInt(st.nextToken())];
        int arrIND[]= new int [arr.length];
        int target=Integer.parseInt(st.nextToken());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            arrIND[i]=i+1;
        }

        for (int i = 0; i < arrIND.length-1; i++) {
            for (int j = 0; j < arrIND.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp=arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=temp;
                    
                    int t=arrIND[j];
                    arrIND[j]= arrIND[j+1];
                    arrIND[j+1]=t;
                }
            }
        }

        for ( int i = 0; i < arr.length; i++) {
            int j=i+1;
            int k=arr.length-1;
            while (j<k) {
                int sum=(arr[i]+arr[j]+arr[k]);
                if (sum==target) {
                    pw.println(arrIND[i]+" "+arrIND[j]+" "+arrIND[k]);
                    return;
                }
                else if(sum>target){
                    k--;
                }
                else{j++;}
            }
        }
        pw.println(-1);
    }
}
