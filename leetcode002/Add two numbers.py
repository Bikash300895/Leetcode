class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        numberOne = 0
        stackOne = []
        while l1 != None:
            stackOne.append(l1.val)
            l1 = l1.next

        while stackOne:
            numberOne = numberOne*10 + stackOne.pop()

        numberTwo = 0
        stackTwo = []
        while l2 != None:
            stackTwo.append(l2.val)
            l2 = l2.next

        while stackTwo:
            numberTwo = numberTwo*10 + stackTwo.pop()

        ans = numberTwo + numberOne

        dummy = ListNode(0)
        dummy.next = ListNode(0)
        current = dummy
        while ans:
            temp = ans%10
            ans = int(ans/10)
            current.next = ListNode(temp)
            current = current.next

        return dummy.next


l1 = ListNode(0)
# l1.next = ListNode(4)
# l1.next.next = ListNode(3)

l2 = ListNode(0)
# l2.next = ListNode(6)
# l2.next.next = ListNode(4)

s = Solution()
s.addTwoNumbers(l1, l2)
