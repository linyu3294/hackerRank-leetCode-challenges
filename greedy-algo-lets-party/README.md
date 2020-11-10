### Let's Party!!

***
Solution missed 3 testcases. Not optimal solution.
***

Solve the question using a greedy algorithm

You want to throw a big party once the pandemic ends and have put together a list of n friends. You know who knows whom, so you have a list of length m containing pairs of people who know each other. You decide that it would be best to invite the maximum number of friends possible, subject to the following constraint: at the party, each person should have at least five people they know and at least five people they do not know.

#### Design an O(n^2) time algorithm that takes as input the list of  pairs of people who know each other and outputs the best choice of party invitees (the guest list which meets the constraints and has maximum size). You may assume you have hashing functionality whenever needed and that n = O(m) and m = o(n^2).

You can assume that all the friends are numbered from 1 to n

Input Format

The first line will contain two integers n and m denoting the number of friends and the size of the list.

Next m lines will contain 2 space separated integers, each denoting the fact that these two friends(ids) know each other.

Constraints

1 <= n <= 10^5

1 <= m <= 10^5

Output Format

    The first line would contain a single integer  denoting the number of people meeting the criteria and being invited to the party

    The second line would contain  space separated integers denoting the members being invited

Sample Input 0

    6 10
    1 2
    1 3
    1 4
    1 5
    1 6
    2 3
    2 4
    4 6
    5 6
    2 5
Sample Output 0

    0
    
Sample Input 1
    
    12 30
    1 2
    1 3
    1 4
    1 5
    1 6
    2 3
    2 4
    2 5
    2 6
    3 4
    3 5
    3 6
    4 5
    4 6
    5 6
    7 8
    7 9
    7 10
    7 11
    7 12
    8 9
    8 10
    8 11
    8 12
    9 10
    9 11
    9 12
    10 11
    10 12
    11 12
    
    
    
   Sample Output 1
    
    12
    1 2 3 4 5 6 7 8 9 10 11 12