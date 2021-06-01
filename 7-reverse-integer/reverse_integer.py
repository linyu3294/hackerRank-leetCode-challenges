
'''
7. Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1


Success!

Runtime: 24 ms, faster than 37.37% of Python online submissions for Reverse Integer.
Memory Usage: 13.6 MB, less than 9.52% of Python online submissions for Reverse Integer.

'''



class Solution(object):
    """
    :type x: int
    :rtype: int
    """
    def reverse(self, x):
        prefix = 'negative' if x < 0 else 'positive'
        number_str = str(abs(x))

        old_lst = [i for i in number_str]
        new_lst = []

        while (len(old_lst) != 0):
            char = old_lst.pop()
            new_lst.append(char)
        if new_lst[0] == 0: new_lst = new_lst[1:]
        reversed_int = int(''.join(new_lst))
        reversed_int = -(reversed_int) if prefix == 'negative' else reversed_int

        # prevents the calculation to go outside of signed int range
        if reversed_int > 2147483647 or reversed_int < -2147483647 : return 0
        return reversed_int
        

if __name__ == '__main__':
    
    sol = Solution()
    test1 = 1230
    test2 = -123

    print (sol.reverse(test2))
    
   
    
 
