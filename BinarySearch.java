public class BinarySearch{
    static int binarySearch(int[] arr, int key){
        int low = 0, high = arr.length - 1;

        int mid = (low + high) / 2;

        while (low <= high) {
            if(arr[mid] == key) return mid;
            else if(arr[mid] < key ) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 6, 7, 10, 34};

        int result = binarySearch(arr, 6);

        if(result != -1) System.out.println("Key found at index : " + result);
        else System.out.println("Key not found");
    }
}