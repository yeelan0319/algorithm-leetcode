public class Solution {
  public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0){
      return "";
    }

    int minLength = strs[0].length();
    for(int i = 1, l = strs.length; i < l; i++) {
      if(strs[i].length() < minLength){
        minLength = strs[i].length();
      }
    }
    for(int i = 0; i < minLength; i++) {
      char c = strs[0].charAt(i);
      for (int j = 0, l = strs.length; j < l; j++) {
        if (strs[j].charAt(i) != c) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0].substring(0, minLength); 
  }
}