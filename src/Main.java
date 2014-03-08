import java.util.Arrays;


public class Main {
	public static void main(String...args) {
		Solution s = new Solution();
		int[] input = {-7, 2, 4, 3, -4, 3};
		int[] inputbasic = {3};
		System.out.println(s.solution(input));
		int[] A = {1, 2, 0, 4, 3, 2, 1, 5, 7};
		int[] B = {2, 8, 0, 7, 6, 5, 3, 4, 5, 6, 5};
		CannonSolution s2 = new CannonSolution();
		System.out.println(Arrays.toString(s2.solution(A, B)));
		int[] testmissin = {2, -1};
		TapeSolution ts = new TapeSolution();
		System.out.println(ts.solution(testmissin));
		FrogJumpSolution fj = new FrogJumpSolution();
		System.out.println(fj.solution(10, 85, 30));
		System.out.println(fj.solution(9999999, 10000000, 100000));
		System.out.println(fj.solution(-9999999, -9999998, 9999999));
	}
}

//you can also use imports, for example:
//import java.math.*;
final class Solution {
 public int solution(int[] A) {
     // write your code in Java SE 7
     long totalsum = totalSum(A);
     long sumsofar = 0;
     for(int i = 0; i < A.length; i++) {
         totalsum += inverse(A[i]);
         if (sumsofar == totalsum) {
             return i;
         }
         sumsofar += A[i];
     }
     return -1;
     
 }
 

 public long inverse(long a) {
     return -1 * a;
 }
 
 public long totalSum(int[] A) {
     long sum = 0;
     for(int i = 0; i < A.length; i++) {
         sum += A[i];
     }
     return sum;
 }
}


final class CannonSolution {
    public int[] solution(int[] A, int[] B) {
        // write your code in Java SE 7
        int[] copyOfA = new int[A.length];
        System.arraycopy(A, 0, copyOfA, 0, A.length);
        for(int i = 0; i < B.length; i++) {
            int minheight = minimumHeight(copyOfA, B[i]);
            if (minheight == -1) {
                continue;
            } else {
                copyOfA[minheight-1] += 1;
            }
        }
        return copyOfA;
    }
    
    public int minimumHeight(int[] A, int level) {
        if(level < A[0]) {
            return -1;
        } else {
            for(int i = 0; i < A.length; i++) {
                if (A[i] >= level) {
                    return i;
                }
            }
            return -1;
        }
    }
}

final class FindMissingSolution {
	class Solution {
	    public int solution(int[] A) {
	       double sumToN = 0;
	       for(int i = 0; i <= A.length; i++) {
	           sumToN += i;
	       }
	       double totalsum = totalSum(A);
	       Double res = (Double) (sumToN - totalsum);
	       return res.intValue();
	    }
	    
	    public double totalSum(int[] A) {
	        double sum = 0;
	        for(int i = 0; i < A.length; i++) {
	            sum += A[i];
	        }
	        return sum;
	    }
	}
}

final class TapeSolution {
    public int solution(int[] A) {
        // write your code in Java SE 7
        long rightsum = totalSum(A);
        long leftsum = 0;
        long diffsofar = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++) {
            rightsum -= A[i];
            leftsum += A[i];
            if (diffsofar >= Math.abs(leftsum - rightsum)) {
                diffsofar = Math.abs(leftsum - rightsum);
            }
        }
        return (int) diffsofar;
    }
    
    long totalSum(int[] A) {
        long sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }
}

class TripleSolution {
  public int solution(int[] A) {
  // write your code in Java SE 7
  Tuple[] Aindexed = indexify(A);
  Arrays.sort(Aindexed);
  int topproduct = tripleproduct(Aindexed[Aindexed.length-1].value, Aindexed[Aindexed.length-2].value, Aindexed[Aindexed.length-3].value);
  int botproduct = tripleproduct(Aindexed[0].value, Aindexed[1].value, Aindexed[Aindexed.length-1].value);
  if (topproduct >= botproduct) {
     return topproduct;
  } else {
     return botproduct;
  }
  
}

public Tuple[] indexify(int[] A) {
  Tuple[] copyOfA = new Tuple[A.length];
  for(int i = 0; i < A.length; i++) {
      Tuple toAdd = new Tuple(i, A[i]);
      copyOfA[i] = toAdd;
  }
  return copyOfA;
}

public int tripleproduct(int a, int b, int c) {
  return a * b * c;
}
}

final class Tuple implements Comparable<Tuple> {
int index;
int value;
Tuple(int index, int value) {
  this.value = value;
  this.index = index;
}

public int compareTo(Tuple t) {
  return this.value - ((Tuple) t).value;
}
}
	// you can also use imports, for example:
	// import java.math.*;
	final class FrogJumpSolution {
	    public int solution(int X, int Y, int D) {
	    	double d = (double) (Y - X) / (double) D;
	    	int i = (Y - X) / D;
	    	if (i == d) {
	    		return i;
	    	} else {
	    		return i+1;
	    	}
	    }
	}