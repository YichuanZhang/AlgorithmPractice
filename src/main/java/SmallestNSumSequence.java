import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Given two arrays a and b both length N, select one element from each we can have n^2 sums
//How to get the smallest N sums
class SmallestNSumSequence {
    public static void main(String[] args) {
        int[] a = {1,3,2,4,5};
        int[] b = {6,3,4,1,7};
        SmallestNSumSequence m = new SmallestNSumSequence();
        m.k_merge(a, b);
    }
    class Node{
        int sum;
        int index_b;
        public Node(int sum, int index_b){
            this.sum = sum;
            this.index_b = index_b;
        }
    }

    public void k_merge(int[] a, int[] b){
        if(a.length == 0 || b.length == 0)return;
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return n1.sum - n2.sum;
            }
        });
        for(int i = 0; i < a.length; i++){
            Node n = new Node(a[i] + b[0], 0);
            pq.offer(n);
        }
        for(int i = 0; i < b.length; i++){
            Node n = pq.poll();
            System.out.println(n.sum);
            n.sum = n.sum - b[n.index_b] + b[n.index_b + 1];
            n.index_b++;
            pq.offer(n);
        }
    }
}
