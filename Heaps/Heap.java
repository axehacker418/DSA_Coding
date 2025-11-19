import java.util.ArrayList;

public class Heap {
    static class InnerHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);
            int x=arr.size()-1;
            int par=(x-1)/2;
            while(x>0 && arr.get(x)<arr.get(par)){
                int temp =arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x=par;
                par=(x-1)/2;
            }
        }

        public void addMax(int data){
            arr.add(data);
            int x=arr.size()-1;
            int par=(x-1)/2;
            while(x>0 && arr.get(x)>arr.get(par)){
                int temp =arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x=par;
                par=(x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        public int peekMax(){
            return arr.get(0);
        }

        private void minheapify(int i){
            int left= (2*i)+1;
            int right=(2*i)+2;
            int minidx=i;

            if (left<arr.size() && arr.get(minidx)>arr.get(left)) {
                minidx=left;
            }
            if (right<arr.size() && arr.get(minidx)>arr.get(right)) {
                minidx=right;
            }
            if (minidx!=i) {
                int temp=arr.get(i);
                arr.set(i, arr.get(minidx));
                arr.set(minidx, temp);
                minheapify(minidx);
            }
        }

        private void maxheapify(int i){
            int left= (2*i)+1;
            int right=(2*i)+2;
            int maxidx=i;

            if (left<arr.size() && arr.get(maxidx)<arr.get(left)) {
                maxidx=left;
            }
            if (right<arr.size() && arr.get(maxidx)<arr.get(right)) {
                maxidx=right;
            }
            if (maxidx!=i) {
                int temp=arr.get(i);
                arr.set(i, arr.get(maxidx));
                arr.set(maxidx, temp);
                maxheapify(maxidx);
            }
        }

        public int mindelete(){
            int val=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.remove(arr.size()-1);
            minheapify(0);
            return val;
        }

        public int maxdelete(){
            int val=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.remove(arr.size()-1);
            maxheapify(0);
            return val;
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }


        
    }

    public static void main(String[] args) {
        InnerHeap h=new InnerHeap();

        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.print(h.peek()+" ");
            h.mindelete();
        }

        System.out.println();

        h.addMax(2);
        h.addMax(3);
        h.addMax(4);
        h.addMax(5);

        while (!h.isEmpty()) {
            System.out.print(h.peek()+" ");
            h.maxdelete();
        }
    }
}
