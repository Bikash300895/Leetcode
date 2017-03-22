class Solution(object):
    def longestPalindromeSubseq(self, input_string):
        n = len(input_string)
        word = "$"

        for i in range(n):
            word = word + input_string[i] + '$'
        # print(word)

        n = n * 2 + 1
        T = [0 for i in range(n)]

        start = 0
        endIndex = 0

        for i in range(n):
            # expand area i. See how far we can go

            while start > 0 and endIndex < n - 1 and word[start - 1] == word[endIndex + 1]:
                start -= 1
                endIndex += 1

            T[i] = endIndex - start + 1

            # According to Case:2 if we already reach end of the string we have nothing else to check
            if endIndex == n - 1:
                break

            # Mark newCenter to be either end or end + 1 depending on if we dealing with even or old number input.
            newCenter = endIndex + 1 if i % 2 == 0 else 0

            for j in range(i + 1, endIndex + 1):
                # i - (j - i) is left mirror. Its possible left mirror might go beyond current center palindrome. So take minimum
                # of either left side palindrome or distance of j to end.
                T[j] = min(T[i - (j - i)], 2 * (endIndex - j) + 1)

                if (int(j + T[i - (j - 1)] / 2) == endIndex):
                    newCenter = j
                    break

            i = newCenter
            start = int(i - T[i]/2)
            endIndex = int(i + T[i]/2)

        return (int(max(T)/2))




s = Solution()
word = "asa"
print(s.longestPalindromeSubseq(word))
