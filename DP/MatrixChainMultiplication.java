//HARD

import java.util.Arrays;

public class MatrixChainMultiplication {
    // recursion
    public static int mcm(int arr[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);

        }
        return ans;
    }

    public static int mcmMemo(int arr[], int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j]!=-1) {
            return dp[i][j];
            
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
            
        }
        return dp[i][j]=ans;
        

        

    }


    public static int mcmTab(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i]=0;
        }

        for(int len=2; len<=n-1; len++){
            for(int i=1; i<=n-len; i++){
                int j=i+len-1; //col
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1; k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]* arr[k]* arr[j];
                    dp[i][j]=Math.min(dp[i][j], cost1+cost2+cost3);
                }

            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 3 };// stores row X col of matrixes like 1X2 and 2X3 etc
        // find the min coast
        System.out.println(mcm(arr, 1, arr.length - 1));

        int dp[][]=new int [arr.length][arr.length];

        for (int i=0; i<arr.length; i++) {
            Arrays.fill(dp[i],-1);            
        }

        System.out.println(mcmMemo(arr,1,arr.length-1,dp));

        System.out.println("using tab"+ mcmTab(arr));

    }
}
