package com.dlh.hqy.psclient;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
public abstract class BaseWapperActivity extends ActionBarActivity implements OnClickListener {
	
	
	private LinearLayout layout_content;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_wapper);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		initView();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base_wapper, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_base_wapper,
					container, false);
			return rootView;
		}
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
	protected abstract void findViewById();
	protected abstract void loadViewLayout();
	protected abstract void processLogic();
	protected abstract void setListener();
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
