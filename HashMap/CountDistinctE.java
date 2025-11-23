import java.util.HashSet;
import java.util.TreeSet;

public class CountDistinctE {

    public static void main(String[] args) {
        int num[]={4,5,2,3,5,6,7,4,2,1};

        // nested loop and check uniques and store 

        // TreeSet<Integer> result=new TreeSet<>();
        // for(int i=0; i<num.length; i++){
        //     result.add(num[i]);
        // }

        // System.out.println(result);

        HashSet<Integer> hs=new HashSet<>();
        for(int i=0; i<num.length; i++){
            hs.add(num[i]);
        }

        System.out.println(hs+" size of this is "+ hs.size());
    }
    
}
