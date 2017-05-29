#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int uniquePaths(int m, int n) {  //45.24%
    if (m < 1 || n < 1) {
      return 0;
    }

    int res[n];
    for (size_t i = 0; i < n; i++) {
      res[i] = 1;
    }
    for(size_t i = 0; i < m - 1; i++) {
      for(size_t j = 1; j < n; j++) {
        res[j] += res[j - 1];
      }
    }

    return res[n - 1];
  }
};

int main() {
  Solution s;
  cout << s.uniquePaths(3, 3) << endl; //6
  cout << s.uniquePaths(0, 0) << endl; //0
  cout << s.uniquePaths(1, 1) << endl; //1

  return 0;
}


