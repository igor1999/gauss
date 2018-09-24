package gauss.equitation;

public interface MatrixInterface {

    void input();

    int getLength();

    EquitationInterface getEquitation(int index);

    SolutionInterface solve() throws Exception;
}
