public class UnboundedKnapsack {
    public static void print(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int maxprofit(int[] val, int[] wt, int w) {
    int n = val.length;
    int[][] dp = new int[n+1][w+1];

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= w; j++) {

            int v = val[i-1];
            int weight = wt[i-1];

            if (weight <= j) {
                int inc = v + dp[i][j - weight];   // reuse item
                int exc = dp[i-1][j];              // skip item
                dp[i][j] = Math.max(inc, exc);
            } else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }

    return dp[n][w];
}

   
      public static void main(String[] args) {
        int val[]={
            15,14,10,45,30
        };
        int wt[]={2,5,1,3,4};
        int w=7;
        System.err.println(maxprofit(val,wt,w));
    }
    
}
