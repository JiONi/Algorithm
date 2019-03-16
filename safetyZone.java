import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class safetyZone {
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int[][] area = new int[110][110];
    public static int maxHigh = 0;
    public static zonePoint[][] point = new zonePoint[110][110];

    public static void main(String args[]){
        Queue<zonePoint> que = new LinkedList<>();
        for(int i=0; i<numN; i++){
            for(int j=0; j<numN; j++){
                area[i][j] = scan.nextInt();
                if(area[i][j] > maxHigh){
                    maxHigh = area[i][j];
                }
                point[i][j] = new zonePoint();
                point[i][j].x = i;
                point[i][j].y = j;
            }
        }


        int result = 0;

        for(int i=1; i<=maxHigh; i++){
            int cnt = 0;
            for(int j=0; j<numN; j++){
                for(int k=0; k<numN; k++){
                    if(area[j][k] > i && point[j][k].visited == false){
                        point[j][k].visited = true;
                        que.add(point[j][k]);
                        bfs(que, i);
                        cnt++;
                    }
                }
            }
            for(int j=0; j<numN; j++){
                for(int k=0; k<numN; k++){
                    point[j][k].visited = false;
                }
            }
            if(result < cnt){
                result = cnt;
            }
        }
        System.out.println(result);
    }

    public static void bfs(Queue<zonePoint> que, int high){
        while(que.isEmpty() == false){
            zonePoint nowPoint = que.peek();
            que.poll();

            if(nowPoint.x > 0 && area[nowPoint.x-1][nowPoint.y] > high && point[nowPoint.x-1][nowPoint.y].visited == false){
                point[nowPoint.x-1][nowPoint.y].visited = true;
                que.add(point[nowPoint.x-1][nowPoint.y]);
            }
            if(nowPoint.x < numN-1 && area[nowPoint.x+1][nowPoint.y] > high && point[nowPoint.x+1][nowPoint.y].visited == false){
                point[nowPoint.x+1][nowPoint.y].visited = true;
                que.add(point[nowPoint.x+1][nowPoint.y]);
            }
            if(nowPoint.y > 0 && area[nowPoint.x][nowPoint.y-1] > high && point[nowPoint.x][nowPoint.y-1].visited == false){
                point[nowPoint.x][nowPoint.y-1].visited = true;
                que.add(point[nowPoint.x][nowPoint.y-1]);
            }
            if(nowPoint.y < numN-1 && area[nowPoint.x][nowPoint.y+1] > high && point[nowPoint.x][nowPoint.y+1].visited == false){
                point[nowPoint.x][nowPoint.y+1].visited = true;
                que.add(point[nowPoint.x][nowPoint.y+1]);
            }
        }
    }
}
class zonePoint{
    int x;
    int y;
    boolean visited = false;
}
