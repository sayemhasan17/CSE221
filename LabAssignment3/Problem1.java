import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class no1Alab3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        // int sum=0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long count = mergeSort(arr, 0, n - 1);
        pw.println(count);
        for (int i = 0; i < arr.length; i++) {
            pw.print(arr[i] + " ");
        }
        pw.flush();
    }

    public static long mergeSort(int a[], int l, int r) {
        long sum = 0;
        if (l < r) {
            int mid = (l + r) / 2;

            long left = mergeSort(a, l, mid);
            long right = mergeSort(a, mid + 1, r);
            long total = merge(a, l, mid, r);
            sum = left + right + total;
        }
        return (sum);
    }

    public static long merge(int a[], int l, int mid, int r) {
        long count = 0;
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = a[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = a[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                a[k++] = left[i];
                i++;
            } else {
                a[k++] = right[j++];
                count += (n1 - i);
            }
        }
        while (i < n1) {
            a[k++] = left[i++];
        }
        while (j < n2) {
            a[k++] = right[j++];
        }

        return count;
    }
}
