import java.util.*;
// package Greedy;

//min absolute differnce of two pares in array

public class Minabs {
    public static void main(String[] args) {
        
        int A[]={1,2,3,9};
        int B[]={4,5,6,7};

        // sort
        Arrays.sort(A);
        Arrays.sort(B);

        int minabs=0;

        for(int i=0; i<A.length; i++){
            minabs+= Math.abs(A[i]-B[i]); // abs function to get absolute value 
            
        }
        System.out.println(" ans is "+ minabs);
    }
    
}
