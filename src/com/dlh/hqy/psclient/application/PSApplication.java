package com.dlh.hqy.psclient.application;
import org.apache.http.Header;
import org.json.JSONException;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.GeofenceClient;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.dlh.hqy.psclient.util.Logger;
import com.dlh.hqy.psclient.util.NFCReader;
import com.dlh.hqy.psclient.util.NetUtil;
import com.dlh.hqy.psclient.vo.TanktransferVo;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;
import android.util.Log;
import android.widget.TextView;
public class PSApplication extends Application {
	private static final String TAG = "PSApplication";
	
	public LocationClient mLocationClient;
	public GeofenceClient mGeofenceClient;
	private MyLocationListener mMyLocationListener;
	public TextView mLocationResult;
	public Vibrator mVibrator;
	public NotifyLister mNotifyLister;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		/**百度**/
		mLocationClient 	=     new LocationClient(this);
		mMyLocationListener = new MyLocationListener();
		mLocationClient.registerLocationListener(mMyLocationListener);
		mGeofenceClient 	=     new GeofenceClient(this);
		mNotifyLister 		= 	  new NotifyLister();
		mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
		initLocationClientOption();
		
	}

	/**
	 * 实现实位回调监听
	 */
	public class MyLocationListener implements BDLocationListener {

			
			@Override
			public void onReceiveLocation(BDLocation location) {
				//Receive Location 
				StringBuffer sb = new StringBuffer(256);
				sb.append("time : ");
				sb.append(location.getTime());
				sb.append("\nerror code : ");
				sb.append(location.getLocType());
				sb.append("\nlatitude : ");
				sb.append(location.getLatitude());
				sb.append("\nlontitude : ");
				sb.append(location.getLongitude());
				sb.append("\nradius : ");
				sb.append(location.getRadius());
				if (location.getLocType() == BDLocation.TypeGpsLocation){
					sb.append("\nspeed : ");
					sb.append(location.getSpeed());
					sb.append("\nsatellite : ");
					sb.append(location.getSatelliteNumber());
					sb.append("\ndirection : ");
					sb.append(location.getDirection());
				} else if (location.getLocType() == BDLocation.TypeNetWorkLocation){
					sb.append("\naddr : ");
					sb.append(location.getAddrStr());
					//运营商信息
					sb.append("\noperationers : ");
					sb.append(location.getOperators());
				}
				logMsg(sb.toString());
				Log.i("BaiduLocationApiDem", sb.toString());
			
			
			
			
			
			
			StringBuffer sb2 = new StringBuffer(256);
			sb.append(location.getLatitude()+",");
			sb.append(location.getLongitude());
			//开始读芯片
			
			TanktransferVo vo = 	new TanktransferVo();
			
			vo.setOfficecode("37018");
			vo.setOfficecode("3701801");
			vo.setOfficename("烟台汇通");
			vo.setLzzt(1);
			
			//读取芯片      
			NFCReader.read(vo );
			//发送到服务器
			
			
			
			RequestParams rp = new RequestParams();
			
			rp.put("tenantcode","37018");
			rp.put("officecode", "3701801");
			rp.put("gpbm", vo.getGpbm()); //钢瓶编码
			rp.put("xpbm", vo.getXpbm());//RFID芯片编码
			rp.put("ggxh", 1);//规格型号，12kg,15kg
			rp.put("czjz",1);//充装介质
			rp.put("jwd", sb.toString());//经纬度
			rp.put("czrcode", "222");
			rp.put("czrname", "方金林");
			rp.put("lzzt", 1);
			
			
			
			NetUtil.post(null, rp, new TextHttpResponseHandler(){

				@Override
				public void onFailure(String responseBody, Throwable error) {
					Logger.i("responseBody", responseBody);
					Logger.i("error", error.getMessage());
				}

				@Override
				public void onSuccess(int statusCode, Header[] headers,
						String responseBody) {
				
					
					
					Logger.i("responseBody", responseBody);
				}

			
				
			});
			
			
			
		}

		@Override
		public void onReceivePoi(BDLocation arg0) {
			
		}
	}
	/**
	 * 显示请求字符串
	 * @param str
	 */
	public void logMsg(String str) {
		try {
			if (mLocationResult != null)
				mLocationResult.setText(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 高精度地理围栏回调
	 * @author jpren
	 *
	 */
	public class NotifyLister extends BDNotifyListener{
		public void onNotify(BDLocation mlocation, float distance){
			mVibrator.vibrate(1000);
		}
	}
	
	
	
	private void initLocationClientOption(){
		
		
	    LocationClientOption option = new LocationClientOption();
	    option.setLocationMode(LocationMode.Hight_Accuracy);//设置定位模式
	    option.setCoorType("bd09ll");//返回的定位结果是百度经纬度，默认值gcj02
	  //  option.setScanType(5000);//设置发起定位请求的间隔时间为5000ms
	    option.setIsNeedAddress(true);//返回的定位结果包含地址信息
	    option.setNeedDeviceDirect(true);//返回的定位结果包含手机机头的方向
	    mLocationClient.setLocOption(option);
		
	}
	
	public void requestLocation(){
		
		
		if(!mLocationClient.isStarted()){
			mLocationClient.start();
		}
		mLocationClient.requestLocation();
	}
}
