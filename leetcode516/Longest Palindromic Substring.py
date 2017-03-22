class Solution(object):
    def longestPalindromeSubseq(self, word):
        n = len(word)
        T = [[0 for _ in range(n)] for _ in range(n)]

        for i in range(n):
            T[i][i] = 1

        for l in range(2, n + 1):
            for i in range(n - l + 1):
                j = i + l - 1
                if l == 2 and word[i] == word[j]:
                    T[i][j] = 2
                elif (word[i] == word[j]):
                    T[i][j] = T[i + 1][j - 1] + 2
                else:
                    T[i][j] = max(T[i + 1][j], T[i][j - 1])
        return T[0][n-1]

s=Solution()
word = input()
print(s.longestPalindromeSubseq(word))
