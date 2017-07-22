from google.apputils import basetest

from twosum import Solution


class MyTest(basetest.TestCase):

  def setUp(self):
    self.s = Solution()

  def testCase1(self):
    expected = (0, 1)
    self.assertEqual(self.s.twoSum([3, 3], 6), expected)

  def testCase2(self):
    expected = (1, 2)
    self.assertEqual(self.s.twoSum([3, 4, 2], 6), expected)

  def testCase3(self):
    expected = (2, 4)
    self.assertEqual(self.s.twoSum([-1, -2, -3, -4, -5], -8), expected)


if __name__ == '__main__':
  basetest.main()
