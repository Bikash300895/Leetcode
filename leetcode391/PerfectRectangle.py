class Solution(object):
    def isRectangleCover(self, rectangles):
        """
        :type rectangles: List[List[int]]
        :rtype: bool
        """
        left = min(x[0] for x in rectangles)
        bottom = min(x[1] for x in rectangles)
        right = max(x[2] for x in rectangles)
        top = max(x[3] for x in rectangles)
        heights = collections.defaultdict(int)
        widths = collections.defaultdict(int)
        for rect in rectangles:
            l, b, r, t = rect
            h, w = t - b, r - l
            heights[l] += h
            heights[r] -= h
            widths[b] += w
            widths[t] -= w
        hSum = heights[left]
        for x in range(left + 1, right):
            heights[x] += heights[x - 1]
            if heights[x] != heights[x - 1]:
                return False
            hSum += heights[x]
        wSum = widths[bottom]
        for x in range(bottom + 1, top):
            widths[x] += widths[x - 1]
            if widths[x] != widths[x - 1]:
                return False
            wSum += widths[x]
        return hSum == wSum == (top - bottom) * (right - left)