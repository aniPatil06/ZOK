import java.util.*; 
public class Main { 
 public static void main(String[] args) { 
 Scanner sc = new Scanner(System.in); 
 System.out.print("Enter number of items: ");  int n = sc.nextInt(); 
 if (n < 0) { 
 System.out.println("Invalid input.");  return; 
 } 
 int[] weight = new int[n]; 
 long[] profit = new long[n];
 for (int i = 0; i < n; i++) { 
 System.out.print("Enter weight and profit: "); 
 weight[i] = sc.nextInt(); 
 profit[i] = sc.nextLong(); 
 if (weight[i] <= 0) { 
 System.out.println("Invalid weight.");  return; 
 } 
 } 
 System.out.print("Enter capacity: ");  int W = sc.nextInt(); 
 if (W < 0) { 
 System.out.println("Invalid capacity.");  return; 
 } 
 long[][] dp = new long[n + 1][W + 1]; 
 for (int i = 1; i <= n; i++) { 
 for (int w = 0; w <= W; w++) { 
 dp[i][w] = dp[i - 1][w]; 
 if (weight[i - 1] <= w) { 
 long take = profit[i - 1]  + dp[i - 1][w - weight[i - 1]]; 
 dp[i][w] = Math.max(dp[i][w], take);  }
 } 
 } 
 System.out.println("Maximum Profit = " + dp[n][W]); 
 ArrayList<Integer> selected = new ArrayList<>();  int w = W; 
 for (int i = n; i > 0; i--) { 
 if (dp[i][w] != dp[i - 1][w]) { 
 selected.add(i); 
 w -= weight[i - 1]; 
 } 
 } 
 Collections.reverse(selected); 
 System.out.println("Selected Items = " + selected);  } 
} 
