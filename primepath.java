import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class primepath {
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int[][] arr = new int[110][2];
    public static boolean[] primeCheck = new boolean[10000];
    public static int[] count = new int[10000];
    public static boolean[] visited = new boolean[10000];

    public static void main(String args[]){
        Queue<Integer> que = new LinkedList<>();

        for(int i=0; i<numN; i++){
            int numA = scan.nextInt();
            int numB = scan.nextInt();

            arr[i][0] = numA;
            arr[i][1] = numB;
        }

        for(int i=2; i<=9999; i++){
            for(int j=2; i*j<=9999; j++){
                if(primeCheck[i*j] == false){
                    primeCheck[i*j] = true;
                }
            }
        }

        for(int i=1000; i<=9999; i++){
            count[i] = 99999999;
        }

        for(int i=0; i<numN; i++){
            count[arr[i][0]] = 0;
            visited[arr[i][0]] = true;
            que.add(arr[i][0]);
            int result = bfs(que, i);
            System.out.println(result);
        }

    }

    public static int bfs(Queue<Integer> que, int index){
        int result = 0;
        while(que.isEmpty() == false){
            int num = que.peek();
            que.poll();

            int one = num%10;
            int ten = num%100/10;
            int hun = num%1000/100;
            int tho = num/1000;

            for(int i=0; i<=9; i++){
                if(i != one){
                    if(primeCheck[(tho*1000)+(hun*100)+(ten*10)+i] == false && visited[(tho*1000)+(hun*100)+(ten*10)+i] == false){
                        if(count[(tho*1000)+(hun*100)+(ten*10)+i] > count[num]+1){
                            count[(tho*1000)+(hun*100)+(ten*10)+i] = count[num]+1;
                        }
                        visited[(tho*1000)+(hun*100)+(ten*10)+i] = true;
                        que.add((tho*1000)+(hun*100)+(ten*10)+i);
                    }
                }
                if(i != ten){
                    if(primeCheck[(tho*1000)+(hun*100)+(i*10)+one] == false && visited[(tho*1000)+(hun*100)+(i*10)+one] == false){
                        if(count[(tho*1000)+(hun*100)+(i*10)+one] > count[num]+1){
                            count[(tho*1000)+(hun*100)+(i*10)+one] = count[num] +1;
                        }
                        visited[(tho*1000)+(hun*100)+(i*10)+one] = true;
                        que.add((tho*1000)+(hun*100)+(i*10)+one);
                    }
                }
                if(i != hun){
                    if(primeCheck[(tho*1000)+(i*100)+(ten*10)+one] == false && visited[(tho*1000)+(i*100)+(ten*10)+one] == false){
                        if(count[(tho*1000)+(i*100)+(ten*10)+one] > count[num]+1){
                            count[(tho*1000)+(i*100)+(ten*10)+one] = count[num]+1;
                        }
                        visited[(tho*1000)+(i*100)+(ten*10)+one] = true;
                        que.add((tho*1000)+(i*100)+(ten*10)+one);
                    }
                }
                if(i != tho && i != 0){
                    if(primeCheck[(i*1000)+(hun*100)+(ten*10)+one] == false && visited[(i*1000)+(hun*100)+(ten*10)+one] == false){
                        if(count[(i*1000)+(hun*100)+(ten*10)+one] > count[num]+1){
                            count[(i*1000)+(hun*100)+(ten*10)+one] = count[num]+1;
                        }
                        visited[(i*1000)+(hun*100)+(ten*10)+one] = true;
                        que.add((i*1000)+(hun*100)+(ten*10)+one);
                    }
                }
            }
        }

        result = count[arr[index][1]];
        for(int i=1000; i<=9999; i++){
            visited[i] = false;
            count[i] = 99999999;
        }

        return result;

    }
}
