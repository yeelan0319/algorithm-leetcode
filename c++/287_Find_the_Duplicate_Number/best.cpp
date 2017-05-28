#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int findDuplicate(vector<int>& nums) {   //67.22%
    if (nums.size() <= 1) {
      return -1;
    }

    int slow = nums[0];
    int fast = nums[nums[0]];

    while (fast != slow) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }

    fast = 0;
    while (fast != slow) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }
};
