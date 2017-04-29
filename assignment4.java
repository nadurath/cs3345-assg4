import java.util.*;
import java.io.*;

public class assignment4
{
	public static int alg;
	public static int order;
	public static int size;
	public static int[] arr;
	public static int mergeCount;
	public static int mergeMove;
	public static int quickCount;
	public static int quickMove;
	public static int heapCount;
	public static int heapMove;

	public static void main(String[] args)
	{
		while(true)
		{
			Scanner x = new Scanner(System.in);

			System.out.println("\nWelcome! Please indicate the array size you wish.");
			size = x.nextInt();
			arr = new int[size];
			ArrayList<Integer> temp = new ArrayList<Integer>();
			Random rand = new Random();

			for(int i = 0; i<size; i++)
			{
				arr[i] = rand.nextInt(1000)+ 1;
				temp.add(rand.nextInt(1000)+ 1);
			}


			System.out.println("\nPlease indicate the order you wish the elements to be placed.\n\n1. InOrder\n2. ReverseOrder\n3. AlmostOrder\n4. Random");
			System.out.println();
			order = x.nextInt();
			System.out.println();

			if(order == 1)
			{
				System.out.println("Alright! You have chosen InOrder.");
				Collections.sort(temp);
				for(int i = 0; i<size; i++)
				{
					arr[i] = temp.get(i);
				}
				System.out.println(Arrays.toString(arr) + "");
			}
			else if(order == 2)
			{
				System.out.println("Alright! You have chosen ReverseOrder.");
				Collections.sort(temp);
				Collections.reverse(temp);
				for(int i = 0; i<size; i++)
				{
					arr[i] = temp.get(i);
				}
				System.out.println(Arrays.toString(arr) + "");
			}
			else if(order == 3)
			{
				System.out.println("Alright! You have chosen AlmostOrder.");
				Collections.sort(temp);
				for(int i = 0; i<size; i++)
				{
					arr[i] = temp.get(i);
				}
				int temp1 = arr[0];
				int temp2 = arr[size-1];
				arr[0] = temp2;
				arr[size-1] = temp1;
				System.out.println(Arrays.toString(arr) + "");
			}
			else if(order == 4)
			{
				System.out.println("Alright! You have chosen Random.");

				System.out.println(Arrays.toString(arr) + "");
			}
			else
				System.out.println("Please choose a number between 1 and 4.");

			System.out.println("Please indicate the number algorithm you wish to test.\n\n1. Insertion Sort\n2. Selection Sort\n3. Radix Sort\n4. Heap Sort\n5. Merge Sort\n6. Quick Sort");
			System.out.println();
			alg = x.nextInt();
			System.out.println();

			if(alg == 1)
				insertionSort(arr);
			else if(alg == 2)
				selectionSort(arr);
			else if(alg == 3)
				radixSort(arr);
			else if(alg == 4)
				heapSort(arr);
			else if(alg == 5)
			{
				System.out.println("Alright! You have chosen to run the Merge Sort algorithm.");
				final long start = System.currentTimeMillis();
				mergeSort(arr,0,arr.length-1);
				final long end = System.currentTimeMillis();
				final long total = end-start;
				System.out.println("The array is now: " + Arrays.toString(arr));
				System.out.println("The algorithm took: " + total + " milliseconds to complete.");
				System.out.println("The number of comparisons was: " + mergeCount + ".");
				System.out.println("The number of movements was: " + mergeMove + ".");
			}
			else if(alg == 6)
			{
				System.out.println("Alright! You have chosen to run the Quick Sort algorithm.");
				final long start = System.currentTimeMillis();
				quickSort(arr, 0, arr.length-1);
				final long end = System.currentTimeMillis();
				final long total = end-start;
				System.out.println("The array is now: " + Arrays.toString(arr));
				System.out.println("The algorithm took: " + total + " milliseconds to complete.");
				System.out.println("The number of comparisons was: " + quickCount + ".");
				System.out.println("The number of movements was: " + quickMove + ".");
			}
			else
				System.out.println("Please choose a number between 1 and 6.");

		}
	}

	public static void insertionSort(int[] a)
	{
		System.out.println("Alright! You have chosen to run the Insertion Sort algorithm.");
		final long start = System.currentTimeMillis();
		int count = 0;
		int movements = 0;
		for(int i = 0; i<a.length;i++)
		{
			for(int x = i; x>0; x--)
			{
				if(a[x] < a[x-1])
				{
					int temp = a[x];
					a[x] = a[x-1];
					a[x-1] = temp;
					count = count+3;
					movements = movements + 3;
				}
				else
					count++;
			}
		}

		final long end = System.currentTimeMillis();
		final long total = end-start;
		System.out.println("The array is now: " + Arrays.toString(a));
		System.out.println("The algorithm took: " + total + " milliseconds to complete.");
		System.out.println("The number of comparisons was: " + count + ".");
		System.out.println("The number of movements was: " + movements + ".");		
	}

