import java.util.Arrays;

class IntersectionSizeTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = 0;
        long[] endStartPairs = new long[intervals.length];
        for (int[] interval : intervals) {
            endStartPairs[n] = -interval[0] & 0xFFFFFFFFL;
            endStartPairs[n++] |= (long) (interval[1]) << 32;
        }
        Arrays.sort(endStartPairs);
        int min = -2;
        int max = -1;
        int curStart;
        int curEnd;
        int res = 0;
        for (long endStartPair : endStartPairs) {
            curStart = -(int) endStartPair;
            curEnd = (int) (endStartPair >> 32);
            if (curStart <= min) {
                continue;
            }
            if (curStart <= max) {
                res += 1;
                min = max;
            } else {
                res += 2;
                min = curEnd - 1;
            }
            max = curEnd;
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionSizeTwo sol = new IntersectionSizeTwo();

        int[][] intervals = {
                { 1, 3 },
                { 1, 4 },
                { 2, 5 },
                { 3, 5 }
        };

        int result = sol.intersectionSizeTwo(intervals);
        System.out.println("Minimum size of containing set: " + result);
    }
}

// import java.util.Arrays;
// import java.util.List;
// import java.util.ArrayList;

// class IntersectionSizeTwo {
// public int intersectionSizeTwo(int[][] intervals) {

// // Step 1: Sort by end asc, start desc
// Arrays.sort(intervals, (a, b) ->
// a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
// );

// List<Integer> nums = new ArrayList<>();

// for (int[] interval : intervals) {
// int start = interval[0], end = interval[1];

// // Count how many nums fall inside [start, end]
// int count = 0;
// for (int i = nums.size() - 1; i >= 0; i--) {
// int val = nums.get(i);
// if (val >= start && val <= end) {
// count++;
// if (count == 2) break;
// }
// }

// // Need 2 numbers
// if (count == 0) {
// nums.add(end - 1);
// nums.add(end);
// }
// // Need 1 more number
// else if (count == 1) {
// nums.add(end);
// }
// }

// return nums.size();
// }

// public static void main(String[] args) {
// IntersectionSizeTwo sol = new IntersectionSizeTwo();

// int[][] intervals = {
// {1,3},
// {1,4},
// {2,5},
// {3,5}
// };

// int result = sol.intersectionSizeTwo(intervals);
// System.out.println("Minimum size of containing set: " + result);
// }
// }
