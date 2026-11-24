public class MergeSort {

    static void merge(int[] arr, int left, int  mid, int right){
        int i = left, j = mid + 1, k = 0;

        int temp[] = new int[right - left + 1];

        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else { 
                temp[k++] = arr[j++];
            }
        }

        while(i<=mid) temp[k++] = arr[i++];
        while(j<=right) temp[k++] = arr[j++];

        for(int x=0; x<temp.length; x++){
            arr[x + left] = temp[x];
        }
    }

    static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args){
        int[] arr = {6, 2, 5, 3, 10, 1};

        mergeSort(arr, 0, arr.length - 1);

        for(int num : arr){
            System.out.println(num);
        }
    }
}