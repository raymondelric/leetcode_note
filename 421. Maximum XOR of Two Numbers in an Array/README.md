# Maximum XOR of Two Numbers in an Array

https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/ <br>
  
  <h2>Ideas</h2><br>
  Since this question requires a O(N) solution, the naive way doesn't work.  <br>
  The main idea is the decide the bit of the max XOR from its most significant bit, and that's why we need a mask.  <br>
  1. In every loop of k, we are focusing only on the first k bit of each nums, adding it to the memo set.  <br>
  2. Next, by the property of XOR, we knew that A XOR B = C can be written as A = B XOR C.
  By traversing every number in nums[] to see if the memo comtains tmp(the currnt max with 1 on its k bit) XOR (nums[i] & mask), the first k bits of nums[i]  <br>
  3. If we do find matches, we can set the max the value of tmp, clear the memo set, and then move to the next bit.  <br>
  
  <h2>Analysis</h2><br>
  Time Complexity: O(31 * (N)) = O(N) <br>
  Space Complexity: O(N) by using a HashSet. <br>
  