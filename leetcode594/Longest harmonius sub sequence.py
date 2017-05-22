import collections


class Solution:
    def findLHS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        # Approach with dictionary
        cnt = collections.Counter(nums)
        ans = 0

        lastKey = lastVal = None

        for key, val in sorted(cnt.items()):
            if lastKey is not None and lastKey + 1 == key:
                ans = max(ans, val + lastVal)

            lastKey, lastVal = key, val

        return ans