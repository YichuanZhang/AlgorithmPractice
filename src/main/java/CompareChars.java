public class CompareChars {
    public static char findOneDifferent(String s, String t){
        if(s == null || t == null)return 0;
        if(Math.abs(s.length() - t.length()) != 1)return 0;
        if(s.length() < t.length()){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != t.charAt(i))return t.charAt(i);
            }
            return t.charAt(t.length() - 1);
        }else{
            for(int i = 0; i < t.length(); i++){
                if(t.charAt(i)!= s.charAt(i))return s.charAt(i);
            }
            return s.charAt(s.length() - 1);
        }
    }

    public static char findOneDifferentNoOrder(String s, String t){
        if(s == null || t == null)return 0;
        if(Math.abs(s.length() - t.length()) != 1)return 0;
        int[] chars = new int[256];
        for(char c : s.toCharArray()){
            chars[c]++;
        }
        for(char c : t.toCharArray()){
            chars[c]--;
        }
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != 0)return (char)(i);
        }
        return 0;
    }
    public static void main(String[] args){
        String s1 = "aacccd";
        String s2 = "aaccced";
        System.out.println(findOneDifferent(s1, s2));
        String s11 = "aaaccc";
        String s22 = "aaaccce";
        System.out.println(findOneDifferent(s11, s22));
        System.out.println("*********************");
        System.out.println(findOneDifferentNoOrder(s1,s2));
        String s111 = "cacaca";
        System.out.println(findOneDifferentNoOrder(s111, s22));
    }
}
