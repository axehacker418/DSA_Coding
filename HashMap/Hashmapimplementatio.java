// import java.util.ArrayList;
// import java.util.LinkedList;

// public class Hashmapimplementatio {

//     static class HashMap<k, v> { // k and v are generric variables mean they can be any datatype {general data
//                                  // type }

//         private class Node {
//             k key;
//             v value;

//             public Node(k key, v value) {
//                 this.key = key;
//                 this.value = value;
//             }

//         }

//         private int n;
//         private int N;
//         private LinkedList<Node> bukets[];// array of linked list of nodes type { this is the actual hashmap}

//         @SuppressWarnings("unchecked")
//         public HashMap() {
//             this.N = 4;
//             this.bukets = new LinkedList[4];
//             for (int i = 0; i < 4; i++) {
//                 this.bukets[i] = new LinkedList<>();
//             }

//         }

//         private int hashFunction(k key) {
//             int hc = key.hashCode();
//             return Math.abs(hc) % N;
//         }

//         private int searchInLL(k key, int bi) {
//             LinkedList<Node> ll = bukets[bi];
//             int di = 0;
//             for (int i = 0; i < ll.size(); i++) {
//                 Node node = ll.get(i);
//                 if (node.key == key) {
//                     return di;

//                 }
//                 di++;
//             }
//             return -1;
//         }
//         @SuppressWarnings("unchecked")

//         private void rehash() {
//             LinkedList<Node> oldbuck[] = bukets;
//             bukets = new LinkedList[N * 2];
//             N = 2 * N;
//             for (int i = 0; i < bukets.length; i++) {
//                 bukets[i] = new LinkedList<>();
//             }

//             // nodes add to new bucket
//             for (int i = 0; i < oldbuck.length; i++) {
//                 LinkedList<Node> ll = oldbuck[i];
//                 for (int j = 0; j < ll.size(); i++) {
//                     Node node = ll.remove();
//                     put(node.key, node.value);
//                 }

//             }
//         }

//         public void put(k key, v value) {
//             int bi = hashFunction(key);// 0 to size-1
//             int di = searchInLL(key, bi);// valid -1
//             if (di != -1) {
//                 Node node = bukets[bi].get(di);
//                 node.value = value;

//             } else {
//                 bukets[bi].add(new Node(key, value));
//                 n++;
//             }
//             double lambda = (double) n / N;
//             if (lambda > 2.0) {
//                 rehash();
//             }

//         }

//         public boolean containsKey(k key) {
//             int bi = hashFunction(key);// 0 to size-1
//             int di = searchInLL(key, bi);// valid -1
//             if (di != -1) {
//                 return true;
//             }
//             else {
//                 return false;
//             }            
//         }

//         public v remove(k key){
//             int bi = hashFunction(key);// 0 to size-1
//             int di = searchInLL(key, bi);// valid -1
//             if (di != -1) {
//                 Node node=bukets[bi].remove(di);
//                 n--;
//                 return node.value;

//             } else {
//                 return null;
              
//             }
//         }

//         public v get(k key){
//             int bi = hashFunction(key);// 0 to size-1
//             int di = searchInLL(key, bi);// valid -1
//             if (di != -1) {
//                 Node node = bukets[bi].get(di);
//                 return node.value;

//             } else {
//                 return null;
//             }
//         }

//         public ArrayList<k> keySet(){
//             ArrayList<k> keys=new ArrayList<>();
//             for(int i=0; i<bukets.length; i++){
//                LinkedList<Node> ll=new LinkedList<>();
//                for(Node node: ll){
//                 keys.add(node.key);
//                }
//             }
//             return keys;
//         }

//         public boolean isEmpty(){
//             return n==0;
//         }

//     }

// // all function O(1) or O(lembda)

//     public static void main(String[] args) {
//         HashMap<String, Integer> hm=new HashMap<>();
//         hm.put("India", 100);
//         hm.put("china", 100);
//         hm.put("us", 100);
//         hm.put("uk", 100);
//         hm.put("nepal", 100);

//         ArrayList<String> keys=hm.keySet();
//         for(String key:keys){
//             System.out.println(key);
//         }
//         System.out.println(hm.get("India"));
//     }
// }








import java.util.ArrayList;
import java.util.LinkedList;

public class Hashmapimplementatio {

    static class HashMap<k, v> {

        private class Node {
            k key;
            v value;

            public Node(k key, v value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> bukets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.bukets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.bukets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(k key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(k key, int bi) {
            LinkedList<Node> ll = bukets[bi];
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);

                // 🔥 FIX: Compare keys using equals() not ==
                if (node.key.equals(key)) {   
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldbuck[] = bukets;

            bukets = new LinkedList[N * 2];
            N = 2 * N;

            for (int i = 0; i < bukets.length; i++) {
                bukets[i] = new LinkedList<>();
            }

            // 🔥 FIX: Reinsert all nodes without using remove()
            n = 0; // reset count before inserting
            for (int i = 0; i < oldbuck.length; i++) {
                LinkedList<Node> ll = oldbuck[i];

                // 🔥 FIX: increment j not i
                for (int j = 0; j < ll.size(); j++) { 
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(k key, v value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = bukets[bi].get(di);
                node.value = value;

            } else {
                bukets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(k key) {
            return searchInLL(key, hashFunction(key)) != -1; // cleaner
        }

        public v remove(k key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = bukets[bi].remove(di);
                n--;
                return node.value;
            }
            return null;
        }

        public v get(k key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = bukets[bi].get(di);
                return node.value;
            }
            return null;
        }

        public ArrayList<k> keySet() {
            ArrayList<k> keys = new ArrayList<>();

            // 🔥 FIX: loop through actual bucket lists, not new empty list
            for (int i = 0; i < bukets.length; i++) {
                LinkedList<Node> ll = bukets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("china", 100);
        hm.put("us", 100);
        hm.put("uk", 100);
        hm.put("nepal", 100);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println(hm.get("India"));
    }
}
