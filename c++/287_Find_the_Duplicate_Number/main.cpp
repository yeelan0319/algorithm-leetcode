#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
  int findDuplicate(vector<int>& nums) {  //#35.07%
    sort(nums.begin(), nums.end());
    for (size_t i = 0; i < nums.size() - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return nums[i];
      }
    }
    return -1;
  }
};

int main() {
  vector<int> nums {2, 1, 3, 3};
  Solution s;
  cout << s.findDuplicate(nums) << endl;
  return 0;
}

