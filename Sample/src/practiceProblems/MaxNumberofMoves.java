package practiceProblems;

public class MaxNumberofMoves {

	static int maximumPoints(int arr[], int n, int k, int i)
	{
	    // Compute sum of first window of size k in which
	    // we consider subArray from index ( 'i-k' to 'i' )
	    // store starting index of sub_array
	    int start;
	    if (k > i)
	 
	        // sub_array from ( 0 to I+(K-I))
	        start = 0;
	    else
	 
	        // sub_array from ( i-i, to i )
	        start = i - k;
	 
	    int res = 0;
	    for (int j = start; j <= start + k && j < n; j++)
	        res += arr[j];
	 
	    // Compute sums of remaining windows by
	    // removing first element of previous
	    // window and adding last element of
	    // current window.
	    int curr_sum = res;
	    for (int j = start + k + 1; j < n && j <= i + k; j++) {
	        curr_sum += arr[j] - arr[j - k - 1];
	        res = max(res, curr_sum);
	    }
	    return res;
	}
	 


	static int max(int a, int b)
	  {
	    return (a > b)? a : b;
	  }



public static void main(String args[])
{
	int arr[] = { 5, 6, 4, 2, 8, 3, 1 };
    int k = 3, i = 3;
    int n = arr.length ;
    int res = maximumPoints(arr, n, k - 1, i);
    System.out.println( "Maximum points: " +res);
    //return 0;
}

}