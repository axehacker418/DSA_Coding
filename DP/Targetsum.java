public class Targetsum {
    public static boolean tsum(int val[], int sum){
        boolean[][] dp=new boolean[val.length+1][sum+1];
        for(int i=0; i<dp.length; i++){
           // i=items j=targetsum
           dp[i][0]=true;
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j =1; j<dp[0].length ; j++){

                //include check 
                int v=val[i-1];

                if (v<=j && dp[i-1][j-v]==true) {
                    dp[i][j]=true;
                }
                else if (dp[i-1][j]==true) {
                    dp[i][j]=true;
                    
                }
            }
        }

        return dp[val.length][sum];

    }
    public static void main(String[] args) {
        int []val={4,2,7,1,3};
        int sum =10;
        System.out.println("op is :"+ tsum(val, 10));
        
    } 
    
}
