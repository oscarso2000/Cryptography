import java.util.Arrays;
import java.util.Scanner;
public class Group{
    public static void main(String[] args){
        System.out.printf("\f");
        Scanner UserInput = new Scanner (System.in);
        System.out.printf("Group Mod (Input Number): ");
        int modPrime = UserInput.nextInt();
        int[] modArray = new int[modPrime-1];
        int[] squaredArray = new int[modPrime-1];
        for (int i=0;i<modArray.length;i++){
            modArray[i]=i+1;
            squaredArray[i]=((i+1)*(i+1));
        }
        for (int i=0;i<modArray.length;i++){
            System.out.printf("%d ",modArray[i]);
        }
        System.out.printf("\n");
        for (int i=0;i<squaredArray.length;i++){
            System.out.printf("%d ",squaredArray[i]);
        }
        System.out.printf("\n");
        for (int i=0;i<modArray.length;i++){
            for (int j=0;j<squaredArray.length;j++){
                if(squaredArray[j]%modPrime == modArray[i]){
                    System.out.printf("√%d, %d mod %d \n",modArray[i],squaredArray[j],modPrime);
                }
            }
        }
    }
}