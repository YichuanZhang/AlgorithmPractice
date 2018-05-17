public class NStraight {

    public static boolean isNStraight(int[] arr, int n){
        if(arr == null || arr.length == 0 || n <= 0)return false;
        if(arr.length % n != 0)return false;
        for(int i = 0; i < arr.length; i+= n){
            for(int j = i; j < i + n - 1; j++){
                if(arr[j] + 1 != arr[j + 1])return false;
            }
        }
        return true;
    }

    public static boolean isNStraightFollow(int[] arr, int n){
        if(arr == null || arr.length == 0 || n <= 0)return false;
        if(arr.length < n)return false;
        int start = 0;
        int counter = n - 1;
        while(start < arr.length - 1){
            if(arr[start] + 1 == arr[++start]){
                counter--;
                //System.out.println("counter: " + counter);
                if(counter == 0)return true;
            }else{
                counter = n - 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr1 = {1,2,3,5,6,7};
        int[] arr2 = {1,2,3,4,5,6};
        System.out.println("arr1: " + isNStraight(arr1, 3));
        System.out.println("arr1: " + isNStraight(arr1, 6));
        System.out.println("arr2: " + isNStraight(arr2, 3));
        System.out.println("arr2: "  + isNStraight(arr2, 6));
        System.out.println("*************follow-up***************");
        System.out.println("arr1: " + isNStraightFollow(arr1,3));
        System.out.println("arr1: " + isNStraightFollow(arr1, 4));
        System.out.println("arr2: " + isNStraightFollow(arr2, 6));
    }
}
