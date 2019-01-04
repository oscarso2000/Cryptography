import java.util.Scanner;
public class e{
    public static void main (String [] args){
        Scanner UserInput = new Scanner(System.in);
        System.out.printf("\fEquation: y^2+y=x^3-x^2 \n");
        System.out.printf("Please input mod prime: ");
        int mod = UserInput.nextInt();
        int counter = 0;
        System.out.printf("X   Y\n");
        for (int x=0;x<mod;x++){
            for(int y=0;y<mod;y++){
                if(((y*y+y)%mod)==((x*x*x-x*x)%mod)){
                    if(x>9){
                        System.out.printf("%d  %d\n",x,y);
                    }else{
                        System.out.printf("%d   %d\n",x,y);                       
                    }
                    counter++;
                }
            }
        }
        int coefficient = mod-counter;
        System.out.printf("p: %d\nNp: %d\np-Np: %d\n",mod,counter,coefficient);
    }
}