	public static void selectionSort(int[] a)
	{
		System.out.println("Alright! You have chosen to run the Selection Sort algorithm.");
		final long start = System.currentTimeMillis();
		int count = 0;
		int movements = 0;
		for(int i = 0; i<a.length-1; i++)
		{
			int spot = i;
			for(int x = i+1; x<a.length; x++)
			{
				count++;
				if(arr[x] < arr[spot])
				{
					spot = x;
					movements++;
				}
			}
			int less = a[spot];
			a[spot] = a[i];
			a[i] = less;
			movements = movements + 3;
		}

		final long end = System.currentTimeMillis();
		final long total = end-start;
		System.out.println("The array is now: " + Arrays.toString(a));
		System.out.println("The algorithm took: " + total + " milliseconds to complete.");
		System.out.println("The number of comparisons was: " + count + ".");
		System.out.println("The number of movements was: " + movements + ".");
	}

	public static void radixSort(int[] a)
	{
		System.out.println("Alright! You have chosen to run the Radix Sort algorithm.");
		final long start = System.currentTimeMillis();
		int count = 0;
		int movements = 0;
		final int RAD = 10;
		List<Integer>[] buck = new ArrayList[RAD];
		for(int i = 0; i<buck.length; i++)
		{
			buck[i] = new ArrayList<Integer>();
		}

		boolean max = false;
		int temp = -1;
		int spot = 1;
		while(!max)
		{
			max = true;
			for(Integer i: a)
			{
				temp = i/spot;
				buck[temp % RAD].add(i);
				if(max && temp > 0)
				{
					count++;
					max = false;
				}
			}

			int x = 0;
			for(int k = 0; k<RAD; k++)
			{
				for(Integer i: buck[k])
				{
					a[x++] = i;
					count++;
					movements++;
				}
				buck[k].clear();
			}
			spot *= RAD;
		}

		final long end = System.currentTimeMillis();
		final long total = end-start;
		System.out.println("The array is now: " + Arrays.toString(a));
		System.out.println("The algorithm took: " + total + " milliseconds to complete.");
		System.out.println("The number of comparisons was: " + count + ".");
		System.out.println("The number of movements was: " + movements + ".");
	}

	public static void heapSort(int[] a)
	{
		System.out.println("Alright! You have chosen to run the Heap Sort algorithm.");
		final long start = System.currentTimeMillis();

		int smallParent = (a.length-1)/2;
		for(int i = smallParent; i>=0; i--)
			percDown(a, i, a.length-1);

		for(int i = a.length-1; i>0; i--)
		{
			if(a[0] > a[i])
			{
				swap(a,0,i);
				percDown(a,0,i-1);
			}
		}

		final long end = System.currentTimeMillis();
		final long total = end-start;
		System.out.println("The array is now: " + Arrays.toString(a));
		System.out.println("The algorithm took: " + total + " milliseconds to complete.");
		System.out.println("The number of comparisons was: " + heapCount + ".");
		System.out.println("The number of movements was: " + heapMove + ".");

	}

	public static void mergeSort(int[] a, int first, int last)
	{
		int mid = (first+last) / 2;

		
		if(first<last)
		{
			mergeSort(a, first, mid);
			mergeSort(a, mid+1, last);
		}
		mergeCount++;

		int b = 0;
		int x = first;
		int n = mid+1;

		int[] temp = new int[last-first+1];

		while (x <= mid && n <= last) {
			temp[b++] = a[x] < a[n] ? a[x++] : a[n++];
			mergeCount++;
			mergeMove++;
		 } 

		while (x <=mid) {
			mergeCount++;
			mergeMove++;
			temp[b++] = a[x++];
		}

		while (n <=last) {
			mergeCount++;
			temp[b++] = a[n++];
			mergeMove++;
		}

		b=0;
		while (first<=last) {
			mergeCount++;
			a[first++] = temp[b++];
			mergeMove++;
		}

		arr = a;
	}

	public static void quickSort(int[] a, int first, int last)
	{
		if(first<last)
		{
			int p = split(a, first, last);
			quickSort(a, first, p-1);
			quickSort(a, p+1, last);
		}
		arr = a;
	}

	public static int split(int[] a, int first, int last)
	{
		int p = first + new Random().nextInt(last-first + 1);
		swap(a, p, last);
		for(int i = first; i<last; i++)
		{
			if(a[i] <= a[last])
			{
				swap(a, i, first);
				first++;
			}
			quickCount++;
		}
		swap(a, first, last);
		return first;
	}

	public static void swap(int[] a, int x, int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
		quickMove = quickMove + 2;
		quickCount = quickCount + 2;
		heapMove = heapMove + 2;
		heapCount = heapCount + 2;
	}

	public static void percDown(int[] a, int first, int last)
	{
		int biggest = 2*first+1;
		while(biggest<=last)
		{
			heapCount++;
			if(biggest < last && a[biggest] < a[biggest + 1])
			{
				heapCount++;
				biggest++;
			}
			if(a[biggest] > a[first])
			{
				swap(a, biggest, first);
				first = biggest;
				biggest = 2*first+1;
			}
			else
				return;
		}
	}
}