import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class no4Dlab2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int arr1[] = new int[N];
        int arr2[] = new int[M];
        int array[] = new int[N + M];

        for (int i = 0; i < N; i++)
            arr1[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++)
            arr2[i] = Integer.parseInt(st2.nextToken());

        int x = 0;
        int y = 0;
        int i = 0;

        while ((x < N && y < M)) {
            if (arr1[x] < arr2[y]) {
                array[i++] = arr1[x++];
            } else if (arr1[x] == arr2[y]) {
                array[i++] = arr1[x++];
            } else {
                array[i++] = arr2[y++];
            }
        }
        while (x < N) {
            array[i++] = arr1[x++];
        }
        while (y < M) {
            array[i++] = arr2[y++];
        }

        for (int j = 0; j < array.length ; j++) {
            pw.print(array[j]);
            pw.print(" ");
        }
        pw.flush();
    }
}
