// package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]=  {2,4,6,7,9,9};

       int  n=start.length;
        // Dynamic data 
        int activities[][]=new int[n][3];

        for(int i=0; i<n; i++){
            activities[i][0]=i; //original index of activites 
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o->o[2])); // lambda function to sort using coloum no. 2 
        
        //After sorting for end time then ...

        // int maxActivity=0;
        // ArrayList<Integer> ans=new ArrayList<>();

        // // fisrt activity selection 
        // maxActivity=1;
        // ans.add(0); // adding activity index 
        // int lastEnd=end[0];
        // for(int i=1; i<end.length; i++){
        //     if (start[i]>=lastEnd) {
        //         maxActivity++;
        //         ans.add(i);
        //         lastEnd=end[i];
        //     }

        // }
        // System.out.println("max activities ="+ maxActivity);

        // for(int i=0; i<ans.size(); i++){
        //     System.out.print(ans.get(i)+1);
        // }


        int maxActivity=0;
        ArrayList<Integer> ans=new ArrayList<>();

        // fisrt activity selection 
        maxActivity=1;
        ans.add(activities[0][0]); // adding activity index 
        int lastEnd=activities[0][2];
        for(int i=1; i<end.length; i++){
            if (activities[i][1]>=lastEnd) {
                maxActivity++;
                ans.add(activities[i][0]);
                lastEnd=activities[i][2];
            }

        }
        System.out.println("max activities ="+ maxActivity);

        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i));
        }
    }
    
}
