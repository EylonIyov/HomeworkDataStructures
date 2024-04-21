
public class GeneralPurposeHeap <T extends Comparable<T>> {
    T[] heap;
    int size;
    int capacity;

    public GeneralPurposeHeap() {
    this.heap = (T[]) new Comparable[16];
    this.heap[0] = null;
    this.size = 0;
    this.capacity = 16;
    }
    public GeneralPurposeHeap(T SingleObject) {
        this.heap = (T[]) new Comparable[16];
        this.heap[0] = null;
        this.heap[1] = SingleObject;
        this.size = 1;
        this.capacity = 16;
    }
    public GeneralPurposeHeap(T[] ArrayToHeap) {
        this.heap = (T[]) new Comparable[ArrayToHeap.length*2];
        this.heap[0] = null;
        System.arraycopy(ArrayToHeap, 0, this.heap, 1, ArrayToHeap.length);
        for (int i = (this.size / 2) -1; i >= 0; i--) {
            //PercDown(this, this.heap[i], );
        }

    }
    public void percDown(int index) {
    int LeftChild = 2 * index;
    int RightChild = LeftChild + 1;
    int current = index;
    if (LeftChild < size && heap[LeftChild].compareTo(heap[RightChild]) < 0 ) {}
    }
    public void ExpandHeap(GeneralPurposeHeap<T> MinHeap){
        int newCapacity = MinHeap.capacity*2;
        T[] newHeap = (T[]) new Comparable[newCapacity];
        for(int i = 0; i < MinHeap.size; i++) newHeap[i] = MinHeap.heap[i];
        MinHeap.heap = newHeap;
        MinHeap.capacity = newCapacity;
        }
    public void swap(int i, int j){
        T temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }
    }


    }


