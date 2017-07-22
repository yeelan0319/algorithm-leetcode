from python.util.ListNode import ListNode


class Solution(object):

  def AddDigit(self, d1, d2, overflow):
    return ((d1 + d2 + overflow) % 10, (d1 + d2 + overflow) / 10)

  def CopyDigits(self, target, source, overflow):
    while source is not None:
      digit, overflow = self.AddDigit(source.val, 0, overflow)
      target.next = ListNode(digit)
      target = target.next
      source = source.next
    return target, overflow

  def AddTwoNumbers(self, l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """
    head = None
    current = None
    overflow = 0
    while l1 is not None and l2 is not None:
      if head is None:
        digit, overflow = self.AddDigit(l1.val, l2.val, overflow)
        head = ListNode(digit)
        current = head
      else:
        digit, overflow = self.AddDigit(l1.val, l2.val, overflow)
        current.next = ListNode(digit)
        current = current.next
      l1 = l1.next
      l2 = l2.next

    if l1 is not None:
      current, overflow = self.CopyDigits(current, l1, overflow)
    elif l2 is not None:
      current, overflow = self.CopyDigits(current, l1, overflow)

    if overflow != 0:
      current.next = ListNode(overflow)

    return head
