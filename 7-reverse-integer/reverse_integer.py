
'''
7. Reverse Integer

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
        return reversed_int
        

if __name__ == '__main__':
    
    sol = Solution()
    test1 = 1230
    test2 = -123

    print (sol.reverse(test2))
    
   
    
 
