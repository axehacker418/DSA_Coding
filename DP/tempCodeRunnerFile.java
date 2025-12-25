 public static int maxprofitTab(int[] val, int[] wt, int w){
        int n=val.length;
        int[][] dp=new int[n+1][w+1];
       // i,j i_items+j=w(knapsack size) maxprofit 

       for(int i=0; i<n+1; i++){
        dp[i][0]=0;
       }
       for(int i=0; i<w+1; i++){
        dp[0][i]=0;
       }

       for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                int v=val[i-1];
                int weight=wt[i-1]; //weight ith item
                if (weight<=j) {
                    int incprofit=v+dp[i-1][j-weight];
                    int exprofit=dp[i-1][j];
                    dp[i][j]=Math.max(incprofit, exprofit);
                    
                }
                else{
                    int exprofit=dp[i-1][j];
                    dp[i][j]=exprofit;


                }

            }


       }
        print(dp);
       return dp[n][w];
    }

    public static void print(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
   

