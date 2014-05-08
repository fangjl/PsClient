package com.dlh.hqy.psclient;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
public class WBottlesOutActivity extends BaseWapperActivity {
	private ListView listView;
	private Button tickBottles;

	@Override
	protected void findViewById() {
		listView = (ListView)this.findViewById(R.id.listView1);
		tickBottles =  (Button)this.findViewById(R.id.button1);
		
		
		
		
		
		
		
		
		tickBottles.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				
				getPSApplication().requestLocation();
				
				
			}
			
		});
	}

	@Override
	protected void loadViewLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_wbottles_out);
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
