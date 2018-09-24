package gauss.equitation;

import gauss.vector.Vector;

public class Solution extends Vector implements SolutionInterface {

    public Solution(int length) throws Exception {
        super(length);
    }

    public void output() {
        System.out.println("Solution:");

        super.output();
    }
}
