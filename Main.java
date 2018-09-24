package gauss;

import gauss.equitation.Matrix;
import gauss.equitation.MatrixInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Number of equitations: ");
        int length = in.nextInt();
        System.out.println();

        MatrixInterface matrix = new Matrix(length);

        matrix.input();
        matrix.solve().output();
    }
}