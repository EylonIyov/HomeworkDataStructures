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
        this.heap = (T[]) new Comparable[ArrayToHeap.length];
        this.size = ArrayToHeap.length;
        this.capacity = ArrayToHeap.length;
        System.arraycopy(ArrayToHeap, 0, this.heap, 0, ArrayToHeap.length);
        sort(this.heap);
        }

    private void PercDown(int index, T value, int n, T[] heap) {
       int left = index * 2 + 1;
       int right = left + 1;
       int j =0;
       if (left <= n) heap[index] = value;
       if(left == n){
           if (heap[left].compareTo(value) < 0 && heap[left] != null) {
               heap[index] = heap[left];
               heap[left] = value;
           }else{
               heap[index] = value;
           }
        }
       if(left<n){
           if(heap[left].compareTo(heap[right]) < 0 && heap[left] != null && heap[right] != null) {
               j = left;
           }else if (heap[right] != null){
               j = right;
           }
           if (j>0 && heap[j] != null && heap[j].compareTo(value) < 0) {
               heap[index] = heap[j];
               PercDown(j, value, n, heap);
           }else{
               heap[index] = value;
           }
       }
    }

//    public void PercUp(int index,T Object, T[] heap) {
//        int parentIndex = (index-1/2) ;
//        if (index == 0 ){
//            heap[0] = Object;
//        }else if (heap[parentIndex] != null && heap[parentIndex].compareTo(Object) < 0 ){
//            heap[index] = Object;
//        }else {
//            heap[index] = heap[parentIndex];
//            PercUp(parentIndex, Object,heap);
//       }
//    }
//    private void percUp(int index){
//        if(index == 0) return;
//        int parent = (index-1 / 2);
//        if(this.heap[parent].compareTo(heap[index]) < 0) return;
//        swap(parent, index);
//        percUp(parent);
//    }
private void percUp(T[] heap, int index) {
    while (index > 0) {
        int parentIndex = (index - 1) / 2;
        if (heap[parentIndex] != null  && heap[index] != null  && heap[index].compareTo(heap[parentIndex]) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
        } else {
            break;
        }
    }
}

    private void ExpandHeap() {
        int newCapacity = this.capacity * 2;
        T[] newHeap = (T[]) new Comparable[newCapacity];
        System.arraycopy(this.heap, 0, newHeap, 0, this.size);
        this.heap = newHeap;
        this.capacity = newCapacity;
    }

    public void swap(int i, int j) {
        T temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }
    public void insert(T Object) {
        if (size == capacity) {
            System.out.println("Heap is full, previous capacity: " + this.capacity + " New capacity: " + this.capacity*2);
            this.ExpandHeap();
        }
            heap[size] = Object;
            percUp(this.heap, size);
            this.size++;
        }

    public int getSize(){
        return size;
    }
    public T getMin(){
        if(size ==0) throw new IllegalStateException("Heap is empty");
        else return heap[0];
    }
    private int GetMinChildIndex(int index){

        if (((index*2)+1) > size && heap[index] != null ) return index*2;
        else{
            if(heap[index*2].compareTo(heap[index*2+1]) > 0) return index*2;
            else{
                return index*2 +1;
            }

        }

    }
    private void sort (T[] Object){
        int n = Object.length;
        for (int i = (n/2) -1 ; i >= 0; i--) {
            PercDown(i, Object[i], n-1, Object);
        }
    }

}





