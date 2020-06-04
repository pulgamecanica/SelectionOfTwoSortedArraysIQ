import java.util.*;

public class Kth { 
    // main function 
    public static void main (String[] args)  { 
        int array1[] = { 1,2,3,4,5,6,7,8, 20,30,49 }; 
        int array2[] = { 20, 40 }; 
        int k1 = 9; 
        int answer = kthLog(array1, array2, k1); 
        if (answer == -1) 
            System.out.println("Invalid query"); 
        else
            System.out.println(answer); 
    } 

    static int kthLog(int arr1[], int arr2[], int k) { 
        int m = arr1.length;
        int n = arr2.length;
        if (k > (m + n) || k < 1) 
            return -1; 
        else if (m > n) 
            return kthLog(arr2, arr1, k); 
        else if (m == 0) 
            return arr2[k - 1]; 
        else if (k == 1) 
            return Math.min(arr1[0], arr2[0]); 
        else{
            Integer min1 = Math.min(m, k / 2); 
            Integer min2 = Math.min(n, k / 2); 
            if (arr1[min1 - 1] > arr2[min2 - 1]) 
                return kthLog(arr1, Arrays.copyOfRange(arr2, min2, n), k - min2); 
            else
                return kthLog(Arrays.copyOfRange(arr2, min2, n), arr2, k - min1); 
        }
    } 
} 
  