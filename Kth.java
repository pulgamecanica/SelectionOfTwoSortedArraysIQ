import java.util.*;

public class Kth { 
    // main function 
    public static void main (String[] args)  { 
        int array1[] = { 1,2,3,4,5,6,7,8, 20,30 }; 
        int array2[] = { 20, 40 }; 
        int k1 = 9; 
        int answer = kthLog(k1, array1, array2); 
        System.out.println("************************");
        if (answer == (int)Double.POSITIVE_INFINITY) 
            System.out.println("Invalid!!!"); 
        else
            System.out.println(answer); 
    } 

    static int kthLog(int k, int arr1[], int arr2[]) { 
        int m = arr1.length;
        int n = arr2.length;
        if (k > (m + n) || k < 1) 
            return (int)Double.POSITIVE_INFINITY; 
        else if (m > n) 
            return kthLog(k, arr2, arr1); 
        else if (m == 0) 
            return arr2[k - 1]; 
        else if (k == 1) 
            return Math.min(arr1[0], arr2[0]); 
        else{
            Integer min1 = Math.min(m, k / 2); 
            Integer min2 = Math.min(n, k / 2); 
            if (arr1[min1 - 1] > arr2[min2 - 1]) 
                return kthLog(k - min2, arr1, Arrays.copyOfRange(arr2, min2, n)); 
            else
                return kthLog( k - min1, Arrays.copyOfRange(arr2, min2, n), arr2); 
        }
    } 
} 
  