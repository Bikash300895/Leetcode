class Solution(object):
    def lengthOfLongestSubstring(self, s):

        if s=="":
            return 0

        n = len(s)
        cur_len = 1
        max_len = 1
        prev_index = 0
        i = 0

        visited = [-1] * 256
        visited[ord(s[0])] = 0

        for i in range(1,n):
            prev_index = visited[ord(s[i])]
            if prev_index==-1 or (i-cur_len > prev_index):
                cur_len +=1

            else:
                if cur_len>max_len:
                    max_len = cur_len

                cur_len = i- prev_index

            visited[ord(s[i])] = i

        if cur_len>max_len:
            max_len = cur_len

        return max_len
