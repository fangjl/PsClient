package com.dlh.hqy.psclient;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
public class MainActivity extends BaseWapperActivity {


	private TextView W_bottlesOut;
	private TextView W_bottlesIn;
	private TextView w_bottlessign;
	private TextView E_bottlesOut;
	private TextView E_bottlesIn;
	@Override
	protected void findViewById() {
		W_bottlesOut = (TextView)this.findViewById(R.id.btu_id_heavy_bottles_out);
		W_bottlesIn  = (TextView)this.findViewById(R.id.btu_id_heavy_bottles_in);
		w_bottlessign= (TextView)this.findViewById(R.id.btu_id_heavy_bottles_sign);
		E_bottlesOut = (TextView)this.findViewById(R.id.btu_id_emtpy_bottles_out);
		E_bottlesIn  = (TextView)this.findViewById(R.id.btu_id_emtpy_bottles_in);
		W_bottlesOut.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,WBottlesOutActivity.class);
				startActivity(intent);
			}
		});
		
	}

	@Override
	protected void loadViewLayout() {
		this.setContentView(R.layout.activity_main);
		
		
	}

	@Override
	protected void processLogic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		
	}



}
