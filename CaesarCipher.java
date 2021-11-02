/**
 *
 * @author toast
 */
//0==shift forwards (can be encrypt)
//1==shift backwards (can be decrypt)
//line 1 will tell you whether to encrypt or decrypt
//line 2 will tell you how many times to encrypt or decrypt
import java.io.*;
import java.util.*;
public class CaesarCipher {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] letters = alpha.toCharArray();
        int index = 0;
        String answer = "";
        String temp = "";
        int length = 0;
        System.out.println("Encrypt in which direction? [1 or 0]");
        int decrypt = sc.nextInt();
        System.out.println("How many times?");
        int numTimes = sc.nextInt();
        System.out.println("Please type your ALL-CAPS alphabetic text for encryption (Type \"Stop\" to process):");
        String temporary = "";
        while(!temporary.contains("Stop")) {
        	temporary += "\n" + sc.nextLine();
        }
        temporary = temporary.substring(0,temporary.length()-4);
        sc.close();
        sc = new Scanner(temporary);
        
        for(int iterator = 0; iterator < numTimes; iterator++){
            if(decrypt==1){
            while(sc.hasNext()){
                temp = sc.next();
                length = temp.length();
                for(int i = 0; i < temp.length(); i++){
                    index = alpha.indexOf(temp.substring(i, i+1));
                    if((index-length)>=0){
                        answer+=letters[index-length];
                    }
                    else{
                        answer+=letters[26-(length-index)];
                    }
                }
                answer+=" ";
            }
            }
            else if(decrypt==0){
                while(sc.hasNext()){
                    temp = sc.next();
                    length = temp.length();
                    for(int i = 0; i < temp.length(); i++){
                        index = alpha.indexOf(temp.substring(i, i+1));
                        if((index+length)<26){
                            answer+=letters[index+length];
                        }
                        else{
                            answer+=letters[(length+index)-26];
                        }
                    }
                    answer+=" ";
                }
            }
            String a = answer + "";
            sc = new Scanner(a);
            System.out.println("Number of times converted: " + (iterator+1) + "\n" + answer);
            answer = "";
        }
        System.out.print(answer);
        sc.close();
    }
}
/*
0
THIS
IS
A
CODE

1
XLMW
KU
B
GSHI
*/