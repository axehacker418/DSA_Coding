public class StringConversion {
     public static int countoperation(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int result= lcstab(word1, word2);
        int delp=n-result;
        int addp=m-result;
        
        return delp+addp;

    }

    public static int lcstab(String s1,String s2){
        int n= s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for (int j=0; j<m+1; j++){
               if (n==0||m==0) {
                 dp[i][j]=0;                
               }
            }
        }

        for(int i=1; i<n+1; i++){
            for (int j=1; j<m+1; j++){
               if (s1.charAt(i-1)==s2.charAt(j-1)) {
                dp[i][j]=dp[i-1][j-1]+1;
                
               }
               else{
                int ans1=dp[i-1][j];
                int ans2=dp[i][j-1];

                dp[i][j]=Math.max(ans1, ans2);
               }

            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "pear";
        String word2 = "sea";
        System.out.println(" this is "+ countoperation(word1, word2));

    }
}
