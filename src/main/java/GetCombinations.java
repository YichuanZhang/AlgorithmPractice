import java.util.LinkedList;
import java.util.List;

public class GetCombinations {
    public static List<List<Integer>> getCombinations(int[] arr, int n){
        int total = 0;
        for(int i : arr)total+= i;
        List<List<Integer>> res = new LinkedList<>();
        if(total < n)return res;
        int[] nums = new int[total];
        int index = 0;
        int index2 = 0;
        for(int i : arr){
            while(i > 0){
                nums[index++] = index2;
                i--;
            }
            index2++;
        }
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("****************************");
        getCombinationsHelper(res, new LinkedList<>(), nums, 0, n);
        return res;
    }

    private static void getCombinationsHelper(List<List<Integer>> res, List<Integer> cur, int[] nums, int start, int n){
        if(cur.size() == n){
            res.add(new LinkedList<>(cur));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1])continue;
            cur.add(nums[i]);
            getCombinationsHelper(res, cur, nums, i + 1, n);
            cur.remove(cur.size() - 1);
        }
    }

    public static int getNumber(int arr, int n){
        return 1;
    }


    public static void main(String[] args){
        int[] arr = new int[]{3, 1, 1};
        List<List<Integer>> res = getCombinations(arr, 3);
        for(List<Integer> l : res){
            for(int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
