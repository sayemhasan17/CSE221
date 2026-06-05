import java.io.*;
//import java.util.*;

public class no2Blab3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());

        String[] parts = br.readLine().split(" ");
        long[] arr = new long[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Long.parseLong(parts[i]);
        }

        long[] temp = new long[n];
        long inversions = mergeSort(arr, temp, 0, n - 1);

        pw.println(inversions);
        pw.flush();
    }

    public static long mergeSort(long[] arr, long[] temp, int left, int right) {
        if (left >= right)
            return 0;
        int mid = (left + right) / 2;
        long invCount = 0;

        invCount += mergeSort(arr, temp, left, mid);
        invCount += mergeSort(arr, temp, mid + 1, right);
        invCount += countPairs(arr, left, mid, right);
        merge(arr, temp, left, mid, right);

        return invCount;
    }

    public static long countPairs(long[] arr, int left, int mid, int right) {
        long count = 0;
        for (int j = mid + 1; j <= right; j++) {
            long val = arr[j] * arr[j];
            int idx = upperBound(arr, left, mid, val);
            count += (mid - idx + 1);
        }
        return count;
    }

    public static int upperBound(long[] arr, int left, int right, long val) {
        int l=left, r=right, ans = right + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > val) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void merge(long[] arr, long[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];

        for (int t = left; t <= right; t++)
            arr[t] = temp[t];
    }
}
