class Solution {
  public int romanToInt(String s) {
    char[] roman = s.toCharArray();
    int n = roman.length;
    int sum = 0;
    
    for (int i = n - 1; i >= 0; --i) {
      char curr = roman[i];
      if (curr == 'I') sum += 1;
      else if (curr == 'V') sum += 5;
      else if (curr == 'X') sum += 10;
      else if (curr == 'L') sum += 50;
      else if (curr == 'C') sum += 100;
      else if (curr == 'D') sum += 500;
      else sum += 1000;

      if (i > 0) {
        char prev = roman[i - 1];
        if (prev == 'I' && (curr == 'V' || curr == 'X')) { --sum; --i; } 
        else if (prev == 'X' && (curr == 'L' || curr == 'C')) { sum -= 10; --i; } 
        else if (prev == 'C' && (curr == 'D' || curr == 'M')) { sum -= 100; --i; }
      }
    }
    return sum;
  }
}