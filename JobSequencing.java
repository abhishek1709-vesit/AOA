import java.util.*;

class Job{
    char id;
    int profit, deadline;

    Job(char id, int profit, int deadline){
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}

public class JobSequencing {


    public static void main(String[] args){

        Job[] jobs = {
            new Job('A',  100, 2),
            new Job('B', 19, 1),
            new Job('C', 97, 2),
            new Job('D', 25, 1)
        };

        Arrays.sort(jobs, (a,b) -> b.profit - a.profit);

        int maxDeadline = 0;

        for(Job job : jobs){
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int totalProfit = 0;

        char[] slots = new char[maxDeadline];
        Arrays.fill(slots, '-');

        for(Job job : jobs){
            for(int j = job.deadline - 1; j>=0; j--){
                if(slots[j] == '-'){
                    slots[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Scheduled Jobs");
        for(char job:slots){
            if(job != '-') System.out.print(job + " ");
        }

        System.out.println("Total profit = " + totalProfit);
    }
}
