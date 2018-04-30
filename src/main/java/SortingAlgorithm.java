class SortingAlgorithm {
    public static void print(int[] nums){
        System.out.println();
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,4,3,2,1};
        //insertionSort(nums);
        selectionSort(nums);
        print(nums);
    }

    public static void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int tmp = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > tmp){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
    }

    public static void selectionSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            int index = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[index]){
                    index = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
    }
    public static void binaryInsertionSort(){

    }
}