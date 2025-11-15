import java.util.*;
//  greedi problem to 
// We are given an infinite supply of denominations {1,2,5,10,20,50,100,500,2000}. Find min no of coins/ notes to make change for a value V.
// Greedy Approach only used for canonican no. systems 

public class IndoCoin {
    public static void main(String[] args) {
        Integer coin[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

        // if not sorted
        Arrays.sort(coin, Comparator.reverseOrder());

        int amount = 590;
        int count = 0;
        ArrayList<Integer> ans=new ArrayList<>();

        for (int i = 0; i < coin.length; i++) {
            if (coin[i] <=amount) {
                while (coin[i] <= amount) {
                    count++;
                    ans.add(coin[i]);
                    amount = amount - coin[i];

                }
            }

        }
        System.out.println(" total min coins used "+ count);

        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }

}
