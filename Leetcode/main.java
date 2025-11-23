public class Main {

    // ---------------------- YOUR ORIGINAL CODE (COMMENTED) ----------------------
    /*
    class Solution {
        public static int[] result(String s){
            int arr[]=new int[s.length()];
            for(int i=0; i<s.length(); i++){
                int digit = s.charAt(i) - '0'; 
                arr[i]=digit;
                
            }

            return arr;
        }
        public int[] sumAndMultiply(String s, int[][] queries) {
            int arr[]=result(s);
            int output[]=new int[queries.length];
            int opc=0;
            for(int i=0; i<queries.length; i++){
                int num=0;
                int sum=0;
                int start = queries[i][0];
                int end   = queries[i][1];
    
                if(start >= arr.length) {
                    output[opc++] = 0;
                    continue;
                }

                end = Math.min(end, arr.length - 1);

                for (int j = start; j <= end; j++) {
                    if(arr[j]!=0){
                        sum =sum +arr[j];
                        num=(num*10)+arr[j];

                        // ❌ WRONG: storing inside loop, causes overflow & partial results
                        int result= num*sum;
                        output[opc++]=result;
                    }
                }
            }
            return output;
        }
    }
    */

    // ---------------------- CORRECTED VERSION ----------------------
    static class Solution {

        // Converts string of digits → array of integers
        // (same as your method, just cleaned)
        public static int[] result(String s){
            int arr[] = new int[s.length()];
            for(int i = 0; i < s.length(); i++){
                arr[i] = s.charAt(i) - '0'; // Convert char → digit
            }
            return arr;
        }


        // Fixed implementation
        public int[] sumAndMultiply(String s, int[][] queries) {
            int arr[] = result(s);
            int output[] = new int[queries.length];
            int opc = 0;

            for(int i = 0; i < queries.length; i++){

                int num = 0;
                int sum = 0;

                int start = queries[i][0];
                int end   = queries[i][1];

                // Prevent invalid query ranges
                if(start >= arr.length){
                    output[opc++] = 0;
                    continue;
                }

                end = Math.min(end, arr.length - 1);

                // Build full subarray result BEFORE storing
                for(int j = start; j <= end; j++){
                    if(arr[j] != 0){
                        sum += arr[j];
                        num = num * 10 + arr[j];
                    }
                }

                // ✔ Store result once per query (not inside loop)
                output[opc++] = num * sum;
            }

            return output;
        }
    }


    // ---------------------- MAIN FUNCTION (RUN LOCALLY) ----------------------
    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "508321";
        int[][] queries = {
            {0, 3},
            {2, 5},
            {4, 10} // tests out-of-range handling
        };

        int[] result = sol.sumAndMultiply(s, queries);

        System.out.println("Output:");
        for(int val : result){
            System.out.println(val);
        }
    }
}
