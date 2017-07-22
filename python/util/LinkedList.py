from ListNode import ListNode


class LinkedList(object):

  def __init__(self, values):
    if not values:
      raise ValueError("LinkedList could not be initiated with no values.")

    self.length = len(values)
    self.head = ListNode(values[0])
    current_node = self.head
    for value in values[1:]:
      current_node.next = ListNode(value)
      current_node = current_node.next

  def __len__(self):
    return self.length

  def __eq__(self, other):
    if len(other) != self.length:
      return False
    current_node = self.head
    other_current_node = other.head
    while current_node.val is not None:
      if (current_node.val != other_current_node.val):
        return False
      current_node = current_node.next
      other_current_node = other_current_node.next
    return True
