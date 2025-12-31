import java.util.Arrays;

public class CatlansNo {
    // recursion + memorization
    public static int catlans(int n,int[] dp){
       
        if (n==0||n==1) {
            return 1;
            
        }

        if (dp[n]!=-1) {
            return dp[n];
            
        }
        int ans=0;
        for(int i=0; i<n; i++){
            ans+=catlans(i,dp)*catlans(n-i-1, dp);
            
        }
        return  dp[n]=ans;
    }


    public static int catlanTab(int n){//n2 time 
        int dp[]=new int[n+1];
        //initilization
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<=n; i++){
            for (int j=0; j<i; j++){
                dp[i]+=dp[j]*dp[i-j-1];
                
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 15;
        // System.err.println(catlans(n));// not will run for 30 or 40 bacuse memory
        // will be full {stackoverflow}
        int dp[] = new int[n + 1];
        // for(int i=0; i<n+1; i++){
        // dp[i]=-1;
        // }
        Arrays.fill(dp, -1);
        System.err.println(catlans(n, dp));// not will run for 30 or 40 bacuse memory will be full {stackoverflow}
        System.out.println(" using tabulation "+catlanTab(n));
}
}
