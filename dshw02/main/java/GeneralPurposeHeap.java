import java.util.NoSuchElementException;

public class GeneralPurposeHeap <T extends Comparable<T>> {
    T[] heap;
    private int size;
    private int capacity;

    public GeneralPurposeHeap() {
        this.heap = (T[]) new Comparable[16];
        this.size = 0;
        this.capacity = 16;
    }

    public GeneralPurposeHeap(int initialCapacity) {
        this.heap = (T[]) new Comparable[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    public GeneralPurposeHeap(T[] ArrayToHeap) {
        this.heap = (T[]) new Comparable[(ArrayToHeap.length + 1)];
        this.size = ArrayToHeap.length;
        this.capacity = ArrayToHeap.length;
        System.arraycopy(ArrayToHeap, 0, this.heap, 1, ArrayToHeap.length);
        sort(this.heap);
    }

    private void PercDown(int index, T value, int n, T[] heap) {
        int left = index * 2;
        int right = left + 1;
        int j = 0;
        if (left > n) heap[index] = value;
        if (left == n) {
            if  (heap[left] != null && heap[left].compareTo(value) < 0 ) {
                heap[index] = heap[left];
                heap[left] = value;
            } else {
                heap[index] = value;
            }
        }
        if (left < n) {
            if (heap[left] != null && heap[right] != null && heap[left].compareTo(heap[right]) < 0) {
                j = left;
            } else if (heap[right] != null) {
                j = right;
            }
            if (j > 1 && heap[j] != null && heap[j].compareTo(value) < 0) {
                heap[index] = heap[j];
                PercDown(j, value, n, heap);
            } else {
                heap[index] = value;
            }
        }
    }

    private void percUp(T[] heap, int index) {
        while (index > 0) {
            int parentIndex = (index) / 2;
            if (heap[parentIndex] != null && heap[index] != null && heap[index].compareTo(heap[parentIndex]) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    public T deleteMin(){
        T temp = this.getMin();
        this.heap[1] = this.heap[size];
        this.heap[size] = null;
        PercDown(1, heap[1], size, heap );
        this.size--;
        return temp;
    }


    private void ExpandHeap() {
        int newCapacity = this.capacity * 2;
        T[] newHeap = (T[]) new Comparable[newCapacity];
        System.arraycopy(this.heap, 0, newHeap, 0, this.size);
        this.heap = newHeap;
        this.capacity = newCapacity;
    }

    private void swap(int i, int j) {
        T temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    public void insert(T Object) {
        if (size == capacity) {
            System.out.println("Heap is full, previous capacity: " + this.capacity + " New capacity: " + this.capacity * 2);
            this.ExpandHeap();
        }
        heap[size] = Object;
        percUp(this.heap, size);
        this.size++;
    }

    public int getSize() {
        return size;
    }

    public T getMin() {
        if (size == 0 || heap[1] == null) throw new IllegalStateException("Heap is empty");
        else return heap[1];
    }

    private int GetMinChildIndex(int index) {

        if (((index * 2) + 1) > size && heap[index] != null) return index * 2;
        else {
            if (heap[index * 2].compareTo(heap[index * 2 + 1]) > 0) return index * 2;
            else {
                return index * 2 + 1;
            }

        }

    }

    private void sort(T[] Object) {
        int n = Object.length;
        for (int i = (n / 2) ; i >= 0; i--) {
            PercDown(i, heap[i], this.size, this.heap );
        }
    }



    private boolean isLeaf(int index) {
        if (index * 2 > size) return true;
        else return false;
    }

    private boolean hasRightChild(int index) {
        if (index * 2 + 1 < size) return true;
        else return false;
    }

    private boolean hasLeftChild(int index) {
        if (index * 2 < size) return true;
        else return false;
    }


}







