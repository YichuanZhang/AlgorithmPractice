//lowbit: means the last '1' from the left represent the number
// lowbit(2) = 2, lowbit(3) = 1, lowbit(6) = 2;
//get lowbit: x&(-x)
class BinaryIndexedTree {
    private int[] tree;
    private int[] nums;
    public BinaryIndexedTree(int[] nums){
        if(nums.length <= 0)return;
        this.nums = nums;
        int n = nums.length;
        // the very first position in tree is no element
        tree = new int[n + 1];
        //build bit: from every node, add ite value to its father
        for(int i = 0; i < n; i++){
            int index = i + 1;
            while(index <= n){
                tree[index] += nums[i];
                index += index & (-index);
            }
        }
    }

    public void update(int index, int val){
        int change = val - nums[index];
        nums[index] = val;
        int i = index + 1;
        //update the note itself as well as all its father node
        while(i <= nums.length){
            tree[i] += change;
            i += i & (- i);
        }
    }

    public int rangeSum(int left, int right){
        return prefixSum(right) - prefixSum(left - 1);
    }

    public int prefixSum(int index){
        int i = index + 1;
        int sum = 0;
        //get sum from itself and all its children
        while(i > 0){
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        BinaryIndexedTree bit = new BinaryIndexedTree(nums);
        System.out.println(bit.rangeSum(0,3));
        bit.update(1,5);
        System.out.println(bit.rangeSum(0,3));
    }
}