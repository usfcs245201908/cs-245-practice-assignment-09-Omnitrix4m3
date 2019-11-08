public class BinaryHeap
{
	//Instance data
	private int data[] = new int[10];
	private int size = 0;
	
	//Adds an item to the binary heap
	void add(int priority)
	{
		//Grows the array if the size might be problematic
		if (size + 1 == data.length)
		{
			grow_array();
		}
		
		data[size++] = priority;

		int child = size - 1;
		int parent = (child - 1) / 2;

		while (parent >= 0 && data[parent] > data[child]) // 'data[parent] < data[child]' for max heap 
		{
			swap(data, parent, child);
			child = parent;

			parent = (child - 1) / 2;
		}
	}

	//Removed and returns an item from the binary heap
	int remove()
	{
		int temp = data[0];

		data[0] = data[--size]; //'--size' so that size is decremented after removing and updates it all in one fell swoop
		siftdown(0); //Auxiliary function which rearranges heap to satisfy second condition

		return temp;
	}

	//Adjusts the binary heap so that it always fulfills both conditions of a heap
	void siftdown(int parent) //n log n runtime
	{
		int child = (parent * 2) + 1;

		if (child < size && child + 1 < size && data[child + 1] < data[child])
		{
			child = child + 1; //right child
		}

		if (child < size && data[parent] > data[child])
		{
			swap(data, child, parent);
			siftdown(child);
		}
	}

	//Primitive swap function that Swaps elements in an array
	void swap(int data[], int first, int second)
	{
		int temp;

		temp = data[first];
		data[first] = data[second];
		data[second] = temp;
	}

	//Doubles the size of an array when invoked
	void grow_array()
	{
		int arr[] = new int[data.length * 2];
        System.arraycopy(data, 0, arr, 0, data.length);
		data = arr;
	}
}

//T arr[] = (T[]) new Object[10];