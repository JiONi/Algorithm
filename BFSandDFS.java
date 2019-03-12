import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSandDFS {
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int numM = scan.nextInt();
    public static int startNode = scan.nextInt();
    public static int[][] arr = new int[1010][1010];
    public static boolean[] DFSCheck = new boolean[1010];
    public static boolean[] BFSCheck = new boolean[1010];

    public static void main(String args[]){
        Queue<Integer> que = new LinkedList<>();

        for(int i=0; i<numM; i++){
            int numA = scan.nextInt();
            int numB = scan.nextInt();

            arr[numA][numB] = 1;
            arr[numB][numA] = 1;
        }

        DFS(startNode);
        System.out.println();

        BFSCheck[startNode] = true;
        que.add(startNode);

        while(que.isEmpty() == false){
            int num = que.peek();
            que.poll();

            System.out.print(num+" ");

            for(int i=1; i<=numN; i++){
                if(arr[num][i] == 1 && BFSCheck[i] == false){
                    BFSCheck[i] = true;
                    que.add(i);
                }
            }
        }
    }

    public static void DFS(int node){
        DFSCheck[node] = true;

        System.out.print(node+" ");
        for(int i=1; i<=numN; i++){
            if(arr[node][i] == 1 && DFSCheck[i] == false){
                DFS(i);
            }
        }
    }
}

