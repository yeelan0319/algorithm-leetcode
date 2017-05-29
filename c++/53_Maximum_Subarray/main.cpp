#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int maxSubArray(vector<int>& nums) {  //53.88%
    int p = 0;
    int sum = 0;
    int maxSum = nums[0];
    while (p < nums.size()) {
      sum += nums[p];
      if (sum > maxSum) {
        maxSum = sum;
      }
      if (sum < 0) {
        sum = 0;
      }
      p++;
    }
    return maxSum;
  }
};


int main() {
  vector<int> nums1 {-2,1,-3,4,-1,2,1,-5,4};
  vector<int> nums2 {-1, -2};
  vector<int> nums3 {-3, -2};

  Solution s;
  cout << s.maxSubArray(nums1) << endl; //6
  cout << s.maxSubArray(nums2) << endl; //-1
  cout << s.maxSubArray(nums3) << endl; //-2

  return 0;
}