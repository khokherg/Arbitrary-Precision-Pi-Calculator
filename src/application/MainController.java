
package application;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

	//Controls in the program

	@FXML private TextField text1;
	@FXML private TextField text2;
	@FXML private TextArea textResult;
	@FXML private Button btnCalculate;
	@FXML private Button btnClear;


	@FXML private void initialize() {
		//Attaching the event handlers
		btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onCalculateClick();         //calling the method of calculate button

			}
		});
		btnClear.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onClearClick();             //calling the method of clear button
			}
		});
	}
	public BigDecimal calculatePi(int iterations,int numberOfPrecisions) {

		//creating the BigDecimal class objects

		BigDecimal result = new BigDecimal(0);
		BigDecimal oddNum = new BigDecimal(1);
		BigDecimal pow5 = new BigDecimal(5);
		BigDecimal pow239 = new BigDecimal(239);
		BigDecimal sign = new BigDecimal(1);

		//Loop to control the iterations

		for (int count = 0; count < iterations; count++) {
			final BigDecimal sixteen = new BigDecimal(16);
			final BigDecimal four = new BigDecimal(4);
			BigDecimal nextTerm = (sixteen.divide (pow5.multiply(oddNum),numberOfPrecisions,RoundingMode.CEILING)).subtract(( four).divide(pow239.multiply(oddNum),numberOfPrecisions,RoundingMode.CEILING));
			result = (sign.multiply(nextTerm)).add(result);
			pow5 = pow5.multiply(pow5).multiply(pow5);
			pow239 = pow239.multiply(pow239).multiply(pow239);  //twoThreeNine
			BigDecimal two = new BigDecimal(2);
			oddNum = oddNum.add(two);
			sign = sign.negate();
		}
		return result;   //returns the result

	}
	// Method which sets the value of calculated pi in the result textField

	private void onCalculateClick()
	{
		textResult.setWrapText(true);
		textResult.setText(String.valueOf(calculatePi(Integer.parseInt(text2.getText()),Integer.parseInt(text1.getText()))));

	}

	//Method which sets the value null in all textBoxes
	private void onClearClick()
	{

		text1.setText("");
		text2.setText("");
		textResult.setText("");
	}
}



