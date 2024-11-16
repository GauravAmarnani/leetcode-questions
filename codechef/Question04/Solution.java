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
            HashMap<Integer, Integer> myMap = new HashMap<>();
            
            for(int j = 0; j < totalNum; j++) {
                int input = scanner.nextInt();
                myMap.put(input, myMap.getOrDefault(input, 0) + 1);
            }

            int maxValue = Integer.MIN_VALUE;
            int key = -1;
            boolean isUnique = true;

            for(Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
                if(entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    key = entry.getKey();
                    isUnique = true; 
                } else if(entry.getValue() == maxValue) {
                    isUnique = false;
                }
            }

            output[i] = isUnique ? key : -1;
        }

        out.println("\n\nOutput:\n\n");
        for(int i = 0; i < testCases; i++) {
            if(output[i] != -1)
                out.println("YES");
            else
                out.println("NO");
        }
    }
}
