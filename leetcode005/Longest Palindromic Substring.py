class Solution(object):
    def longestPalindrome(self, word):
        n = len(word)

        # Creating a table
        table = [[False for i in range(n)] for j in range(n)]

        # initializr the values for length one with true because string with one letter is always palindrome
        for i in range(n):
            table[i][i] = True

        # Declare two variable start and maxLength
        start = 0
        maxLength = 1

        # Lets handle the length 2 cases first then loop for all other length
        for i in range(n - 1):
            if word[i] == word[i + 1]:
                table[i][i + 1] = True
                start = i
                maxLength = 2

        for l in range(3, n + 1):
            for i in range(n - l + 1):
                j = i + l - 1

                if word[i] == word[j] and table[i + 1][j - 1]:
                    table[i][j] = True
                    if l > maxLength:
                        maxLength = l
                        start = i

        ans=""
        for i in range(start, start + maxLength):
            ans+=word[i]

        return ans

s=Solution()
print(s.longestPalindrome("a"))

# Test cases
if __name__ == "__main__":
    assert Solution().longestPalindrome("aba") == "aba"
    assert Solution().longestPalindrome("abba") == "abba"
    assert Solution().longestPalindrome("xaba") == "aba"
    assert Solution().longestPalindrome("xabba") == "abba"
