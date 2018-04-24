import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeTraversal {
    class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeTraversal m = new TreeTraversal();
        int[] nums = {1,2,3,4,5,6,7};
        TreeNode root = m.buildBST(nums, 0, nums.length - 1);
        preOrder(root);
        System.out.println("\nRecursive PreOrder");
        preOrder_r(root);
        System.out.println("\nIterative InOrder");
        inOrder(root);
        System.out.println("\nIterative postOrder");
        postOrder(root);
        System.out.println("\nLevel Order");
        levelOrder(root);
        System.out.println("\nMorris InOrder");
        morrisInOrder(root);
        System.out.println("\nMorris PreOrder");
        morrisPreOrder(root);
    }

    public TreeNode buildBST(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, start, mid - 1);
        node.right = buildBST(nums, mid + 1, end);
        return node;
    }

    public static void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if(root != null)stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if(node.right != null)stack.push(node.right);
            if(node.left != null)stack.push(node.left);
        }
    }

    public static void preOrder_r(TreeNode root){
        if(root == null)return;
        System.out.print(root.val + " ");
        preOrder_r(root.left);
        preOrder_r(root.right);
    }

    public static void inOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    public static void postOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        //p: 正在访问节点， q：刚刚访问过的节点
        TreeNode p = root, q = null;
        do{
            while(p != null){//往左下
                stack.push(p);
                p = p.left;
            }
            q = null;//左下走不动了
            while(!stack.isEmpty()){
                p = stack.pop();//取一个出来看看
                if(p.right == q){//右边没有或者已经访问过了
                    System.out.print(p.val + " ");
                    q = p;
                }else{//现在不能访问，得再放进去，往右下走一步
                    stack.push(p);
                    p = p.right;
                    break;
                }
            }
        }while(!stack.isEmpty());
    }

    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            System.out.print(root.val + " ");
            if(root.left != null)queue.offer(root.left);
            if(root.right != null)queue.offer(root.right);
        }
    }

    public static void morrisInOrder(TreeNode root){
        TreeNode cur = root, prev = null;
        while(cur != null){
            if(cur.left == null){
                System.out.print(cur.val + " ");
                prev = cur;
                cur = cur.right;
            }else{
                //find precessor
                TreeNode node = cur.left;
                while(node.right != null && node.right != cur)node = node.right;
                if(node.right == null){// not threaded yet
                    node.right = cur;
                    cur = cur.left;
                }else{// has been threaded, visit cur and delete the thread
                    System.out.print(cur.val + " ");
                    node.right = null;
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
    }

    public static void morrisPreOrder(TreeNode root){
        TreeNode prev = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                System.out.print(cur.val + " ");
                prev = cur;
                cur = cur.right;
            }else{
                TreeNode node = cur.left;
                while(node.right != null && node.right != cur){
                    node = node.right;
                }
                if(node.right == null){
                    System.out.print(cur.val + " ");
                    node.right = cur;
                    prev = cur;
                    cur = cur.left;
                }else{
                    node.right = null;
                    cur = cur.right;
                }
            }
        }
    }
}