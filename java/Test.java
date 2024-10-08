package java;
import java.util.*;
/* 
This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
*/
public class Test {
  public int solution(int[] A) {
    Arrays.sort(A);
    int i=0;
    for(;i<A.length-1;i++) {
      if(A[i+1] == A[i]) {
        continue;
      }

      if(A[i+1]!=A[i]+1) {
        return A[i]+1;
      }
    }

    return A[i]+1;
  }
  public static void main(String[] args) {
   System.out.println(new Test().solution(new int[]{1,2,3}));
  }
}



