//either i can do 0 or one means yes or no 
//weight and value if i can fit weight i need to sell on max value 

//unbounded knapsack means infinite items to same item 
public class ZeroOneKnapsack {
    
    //recursion
    public static int zoKnapsack(int[] val,int[] wt, int w,int n){
        if(w==0 || n==0 ){
            return 0;
        }
        if (wt[n-1]<=w) {
            int ans1=val[n-1]+zoKnapsack(val,wt,w-wt[n-1], n-1);        
            int ans2=zoKnapsack(val,wt,w, n-1); 
            return Math.max(ans1,ans2);       

        }
        else{
            return zoKnapsack(val,wt,w, n-1);        

        }
        
       
    }
    //memoisation
    public static int maxprofitMem(int[] val, int wt[], int w,int n,int[][] dp){
        if(w==0 || n==0 ){
            return 0;
        }
        if (dp[n][w]!=-1) {
            return dp[n][w];
            
        }
        if (wt[n-1]<=w) {
            int ans1=val[n-1]+maxprofitMem(val,wt,w-wt[n-1], n-1,dp);        
            int ans2=maxprofitMem(val,wt,w, n-1,dp); 
            dp[n][w]=Math.max(ans1,ans2);  
            return dp[n][w];

        }
        else{
            dp[n][w]=zoKnapsack(val,wt,w, n-1);   
            return dp[n][w];     

        }
    }

    public static int maxprofitTab(int[] val, int[] wt, int w){
        return 0;
    }

    //tabulation


    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int w=7;
        System.out.println("Maximum profit is: " + zoKnapsack(val,wt,w,val.length));

        //memo
        int dp[][]=new int[val.length+1][w+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(maxprofitMem(val, wt, w ,val.length,dp));


    }
    
}
