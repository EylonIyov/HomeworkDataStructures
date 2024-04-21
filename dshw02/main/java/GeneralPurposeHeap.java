
public class GeneralPurposeHeap <T extends Comparable<T>> {
    T[] heap;
    int size;
    int capacity;

    public GeneralPurposeHeap() {
        this.heap = (T[]) new Comparable[17];
        this.heap[0] = null;
        this.size = 0;
        this.capacity = 16;
    }

    public GeneralPurposeHeap(T SingleObject) {
        this.heap = (T[]) new Comparable[17];
        this.heap[0] = null;
        this.heap[1] = SingleObject;
        this.size = 1;
        this.capacity = 16;
    }

    public GeneralPurposeHeap(T[] ArrayToHeap) {
        this.heap = (T[]) new Comparable[ArrayToHeap.length * 2];
        this.heap[0] = null;
        System.arraycopy(ArrayToHeap, 0, this.heap, 1, ArrayToHeap.length);
        this.size = ArrayToHeap.length;
        this.capacity = ArrayToHeap.length * 2 - 1;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            PercDown(i);
        }

    }

    public void PercDown(int index) {
        int smallest = index;
        int leftChild = index * 2;
        int rightChild = index * 2 + 1;
        if (leftChild < size && heap[leftChild].compareTo(heap[smallest]) < 0) {
            smallest = leftChild;
        }
        if (rightChild < size && heap[rightChild].compareTo(heap[smallest]) < 0) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(smallest, index);
            PercDown(smallest);
        }
    }
    public void PercUp(int index) {
        int parentIndex = index / 2;
        while (index > 0 && heap[index].compareTo(heap[parentIndex]) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = index / 2;
        }
    }

    public void ExpandHeap(GeneralPurposeHeap<T> MinHeap) {
        int newCapacity = MinHeap.capacity * 2;
        T[] newHeap = (T[]) new Comparable[newCapacity];
        for (int i = 0; i < MinHeap.size; i++) newHeap[i] = MinHeap.heap[i];
        MinHeap.heap = newHeap;
        MinHeap.capacity = newCapacity;
    }

    public void swap(int i, int j) {
        T temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }
    public void insert(T Object) {
        if (size == capacity) {
            System.out.println("Heap is full, previous capacity: " + this.capacity + " New capacity: " + this.capacity*2  );
            ExpandHeap(this);
        }else{
            heap[size] = Object;
            PercUp(size);
            size++;
        }
    }
    public int getSize(){
        return size;
    }
    public T getMin(){
        return heap[1];
    }
}





