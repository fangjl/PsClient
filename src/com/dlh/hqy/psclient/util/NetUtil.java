package com.dlh.hqy.psclient.util;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
public class NetUtil {

	  private static final String BASE_URL = "http://127.0.0.1:8080/testdd/transfter";

	  
	 
	  private static AsyncHttpClient client = new AsyncHttpClient();
	
	  public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
	      client.get(getAbsoluteUrl(url), params, responseHandler);
	  }

	  public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
	      client.post("http://localhost:8080/testdd/transfter", params, responseHandler);
	  }

	  
	  
	  
	  
	  private static String getAbsoluteUrl(String relativeUrl) {
		  if(relativeUrl==null){
			  relativeUrl = "";
		  }
	      return BASE_URL + relativeUrl;
	  }
	  
}
