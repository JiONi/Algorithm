import java.util.*;
public class party{
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int numM = scan.nextInt();
    public static int cHouse = scan.nextInt();
    public static ArrayList<Integer> arr[] = new ArrayList[1010];
    public static ArrayList<Integer> reverseArr[] = new ArrayList[1010];
    public static ArrayList<Integer> cost[] = new ArrayList[1010];
    public static ArrayList<Integer> reverseCost[] = new ArrayList[1010];
    public static int[] minDistToHome = new int[numN+1];
    public static int[] minDistToCHouse = new int[numN+1];
    public static boolean[] checkToHome = new boolean[numN+1];
    public static boolean[] checkToCHose = new boolean[numN+1];

    public static void main(String[] args){

        // Please Enter Your Code Here

        for(int i=0; i<numM; i++){
            int numA = scan.nextInt();
            int numB = scan.nextInt();
            int numCost = scan.nextInt();

            if(arr[numA] == null){
                arr[numA] = new ArrayList<Integer>();
                cost[numA] = new ArrayList<Integer>();
            }

            if(reverseArr[numB] == null){
                reverseArr[numB] = new ArrayList<Integer>();
                reverseCost[numB] = new ArrayList<Integer>();
            }
            arr[numA].add(numB);
            reverseArr[numB].add(numA);
            cost[numA].add(numCost);
            reverseCost[numB].add(numCost);
        }

        for(int i=0; i<=numN; i++){
            minDistToHome[i] = 987987987;
            minDistToCHouse[i] = 987987987;
        }

        minDistToHome[cHouse] = 0;

        for(int i=1; i<=numN; i++){
            int minValue = 987987987;
            int minIndex = -1;

            for(int j=1; j<=numN; j++){
                if(checkToHome[j] == false){
                    if(minValue > minDistToHome[j]){
                        minValue = minDistToHome[j];
                        minIndex = j;
                    }
                }
            }

            checkToHome[minIndex] = true;

            for(int j=0; j<arr[minIndex].size(); j++){
                int node2 = arr[minIndex].get(j);
                int cost2 = cost[minIndex].get(j);

                if(minDistToHome[node2] > minDistToHome[minIndex]+cost2){
                    minDistToHome[node2] = minDistToHome[minIndex]+cost2;
                }
            }
        }

        minDistToCHouse[cHouse] = 0;

        for(int i=1; i<=numN; i++){
            int minValue = 987987987;
            int minIndex = -1;

            for(int j=1; j<=numN; j++){
                if(checkToCHose[j] == false){
                    if(minValue > minDistToCHouse[j]){
                        minValue = minDistToCHouse[j];
                        minIndex = j;
                    }
                }
            }

            checkToCHose[minIndex] = true;

            for(int j=0; j<reverseArr[minIndex].size(); j++){
                int node2 = reverseArr[minIndex].get(j);
                int cost2 = reverseCost[minIndex].get(j);

                if(minDistToCHouse[node2] > minDistToCHouse[minIndex] + cost2){
                    minDistToCHouse[node2] = minDistToCHouse[minIndex] + cost2;
                }
            }
        }

        int result = 0;

        for(int i=1; i<=numN; i++){
            result += minDistToCHouse[i];
            result += minDistToHome[i];
        }

        System.out.println(result);
    }
}