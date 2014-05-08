package com.dlh.hqy.psclient;
import com.dlh.hqy.psclient.application.PSApplication;
import com.dlh.hqy.psclient.util.ThreadPoolManager;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
public abstract class BaseWapperActivity extends Activity implements OnClickListener {
	private LinearLayout layout_content;
	/** ContentView */
	private View inflate;
	private ThreadPoolManager threadPoolManager;
	protected Context context;
	private PSApplication PSApplication;
	
	
	
	
	
	
	public PSApplication getPSApplication() {
		return PSApplication;
	}

	public BaseWapperActivity(){
		//threadPoolManager = ThreadPoolManager.getInstance();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_base_wapper);
		layout_content = (LinearLayout) super.findViewById(R.id.frame_content);
	//	context = getApplicationContext();
		PSApplication = (PSApplication) getApplication();
		
		
		
		initView();
	}
	
	/**
	 * 初始话子类视图
	 */
	private void initView() {
		/*if (isLoadBottomTab()) {
			loadBottomTab();
			selectedBottomTab(DEFAULT_INDEX);
		}*/
		loadViewLayout();
		findViewById();
		setListener();
		processLogic();
	}
	
	
	
	
	
	@Override
	public void setContentView(int layoutResID) {
		inflate = getLayoutInflater().inflate(layoutResID, null);
		setContentView(inflate);
	}
	@Override
	public void setContentView(View view) {
		layout_content.removeAllViews();
		layout_content.addView(inflate);
	}
	
	
	
	@Override
	public View findViewById(int id) {
		return inflate.findViewById(id);
	}
	
	
	protected abstract void findViewById();
	protected abstract void loadViewLayout();
	protected abstract void processLogic();
	protected abstract void setListener();
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		if(PSApplication.mLocationClient!=null && PSApplication.mLocationClient.isStarted()){
			PSApplication.mLocationClient.stop();
		}
		//PSApplication.removeActvity(this);
		context = null;
		threadPoolManager = null;
		layout_content = null;
		inflate = null;
		PSApplication = null;
	}
	
	
}
