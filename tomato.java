import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tomato {
    public static Scanner scan = new Scanner(System.in);
    public static int numM = scan.nextInt();
    public static int numN = scan.nextInt();
    public static int numH = scan.nextInt();
    public static int[][][] box = new int[110][110][110];
    public static Point[][][] point = new Point[110][110][110];

    public static void main(String args[]){
        Queue<Point> que = new LinkedList<>();


        for(int i=0; i<numH; i++){
            for(int j=0; j<numN; j++){
                for(int k=0; k<numM; k++){
                    point[i][j][k] = new Point();
                    point[i][j][k].x = j;
                    point[i][j][k].y = k;
                    point[i][j][k].h = i;
                    box[i][j][k] = scan.nextInt();
                    if(box[i][j][k] == 1){
                        point[i][j][k].visited = true;
                        point[i][j][k].dist = 0;
                        que.add(point[i][j][k]);
                    }
                }
            }
        }

        bfs(que);

        int maxTime = -987987987;
        for(int i=0; i<numH; i++){
            for(int j=0; j<numN; j++){
                for(int k=0; k<numM; k++){
                    if(point[i][j][k].visited == true && point[i][j][k].dist > maxTime){
                        maxTime = point[i][j][k].dist;
                    }
                    if(box[i][j][k] == 0){
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
        System.out.println(maxTime);

    }
    public static void bfs(Queue<Point> que){
        while(que.isEmpty() == false){
            Point nowPoint = que.peek();
            que.poll();
            if(nowPoint.h > 0 && point[nowPoint.h-1][nowPoint.x][nowPoint.y].visited == false && box[nowPoint.h-1][nowPoint.x][nowPoint.y] == 0){
                box[nowPoint.h-1][nowPoint.x][nowPoint.y] = 1;
                point[nowPoint.h-1][nowPoint.x][nowPoint.y].visited = true;
                point[nowPoint.h-1][nowPoint.x][nowPoint.y].dist = nowPoint.dist+1;
                que.add(point[nowPoint.h-1][nowPoint.x][nowPoint.y]);
            }
            if(nowPoint.h < numH-1 && point[nowPoint.h+1][nowPoint.x][nowPoint.y].visited == false && box[nowPoint.h+1][nowPoint.x][nowPoint.y] == 0){
                box[nowPoint.h+1][nowPoint.x][nowPoint.y] = 1;
                point[nowPoint.h+1][nowPoint.x][nowPoint.y].visited = true;
                point[nowPoint.h+1][nowPoint.x][nowPoint.y].dist = nowPoint.dist+1;
                que.add(point[nowPoint.h+1][nowPoint.x][nowPoint.y]);
            }
            if(nowPoint.x > 0 && point[nowPoint.h][nowPoint.x-1][nowPoint.y].visited == false && box[nowPoint.h][nowPoint.x-1][nowPoint.y] == 0){
                box[nowPoint.h][nowPoint.x-1][nowPoint.y] = 1;
                point[nowPoint.h][nowPoint.x-1][nowPoint.y].visited = true;
                point[nowPoint.h][nowPoint.x-1][nowPoint.y].dist = nowPoint.dist+1;
                que.add(point[nowPoint.h][nowPoint.x-1][nowPoint.y]);
            }
            if(nowPoint.x < numN-1 && point[nowPoint.h][nowPoint.x+1][nowPoint.y].visited == false && box[nowPoint.h][nowPoint.x+1][nowPoint.y] == 0){
                box[nowPoint.h][nowPoint.x+1][nowPoint.y] = 1;
                point[nowPoint.h][nowPoint.x+1][nowPoint.y].visited = true;
                point[nowPoint.h][nowPoint.x+1][nowPoint.y].dist = nowPoint.dist+1;
                que.add(point[nowPoint.h][nowPoint.x+1][nowPoint.y]);
            }
            if(nowPoint.y > 0 && point[nowPoint.h][nowPoint.x][nowPoint.y-1].visited == false && box[nowPoint.h][nowPoint.x][nowPoint.y-1] == 0){
                box[nowPoint.h][nowPoint.x][nowPoint.y-1] = 1;
                point[nowPoint.h][nowPoint.x][nowPoint.y-1].visited = true;
                point[nowPoint.h][nowPoint.x][nowPoint.y-1].dist = nowPoint.dist+1;
                que.add(point[nowPoint.h][nowPoint.x][nowPoint.y-1]);
            }
            if(nowPoint.y < numM-1 && point[nowPoint.h][nowPoint.x][nowPoint.y+1].visited == false && box[nowPoint.h][nowPoint.x][nowPoint.y+1] == 0){
                box[nowPoint.h][nowPoint.x][nowPoint.y+1] = 1;
                point[nowPoint.h][nowPoint.x][nowPoint.y+1].visited = true;
                point[nowPoint.h][nowPoint.x][nowPoint.y+1].dist = nowPoint.dist+1;
                que.add(point[nowPoint.h][nowPoint.x][nowPoint.y+1]);
            }

        }
    }
}

class Point{
    int x;
    int y;
    int h;
    boolean visited = false;
    int dist = 987987987;
}
