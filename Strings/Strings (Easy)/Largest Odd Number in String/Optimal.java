class Solution {
  public String largestOddNumber(String num) {
    int index = -1;
    index = Math.max(num.lastIndexOf('1'), index);
    index = Math.max(num.lastIndexOf('3'), index);
    index = Math.max(num.lastIndexOf('5'), index);
    index = Math.max(num.lastIndexOf('7'), index);
    index = Math.max(num.lastIndexOf('9'), index);
    return num.substring(0, index + 1);
  }
}