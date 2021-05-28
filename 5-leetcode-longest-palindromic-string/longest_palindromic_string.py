'''
5. Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Input: s = "cbbd"
Output: "bb"

Input: s = "a"
Output: "a"

Input: s = "ac"
Output: "a"

'''



class Solution(object):
    def longestPalindrome(self, s):
        # this line adds two placeholders at each end of the string
        # without it the algo does not evaluate the terminals in the string 
        s = ' ' + s + ' '
        
        n = len(s)
        def getLen(l,r):
            while l>0 and r<n and s[l] == s[r]:
                l -= 1
                r += 1
            return r-l-1

        head = 0
        length = 0
        for i in range (n+1):

            # get the max of the palindrome count
            # starting from each of the two centers : @ i  vs  @ i + 1
  
            cur = max(getLen(i,i),
                      getLen(i,i+1))

            print('break')
            
            # don't update
            if cur <= length: continue
            # update
            length = cur 
            head = i - (cur - 1) // 2
            
        print(length)
        print ('head', head)
        return s[head:head+length]

        

if __name__ == '__main__':
    
    sol = Solution()
    test1 = 'c'
    test2 = 'cc'
    test3 = 'ccc'
    test4 = 'abccba'
    test5 = 'gabccbaerv'
    test6 = 'abccbaerv'
    test7 = 'ervabccba'
    print(sol.longestPalindrome(test3))
    
    print ('hello')
 
