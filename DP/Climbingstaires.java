// one or two steps at a time for n stairs 
//count number of way to reach nth stair 
import java.util.*;
public class Climbingstaires {
    
    public static int staire(int n){
        if (n==0) {
            return 1;
        }
        if (n==1) {
            return 1;
            
        }

        if (n==2) {
            return 2;
        }
        int count = staire(n-1)+staire(n-2);

        return count;
    }
     public static int countwaysTab(int n){
        int dp[]=new int[n+1];
        dp[0]=1;

        //tablulation loop 
        for(int i=1; i<=n; i++){
            if (i==1) {
                dp[i]=dp[i-1];
                
                
            }
            else{
                dp[i]=dp[i-1]+dp[i-2];
            }

        }
       
        


        return dp[n];
    }
    public static int staireMemorization(int n,int[] ways){
       
        if (n==0) {
            return 1;
        }
        if (n<=0) {
            return 0;
            
        }

        if (ways[n]!=-1) {
            return ways[n];
        }
        ways[n]= staireMemorization(n-1,ways)+staireMemorization(n-2,ways);

        return ways[n];
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(staire(n));
        System.out.println(countwaysTab(n));
        int ways[]=new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println(staireMemorization(n,ways));

    }
}


// its a exponential complexity solution 

// optimized with dp 

