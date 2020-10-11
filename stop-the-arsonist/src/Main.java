import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

    public class Main {
        private static final Scanner scanner = new Scanner(System.in);


        private static String merge (String leftList, String rightList) {
            StringBuilder longestCommonPrefix = new StringBuilder("");

            for (int i = 0; i< Math.min(leftList.length(), rightList.length()); i++){
                if (leftList.charAt(i) != rightList.charAt(i)){
                    break;
                }
                else {longestCommonPrefix = longestCommonPrefix.append(leftList.charAt(i));}
            }
            return longestCommonPrefix.toString();
        }

        private static String findLongestPrefix (List <String> locations) {
            if (locations.size() == 1){
                return locations.get(0);
            }

            int total = locations.size();
            int midpoint = (int)(total/2);

            List<String> leftList = locations.subList(0, midpoint);
            List<String> rightList = locations.subList(midpoint, total);

            String mergedLeft = findLongestPrefix(leftList);
            String mergedRight = findLongestPrefix(rightList);
            String newLongestPrefix = merge(mergedLeft, mergedRight);

            return newLongestPrefix;
        }

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scanner = new Scanner(System.in);
            List<String> input= new ArrayList<String>();

//            String myString = scanner.next();
//            while(scanner.hasNext()){
//                input.add(scanner.next());
//            }
//            scanner.close();

        input.add("northeasternkhouryccis");
        input.add("northeasternkhouryccisbuilding");
        input.add("northeasternkhouryyyyyyyy");
        input.add("northeasternkhourybuilding");
        input.add("northeasternkhortheastern");
        input.add("northeasternkhourj");

            String longestPrefix = findLongestPrefix(input);
            System.out.println(longestPrefix);
        }
}
