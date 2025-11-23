public class Trie {

    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        Node(){
            for(int i=0; i<26; i++){
                children[i]=null;
            }
        }
    }

    public static Node root=new Node();// always empty root node
    
    //insertion in tries important in fang companies    O(l)  where l =largest word's length 
    public static void main(String[] args) {
        
        
    }
}