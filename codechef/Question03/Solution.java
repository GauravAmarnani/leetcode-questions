import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.System.*;

class Codechef {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int testCases = scanner.nextInt();
        int[] output = new int[testCases];
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < testCases; i++) {
            int totalNum = scanner.nextInt();

            for (int j = 0; j < totalNum; j++) {
                int input = scanner.nextInt();
                myMap.put(input, myMap.getOrDefault(input, 0) + 1);
            }

            int maxValue = Integer.MIN_VALUE;

            for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
                maxValue = Math.max(maxValue, entry.getValue());
            }

            output[i] = totalNum - maxValue;
            myMap.clear();
        }

        out.println("\n\nOutput:\n\n");
        for (int i = 0; i < testCases; i++) {
            out.println(output[i]);
        }
    }
}
