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

    //tabulation

    //to perform tabulation :- create table and assign meaning and fill in bottom up manner 


    public static int maxprofitTab(int[] val, int[] wt, int w){
        int n=val.length;
        int[][] dp=new int[n+1][w+1];
       // i=no. of items ,j=current capacity or weight :  i_items+j=w(knapsack size) maxprofit 

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

        System.out.println("using tabulation " + maxprofitTab(val, wt, w));


    }

    

    
}
