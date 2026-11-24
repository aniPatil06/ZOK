import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of items: "); int n=sc.nextInt();
        if(n<0) { System.out.println("Invalid input"); return; }
        int[] wt=new int[n]; long[] p=new long[n];
        for(int i=0;i<n;i++) {
            System.out.print("Enter weight and profit: ");
            wt[i]=sc.nextInt(); p[i]=sc.nextLong();
            if(wt[i]<0) { System.out.println("Invalid weight"); return; }
        }
        System.out.print("Enter capacity: "); int W=sc.nextInt();
        if(W<0) { System.out.println("Invalid capacity"); return; }
        long[][] dp=new long[n+1][W+1];
        for(int i=1;i<=n;i++) for(int w=0;w<=W;w++) {
            dp[i][w]=dp[i-1][w];
            if(wt[i-1]<=w) dp[i][w]=Math.max(dp[i][w],p[i-1]+dp[i-1][w-wt[i-1]]);
        }
        ArrayList<Integer> chosen=new ArrayList<>();
        int w=W;
        for(int i=n;i>0;i--) if(dp[i][w]!=dp[i-1][w]) {
            chosen.add(i); w-=wt[i-1];
        }
        Collections.reverse(chosen);
        System.out.println("Maximum Profit = "+dp[n][W]);
        System.out.println("Selected Items = "+chosen);
    }
}
