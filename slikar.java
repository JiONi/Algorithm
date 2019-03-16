import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class slikar {
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int numM = scan.nextInt();
    public static char[][] map = new char[55][55];
    public static Dot[][] point = new Dot[55][55];
    public static int beaverX = 0;
    public static int beaverY = 0;

    public static void main(String args[]){
        Queue<Dot> queWater = new LinkedList<>();
        Queue<Dot> queHedgehog = new LinkedList<>();

        scan.nextLine();

        for(int i=1; i<=numN; i++){
            String s = scan.nextLine();
            for(int j=1; j<=numM; j++){
                point[i][j] = new Dot();
                point[i][j].x = i;
                point[i][j].y = j;
                map[i][j] = s.charAt(j-1);
                if(map[i][j] == 'S'){
                    point[i][j].dist = 0;
                    point[i][j].visited = true;
                    queHedgehog.add(point[i][j]);
                }
                if(map[i][j] == 'D'){
                    beaverX = i;
                    beaverY = j;
                }
            }
        }

        while(queHedgehog.isEmpty() == false){
            Dot nowPoint = queHedgehog.peek();
            queHedgehog.poll();

            waterBfs(queWater);
            if(nowPoint.x > 1 && (map[nowPoint.x-1][nowPoint.y] == '.' || map[nowPoint.x-1][nowPoint.y] == 'D') && point[nowPoint.x-1][nowPoint.y].visited == false){
                if(point[nowPoint.x-1][nowPoint.y].dist > nowPoint.dist+1){
                    point[nowPoint.x-1][nowPoint.y].dist = nowPoint.dist+1;
                }
                point[nowPoint.x-1][nowPoint.y].visited = true;
                queHedgehog.add(point[nowPoint.x-1][nowPoint.y]);
            }
            if(nowPoint.x < numN && (map[nowPoint.x+1][nowPoint.y] == '.' || map[nowPoint.x+1][nowPoint.y] == 'D') && point[nowPoint.x+1][nowPoint.y].visited == false){
                if(point[nowPoint.x+1][nowPoint.y].dist > nowPoint.dist+1){
                    point[nowPoint.x+1][nowPoint.y].dist = nowPoint.dist+1;
                }
                point[nowPoint.x+1][nowPoint.y].visited = true;
                queHedgehog.add(point[nowPoint.x+1][nowPoint.y]);
            }
            if(nowPoint.y > 1 && (map[nowPoint.x][nowPoint.y-1] == '.' || map[nowPoint.x][nowPoint.y-1] == 'D') && point[nowPoint.x][nowPoint.y-1].visited == false){
                if(point[nowPoint.x][nowPoint.y-1].dist > nowPoint.dist+1){
                    point[nowPoint.x][nowPoint.y-1].dist = nowPoint.dist+1;
                }
                point[nowPoint.x][nowPoint.y-1].visited = true;
                queHedgehog.add(point[nowPoint.x][nowPoint.y-1]);
            }
            if(nowPoint.y < numM && (map[nowPoint.x][nowPoint.y+1] == '.' || map[nowPoint.x][nowPoint.y+1] == 'D') && point[nowPoint.x][nowPoint.y+1].visited == false){
                if(point[nowPoint.x][nowPoint.y+1].dist > nowPoint.dist+1){
                    point[nowPoint.x][nowPoint.y+1].dist = nowPoint.dist+1;
                }
                point[nowPoint.x][nowPoint.y+1].visited = true;
                queHedgehog.add(point[nowPoint.x][nowPoint.y+1]);
            }
        }

        if(point[beaverX][beaverY].visited == true){
            System.out.println(point[beaverX][beaverY].dist);
        }else{
            System.out.println("KAKTUS");
        }
    }
    public static void waterBfs(Queue<Dot> que){
        for(int i=1; i<=numN; i++){
            for(int j=1; j<=numM; j++){
                if(map[i][j] == '*'){
                    que.add(point[i][j]);
                }
            }
        }
        while(que.isEmpty() == false){
            Dot nowPoint = que.peek();
            que.poll();

            if(nowPoint.x > 1 && map[nowPoint.x-1][nowPoint.y] == '.' && point[nowPoint.x-1][nowPoint.y].visited == false){
                map[nowPoint.x-1][nowPoint.y] = '*';
            }
            if(nowPoint.x < numN && map[nowPoint.x+1][nowPoint.y] == '.' && point[nowPoint.x+1][nowPoint.y].visited == false){
                map[nowPoint.x+1][nowPoint.y] = '*';
            }
            if(nowPoint.y > 1 && map[nowPoint.x][nowPoint.y-1] == '.' && point[nowPoint.x][nowPoint.y-1].visited == false){
                map[nowPoint.x][nowPoint.y-1] = '*';
            }
            if(nowPoint.y < numM && map[nowPoint.x][nowPoint.y+1] == '.' && point[nowPoint.x][nowPoint.y+1].visited == false){
                map[nowPoint.x][nowPoint.y+1] = '*';
            }
        }
    }

}
class Dot{
    int x;
    int y;
    boolean visited = false;
    int dist = 987987987;
}