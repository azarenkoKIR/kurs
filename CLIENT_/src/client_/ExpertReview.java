package client_;

public class ExpertReview {

    private double[][] review = new double[4][12];

    private int expert_value = 0;

    public int getExpert_value() {
        return expert_value;
    }

    public void setExpert_value(int expert_value) {
        this.expert_value = expert_value;
    }

    public double[][] getReview() {
        return review;
    }

    public void setReview(int i, int j, double value) {
        review[i][j] = value;
    }

    public void setReview(double[][] review) {
        this.review = review;
    }

    public double getReview(int i, int j) {
        return review[i][j];
    }

    public int ExpertValueIncrement() {
        return ++expert_value;
    }
}
