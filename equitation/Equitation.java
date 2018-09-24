package gauss.equitation;

import java.util.Scanner;
import gauss.vector.*;

public class Equitation implements EquitationInterface {

    private VectorInterface factors;

    private double freeMember = 0;


    public Equitation(int length) throws Exception {
        this.factors = this.createVector(length);
    }

    protected VectorInterface createVector(int length) throws Exception {
        return new Vector(length);
    }

    public void input() {
        Scanner in = new Scanner(System.in);

        System.out.println("Factors:");
        this.factors.input();

        System.out.print("Free member: ");
        this.freeMember = in.nextDouble();
        System.out.println();
    }

    public VectorInterface getFactors() {
        return this.factors;
    }

    public double getFreeMember() {
        return this.freeMember;
    }

    public void setFreeMember(double freeMember) {
        this.freeMember = freeMember;
    }

    public void sumEquitation(EquitationInterface equitation) throws Exception {
        this.factors.sumVector(equitation.getFactors());

        this.freeMember += equitation.getFreeMember();
    }

    public void productScalar(double scalar) {
        this.factors.productScalar(scalar);

        this.freeMember *= scalar;
    }

    public void calculateMemberN(int n, VectorInterface vector) throws Exception {
        double result = (this.freeMember - this.factors.productVectorToScalar(vector)) / this.factors.get(n);

        vector.set(n, result);
    }
}
