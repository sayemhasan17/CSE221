import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class no7Glab2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x= Integer.parseInt(st.nextToken());
        int y= Integer.parseInt(st.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int arr[] = new int[x];
        for (int i = 0; i < x; i++) arr[i] = Integer.parseInt(st2.nextToken());
        
        for (int i = 0; i < y; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st3.nextToken());
            int b=Integer.parseInt(st3.nextToken());
            int up=UPPER(arr, b);
            int down=DOWN(arr,a);
            pw.println(up-down);
        }
    }
    public static int UPPER(int [] a, int x){
        int l=0;
        int r=a.length;
        while (l<r) {
            int mid =l+ (r-l)/2;
            if (a[mid]<=x){
                l=mid+1;
                //r=mid;
            }
            else{r=mid;}
        }
        return l;
    }
    public static int DOWN(int [] a, int x){
        int l=0;
        int r=a.length;
        while (l<r) {
            int mid = l+(r-l)/2;
            if (a[mid]<x){
                l=mid+1;
            }
            else{r=mid;}
        }
        return l;
    }
}
