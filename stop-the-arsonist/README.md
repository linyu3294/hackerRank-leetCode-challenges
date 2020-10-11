You should use a 'Divide and Conquer' technique to solve this problem.

Boston FD receives a letter from an arsonist. In the letter they find a list of n words and a note that the building the arsonist plans to destroy is encoded within the list. The arsonist, who thinks he is clever, also provides a hint:

"The name of the building that I plan to destroy is the longest common prefix of all words in the attached list!".

Clearly, the arsonist is not very clever because (a) it is a terrible encoding and (b) he didn't think Boston FD had you to help them!

We let w_i be the i-th word in the list (1 <= i <= 1000) and l(w_i) be the length of w_i (1 <= l(w_i) <= 25000 for all i). We let L be the max(l(w_i)) over all i.

Your task is to determine the longest prefix of all words in the arsonsist's list, before he destroys his target.

Input Format

The first line contains the value of 'n', where n is the number of words in the list.

Each of the next n lines contains a word.

Note: Each word in the list only contains lowercase English alphabet letters (i.e. a, b, ... , y, z).

Constraints

    1 <= n <= 1000

    1 <= l(w_i) <= 25000 for all i (1 <= i <= n)

Output Format

Output the name of the building which is the arsonist's target.

Sample Input 0

    5
    northeasternkhouryccis
    northeasternkhouryccisbuilding
    northeasternkhouryyyyyyyy
    northeasternkhourybuilding
    northeasternkhourynortheastern
Sample Output 0

    northeasternkhoury
Explanation 0

Here n=5. We need to find the longest common prefix of the 5 words.

All 5 words have a common prefix of "northeasternkhoury", and no longer common prefix, so this is the correct answer.

    Some wrong answers include:
    a. "north": a common prefix in all 5 names but NOT the longest.
    b. "northeastern": a common prefix in all 5 names but NOT the longest.
    c. "northeasternkhouryccis": a longer prefix that is common for the first 2 words, but NOT all 5.