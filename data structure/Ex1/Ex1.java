package Ex1;

import java.util.Arrays;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,7,45,99,785,1000,1052,4568,5555,6423, 6548};
		int k = 6548;
		System.out.println(Search(arr, k));
	}

	public static int Search(int [] arr, int k) {
		// TODO Auto-generated method stub
		if(arr[0] == k)
			return 0;
		int i = 1; 
		while (i < arr.length && arr[i] <= k) 
			i = i*2;
		if(i > arr.length) {
			int ans =  Arrays.binarySearch(arr, i/2, arr.length, k);
			if(ans < 0) return -1;
			return ans;
		}
		else {
			int ans =  Arrays.binarySearch(arr, i/2, i, k);
			if(ans < 0) return -1;
			return ans;
		}
	}
}
