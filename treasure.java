import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class treasure {
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int numM = scan.nextInt();
    public static char[][] map = new char[55][55];
    public static treasurePoint[][] point = new treasurePoint[55][55];
    public static treasurePoint[] groundPoint = new treasurePoint[55];
    public static int groundCnt = 0 ;

    public static void main(String args[]){
        Queue<treasurePoint> que = new LinkedList<>();

        scan.nextLine();

        for(int i=0; i<numN; i++){
            String s = scan.nextLine();
            for(int j=0; j<numM; j++){
                point[i][j] = new treasurePoint();
                point[i][j].x = i;
                point[i][j].y = j;
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'L'){
                    groundPoint[groundCnt++] = point[i][j];
                }
            }
        }

        int result = -987987987;
        for(int i=0; i<groundCnt; i++){
            treasurePoint firstPoint = groundPoint[i];

            firstPoint.visited = true;
            firstPoint.dist = 0;
            que.add(firstPoint);
            int dist = bfs(que);
            if(dist > result){
                result = dist;
            }
        }

        System.out.println(result);
    }

    public static int bfs(Queue<treasurePoint> que){
        while(que.isEmpty() == false){
            treasurePoint nowPoint = que.peek();
            que.poll();

            if(nowPoint.x > 0 && map[nowPoint.x-1][nowPoint.y] == 'L' && point[nowPoint.x-1][nowPoint.y].visited == false){
                if(point[nowPoint.x-1][nowPoint.y].dist > nowPoint.dist+1){
                    point[nowPoint.x-1][nowPoint.y].dist = nowPoint.dist+1;
                }
                point[nowPoint.x-1][nowPoint.y].visited = true;
                que.add(point[nowPoint.x-1][nowPoint.y]);
            }
            if(nowPoint.x < numN-1 && map[nowPoint.x+1][nowPoint.y] == 'L' && point[nowPoint.x+1][nowPoint.y].visited == false){
                if(point[nowPoint.x+1][nowPoint.y].dist > nowPoint.dist+1){
                    point[nowPoint.x+1][nowPoint.y].dist = nowPoint.dist+1;
                }
                point[nowPoint.x+1][nowPoint.y].visited = true;
                que.add(point[nowPoint.x+1][nowPoint.y]);
            }
            if(nowPoint.y > 0 && map[nowPoint.x][nowPoint.y-1] == 'L' && point[nowPoint.x][nowPoint.y-1].visited == false){
                if(point[nowPoint.x][nowPoint.y-1].dist > nowPoint.dist+1){
                    point[nowPoint.x][nowPoint.y-1].dist = nowPoint.dist+1;
                }
                point[nowPoint.x][nowPoint.y-1].visited = true;
                que.add(point[nowPoint.x][nowPoint.y-1]);
            }
            if(nowPoint.y < numM-1 && map[nowPoint.x][nowPoint.y+1] == 'L' && point[nowPoint.x][nowPoint.y+1].visited == false){
                if(point[nowPoint.x][nowPoint.y+1].dist > nowPoint.dist+1){
                    point[nowPoint.x][nowPoint.y+1].dist = nowPoint.dist+1;
                }
                point[nowPoint.x][nowPoint.y+1].visited = true;
                que.add(point[nowPoint.x][nowPoint.y+1]);
            }
        }

        int max = -987987987;
        for(int i=0; i<numN; i++){
            for(int j=0; j<numM; j++){
                if(point[i][j].visited == true && point[i][j].dist > max){
                    max = point[i][j].dist;
                }
                point[i][j].visited = false;
                point[i][j].dist = 987987987;
            }
        }

        return max;
    }
}
class treasurePoint{
    int x;
    int y;
    boolean visited = false;
    int dist = 987987987;
}