package il.ac.huji.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {
	
	private static final double PRECENT = 0.12;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		final EditText edtBillAmount = (EditText) findViewById(R.id.edtBillAmount);
		final CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
		final Button calculateButton = (Button) findViewById(R.id.btnCalculate);
		final TextView txtTipResult = (TextView)findViewById(R.id.txtTipResult);
		
		final String resultText = (String) txtTipResult.getText();
		
		calculateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String amountString = edtBillAmount.getText().toString();
				try {
					Double amountDouble = Double.valueOf(amountString);
					Double resultDouble = amountDouble*PRECENT;
					if (chkRound.isChecked()) {
						Long result = Math.round(resultDouble);
						txtTipResult.setText(resultText+result.toString());
					} else {
						txtTipResult.setText(resultText+resultDouble.toString());
						
					}
				} catch(NumberFormatException e) {
					Toast toast = Toast.makeText(getApplicationContext(), R.string.problem, Toast.LENGTH_SHORT);
					toast.show();
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}
