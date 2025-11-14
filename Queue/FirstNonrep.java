import java.util.Queue;
import java.util.LinkedList;

public class FirstNonrep{

    public static void Nonrep(String str){

        int freq[] =new int[26]; // a-z

        Queue<Character> q1=new LinkedList<>();
        // Queue<Character> q2=new LinkedList<>();

        for(int i=0; i<str.length(); i++){ 
            char ch =str.charAt(i); //char track 
            ch = Character.toLowerCase(ch);
            q1.add(ch); // add in queue 
            freq[ch-'a']++; // int value of 0-25 no a-a =0 because 97-97
            while (!q1.isEmpty() && freq[q1.peek()-'a']>1) {q1.remove();
                
            }
            if (q1.isEmpty()) {
                System.out.println(-1+" ");
                
            }
            else{
                System.out.println(q1.peek()+" ");
            }
        }
        q1.peek();


    }

    public static void main(String[] args) {
        String input="aabccxb";
        Nonrep(input);


        
    }
}