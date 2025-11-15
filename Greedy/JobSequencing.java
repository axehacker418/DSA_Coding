// package Greedy;

//  Job do before deadline  Job A=4,20 JOb B=1, 10 etc 

// // Given an array of jobs where every job has a deadlne and
//  profit if the job is finished before the deadline .
//   it is also given that every job takes a single unit of time 
//   so the minimum possible deadline for any job is 1. Mx the total profit if only one job can be sheduled at a time . 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencing {
  static class Job{
    int deadline;
    int profit;
    int id;

    public Job(int d, int p, int id){
        this.deadline=d;
        this.profit=p;
        this.id=id;

    }
  }
    public static void main(String[] args) {
        int jobsinfo[][]={{4,20}, {1,10}, {1,40}, {1,30}};

        ArrayList<Job> jobs =new ArrayList<>();

        for(int i=0; i<jobsinfo.length; i++){
            jobs.add(new Job(jobsinfo[i][0],jobsinfo[i][1], i));
        }

        // Arrays.sort(jobs, Comparator.comparingDouble(o->o[1]));
        Collections.sort(jobs, (a,b)->b.profit- a.profit); // decending sort
        int time =0;
        ArrayList<Integer> seq=new ArrayList<>();
        for(int i=0; i<jobs.size(); i++){ 
            Job curr= jobs.get(i);
            if (curr.deadline>time) {
                seq.add(curr.id);
            }
            time++;
        }

        System.out.println("max jobs "+ seq.size());

        for(int i=0; i<seq.size(); i++){
            System.out.print(" "+ seq.get(i));
        }
        System.out.println(" ");
    }
    
}
