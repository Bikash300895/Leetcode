class Solution(object):
    def lexicalOrder(self, n):
        result = []
        stack = [1]
        
        while stack:
            m = stack.pop()
            result.append(m);
            if m<n and m%10<9:
                stack.append(m+1)
            if m * 10 <= n: 
                stack.append(m*10)
        
        return result
        

        
if __name__ == '__main__':
    s = Solution();
    arr = s.lexicalOrder(15);
    print arr