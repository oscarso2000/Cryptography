import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;
public class RSA{
    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();
    private static BigInteger privateKey;
    private static BigInteger publicKey;
    private static BigInteger N;
    public static void main(String[] args) {
            Scanner UserInput = new Scanner(System.in);
            System.out.printf("\fMessage is: ");
            String s = UserInput.nextLine();
            System.out.printf("Loading... Please Wait... \n");
            BigInteger p = BigInteger.probablePrime(2048, random); 
            BigInteger q = BigInteger.probablePrime(2048, random); 
            BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
            N = p.multiply(q);
            publicKey = N.subtract(phi);
            while (!phi.gcd(publicKey).equals(one)) {
                publicKey = publicKey.add(one);
            }
            privateKey = publicKey.modInverse(phi);
            System.out.printf("P: %d \nQ: %d \nN: %d \nPhi(N): %d \nPublic Key: %d \nPrivate Key: %d",p,q,N,phi,publicKey,privateKey);
            //testString (Not used in code) String s = "The American Constitution was established in 1787 under Thomas Jefferson, Alexander Hamilton, and George Washington, including delagates to the constitutional convention in Philidelphia establishing America's national government and fundamental laws and guarantee the certain basic rights for its citizens originally composed with 7 articles.";
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()){
                sb.append((int)c);
            }
            BigInteger plaintext = new BigInteger(sb.toString());
            System.out.printf("\n\nAscii Code String: %d\n", plaintext);
            BigInteger ciphertext = plaintext.modPow(publicKey,N);
            BigInteger decrypt = ciphertext.modPow(privateKey,N);
            System.out.println("Encrypted Text: " + ciphertext);
            System.out.println("Decrypted Text: " + decrypt);
            //print digits
            System.out.printf("\nPublic Key Digits: %d \nP Digits: %d \nQ Digits: %d \nPrivate Key Digits: %d \nN Digits: %d \n", publicKey.toString().length(),p.toString().length(),q.toString().length(),privateKey.toString().length(),N.toString().length());
            String decrypted = decrypt.toString();
            //convert Ascii to String
            StringBuilder sb2 = new StringBuilder();
            for (int i=0;i<decrypted.length();i=i){
                if(decrypted.charAt(i)!='1'){
                    String partial = decrypted.substring(i,i+2);
                    char partial2 = (char)Integer.parseInt(partial);
                    sb2.append(partial2);
                    i=i+2;
                }else{
                    String partial = decrypted.substring(i,i+3);
                    char partial2 = (char)Integer.parseInt(partial);
                    sb2.append(partial2);
                    i=i+3;
                }
            }
            String finalized = sb2.toString();
            System.out.printf("\nMessage is: %s\n",finalized);
    }
}