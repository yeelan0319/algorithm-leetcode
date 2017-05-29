#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int findMin(vector<int>& nums) {
  if (nums.size() == 0) {  // 2.83%
      return -1;
    }

    int start = 0;
    int end = nums.size() - 1;
    int mid;

    while (start < end) {
      if(nums[start] < nums[end]) {
        return nums[start];
      }

      mid = (start + end) / 2;
      if (nums[mid] < nums[start]) {
        end = mid;
      }
      else {
        start = mid + 1;
      }
    }

    return nums[start];
  }
};