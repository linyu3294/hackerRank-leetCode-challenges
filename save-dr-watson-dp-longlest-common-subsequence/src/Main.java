import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int[][][] dpTable;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner((System.in));
        List<String> input = new ArrayList<String>();

//        while ((scanner.hasNext())){
//            input.add(scanner.next());
//        }
//        scanner.close();
//        input.add("uwytubiweutpowegbiutpoweeniwotiweqz"); //b-5 /i-7 //g-15 //b-16 /e /n
//        input.add("udsjkhfbklsdfigkjfdbensdjdlqz"); //b-7 /i-13 //g-14 //b-19 /e /n
//        input.add("umnvbcxmbimxcnbvmgxmnbvcxbexmbnnaz"); //b-4 /i-10 //g-17 //b-21 /e /n

//        input.add("academy"); //b-5 /i-7 //g-15 //b-16 /e /n
//        input.add("abracadabra"); //b-7 /i-13 //g-14 //b-19 /e /n
//        input.add("abcbadara"); //b-4 /i-10 //g-17 //b-21 /e /n


        int lcsMaxVal = findLCSOpt(input);
        String m = input.get(0);
        String n = input.get(1);
        String p = input.get(2);
        StringBuilder longestCommonSubString = new StringBuilder();
        findLongestCommonSubString(m, n, p, longestCommonSubString);
        System.out.println(lcsMaxVal);
        if (lcsMaxVal == 0) {
            System.out.println("Does not exist");
        }
        else {
            System.out.println(longestCommonSubString);
        }
    }


    public static int findLCSOpt(List<String> input) {
        String m = input.get(0);
        String n = input.get(1);
        String p = input.get(2);

        int mLen = m.length();  //35
        int nLen = n.length();  //29
        int pLen = p.length();  //34

        dpTable = new int[mLen + 1][nLen + 1][pLen + 1];

        dpTable[0][0][0] = 0;
        dpTable[1][0][0] = 0;
        dpTable[0][1][0] = 0;
        dpTable[0][0][1] = 0;

        for (int e = 1; e < mLen+1; e++) {
            for (int f = 1; f < nLen+1; f++) {
                for (int g = 1; g < pLen+1; g++) {
                    char mChar = m.charAt(e - 1 );
                    char nChar = n.charAt(f - 1 );
                    char pChar = p.charAt(g - 1);


                    if (mChar == nChar && nChar == pChar) {
                        dpTable[e][f][g] = 1 + dpTable[e - 1][f - 1][g - 1];
                    } else if (mChar != nChar || nChar != pChar) {
                        int tempMax = Math.max(dpTable[e - 1][f][g], dpTable[e][f - 1][g]);
                        int max = Math.max(tempMax, dpTable[e][f][g - 1]);
                        dpTable[e][f][g] = max;
                    }
                }
            }
        }

        int maxvalue = dpTable[m.length() ][n.length() ][p.length() ];
        return maxvalue;
    }


    public static String findLongestCommonSubString(
            String m,
            String n,
            String p,
            StringBuilder longestCommonSubString) {

            char mChar = 0;
            char nChar = 0;
            char pChar = 0;

        if (m.length() >= 1 && n.length() >= 1 && p.length() >= 1) {
            mChar = m.charAt(m.length() - 1);
            nChar = n.charAt(n.length() - 1);
            pChar = p.charAt(p.length() - 1);
        }
        

        if (m.length() == 0 || n.length() == 0 || p.length() ==0 )  {
           return longestCommonSubString.toString();
        }

        if (mChar == nChar && nChar == pChar) {
            longestCommonSubString.insert(0, mChar);
            return findLongestCommonSubString(
                    m.substring(0, m.length() - 1),
                    n.substring(0, n.length() - 1),
                    p.substring(0, p.length() - 1),
                    longestCommonSubString
            )+ longestCommonSubString;
        }

        else if (m.length() >= 1 && n.length() >= 1 && p.length() >= 1) {
                int mPrior = dpTable[m.length() - 1][n.length() ][p.length() ];
                int nPrior = dpTable[m.length()][n.length() - 1][p.length()];
                int pPrior = dpTable[m.length()][n.length()][p.length() - 1];
                if (mPrior >= nPrior && mPrior >= pPrior)
                    return findLongestCommonSubString(
                            m.substring(0, m.length() - 1),
                            n.substring(0, n.length()),
                            p.substring(0, p.length()),
                            longestCommonSubString
                    );
                if (nPrior >= mPrior && nPrior >= pPrior)
                    return findLongestCommonSubString(
                            m.substring(0, m.length()),
                            n.substring(0, n.length() - 1),
                            p.substring(0, p.length()),
                            longestCommonSubString
                    );
                if (pPrior >= mPrior && pPrior >= nPrior)
                    return findLongestCommonSubString(
                            m.substring(0, m.length()),
                            n.substring(0, n.length()),
                            p.substring(0, p.length() - 1),
                            longestCommonSubString
                    );
            }
            else {return "";}

        return longestCommonSubString.toString();
    }

}
