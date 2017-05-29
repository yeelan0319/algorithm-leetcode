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

    // in case there is no rotate happened
    if(nums[start] < nums[end]) {
      return nums[start];
    }

    int mid = (start + end) / 2;
    while (mid != start) {
      if (nums[mid] < nums[start]) {
        end = mid;
      }
      else {
        start = mid;
      }
      mid = (start + end) / 2;
    }

    return nums[end];
  }
};

int main() {
  vector<int> nums1 {0, 1, 2, 3, 4};
  vector<int> nums2 {1, 2, 3, 4, 0};
  vector<int> nums3 {4, 0, 1, 2, 3};
  vector<int> nums4 {1};
  vector<int> nums5 {};
  vector<int> nums6 {3, 4, 0, 1, 2};
  vector<int> nums7 {3, 4, 0, 1};

  Solution s;
  cout << s.findMin(nums1) << endl; //0
  cout << s.findMin(nums2) << endl; //0
  cout << s.findMin(nums3) << endl; //0
  cout << s.findMin(nums4) << endl; //1
  cout << s.findMin(nums5) << endl; //-1
  cout << s.findMin(nums6) << endl; //0
  cout << s.findMin(nums7) << endl; //0

  return 0;
}