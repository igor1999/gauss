package gauss.vector;

public interface VectorInterface {

    void input();

    void output();

    int getLength();

    double get(int index);

    void set(int index, double value);

    boolean compareLength(VectorInterface vector);

    void sumVector(VectorInterface vector) throws Exception;

    void productScalar(double scalar);

    double productVectorToScalar(VectorInterface vector) throws Exception;
}
