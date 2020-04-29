package mvccalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {

    private CalcModel calcModel;
    private CalcView calcView;

    public CalcController(CalcModel calcModel, CalcView calcView) {
        this.calcModel = calcModel;
        this.calcView = calcView;

        this.calcView.addCalcListener(new CalculateListener());

    }

    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            int first, second = 0;

            try {
                first = calcView.getFirstNumber();
                second = calcView.getSecondNumber();
                calcModel.calculate(first, second);
                calcView.setResult(calcModel.getResult());

            } catch (NumberFormatException e) {
                calcView.displayErrorMessage("You need to enter 2 integers!");

            }
        }
    }

}
