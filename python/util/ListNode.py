# Definition for singly-linked list.
class ListNode(object):

  def __init__(self, x):
    self.val = x
    self.next = None

  def __eq__(self, other):
    current = self
    while current is not None and other is not None:
      if (current.val != other.val):
        return False
      current = current.next
      other = other.next
    if current is None and other is None:
      return True
    else:
      return False
