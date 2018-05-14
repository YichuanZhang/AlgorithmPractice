public class LongestCommonSubstring {
    //use dynamic programming to reach O(m*n) complexity
    public static String longestCommonSubstring(String s, String t){
        if(s == null || t == null || s.length() == 0 || t.length() == 0)return "";
        int[][] dp = new int[s.length() + 1][t.length() + 1];//dp[i - 1][j - 1] is to store the longest common suffix in prefix of s and prefix of t
        int longest = 0;
        int pos = 0;
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j <= t.length(); j++){
                if(i == 0 || j == 0)dp[i][j] = 0;
                else if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    //longest = Math.max(longest, dp[i - 1][j - 1]);
                    if(dp[i - 1][j - 1] > longest){
                        longest = dp[i - 1][j - 1];
                        //System.out.println("i: " + (i - 1));
                        //System.out.println("j: " + (j - 1));
                        pos = j - 1;
                    }
                }
                else dp[i][j] = 0;
            }
        }
        return t.substring(pos - longest, pos + 1);
    }

    public static void main(String[] agrs){
        String s = "geeksforgeeks";
        String t = "ageeks123eeks";
        System.out.println(longestCommonSubstring(s, t));
    }
}
