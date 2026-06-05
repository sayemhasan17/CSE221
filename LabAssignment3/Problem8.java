import java.io.*;
import java.util.*;

public class no8Hlab3 {
    static Map<Integer, Integer> map = new HashMap<>();
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] inorder = new int[N];
        int[] postorder = new int[N];

        for (int i = 0; i < N; i++) inorder[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) postorder[i] = Integer.parseInt(st2.nextToken());

        
        for (int i = 0; i < N; i++) map.put(inorder[i], i);

        builfPre(inorder, postorder, 0, N - 1, 0, N - 1);

       
    }

    public static void builfPre(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd];
        
        pw.print(root + " ");
        
        int rootIndex = map.get(root);
        int leftCount = rootIndex - inStart;

        // left kids first
        builfPre(inorder, postorder, inStart, rootIndex - 1, postStart , postStart + leftCount-1);

        
        // right kids next
        builfPre(inorder, postorder, rootIndex + 1, inEnd, postStart + leftCount , postEnd-1);

        // print boss last
        
        pw.flush();
    }
    
}
