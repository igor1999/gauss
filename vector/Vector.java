package gauss.vector;

import java.util.*;

public class Vector implements VectorInterface {

    private List<Double> elements = new ArrayList<>();

    private int length;


    public Vector(int length) throws Exception {
        this.length = length;

        if (this.length < 1) {
            throw new Exception("Length should be a positive number");
        }

        for (int i = 0; i <= this.length - 1; i ++) {
            this.elements.add(0.0);
        }
    }

    public void input() {
        Scanner in = new Scanner(System.in);

        int index = 0;
        for (double element: this.elements) {
            System.out.print("\tElement " + index + ": ");
            this.set(index, in.nextDouble());

            index += 1;
        }
    }

    public void output() {
        StringBuilder stringBuilder = new StringBuilder();

        for (double element: this.elements) {
            stringBuilder.append(element).append("; ");
        }

        System.out.println(stringBuilder.toString());
    }

    public int getLength() {
        return this.length;
    }

    public double get(int index) {
        return this.elements.get(index);
    }

    public void set(int index, double value) {
        this.elements.set(index, value);
    }

    public boolean compareLength(VectorInterface vector) {
        return this.length == vector.getLength();
    }

    public void sumVector(VectorInterface vector) throws Exception {
        if (!this.compareLength(vector)) {
            throw new Exception("Lengths should be identical");
        }

        for (int i = 0; i <= this.length - 1; i ++) {
            this.set(i, this.get(i) + vector.get(i));
        }
    }

    public void productScalar(double scalar) {
        for (int i = 0; i <= this.length - 1; i ++) {
            this.set(i, this.get(i) * scalar);
        }
    }

    public double productVectorToScalar(VectorInterface vector) throws Exception {
        if (!this.compareLength(vector)) {
            throw new Exception("Lengths should be identical");
        }

        float sum = 0;
        for (int i = 0; i <= this.length - 1; i ++) {
            sum += (this.get(i) * vector.get(i));
        }

        return sum;
    }
}
