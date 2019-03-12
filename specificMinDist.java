import java.util.ArrayList;
import java.util.Scanner;

public class specificMinDist {
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int numM = scan.nextInt();
    public static ArrayList<Integer> arr[] = new ArrayList[1010];
    public static ArrayList<Integer> cost[] = new ArrayList[1010];
    public static int[] minDistFromStart = new int[1010];
    public static int[] minDistFromA = new int[1010];
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
            minDistFromStart[i] = 987987987;
            minDistFromA[i] = 987987987;
            minDistToEnd[i] = 987987987;
        }

        minDistFromStart[1] = 0;
        int resultAtoB = 0;
        int resultBtoA = 0;

        for(int i=1; i<=numN; i++){
            int minValue = 987987987;
            int minIndex = -1;
            for(int j=1; j<=numN; j++){
                if(checkToA[j] == false && minValue > minDistFromStart[j]){
                    minValue = minDistFromStart[j];
                    minIndex = j;
                }
            }

            checkToA[minIndex] = true;
            for(int j=0; j<arr[minIndex].size(); j++){
                int node2 = arr[minIndex].get(j);
                int cost2 = cost[minIndex].get(j);

                if(minDistFromStart[node2] > minDistFromStart[minIndex]+cost2){
                    minDistFromStart[node2] = minDistFromStart[minIndex]+cost2;
                }
            }
        }

        resultAtoB += minDistFromStart[nodeA];
        resultBtoA += minDistFromStart[nodeB];

        minDistFromA[nodeA] = 0;

        for(int i=1; i<=numN; i++){
            int minValue = 987987987;
            int minIndex = -1;

            for(int j=1; j<=numN; j++){
                if(checkToB[j] == false && minValue > minDistFromA[j]){
                    minValue = minDistFromA[j];
                    minIndex = j;
                }
            }

            checkToB[minIndex] = true;

            for(int j=0; j<arr[minIndex].size(); j++){
                int node2 = arr[minIndex].get(j);
                int cost2 = cost[minIndex].get(j);

                if(minDistFromA[node2] > minDistFromA[minIndex]+cost2){
                    minDistFromA[node2] = minDistFromA[minIndex]+cost2;
                }

            }
        }

        resultAtoB += minDistFromA[nodeB];
        resultBtoA += minDistFromA[nodeB];

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

        resultAtoB += minDistToEnd[numN];
        resultBtoA += minDistFromA[numN];

        if(resultAtoB > resultBtoA){
            System.out.println(resultBtoA);
        }else{
            System.out.println(resultAtoB);
        }
    }
}
