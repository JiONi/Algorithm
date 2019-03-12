import java.util.*;
public class crashMaze{
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int numM = scan.nextInt();
    public static int[][] arr = new int[numN+10][numM+10];

    public static void main(String[] args){

        // Please Enter Your Code Here
        Queue<Point> que = new LinkedList<>();
        Point[][] pointFromStart = new Point[numN][numM];
        Point[][] pointFromEnd = new Point[numN][numM];
        for(int i=0; i<numN+2; i++){
            for(int j=0; j<numM+2; j++){
                arr[i][j] = 1;
            }
        }

        for(int i=0; i<numN; i++){
            for(int j=0; j<numM; j++){
                arr[i][j] = scan.nextInt();
                pointFromStart[i][j] = new Point();
                pointFromStart[i][j].x = i;
                pointFromStart[i][j].y = j;
                pointFromEnd[i][j] = new Point();
                pointFromEnd[i][j].x = i;
                pointFromEnd[i][j].y = j;
            }
        }

        pointFromStart[numN-1][0].visited = true;
        pointFromStart[numN-1][0].dist = 0;
        que.add(pointFromStart[numN-1][0]);

        while(que.isEmpty() == false){
            Point nowPoint = que.peek();
            que.poll();

            if(nowPoint.x > 0 && pointFromStart[nowPoint.x-1][nowPoint.y].visited == false){
                if(arr[nowPoint.x-1][nowPoint.y] == 0){
                    if(pointFromStart[nowPoint.x-1][nowPoint.y].dist > nowPoint.dist+1){
                        pointFromStart[nowPoint.x-1][nowPoint.y].dist = nowPoint.dist+1;
                    }
                    pointFromStart[nowPoint.x-1][nowPoint.y].visited = true;
                    que.add(pointFromStart[nowPoint.x-1][nowPoint.y]);
                }else{
                    if(pointFromStart[nowPoint.x-1][nowPoint.y].dist > nowPoint.dist+1){
                        pointFromStart[nowPoint.x-1][nowPoint.y].dist = nowPoint.dist+1;
                    }
                }
            }
            if(nowPoint.x < numN-1 && pointFromStart[nowPoint.x+1][nowPoint.y].visited == false){
                if(arr[nowPoint.x+1][nowPoint.y] == 0){
                    if(pointFromStart[nowPoint.x+1][nowPoint.y].dist > nowPoint.dist+1){
                        pointFromStart[nowPoint.x+1][nowPoint.y].dist = nowPoint.dist+1;
                    }
                    pointFromStart[nowPoint.x+1][nowPoint.y].visited = true;
                    que.add(pointFromStart[nowPoint.x+1][nowPoint.y]);
                }else{
                    if(pointFromStart[nowPoint.x+1][nowPoint.y].dist > nowPoint.dist+1){
                        pointFromStart[nowPoint.x+1][nowPoint.y].dist = nowPoint.dist+1;
                    }
                }
            }
            if(nowPoint.y > 0 && pointFromStart[nowPoint.x][nowPoint.y-1].visited == false){
                if(arr[nowPoint.x][nowPoint.y-1] == 0){
                    if(pointFromStart[nowPoint.x][nowPoint.y-1].dist > nowPoint.dist+1){
                        pointFromStart[nowPoint.x][nowPoint.y-1].dist = nowPoint.dist+1;
                    }
                    pointFromStart[nowPoint.x][nowPoint.y-1].visited = true;
                    que.add(pointFromStart[nowPoint.x][nowPoint.y-1]);
                }else{
                    if(pointFromStart[nowPoint.x][nowPoint.y-1].dist > nowPoint.dist+1){
                        pointFromStart[nowPoint.x][nowPoint.y-1].dist = nowPoint.dist+1;
                    }
                }
            }
            if(nowPoint.y < numM-1 && pointFromStart[nowPoint.x][nowPoint.y+1].visited == false){
                if(arr[nowPoint.x][nowPoint.y+1] == 0){
                    if(pointFromStart[nowPoint.x][nowPoint.y+1].dist > nowPoint.dist+1){
                        pointFromStart[nowPoint.x][nowPoint.y+1].dist = nowPoint.dist+1;
                    }
                    pointFromStart[nowPoint.x][nowPoint.y+1].visited = true;
                    que.add(pointFromStart[nowPoint.x][nowPoint.y+1]);
                }else{
                    if(pointFromStart[nowPoint.x][nowPoint.y+1].dist > nowPoint.dist+1){
                        pointFromStart[nowPoint.x][nowPoint.y+1].dist = nowPoint.dist+1;
                    }
                }
            }
        }

        Queue<Point> que2 = new LinkedList<>();

        pointFromEnd[0][numM-1].visited = true;
        pointFromEnd[0][numM-1].dist = 0;
        que2.add(pointFromEnd[0][numM-1]);

        while(que2.isEmpty() == false){
            Point nowPoint = que2.peek();
            que2.poll();

            if(nowPoint.x > 0 && pointFromEnd[nowPoint.x-1][nowPoint.y].visited == false){
                if(arr[nowPoint.x-1][nowPoint.y] == 0){
                    if(pointFromEnd[nowPoint.x-1][nowPoint.y].dist > nowPoint.dist+1){
                        pointFromEnd[nowPoint.x-1][nowPoint.y].dist = nowPoint.dist+1;
                    }
                    pointFromEnd[nowPoint.x-1][nowPoint.y].visited = true;
                    que2.add(pointFromEnd[nowPoint.x-1][nowPoint.y]);
                }else{
                    if(pointFromEnd[nowPoint.x-1][nowPoint.y].dist > nowPoint.dist+1){
                        pointFromEnd[nowPoint.x-1][nowPoint.y].dist = nowPoint.dist+1;
                    }
                }
            }
            if(nowPoint.x < numN-1 && pointFromEnd[nowPoint.x+1][nowPoint.y].visited == false){
                if(arr[nowPoint.x+1][nowPoint.y] == 0){
                    if(pointFromEnd[nowPoint.x+1][nowPoint.y].dist > nowPoint.dist+1){
                        pointFromEnd[nowPoint.x+1][nowPoint.y].dist = nowPoint.dist+1;
                    }
                    pointFromEnd[nowPoint.x+1][nowPoint.y].visited = true;
                    que2.add(pointFromEnd[nowPoint.x+1][nowPoint.y]);
                }else{
                    if(pointFromEnd[nowPoint.x+1][nowPoint.y].dist > nowPoint.dist+1){
                        pointFromEnd[nowPoint.x+1][nowPoint.y].dist = nowPoint.dist+1;
                    }
                }
            }
            if(nowPoint.y > 0 && pointFromEnd[nowPoint.x][nowPoint.y-1].visited == false){
                if(arr[nowPoint.x][nowPoint.y-1] == 0){
                    if(pointFromEnd[nowPoint.x][nowPoint.y-1].dist > nowPoint.dist+1){
                        pointFromEnd[nowPoint.x][nowPoint.y-1].dist = nowPoint.dist+1;
                    }
                    pointFromEnd[nowPoint.y][nowPoint.y-1].visited = true;
                    que2.add(pointFromEnd[nowPoint.x][nowPoint.y-1]);
                }else{
                    if(pointFromEnd[nowPoint.x][nowPoint.y-1].dist > nowPoint.dist+1){
                        pointFromEnd[nowPoint.x][nowPoint.y-1].dist = nowPoint.dist+1;
                    }
                }
            }
            if(nowPoint.y < numM-1 && pointFromEnd[nowPoint.x][nowPoint.y+1].visited == false){
                if(arr[nowPoint.x][nowPoint.y+1] == 0){
                    if(pointFromEnd[nowPoint.x][nowPoint.y+1].dist > nowPoint.dist+1){
                        pointFromEnd[nowPoint.x][nowPoint.y+1].dist = nowPoint.dist+1;
                    }
                    pointFromEnd[nowPoint.x][nowPoint.y+1].visited = true;
                    que2.add(pointFromEnd[nowPoint.x][nowPoint.y+1]);
                }else{
                    if(pointFromEnd[nowPoint.x][nowPoint.y+1].dist > nowPoint.dist+1){
                        pointFromEnd[nowPoint.x][nowPoint.y+1].dist = nowPoint.dist+1;
                    }
                }
            }
        }

        int minDist = 987987987;
        for(int i=0; i<numN; i++){
            for(int j=0; j<numM; j++){
                if(arr[i][j] == 1){
                    int sum = pointFromStart[i][j].dist + pointFromEnd[i][j].dist;
                    if(minDist > sum){
                        minDist = sum;
                    }
                }
            }
        }

        if(pointFromStart[0][numM-1].dist > minDist){
            System.out.println(minDist);
        }else {
            System.out.println(pointFromStart[0][numM - 1].dist);
        }
    }
}

class Point{
    int x;
    int y;
    int dist = 100;
    boolean visited=false;
    boolean crash=true;
}