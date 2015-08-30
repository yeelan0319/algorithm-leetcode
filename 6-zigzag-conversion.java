public class Solution {
  public String convert(String s, int numRows) {
    if (s == null) {
      return null;
    }
    if (s.length() <= numRows || numRows == 1) {
      return s;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      sb.append(s.charAt(i));
      int step = (numRows - 1 - i) * 2;
      int position = i + step;
      while (position < s.length()) {
        if (step != 0) {
          sb.append(s.charAt(position));
        }
        step = (numRows - 1) * 2 - step;
        position += step;
      }
    }
    return sb.toString();
  }
}