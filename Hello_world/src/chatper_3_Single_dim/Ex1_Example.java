package chatper_3_Single_dim;

public class Ex1_Example {


public void main() {
        int[] arr= {1 ,2 ,4 ,3,5,6,7};
        if (isSorted(arr))
        {
            System.out.println("Array is sorted Ascending older : ");
        }else {
            System.out.println("Array is not sorted Ascending older : ");
        }

}
    public static boolean isSorted(int[] arr)
    {
        for (int i = 0; i<arr.length-1 ; i++)
        {
            if (arr[i]> arr[i+1]){
                return false;
            }
               
        }
        return true;
    }

}