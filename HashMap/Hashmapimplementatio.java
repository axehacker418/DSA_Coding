import java.util.LinkedList;

public class Hashmapimplementatio {

    static class HashMap<k, v> { // k and v are generric variables mean they can be any datatype {general data
                                 // type }

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
        private LinkedList<Node> bukets[];// array of linked list of nodes type { this is the actual hashmap}

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
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;

                }
                di++;
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldbuck[] = bukets;
            bukets = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < bukets.length; i++) {
                bukets[i] = new LinkedList<>();
            }

            // nodes add to new bucket
            for (int i = 0; i < oldbuck.length; i++) {
                LinkedList<Node> ll = oldbuck[i];
                for (int j = 0; j < ll.size(); i++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }

            }
        }

        public void put(k key, v value) {
            int bi = hashFunction(key);// 0 to size-1
            int di = searchInLL(key, bi);// valid -1
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
            return true;
        }
    }



    public static void main(String[] args) {
        HashMap<String, Integer> hm=new HashMap<>();
        hm.put("India", 100);
    }
}