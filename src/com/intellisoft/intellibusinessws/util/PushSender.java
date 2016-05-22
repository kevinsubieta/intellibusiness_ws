package com.intellisoft.intellibusinessws.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PushSender {
	
	public static final String PROJECT_NUMBER = "597439290090";
	public static final String PROJECT_NAME = "PushCheckIn";
	public static final String PROJECT_ID = "poised-space-93719";
	public static final String gcmAuthToken = "AIzaSyAKtsi6iO7cTgFWT53aTlCf1pJNBHP7hQg";  
	
	public static final String gcmURL = "https://android.googleapis.com/gcm/send";
//	public static String gcmRegID_Duos = "APA91bHk1cmLCRSe15WaozxfKupIe-uxPpw5Xcw2oThmUW6867NPJe5gEE-fgz_gScZhYSPEel58OHts6h8mPDDwxA8DOYAwsW7fFINd_4CWwbIDCx18ejKDeABBNcq_s3k1GpSluklu9MnvdHq37E6dj-rvhlW0Wg";
	public static String gcmRegID_Ace3 = "APA91bE2VUY1dww2PGcGgl1UHlW-5DtMCoftEbB75f5SOvS73T-7ZiNMPuUYqUZtieD6JyjESIgyXO6YnFcScFbis0bKcS2spNrRgcRteNVcOYhnvW5fz6XsGMeQ6vvPA-czGZ85xi5niwg1B-xxWXbbZdOWOguWWw";
//	public static String gcmRegID_Note = "APA91bFf3FmyhT9OEdQO-zGNfvwTkdxeYwHvIWGsbHWnaRj6aGNUOwDpo6RMb-FS3SOpvokZQjUXKN3BWyvij-7FhUVnZGCMeetEAIZkzKEJrvf8gIg54sMGLH0vNoE2oBTQsitRoENT15MiUlgvR5kZKTb6yoD6-Q";	
	    
	@SuppressWarnings("unchecked")
	public static String send() throws Exception {
		JSONObject obj = new JSONObject();
	    obj.put("collapse_key", "score_update");
	    obj.put("time_to_live", 500);
	    obj.put("delay_while_idle", true);
	    JSONObject data = new JSONObject();
	    data.put("mensaje", "Hola que hace");
	    data.put("atencion","NO");	    
	    obj.put("data", data);
	    JSONArray ids = new JSONArray();
//	    ids.add(gcmRegID_Duos);
	    ids.add(gcmRegID_Ace3);
//	    ids.add(gcmRegID_Note);
	    obj.put("registration_ids", ids);
	    System.out.println(obj.toJSONString());
	    
	    URL url = new URL(gcmURL);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    HttpsURLConnection
	            .setDefaultHostnameVerifier(new FakeHostnameVerifier());
	    conn.setDoOutput(true);
	    conn.setUseCaches(false);
	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("Content-Type",
	            "application/json");
	    conn.setRequestProperty("Authorization", "key=" + gcmAuthToken);
	    OutputStream out = conn.getOutputStream();
	    out.write(obj.toJSONString().getBytes());
	    out.close();
	    conn.getInputStream();
	    String reponseLine = new BufferedReader(new InputStreamReader(
	            conn.getInputStream())).readLine();
	   return reponseLine;
	}
		
	public static void main(String... args){
		PushSender sender = new PushSender();
		try {
			sender.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	private static class FakeHostnameVerifier implements HostnameVerifier {
	    public boolean verify(String hostname, SSLSession session) {
	        return true;
	    }
	}
}
