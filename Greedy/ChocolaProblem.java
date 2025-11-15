
//  We are given a bar of a chocolate compsed of mxn sqaure pieces .
// One should break the chocolaye into single Squre . Each nbreak of a part of the chocolate is charged a cost expresses bya positive integer this cost does not deprend on the soze of the part that is being broken 
// but only depends on the line the break goes along let us denote the costs of breakinf along consecutive vertical lines with x1 x2 .. xm-1 and along horizontal lines with y1 y2    yn-1 .package Greedy;
// compute the minimal cost of breaking the whole chcolate into single squares .
// SPOJ
import java.util.*;

class ChocolaProblem {
    public static void main(String[] args) {
        int n = 4;
        int m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int h = 0;
        int v = 0;
        int hp = 1, vp = 1, cost = 0;
        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {
                cost += (costHor[h] * vp);
                hp++;
                h++;

            } else {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }

        }

        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            hp++;
            h++;

        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;

        }

        System.out.println("total cost is " + cost);
    }

}