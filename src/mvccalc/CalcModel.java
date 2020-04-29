package mvccalc;

public class CalcModel {

    private int result;

    public void calculate(int first, int second) {
        result = first + second;
    }
    public int getResult() {
        return result;
    }
}
