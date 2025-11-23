import java.util.HashSet;

public class UnionAndIntersectionsOfTwoArrays {
    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };

        // two union of thease means combined unique element
        HashSet<Integer> union = new HashSet<>();
        for (int each : arr1) {
            union.add(each);
        }
        for (int each : arr2) {
            union.add(each);
        }
        System.out.println(union + " total are " + union.size());

        // check intersection

        HashSet<Integer> intersection = new HashSet<>();
        int countIntersection = 0;
        // add arr1 elements
        for (int each : arr1) {
            intersection.add(each);

        }
        // check if they exist and count {intersection means comman element in both
        // arrays }
        for (int each : arr2) {
            if (intersection.contains(each)) {
                countIntersection++;
                intersection.remove(each);
            } else {
                intersection.add(each);
            }
        }

        System.out.println("My intersection is equal to : " + countIntersection);

        // inbuild intersection method that is s1.retainAll(s2) s1 and s2 are the sets ;

        // HashSet<Integer> set1 = new HashSet<>();
        // for (int each : arr1) {
        // set1.add(each);
        // }

        // HashSet<Integer> intersection = new HashSet<>();
        // for (int each : arr2) {
        // if (set1.contains(each)) {
        // intersection.add(each);
        // }
        // }

        // System.out.println("Intersection elements: " + intersection);
        // System.out.println("Count: " + intersection.size());

        //OR


        // set1.retainAll(set2);
        // System.out.println(set1); // intersection elements
        // System.out.println(set1.size());

    }

}
