package gauss.equitation;

import java.util.ArrayList;
import java.util.List;

public class Matrix implements MatrixInterface {

    private List<EquitationInterface> equitations = new ArrayList<>();

    private int length;


    public Matrix(int length) throws Exception {
        this.length = length;

        if (this.length < 1) {
            throw new Exception("Length should be a positive number");
        }

        for (int i = 0; i <= this.length - 1; i ++) {
            this.equitations.add(this.createEquitation());
        }
    }

    public void input() {
        for (int i = 0; i <= this.length - 1; i ++) {
            System.out.println("Equitation " + i + ':');
            this.getEquitation(i).input();
        }
    }

    protected EquitationInterface createEquitation() throws Exception{
        return new Equitation(this.length);
    }

    public int getLength() {
        return length;
    }

    public EquitationInterface getEquitation(int index) {
        return this.equitations.get(index);
    }

    public SolutionInterface solve() throws Exception {
        SolutionInterface solution = this.createSolution();

        this.createTriangle(0);

        for (int i = this.length - 1; i >= 0; i --) {
            this.getEquitation(i).calculateMemberN(i, solution);
        }

        return solution;
    }

    protected SolutionInterface createSolution() throws Exception {
        return new Solution(this.length);
    }

    protected void createTriangle(int column) throws Exception {
        int row = this.findNotZero(column);

        if (row == -1) {
            throw new Exception("System data is not valid");
        }

        this.swap(column, row);

        double firstOfBase = this.getEquitation(column).getFactors().get(column);

        for (int i = column + 1; i <= this.length - 1; i ++) {
            double firstOfRow = this.getEquitation(i).getFactors().get(column);

            if (firstOfRow != 0) {
                double factor = - (firstOfBase / firstOfRow);
                this.getEquitation(i).productScalar(factor);
                this.getEquitation(i).sumEquitation(this.getEquitation(column));
            }
        }

        if (column < this.length - 2) {
            this.createTriangle(column + 1);
        }
    }

    protected int findNotZero(int column) {
        int row = -1;

        for (int i = column; i <= this.length - 1; i ++) {
            if (this.getEquitation(i).getFactors().get(column) != 0) {
                row = i;
                break;
            }
        }

        return row;
    }

    protected void swap(int row1, int row2) {
        if (row1 != row2) {
            EquitationInterface equitation1 = this.getEquitation(row1);
            EquitationInterface equitation2 = this.getEquitation(row2);

            this.equitations.set(row1, equitation2);
            this.equitations.set(row2, equitation1);
        }
    }
}
