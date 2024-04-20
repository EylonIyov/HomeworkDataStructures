import java.util.ArrayList;

public class GeneralPurposeHeap <T extends Comparable> {
    ArrayList<T> heap;
    int size;

    public GeneralPurposeHeap() {
    this.heap = new ArrayList<T>();
    this.heap.set(0, null);
    this.size = 0;
    }
    public GeneralPurposeHeap(T SingleObject) {
        this.heap = new ArrayList<T>();
        this.heap.set(0, null);
        this.heap.set(1, SingleObject);
        this.size = 1;
    }
    public void PercDown(GeneralPurposeHeap<T> MinHeap,T elementInserted,int index ){
        if(2*index >  MinHeap.size){
            MinHeap.heap.set(index, elementInserted);
        }
        if(2*index == MinHeap.size){
            if(MinHeap.heap.get(index).compareTo(elementInserted) == -1){
                MinHeap.heap.set(index, MinHeap.heap.get(2*index));
                MinHeap.heap.set(2*index, elementInserted);
            }
            else {
                MinHeap.heap.set(index, elementInserted);
            }
        }
        int j;
        if(MinHeap.heap.get(index).compareTo(elementInserted) == 1){
            if(MinHeap.heap.get(index*2).compareTo(MinHeap.heap.get(index*2+1)) == -1){
                 j = index*2;
            }
            else{
                j = index*2+1;
            }
            if(MinHeap.heap.get(j).compareTo(elementInserted) == -1){
                MinHeap.heap.set(index, MinHeap.heap.get(j));
                PercDown(MinHeap,elementInserted,j);
            }else{
                MinHeap.heap.set(index, elementInserted);
            }
        }
    }

    }


