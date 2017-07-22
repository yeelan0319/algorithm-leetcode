class Solution(object):

  def twoSum(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    missing = {}
    for index, value in enumerate(nums):
      if value in missing:
        return (missing[value], index)
      else:
        missing[target - value] = index
