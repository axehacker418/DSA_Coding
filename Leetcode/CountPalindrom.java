public class CountPalindrom {

    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int result = 0;

        for (char c = 'a'; c <= 'z'; c++) {

            int left = -1, right = -1;

            // find first occurrence
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == c) {
                    left = i;
                    break;
                }
            }

            // find last occurrence
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == c) {
                    right = i;
                    break;
                }
            }

            // no valid palindrome possible if no pair
            if (left == -1 || right == -1 || left >= right)
                continue;

            // count distinct chars between left & right
            boolean[] seen = new boolean[26];
            for (int i = left + 1; i < right; i++) {
                seen[s.charAt(i) - 'a'] = true;
            }

            // count unique middle characters
            for (boolean exists : seen) {
                if (exists)
                    result++;
            }
        }

        return result;
    }

    // Test the function
    public static void main(String[] args) {
        CountPalindrom obj = new CountPalindrom();

        String s = "aabca";
        int ans = obj.countPalindromicSubsequence(s);

        System.out.println("Count: " + ans);
    }
}

// class Solution {
// public int countPalindromicSubsequence(String s) {
// int n = s.length();
// int[] charFirst = new int[26];
// int[] posBit = new int[n];
// Arrays.fill(charFirst, -1);

// int bits = 0;
// for (int i = 0; i < n; i++) {
// int idx = s.charAt(i) - 'a';
// posBit[i] = bits |= 1 << idx;
// if (charFirst[idx] == -1) {
// charFirst[idx] = i;
// bits = 0;
// }
// }

// int res = 0;
// for (int i = n - 1; i >= 2; i--) {
// int idx = s.charAt(i) - 'a';
// if (charFirst[idx] <= -1 || charFirst[idx] == i) {
// continue;
// }
// res += Integer.bitCount(arrOr(charFirst[idx] + 1, i - 1, posBit));
// charFirst[idx] = -2;
// }
// return res;
// }

// private int arrOr(int start, int end, int[] arr) {
// int res = 0;
// for (int i=start; i<=end; i++) {
// res |= arr[i];
// }
// return res;
// }

// // public int countPalindromicSubsequence(String s) {
// // int n = s.length();
// // int[] charFirst = new int[26];
// // Arrays.fill(charFirst, -1);

// // for (int i = 0; i < n; i++) {
// // int idx = s.charAt(i) - 'a';
// // if (charFirst[idx] == -1) {
// // charFirst[idx] = i;
// // }
// // }

// // int res = 0;
// // for (int i = n - 1; i >= 2; i--) {
// // int idx = s.charAt(i) - 'a';
// // if (charFirst[idx] <= -1 || charFirst[idx] == i) {
// // continue;
// // }
// // res += s.substring(charFirst[idx] + 1, i).chars().distinct().count();
// // charFirst[idx] = -2;
// // }
// // return res;
// // }

// }
