import java.util.*;

/**
 * Solution did not pass 3 testcases
 */
public class Main {

        /**
         * @param args
         */
        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            // write your code here
            Scanner scanner = new Scanner((System.in));
            List<String> input = new ArrayList<String>();



//            while ((scanner.hasNextLine())) {
//                input.add(scanner.nextLine());
//            }
//            scanner.close();

            HashMap <Integer, Integer> socialScore = new HashMap<>();

             input.addAll(Arrays.asList(
                     "12 30",
                     "1 2",
                     "1 3",
                     "1 4",
                     "1 5",
                     "1 6",
                     "2 3",
                     "2 4",
                     "2 5",
                     "2 6",
                     "3 4",
                     "3 5",
                     "3 6",
                     "4 5",
                     "4 6",
                     "5 6",
                     "7 8",
                     "7 9",
                     "7 10",
                     "7 11",
                     "7 12",
                     "8 9",
                     "8 10",
                     "8 11",
                     "8 12",
                     "9 10",
                     "9 11",
                     "9 12",
                     "10 11",
                     "10 12",
                     "11 12"));

//            for (int j =0; j<input.size(); j++){
//                System.out.println(input.get(j));
//            }

            int numFriends = Integer.parseInt(input.get(0).split(" ")[0].trim());
            int sizeList = Integer.parseInt(input.get(0).split(" ")[1].trim());

//            System.out.println("Number of friends : " + numFriends);
//            System.out.println("Size of List : " + sizeList);
            socialScore = initScore(numFriends, socialScore);
            socialScore = updateScore(input, socialScore);


            String results = greedySelect(socialScore);
            String totalQualifiedFriends = results.split("-")[0];
            System.out.println(totalQualifiedFriends);

            if (!totalQualifiedFriends.trim().equals("0")) {
                System.out.println(results.split("-")[1]);
            }
    }

    /**
     *
     * @param socialScore
     * @return
     */
    public static String greedySelect(HashMap<Integer, Integer> socialScore) {
        int numQualitfied = 0;
        StringBuilder results = new StringBuilder();
        for (int i =1; i<socialScore.size()+1; i++){
            int iScore = socialScore.get(i);
            if (iScore >=5 && (socialScore.size()-socialScore.get(i))>=5) {
                results.append(i + " ");
                numQualitfied++;}
        }
        results.insert(0,numQualitfied + "-");
        return results.toString();
    }


    /**
     *
     * @param numFriends
     * @param socialScore
     * @return
     */
    public static HashMap initScore(int numFriends, HashMap socialScore) {
        for (int i = 1; i < numFriends + 1; i++) {
            socialScore.put(i, 0);
        }
        return socialScore;
    }

    /**
     * @param input
     * @param socialScore
     * @return
     */
    public static HashMap<Integer, Integer> updateScore(List<String> input, HashMap <Integer, Integer> socialScore) {
        for (int i = 1; i < input.size(); i++) {
            int firNum = Integer.parseInt(input.get(i).split(" ")[0].trim());
            int secNum = Integer.parseInt(input.get(i).split(" ")[1].trim());
            int firUpdate = socialScore.get(firNum) + 1;
            int secUpdate = socialScore.get(secNum) + 1;
            socialScore.put(firNum, firUpdate);
            socialScore.put(secNum, secUpdate);
        }
        return socialScore;
    }


}