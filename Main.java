import java.util.*; 
public class Main { 
 static class Item { 
 int id, profit, weight; 
 double ratio;
 Item(int id, int profit, int weight) {  this.id = id; 
 this.profit = profit; 
 this.weight = weight; 
 this.ratio = (double) profit / weight;  } 
 } 
 public static void main(String[] args) {  Scanner sc = new Scanner(System.in); 
 System.out.print("Enter number of items: ");  int n = sc.nextInt(); 
 if (n < 0) { 
 System.out.println("Invalid input.");  return; 
 } 
 Item[] items = new Item[n]; 
 for (int i = 0; i < n; i++) { 
 System.out.print("Enter profit and weight: "); 
 int p = sc.nextInt(); 
 int w = sc.nextInt(); 
 if (w <= 0) { 
 System.out.println("Weight must be positive."); 
 return; 
 }
 items[i] = new Item(i + 1, p, w);  } 
 System.out.print("Enter knapsack capacity: ");  int capacity = sc.nextInt(); 
 if (capacity < 0) { 
 System.out.println("Invalid capacity.");  return; 
 } 
 Arrays.sort(items, (a, b) -> 
 Double.compare(b.ratio, a.ratio)); 
 double totalProfit = 0; 
 double remaining = capacity; 
 System.out.println("\nSelected Items:"); 
 for (Item x : items) { 
 if (remaining <= 0) 
 break; 
 if (x.profit <= 0) 
 continue; 
 double taken = Math.min(remaining, x.weight);  double fraction = taken / x.weight; 
 totalProfit += fraction * x.profit;  remaining -= taken; 
 System.out.printf(
 "Item %d: Weight = %.2f, Fraction = %.2f, Profit = %.2f%n", 
 x.id, taken, fraction, fraction * x.profit  ); 
 } 
 System.out.printf("Maximum Profit = %.2f%n", totalProfit); 
 } 
} 
