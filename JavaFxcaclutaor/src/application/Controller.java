package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TextArea input;
	@FXML
	private TextField output1;
	@FXML
	private TextField output2;
	@FXML
	private CheckBox pc;
	@FXML
	private CheckBox top;
	@FXML
	private void calculate(ActionEvent e) {
		String str = input.getText();
		long num =  Integer.parseInt(str);
		int discount = 0;
		if(pc.isSelected()) {
			discount += 30;
		}
		if(top.isSelected()) {
			discount += 20;
		}
		long tax = num*(40*(100-discount)/100)/100;
		
		int number = (int)(num-tax);
		String money = number+"";
		String[] han1 = {"","��","��","��","��","��","��","ĥ","��","��"}; String[] han2 = {"","��","��","õ"}; String[] han3 = {"","��","��","��","��"}; StringBuffer result = new StringBuffer(); int len = money.length(); for(int i=len-1; i>=0; i--){ result.append(han1[Integer.parseInt(money.substring(len-i-1, len-i))]); if(Integer.parseInt(money.substring(len-i-1, len-i)) > 0) result.append(han2[i%4]); if(i%4 == 0) result.append(han3[i/4]); }

		
		output1.setText(tax+" ( ����: "+((num*40/100)-tax)+")");
		output2.setText(num-tax+" ( "+result.toString()+" )");
		
	}
}
