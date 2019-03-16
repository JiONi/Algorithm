import java.util.Scanner;
import java.util.Stack;

public class tower {
    public static Scanner scan = new Scanner(System.in);
    public static int numN = scan.nextInt();
    public static int[] top = new int[110];
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String args[]){

        for(int i=0; i<numN; i++){
            top[i] = scan.nextInt();
        }

        int[] result = solution(top);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]+" ");
        }

    }

    public static int[] solution(int[] heights){
        int[] result = new int[numN];
        int[] answer = {};

        for(int i=0; i<numN; i++){
            if(stack.isEmpty() == true){
                result[i] = 0;
                stack.push(i);
            }else{
                if(heights[stack.peek()] > heights[i]){
                    result[i] = stack.peek()+1;
                    stack.push(i);
                }else{
                    while(heights[stack.peek()] <= heights[i]){
                        stack.pop();

                        if(stack.isEmpty() == true){
                            break;
                        }
                    }
                    if(stack.isEmpty() == true){
                        result[i] = 0;
                        stack.push(i);
                    }else{
                        result[i] = stack.peek()+1;
                        stack.push(i);
                    }
                }
            }
        }
        answer = result;
        return answer;
    }
}
