import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.System.*;

class Codechef {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(in);
        int testCases = scanner.nextInt();
        int[] output = new int[testCases];
        HashMap<Integer, Integer> myMap = new HashMap<>();
        
        for(int i = 0; i < testCases; i++) {
            int total = scanner.nextInt();
            
            for(int j = 0; j < total; j++) {
                int temp = scanner.nextInt();
                if(myMap.containsKey(temp)) 
                    myMap.remove(temp);
                else
                    myMap.put(temp, 1);
            }
            
            try {
                Map.Entry<Integer, Integer> onlyEntry = myMap.entrySet().iterator().next();            
                output[i] = onlyEntry.getKey();
                myMap.clear();
            } catch(NoSuchElementException noSuchElementException) {
                output[i] = -1;
            }
        }

        out.println("\n\nOUTPUT: \n");
        for(int i = 0; i < testCases; i++) {
            out.println(output[i]);
        }
    }
}
