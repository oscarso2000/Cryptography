import java.util.Scanner;
import java.util.ArrayList;
public class euclid{
    public static void main(String [] args){
        System.out.printf("\f");
        //Euclidean Algorithm
        Scanner RPrimeScanner = new Scanner(System.in);
        System.out.printf("Relative Prime 1: ");
        long rp1 = RPrimeScanner.nextInt();
        System.out.printf("Relative Prime 2: ");
        long rp2 = RPrimeScanner.nextInt();
        if (rp2>rp1){ //makes p1 the greater prime
            long temp = rp1;
            rp1 = rp2;
            rp2 = temp;
        }
        ArrayList<Long> Quotient = new ArrayList<Long>(); 
        ArrayList<Long> Remainder = new ArrayList<Long>();
        long z1 = rp1;
        long z2 = rp2;
        if (gcd(rp1,rp2)==1){
            while(z2!=1){
                Quotient.add(z1/z2);
                Remainder.add(z1%z2);
                z1=z2;
                z2=Remainder.get(Remainder.size()-1);
            }
            //display
            /*System.out.printf("\nQuotient List: ");
            for(int i=0;i<Quotient.size();i++){
                System.out.printf("%d ",Quotient.get(i));
            }
            System.out.printf("\nRemainder List: ");
            for(int i=0;i<Remainder.size();i++){
                System.out.printf("%d ",Remainder.get(i));
            }*/
        
            /*//part 2 (rp1x+rp2y = 1)
             * int smallRemainder = Remainder.size()-3;
             * int BigRemainder = Remainder.size()-4;
             * int FQuotient = Quotient.size()-2;*/
            //prints multiplication
             System.out.printf("\n%d = %d x %d + %d", rp1,rp2,Quotient.get(0),Remainder.get(0));
             System.out.printf("\n%d = %d x %d + %d", rp2,Remainder.get(0),Quotient.get(1),Remainder.get(1));
             for(int i=2;i<Quotient.size();i++){
                 System.out.printf("\n%d = %d x %d + %d", Remainder.get(i-2),Remainder.get(i-1),Quotient.get(i),Remainder.get(i));
                }
            }else{
            System.out.printf("Not Relatively Prime. \n");
            }
        }
        //check relatively prime
    private static long gcd(long a, long b) {
        long t;
        while(b != 0){
            t = a;
            a = b;
            b = t%b;
        }
        return a;
    }
}