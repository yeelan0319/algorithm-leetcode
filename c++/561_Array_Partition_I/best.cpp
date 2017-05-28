#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int arrayPairSum(vector<int>& nums) {
    vector<int> hashTable(20001, 0);
    for(size_t i = 0; i < nums.size(); i++) {
      hashTable[nums[i] + 10000]++;  // Count increase in hashTable everytime number appear.
    }

    int res = 0;
    int flag = 0;
    for(size_t i = 0; i < 20001; ) {
      if(hashTable[i] > 0 && flag == 0) {  // Add the odd indexed number
        res += i - 10000;
        flag = 1;
        hashTable[i]--;
      }
      else if (hashTable[i] > 0 && flag == 1) {  //Skip the next larger number
        flag = 0;
        hashTable[i]--;
      }
      else {
        i++;
      }
    }
    return res;
  }
};