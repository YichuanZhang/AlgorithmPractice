import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        List<Integer> l = findNextGreaterElements(nums);
        for(int i : l)System.out.print(i + ",");
    }

    public static List<Integer> findNextGreaterElements(int[] nums){
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if(nums.length == 0)return list;
        int next = -1;
        stack.push(nums[0]);
        for(int i = 1; i < nums.length; i++){
            next = nums[i];
            if(!stack.isEmpty()){
                int element = stack.pop();
                while(element < next){
                    list.add(next);
                    if(stack.isEmpty())break;
                    element = stack.pop();
                }
                if(element > next){
                    stack.push(element);
                }
            }
            stack.push(next);
        }
        while(!stack.isEmpty()){
            list.add(-1);
            stack.pop();
        }
        return list;
    }
}
