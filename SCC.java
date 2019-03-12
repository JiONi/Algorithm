import java.util.ArrayList;
import java.util.Scanner;
public class SCC{
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int numM = scan.nextInt();
    public static ArrayList<Integer> arr[] = new ArrayList[1010];
    public static ArrayList<Integer> reverseArr[] = new ArrayList[1010];
    public static int[] time = new int[1010];
    public static int clock = 0;
    public static int[] order = new int[1010];
    public static int orderLen = 0;
    public static boolean[] check = new boolean[1010];
    public static boolean[] check2 = new boolean[1010];
    public static int[] group = new int[1010];
    public static int groupCnt = 1;

    public static void main(String[] args){

        // Please Enter Your Code Here
        
        // ArrayList 초기 생성
        for(int i=0; i<=numN; i++){
            arr[i] = new ArrayList<Integer>();
            reverseArr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<numM; i++){
            int numA = scan.nextInt();
            int numB = scan.nextInt();

            if(arr[numA] == null){
                arr[numA] = new ArrayList<Integer>();
            }
            if(reverseArr[numB] == null){
                reverseArr[numB] = new ArrayList<Integer>();
            }
            arr[numA].add(numB);
            reverseArr[numB].add(numA);
        }

        // DFS로 순회 하며 돌아오는데 걸리는 시간 저장
        for(int i=1; i<=numN; i++){
            if(check[i] == false){
                getTime(i);
            }
        }

        // 돌아오는 시간이 큰 순서대로 역간선방향 순회하며 그룹 찾기
        for(int i=orderLen-1; i>=0; i--){
            int node = order[i];
            if(check2[node] == false){
                getMyGroup(node);
                groupCnt++;
            }
        }

        System.out.println(groupCnt-1);
    }

    public static void getTime(int node){
        check[node] = true;

        for(int i=0; i<arr[node].size(); i++){
            int num = arr[node].get(i);

            if(check[num] == false){
                getTime(num);
            }
        }

        time[node] = clock;
        clock++;
        order[orderLen++] = node;
    }

    public static void getMyGroup(int node){
        check2[node] = true;
        group[node] = groupCnt;

        for(int i=0; i<reverseArr[node].size(); i++){
            int num = reverseArr[node].get(i);

            if(check2[num] == false){
                getMyGroup(num);
            }
        }
    }
}