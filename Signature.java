import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;
public class Signature{
    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();
    private static BigInteger privateKey;
    private static BigInteger publicKey;
    private static BigInteger N;
    public static void main(String[] args) {
            Scanner UserInput = new Scanner(System.in);
            Scanner UserInput2 = new Scanner(System.in);
            System.out.printf("\fMessage is: ");
            String s = UserInput.nextLine();
            System.out.printf("\fLoading... Please Wait... \n ");
            BigInteger p = BigInteger.probablePrime(2048, random); 
            BigInteger q = BigInteger.probablePrime(2048, random); 
            BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
            N = p.multiply(q);
            publicKey = N.subtract(phi);
            while (!phi.gcd(publicKey).equals(one)) {
                publicKey = publicKey.add(one);
            }
            privateKey = publicKey.modInverse(phi);
            System.out.printf("\nP: %d \nQ: %d \nN: %d \nPhi(N): %d \nPublic Key: %d \nPrivate Key: %d",p,q,N,phi,publicKey,privateKey);
            System.out.printf("\n\nDo you want to sign your message? (y/n) \n");
            char reply = UserInput2.nextLine().charAt(0);
            if(reply == 'y'){
                StringBuilder sb = new StringBuilder();
                for (char c : s.toCharArray()){
                    sb.append((int)c);
                }
                BigInteger plaintext = new BigInteger(sb.toString());
                System.out.printf("\nSent: \nAscii Code String: %d\n", plaintext);
                BigInteger ciphertext = plaintext.modPow(privateKey,N);
                System.out.println("Encrypted: " + ciphertext);
                System.out.printf("\n\nWhat other user gets: \n");
                BigInteger decrypt = ciphertext.modPow(publicKey,N);
                System.out.println("Decrypted: " + decrypt);
                StringBuilder sb2 = new StringBuilder();
                String decrypted = decrypt.toString();
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
                System.out.printf("Message is: %s\n",finalized);
                if (finalized.compareTo(s)==0){
                    System.out.printf("No fraud inspected. \n");
                }
            }
    }
}