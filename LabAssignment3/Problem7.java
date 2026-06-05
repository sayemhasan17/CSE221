import java.io.*;
import java.util.*;

public class no7Glab3 {
    static Map<Integer, Integer> map = new HashMap<>();
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] inorder = new int[N];
        int[] preorder = new int[N];

        for (int i = 0; i < N; i++) inorder[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) preorder[i] = Integer.parseInt(st2.nextToken());

        
        for (int i = 0; i < N; i++) map.put(inorder[i], i);

        buildPost(inorder, preorder, 0, N - 1, 0, N - 1);

       
    }

    public static void buildPost(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) return;

        int root = preorder[preStart];
        int rootIndex = map.get(root);
        int leftCount = rootIndex - inStart;

        // left kids first
        buildPost(inorder, preorder, inStart, rootIndex - 1, preStart + 1, preStart + leftCount);

        // right kids next
        buildPost(inorder, preorder, rootIndex + 1, inEnd, preStart + leftCount + 1, preEnd);

        // print boss last
        pw.print(root + " ");
        pw.flush();
    }
    
}
