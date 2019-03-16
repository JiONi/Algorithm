import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class cheeze {
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int numM = scan.nextInt();
    public static int[][] map = new int[110][110];
    public static mapPoint[][] point = new mapPoint[110][110];
    public static int[] remainCheeze = new int[110];
    public static int time = 1;

    public static void main(String args[]){
        Queue<mapPoint> que = new LinkedList<>();

        int firstCheeze = 0;
        for(int i=0; i<numN; i++){
            for(int j=0; j<numM; j++){
                point[i][j] = new mapPoint();
                point[i][j].x = i;
                point[i][j].y = j;
                map[i][j] = scan.nextInt();
                if(map[i][j] == 1){
                    firstCheeze++;
                }
            }
        }
        remainCheeze[0] = firstCheeze;

        while(bfs(que));

        System.out.println(time+" "+remainCheeze[time-1]);

    }

    public static boolean bfs(Queue<mapPoint> que){
        que.add(point[0][0]);

        while(que.isEmpty() == false){
            mapPoint nowPoint = que.peek();
            que.poll();

            if(nowPoint.x > 0 && point[nowPoint.x-1][nowPoint.y].visited == false){
                if(map[nowPoint.x-1][nowPoint.y] == 1){
                    point[nowPoint.x-1][nowPoint.y].visited = true;
                    map[nowPoint.x-1][nowPoint.y] = 0;
                }else{
                    point[nowPoint.x-1][nowPoint.y].visited = true;
                    que.add(point[nowPoint.x-1][nowPoint.y]);
                }
            }
            if(nowPoint.x < numN-1 && point[nowPoint.x+1][nowPoint.y].visited == false){
                if(map[nowPoint.x+1][nowPoint.y] == 1){
                    point[nowPoint.x+1][nowPoint.y].visited = true;
                    map[nowPoint.x+1][nowPoint.y] = 0;
                }else{
                    point[nowPoint.x+1][nowPoint.y].visited = true;
                    que.add(point[nowPoint.x+1][nowPoint.y]);
                }
            }
            if(nowPoint.y > 0 && point[nowPoint.x][nowPoint.y-1].visited == false){
                if(map[nowPoint.x][nowPoint.y-1] == 1){
                    point[nowPoint.x][nowPoint.y-1].visited = true;
                    map[nowPoint.x][nowPoint.y-1] = 0;
                }else{
                    point[nowPoint.x][nowPoint.y].visited = true;
                    que.add(point[nowPoint.x][nowPoint.y-1]);
                }
            }
            if(nowPoint.y < numM-1 && point[nowPoint.x][nowPoint.y+1].visited == false){
                if(map[nowPoint.x][nowPoint.y+1] == 1){
                    point[nowPoint.x][nowPoint.y+1].visited = true;
                    map[nowPoint.x][nowPoint.y+1] = 0;
                }else{
                    point[nowPoint.x][nowPoint.y+1].visited = true;
                    que.add(point[nowPoint.x][nowPoint.y+1]);
                }

            }
        }

        int cheezeSum = 0;
        for(int i=0; i<numN; i++){
            for(int j=0; j<numM; j++){
                point[i][j].visited = false;
                if(map[i][j] == 1){
                    cheezeSum++;
                }
            }
        }

        if(cheezeSum == 0){
            return false;
        }else{
            remainCheeze[time] = cheezeSum;
            time++;
            return true;
        }

    }
}
class mapPoint{
    int x;
    int y;
    boolean visited = false;
}
