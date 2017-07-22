from google.apputils import basetest

from python.util.LinkedList import LinkedList
from addtwonumbers import Solution


class MyTest(basetest.TestCase):

  def setUp(self):
    self.s = Solution()

  def testEqualLengthNoOverflow(self):
    l1 = LinkedList([2, 3, 3])
    l2 = LinkedList([5, 6, 4])
    expected = LinkedList([7, 9, 7])
    self.assertEqual(self.s.AddTwoNumbers(l1.head, l2.head), expected.head)

  def testEqualLengthWithOverflow(self):
    l1 = LinkedList([2, 4, 3])
    l2 = LinkedList([5, 6, 4])
    expected = LinkedList([7, 0, 8])
    self.assertEqual(self.s.AddTwoNumbers(l1.head, l2.head), expected.head)

  def testEqualLengthWithOverflowLongerThanBoth(self):
    l1 = LinkedList([2, 4, 5])
    l2 = LinkedList([5, 6, 4])
    expected = LinkedList([7, 0, 0, 1])
    self.assertEqual(self.s.AddTwoNumbers(l1.head, l2.head), expected.head)

  def testInequalLengthNoOverflow(self):
    l1 = LinkedList([2, 3, 3])
    l2 = LinkedList([5, 6])
    expected = LinkedList([7, 9, 3])
    self.assertEqual(self.s.AddTwoNumbers(l1.head, l2.head), expected.head)

  def testInequalLengthWithOverflow(self):
    l1 = LinkedList([9, 9, 8])
    l2 = LinkedList([1])
    expected = LinkedList([0, 0, 9])
    self.assertEqual(self.s.AddTwoNumbers(l1.head, l2.head), expected.head)

  def testInequalLengthWithOverflowLongerThanBoth(self):
    l1 = LinkedList([9, 9, 9])
    l2 = LinkedList([1])
    expected = LinkedList([0, 0, 0, 1])
    self.assertEqual(self.s.AddTwoNumbers(l1.head, l2.head), expected.head)


if __name__ == '__main__':
  basetest.main()
