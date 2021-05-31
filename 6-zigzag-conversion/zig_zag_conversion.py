
'''
6. ZigZag Conversion


The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"



Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"

Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I



Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000

'''



class Solution(object):
    '''
    :type s: str
    :type numRows: int
    :rtype: str
    '''
    def convert(self, s, numRows):

        if numRows == 1 or len(s) <= numRows:
            return s
        
        buckets = ['' for r in range(numRows)]

        direction = -1
        index = 0
        n=0

        while (n<len(s)):
            if (index == 0) or (index == numRows-1):
                direction *= -1
            buckets[index] += s[n]
            index += direction
            n += 1
            

        final_str = ''
        for b in buckets:
            final_str += ''.join (b)

        return final_str
        

if __name__ == '__main__':
    
    sol = Solution()
    test1 = 'PAYPALISHIRING'
    
    print(sol.convert(test1, 3))
    
 
