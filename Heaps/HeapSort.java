public class HeapSort {
    public static void maxheapify(int arr[], int i, int size) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int maxidx = i;

        if (left < size && arr[left] > arr[maxidx]) {
            maxidx = left;
        }
        if (right < size && arr[right] > arr[maxidx]) {
            maxidx = right;
        }
        if (maxidx != i) {
            int temp = arr[i];
            arr[i] = arr[maxidx];
            arr[maxidx] = temp;
            maxheapify(arr, maxidx, size);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            maxheapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxheapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 7, 8, 9, 1, 2, 4 };

        heapSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
