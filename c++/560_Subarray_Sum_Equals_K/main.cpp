#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:
  int subarraySum(vector<int>& nums, int k) {
    if (nums.size() == 0) {
      return 0;
    }

    int count = 0;  // 57.23%
    int sum = 0;
    map<int, int> rec;
    rec[0]++;

    for(size_t i = 0; i < nums.size(); i++) {
      sum += nums[i];
      count += rec[sum - k];
      rec[sum]++;
    }

    // 下面的这段解法是错误的，分析见README
    // int start = 0;
    // int end = 1;
    // int sum = nums[0];
    // int count = sum == k? 1 : 0;
    // while (!(start >= nums.size() - 1 && end >= nums.size())) {
    //   if (sum < k && end < nums.size()) {
    //     sum += nums[end];
    //     end++;
    //   }
    //   else {
    //     sum -= nums[start];
    //     start++;
    //   }
    //   if (sum == k) {
    //     count++;
    //   }
    // }


    return count;
  }
};

int main() {
  vector<int> nums1 {1, 1, 1};
  vector<int> nums2 {1, 2, 3};
  vector<int> nums3 {1};
  vector<int> nums4 {-1, -1, 1};
  vector<int> nums5 {1,2,3,4,5,6,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2};
  vector<int> nums6 {28,54,7,-70,22,65,-6};

  int k1 = 2;
  int k2 = 3;
  int k3 = 0;
  int k4 = 100;

  Solution s;
  cout << s.subarraySum(nums1, k1) << endl; //2
  cout << s.subarraySum(nums2, k2) << endl; //2
  cout << s.subarraySum(nums3, k3) << endl; //0
  cout << s.subarraySum(nums4, k3) << endl; //1
  cout << s.subarraySum(nums5, k1) << endl; //10
  cout << s.subarraySum(nums6, k4) << endl; //1

  return 0;
}