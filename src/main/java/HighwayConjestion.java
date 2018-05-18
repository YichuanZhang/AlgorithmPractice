import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class HighwayConjestion {
    public static List<List<Integer>> highwayConjestion(int[] carSpeed){
        List<List<Integer>> res = new LinkedList<>();
        if(carSpeed == null || carSpeed.length == 0)return res;
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> intial = new LinkedList<>();
        intial.add(carSpeed[0]);
        int firstCar = carSpeed[0];
        stack.push(intial);
        for(int i = 1; i < carSpeed.length; i++){
            if(carSpeed[i] >= firstCar){
                List<Integer> curList = stack.pop();
                curList.add(carSpeed[i]);
                stack.push(curList);
            }else{
                List<Integer> newLine = new LinkedList<>();
                newLine.add(carSpeed[i]);
                firstCar = carSpeed[i];
                stack.push(newLine);
            }
        }
        while(!stack.isEmpty()){
            res.add(0, stack.pop());
        }
        return res;
    }


    public static void main(String[] args){
        int[] cars = new int[]{60, 70, 40, 60, 80, 100, 30, 20};
        List<List<Integer>> res = highwayConjestion(cars);
        for(List<Integer> l : res){
            for(int i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
