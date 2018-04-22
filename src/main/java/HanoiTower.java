public class HanoiTower {
    public static void main(String[] args) {
        int n = 4;
        System.out.println((1 << n) - 1);
        hanoi(n, 'A', 'B', 'C');

    }

    public static void hanoi(int n, char x, char y, char z){
        if(n == 1){
            System.out.println(n + " from " + x + " to " + z);
            return;
        }else{
            hanoi(n - 1, x, z, y);
            System.out.println(n + " from " + x + " to " + z);
            hanoi(n - 1, y, x, z);
        }
    }
}
