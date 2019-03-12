import java.util.ArrayList;
import java.util.Scanner;

public class specificMinDist {
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int numM = scan.nextInt();
    public static ArrayList<Integer> arr[] = new ArrayList[1010];
    public static ArrayList<Integer> cost[] = new ArrayList[1010];
    public static int[] minDistToA = new int[1010];
    public static int[] minDistToB = new int[1010];
    public static int[] minDistToEnd = new int[1010];
    public static boolean[] checkToA = new boolean[1010];
    public static boolean[] checkToB = new boolean[1010];
    public static boolean[] checkToEnd = new boolean[1010];

    public static void main(String args[]){
        for(int i=0; i<numM; i++){
            int numA = scan.nextInt();
            int numB = scan.nextInt();
            int weight = scan.nextInt();

            if(arr[numA] == null){
                arr[numA] = new ArrayList<Integer>();
            }
            if(arr[numB] == null){
                arr[numB] = new ArrayList<Integer>();
            }
            if(cost[numA] == null){
                cost[numA] = new ArrayList<Integer>();
            }
            if(cost[numB] == null){
                cost[numB] = new ArrayList<Integer>();
            }
            arr[numA].add(numB);
            arr[numB].add(numA);
            cost[numA].add(weight);
            cost[numB].add(weight);
        }

        int nodeA = scan.nextInt();
        int nodeB = scan.nextInt();

        for(int i=0; i<=numN; i++){
            minDistToA[i] = 987987987;
            minDistToB[i] = 987987987;
            minDistToEnd[i] = 987987987;
        }

        minDistToA[1] = 0;
        int result = 0;

        for(int i=1; i<=numN; i++){
            int minValue = 987987987;
            int minIndex = -1;
            for(int j=1; j<=numN; j++){
                if(checkToA[j] == false && minValue > minDistToA[j]){
                    minValue = minDistToA[j];
                    minIndex = j;
                }
            }

            checkToA[minIndex] = true;
            for(int j=0; j<arr[minIndex].size(); j++){
                int node2 = arr[minIndex].get(j);
                int cost2 = cost[minIndex].get(j);

                if(minDistToA[node2] > minDistToA[minIndex]+cost2){
                    minDistToA[node2] = minDistToA[minIndex]+cost2;
                }
            }
        }

        result += minDistToA[nodeA];

        minDistToB[nodeA] = 0;

        for(int i=1; i<=numN; i++){
            int minValue = 987987987;
            int minIndex = -1;

            for(int j=1; j<=numN; j++){
                if(checkToB[j] == false && minValue > minDistToB[j]){
                    minValue = minDistToB[j];
                    minIndex = j;
                }
            }

            checkToB[minIndex] = true;

            for(int j=0; j<arr[minIndex].size(); j++){
                int node2 = arr[minIndex].get(j);
                int cost2 = cost[minIndex].get(j);

                if(minDistToB[node2] > minDistToB[minIndex]+cost2){
                    minDistToB[node2] = minDistToB[minIndex]+cost2;
                }

            }
        }

        result += minDistToB[nodeB];

        minDistToEnd[nodeB] = 0;

        for(int i=1; i<=numN; i++){
            int minValue = 987987987;
            int minIndex = -1;

            for(int j=1; j<=numN; j++){
                if(checkToEnd[j] == false && minValue > minDistToEnd[j]){
                    minValue = minDistToEnd[j];
                    minIndex = j;
                }
            }

            checkToEnd[minIndex] = true;

            for(int j=0; j<arr[minIndex].size(); j++){
                int node2 = arr[minIndex].get(j);
                int cost2 = cost[minIndex].get(j);

                if(minDistToEnd[node2] > minDistToEnd[minIndex]+cost2){
                    minDistToEnd[node2] = minDistToEnd[minIndex]+cost2;
                }
            }
        }

        result += minDistToEnd[numN];

        System.out.println(result);
    }
}
