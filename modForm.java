import java.util.Scanner;
public class modForm{
    public static void main(String[]args){
        Scanner UserInput = new Scanner(System.in);
        System.out.printf("Coefficient of: ");
        int q = UserInput.nextInt();
        int total = q;
        int powered = q;
        for(int i=0;i<q;i++){
            total = total*((1-powered)*(1-powered));
            powered = powered*q;
        }
        System.out.printf("%d",total);
    }
}