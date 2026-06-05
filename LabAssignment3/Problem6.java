import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class no6Flab3 {
    public static int i = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        BST(a, 0, n - 1, arr);

        for (int i = 0; i < a.length; i++) {
            pw.print(arr[i] + " ");
        }
        pw.flush();

    }

    public static void BST(int a[], int l, int r, int arr[]) {
        
        if (l > r) return;
            int mid = (l + r) / 2;
            arr[i++] = a[mid];
            BST(a, l, mid - 1, arr);
            BST(a, mid+1, r, arr);
        
    }
}
