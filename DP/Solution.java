class Solution {
    public static boolean isSubs(int nums[], int i, int j){
        //12345
        if(i<j && j<nums.length){
            return true;
        }
        return false;
    }

    public static int subSequence(int nums[]){
        //all non empty subsequence
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
            for(int j=0+i; j<nums.length; j++ ){
                 System.out.print(nums[i]+" ");
            }
        }
        return 0;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length; 
        int m=nums2.length; 

        int dp[][]=new int [n+1][m+1];
        int i=0,j=0;

        if(i>n || j>m){
            return 0;
        }
       return 0;
        
    }


    public static void main(String[] args) {
        int nums1[]={1,2,3,4,5,6};
        
    }
}