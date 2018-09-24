package gauss.equitation;

import gauss.vector.VectorInterface;

public interface EquitationInterface {

    void input();

    VectorInterface getFactors();

    double getFreeMember();

    void setFreeMember(double freeMember);

    void sumEquitation(EquitationInterface equitation) throws Exception;

    void productScalar(double scalar);

    void calculateMemberN(int n, VectorInterface vector) throws Exception;
}
