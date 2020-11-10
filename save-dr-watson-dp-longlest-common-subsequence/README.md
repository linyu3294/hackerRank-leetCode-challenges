#### Save Dr.Watson!! - LCS (Longest Common Substring)

You should provide a ‘Dynamic Programming’ algorithm to solve this problem.

Dr. Watson has been kidnaped! Sherlock Holmes was contacted by the kidnapper for ransom. Moments later he received a message from Dr. Watson’s phone. The message contained three random strings. Sherlock being Sherlock, was able to deduce immediately that Dr. Watson was trying to give a hint about his location. He figured out that the longest common subsequence between the 3 words is the location. But since it was too easy for him, he got bored and asked you to find out what the actual location is.

Your task is to find the longest common subsequence from the 3 given strings before it is too late.

Definitions: Subsequence - A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements. For instance, given a sequence “drew”; “d”, “w”, “de”, “drw”, “drew” are all examples of valid subsequences (there are also others), while “er”, “wdre” are not.

Note: W is a common subsequence of X, Y, and Z if and only if W is a subsequence of X, W is a subsequence of Y and W is a subsequence of Z.

If a common subsequence does not exist, return "Does not exist" (without quotes)

Your goal is to find the longest common subsequence, not just any common subsequence.

Input Format

Three lines, each containing a string.

Note: Each string only contains lowercase English alphabet letters (i.e. a, b, ... , y, z).

Constraints

1 <= x*y*z <= 10^7

x, y, and z are the lengths of the input strings X, Y, and Z respectively.

Output Format

Location of Dr. Watson (longest common subsequence of all the 3 sequences)

Sample Input 0

    uwytubiweutpowegbiutpoweeniwotiweqz
    fdsjkhfbklsdfigkjfdbensdjdlqa
    cmnvbcxmbimxcnbvmgxmnbvcxbexmbnnaz
Sample Output 0

    bigben
Explanation 0

uwytu bi weutpowe gb iutpow e e n iwotiwe qz

fdsjkhf b klsdf ig kjfd ben sdjdl qa

cmnv b cxmb i mxcnbvm g xmn b vcxb e xmb n n az

Note that the longest common subsequence between the first and the second string is bigbenq. Similarly the LCS between second and the third is bigbena and the first and the third is bigbenz

However, what we need is the longest common subsequence between all the three strings which turns out to be bigben