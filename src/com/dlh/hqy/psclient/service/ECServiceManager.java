package com.dlh.hqy.psclient.service;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class ECServiceManager extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
//
//	private MyIECManager myIECManager;
//	private ProductDao productHistroyDao;
//	private static final String TAG = "ECServiceManager";
//
//	@Override
//	public void onCreate() {
//		super.onCreate();
//		myIECManager = new MyIECManager();
//		productHistroyDao = new ProductDao(this);
//
//		Logger.d(TAG, "ECServiceManager is start");
//	}
//
//	@Override
//	public IBinder onBind(Intent intent) {
//		Logger.d(TAG, "onBind ");
//		return myIECManager;
//	}
//
//	private class MyIECManager extends Binder implements IECManager {
//
//		@Override
//		public void addProductToHistory(ProdcutHistory history) {
//			Logger.d(TAG, "addProductToHistory" + history.toString());
//
//			if (productHistroyDao.findById(history.getId()))
//				productHistroyDao.update(history);
//			else
//				productHistroyDao.add(history);
//		}
//
//		@Override
//		public void clearProductHistory() {
//			Logger.d(TAG, "clearProductHistory");
//			productHistroyDao.deleteAll();
//		}
//
//		@Override
//		public List<ProdcutHistory> getAllProductHistory() {
//			Logger.d(TAG, "getAllProductHistory");
//			return productHistroyDao.getAll();
//		}
//	}
}
