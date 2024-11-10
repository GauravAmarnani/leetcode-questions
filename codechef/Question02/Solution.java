import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.System.*;

class Codechef {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(in);
        int testCases = scanner.nextInt();
        int[] output = new int[testCases];

        for(int i = 0; i < testCases; i++) {
            int totalNum = scanner.nextInt();
            int[] temp = new int[101];
            int total = 0;
            
            for(int j = 0; j < totalNum; j++) {
                int input = scanner.nextInt();
                if(temp[input] == 0) {
                    total++;
                    temp[input] = 1;
                }
            }

            output[i] = total;
        }

        out.println("\n\nOutput:\n\n");
        for(int i = 0; i < testCases; i++) {
            out.println(output[i]);
        }
    }
}
