package com.dlh.hqy.psclient;
import java.io.File;
import com.dlh.hqy.psclient.engine.DownLoadTask;
import com.dlh.hqy.psclient.engine.DownLoadTask.DownlaodListener;
import com.dlh.hqy.psclient.util.Logger;
import com.dlh.hqy.psclient.util.ThreadPoolManager;
import com.dlh.hqy.psclient.vo.Version;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class WebcomeActivity extends Activity implements Runnable, DownlaodListener{

	private static final String TAG = "WelcomeActivity";

	/** 提示用户更新 */
	private static final int SHOW_UPDATE_DIALOG = 11;
	/** 下载失败 */
	private static final int DOWN_ERROR = 12;

	/** 从服务器获取的版本信息 */
	private Version version;

	/** 是否设置进度条最大值 */
	private boolean flag = true;

	/** 进度条 */
	private ProgressDialog mProgressDialog;

	/** 进度条当前的值 */
	private int progressVaue;

	/** apk 文件 */
	private File file;

	/** 下载任务 */
	private DownLoadTask downLoadTask;
	
	private String clientVersion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webcome);
		try {
			clientVersion = getClientVersion();
		} catch (NameNotFoundException e) {
			Logger.e(TAG, e);
		}
		
		ThreadPoolManager.getInstance().addTask(this);
	}


	@Override
	public void update(int total, int len, int threadid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void downLoadFinish(int totalSucess) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void downLoadError(int type) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 进入主页
	 */
	private void gotoHome() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}
	@Override
	public void run() {
		gotoHome();
		/*// TODO Auto-generated method stub
		try {
			if (NetUtil.hasNetwork(this)) {
				BaseParser<Version> jsonParser = new VersionParser();
				RequestVo vo = new RequestVo(R.string.url_version, this, null, jsonParser);
				version = (Version) NetUtil.get(vo);
				if (version != null) {
					String v = version.getVersion();

					Logger.d(TAG, "获取当前服务器版本号为 ：" + v);
					if (clientVersion.equals(v)) {
						gotoHome();
					} else {
						Message.obtain(handler, SHOW_UPDATE_DIALOG).sendToTarget();
					}
				} else {
					gotoHome();
				}
			} else {
				gotoHome();
			}
		} catch (Exception e) {
			Logger.e(TAG, e);
			gotoHome();
		}*/
	}

	private String getClientVersion() throws NameNotFoundException {
		PackageManager packageManager = getPackageManager();
		PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
		return packageInfo.versionName;
	}

	
	

}
