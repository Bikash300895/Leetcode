class Solution(object):
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """

        result = []
        def solve(m):
            result.append(m)
            if m*10<=n : solve(m*10)
            if m<n and m%10<9: solve(m+1)

        solve(1)
        return result


if __name__ == '__main__':
    s = Solution();
    arr = s.lexicalOrder(15);
    print arr