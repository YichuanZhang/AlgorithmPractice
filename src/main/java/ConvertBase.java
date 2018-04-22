import java.util.Stack;

public class ConvertBase {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        convert_base(188, 16);
        System.out.println();
        System.out.println(restore("BC", 16));
    }
    //input 10 base
    //output d base d<=16
    public static void convert_base(int n, int d){
        Stack<Integer> s = new Stack<>();
        int e = 0;
        while(n != 0){
            e = n % d;
            s.push(e);
            n /= d;
        }
        while(!s.isEmpty()){
            e = s.pop();
            System.out.printf("%X", e);
        }
    }
    //intput d base string d<= 16
    //output 10 base int
    public static int restore(String s, int d){
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int result = 0;
        int one = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= '0' && chars[i] <= '9'){
                one = chars[i] - '0';
            }else{
                one = chars[i] - 'a' + 10;
            }
            result = result * d + one;
        }
        return result;
    }

}
