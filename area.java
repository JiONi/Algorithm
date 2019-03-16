import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class area {
    public static Scanner scan = new Scanner(System.in);
    public static int numM = scan.nextInt();
    public static int numN = scan.nextInt();
    public static int numK = scan.nextInt();
    public static int[][] map = new int[110][110];
    public static areaPoint[][] point = new areaPoint[110][110];
    public static int[] countArr = new int[1000];
    public static int countLen = 0;

    public static void main(String args[]){
        Queue<areaPoint> que = new LinkedList<>();

        for(int i=0; i<numN; i++){
            for(int j=0; j<numM; j++){
                point[i][j] = new areaPoint();
                point[i][j].x = i;
                point[i][j].y = j;
            }
        }

        for(int i=0; i<numK; i++){
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            for(int j=x1; j<x2; j++){
                for(int k=y1; k<y2; k++){
                    map[j][k] = 1;
                }
            }
        }

        for(int i=0; i<numN; i++){
            for(int j=0; j<numM; j++){
                if(map[i][j] == 0 && point[i][j].visited == false){
                    point[i][j].visited = true;
                    que.add(point[i][j]);

                    int count = bfs(que);
                    countArr[countLen++] = count;
                }
            }
        }


        quickSort(0, countLen-1);

        System.out.println(countLen);
        for(int i=0; i<countLen; i++)
            System.out.print(countArr[i]+" ");
    }
    public static void quickSort(int start, int end){
        if(start >= end){
            return;
        }else{
            int pivot = countArr[start];
            int[] left = new int[end-start+1];
            int[] right = new int[end-start+1];
            int leftCnt = getLeft(start+1, end, pivot, left);
            int rightCnt = getRight(start+1, end, pivot, right);

            for(int i=0; i<leftCnt; i++){
                countArr[start+i] = left[i];
            }
            countArr[start+leftCnt] = pivot;
            for(int i=0; i<rightCnt; i++){
                countArr[start+leftCnt+1+i] = right[i];
            }
            quickSort(start, start+leftCnt-1);
            quickSort(start+leftCnt+1, end);
        }
    }
    public static int getLeft(int start, int end, int pivot, int[] result){
        int idx = 0;
        for(int i=start; i<=end; i++){
            if(countArr[i] <= pivot){
                result[idx++] = countArr[i];
            }
        }
        return idx;
    }
    public static int getRight(int start, int end, int pivot, int[] result){
        int idx = 0;
        for(int i=start; i<=end; i++){
            if(countArr[i] > pivot){
                result[idx++] = countArr[i];
            }
        }
        return idx;
    }
    public static int bfs(Queue<areaPoint> que){
        int count = 0;
        while(que.isEmpty() == false){
            areaPoint nowPoint = que.peek();
            que.poll();
            count++;
            if(nowPoint.x > 0 && map[nowPoint.x-1][nowPoint.y] == 0 && point[nowPoint.x-1][nowPoint.y].visited == false){
                point[nowPoint.x-1][nowPoint.y].visited = true;
                que.add(point[nowPoint.x-1][nowPoint.y]);
            }
            if(nowPoint.x < numN-1 && map[nowPoint.x+1][nowPoint.y] == 0 && point[nowPoint.x+1][nowPoint.y].visited == false){
                point[nowPoint.x+1][nowPoint.y].visited = true;
                que.add(point[nowPoint.x+1][nowPoint.y]);
            }
            if(nowPoint.y > 0 && map[nowPoint.x][nowPoint.y-1] == 0 && point[nowPoint.x][nowPoint.y-1].visited == false){
                point[nowPoint.x][nowPoint.y-1].visited = true;
                que.add(point[nowPoint.x][nowPoint.y-1]);
            }
            if(nowPoint.y < numM-1 && map[nowPoint.x][nowPoint.y+1] == 0 && point[nowPoint.x][nowPoint.y+1].visited == false){
                point[nowPoint.x][nowPoint.y+1].visited = true;
                que.add(point[nowPoint.x][nowPoint.y+1]);
            }

        }
        return count;
    }
}
class areaPoint{
    int x;
    int y;
    boolean visited = false;
}
