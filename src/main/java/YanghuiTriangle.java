import java.util.LinkedList;
import java.util.Queue;

public class YanghuiTriangle {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        yanghui_triangle(5);
    }
    //print(a + b)^n
    public static void yanghui_triangle(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        for(int i = 0; i <= n; i++){
            int s = 0;
            q.offer(s);
            for(int j = 0; j < i + 2; j++){
                int t = q.poll();
                int tmp = s + t;
                q.offer(tmp);
                s = t;
                if(j != i + 1){
                    System.out.print(s + " ");
                }
            }
            System.out.println();
        }
    }
}
