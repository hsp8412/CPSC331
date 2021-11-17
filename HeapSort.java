import java.util.Random;

public class HeapSort { 
    static class HeapFullException extends Exception{
        public HeapFullException(String msg){
            super(msg);
        }
    }
    
    static class HeapEmptyException extends Exception{
        public HeapEmptyException(String msg){
            super(msg);
        }
    }

    static class Heap{
        private int heap_size;
        private int[] A;

        public Heap(int[] T){
            heap_size = T.length;
            A = T;
        }

        public void insert(int x) throws HeapFullException{
            if(heap_size < A.length){
                A[heap_size] = x;
                heap_size++;
                BubbleUp();
            }
            else{
                throw new HeapFullException("Heap is full!");
            }
        }

        private void BubbleUp(){
            int i = heap_size - 1;
            int parent;
            while(i > 0){
                parent = (i-1)/2;
                if(A[parent]<A[i]){
                    int tmp = A[i];
                    A[i] = A[parent];
                    A[parent] = tmp;
                    i = parent;
                }
                else{
                    break;
                }
            }
        }

        public int delete() throws HeapEmptyException{
            if(heap_size == 0){
                throw new HeapEmptyException("Heap is empty!");
            } else{
                int v = A[0];
                A[0] = A[heap_size-1];
                heap_size--;
                bubbleDown();
                return v;
            }
        }

        private void bubbleDown(){
            int i = 0;
            while(2*i+1 < heap_size){
                int left = 2*i+1;
                int right = 2*i+2;
                if(2*i+2 < heap_size){
                    int max;
                    if(A[left]>=A[right]){
                        max = left;
                    } 
                    else{
                        max = right;
                    }
                    if(A[max]>A[i]){
                        int tmp = A[i];
                        A[i] = A[max];
                        A[max] = tmp;
                        i = max; 
                    } else {
                        break;
                    }
                } else{
                    if(A[i] < A[2*i+1]){
                        int tmp = A[i];
                        A[i] = A[2*i+1];
                        A[2*i+1] = tmp;
                        i = 2*i+1;
                    } else{
                        break;
                    }
                }
                
            }
        }

        public void heapSort(){
            heap_size = 1;
            int i = 1;
            while(i < A.length){
                try {
                    insert(A[i]);
                    i++;
                } catch (HeapFullException e) {
                    System.out.println("Heap is full!");
                }
            }
            i = A.length-1;
            while(i>0){
                try {
                    int largest = delete();
                    A[i] = largest;
                    i--;
                } catch (Exception e) {
                    System.out.println("Heap is empty!");
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int n = rd.nextInt(100);
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = rd.nextInt(100);
        }
        System.out.println("The initial array: ");
        for(int i = 0; i < n; i++){
            System.out.printf("%d ", array[i]);
        }
        System.out.printf("\n");

        Heap aHeap = new Heap(array);
        aHeap.heapSort();

        System.out.println("The sorted array: ");
        for(int i = 0; i < n; i++){
            System.out.printf("%d ", array[i]);
        }
        System.out.printf("\n");
    }
}
