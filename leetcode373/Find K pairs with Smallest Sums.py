class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """

        results = []
        if len(nums1) == 0 or len(nums2) == 0:
            return results

        k = min(k, (len(nums2) * len(nums1)))

        index = [0] * len(nums1)

        while k>0:
            min_val = 0x7FFFFFFF
            t = 0

            for i in range(len(nums1)):
                if index[i]<len(nums2) and nums1[i] + nums2[index[i]] < min_val:
                    t = i
                    min_val = nums1[i] + nums2[index[i]]

            results.append([nums1[t], nums2[index[t]]])
            index[t] +=1

            k -=1

        return results


nums1 = [1,7,11]
nums2 = [2,4,6]
k = 3

s = Solution()
print(s.kSmallestPairs(nums1,nums2,3))