
'''
8. Palindrome Number
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.
For example, 121 is palindrome while 123 is not.

 

Example 1:

Input: x = 121
Output: true



Example 2:

Input: x = -121
Output: false
Explanation: From left to right,it reads -121. From right to left, it becomes 121-.
Therefore it is not a palindrome.



Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.



Example 4:

Input: x = -101
Output: false
 

Constraints:

-231 <= x <= 231 - 1
 

Follow up: Could you solve it without converting the integer to a string?
'''

class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        
        x_str = str(x)
        if (len(x_str) == 1): return True
        if (x_str[0] == '-' or x_str[0] == '+'):
            return False
        if len(x_str) % 2 == 0:
            mid = int(len(x_str) /2)
            
        if len(x_str) % 2 == 1:
            mid = int((len(x_str)-1) /2)

        for i in range(mid):
       
            inflection = len(x_str) -1 - i
            print(x_str[i])
            print(inflection)
            if x_str[i] != x_str[inflection]:
               return False
            if i == mid-1:
               return True
                
            

if __name__ == '__main__':
    
    sol = Solution()
    test1 = 121
    test2 = -121
    test3 = -101
    test4 = 10

    print (sol.isPalindrome(test4))
    
   
    
 
