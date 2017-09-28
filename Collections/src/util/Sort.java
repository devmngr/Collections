package util;

public class Sort {

	public static void selectionSort(int[] A) {
		int i = 0;

		while (i < A.length - 1) {
			int idx = findSmallestElemIn(A, i, A.length - 1);
			swap(A, idx, i);
			i++;
		}
	}

	public static void insertionSort(int[] A) {
		int i = 1;
		while (i <= A.length - 1) {
			int idx = i;
			putIntoRightPlace(A, idx);
			i++;
		}
	}

	public static void quickSort(int[] A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort(A, p, q);
			quickSort(A, q + 1, r);
		}
	}
/* O(n^2)*/
	public static void bubbleSort(int[] A) {

		for (int i = A.length - 1; i >= 0; i--)
			for (int j = 0; j < A.length - i - 1; j++)
				if (A[j] > A[j + 1])
					swap(A, j, j + 1);
	}

	public static void mergeSort(int[] A) {
		mergeSort(A, 0, A.length-1);

	}

	private static int partition(int[] A, int p, int r) {
		int x = A[p]; // pivot element x
		int i = p - 1;
		int j = r + 1;

		// partition
		while (true) {
			do {
				j--;
			} while (A[j] > x);
			do {
				i++;
			} while (A[i] < x);

			if (i < j)
				swap(A, i, j);
			else
				return j;
		}

	}

	private static void putIntoRightPlace(int[] A, int index) {
		int element = A[index];// get element at place index
		for (int i = index; i > 0; i--) {
			if (A[i] < A[i - 1]) {
				swap(A, i, i - 1);
			}
		}

	}

	private static int findSmallestElemIn(int[] A, int from, int to) {
		int idxToSmallest = from;

		for (int i = from + 1; i <= to; i++) {
			if (A[i] < A[idxToSmallest])
				idxToSmallest = i;
		}
		return idxToSmallest;
	}

	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	
	
	private static void mergeSort(int[] A, int min,int max){
		if(min<max){
			int mid = (min+max)/2;
			mergeSort(A,min,mid);
			mergeSort(A, mid+1, max);
			merge(A, min, mid, max);
		}
		
	}

	private static void merge(int[] A, int first, int mid, int last) {

		int[] temp = new int[A.length];
		int first1 = first;
		int last1 = mid;

		int first2 = mid + 1;
		int last2 = last;
		int index = first1;

		while (first1 <= last1 && first2 <= last2) {

			if (A[first1] < A[first2]) {
				temp[index] = A[first1];
				first1++;
			} else {

				temp[index] = A[first2];
				first2++;

			}
			index++;
		}
		
		while (first1<=last1){
			temp[index] = A[first1];
			first1++;
			index++;
		}
		while(first2<=last2){
			
			temp[index] = A[first2];
			first2++;
			index++;
		}
		
		for (int i = first; i <=last; i++) 
			A[i]=temp[i];

	}

	public String arrayToString(int[] A) {
		String str = "";
		for (int i = 0; i < A.length; i++) {
			str += A[i];
			if (i < A.length - 1) {
				str += ", ";
			}
		}
		return str;
	}

	public static void main(String[] args) {

		int[] sort = { 11, 12, 1, 3, 8, 6, 9, 10 };
		for (int i = 0; i < sort.length; i++) {
			System.out.print(sort[i] + ", ");
		}
		System.out.println();
		System.out.println("After");
		mergeSort(sort);
		for (int i = 0; i < sort.length; i++) {
			System.out.print(sort[i] + ", ");
		}

	}

}
