package org.liaohailong.http;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static void main(String[] args) {
		String url = "http://127.0.0.1/http/user";
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "liaohailong");
		params.put("password", "123456");
		doPost(url, params);
	}

	public static void doPost(String url, Map<String, String> params) {
		CloseableHttpClient createDefault = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> parameters = new LinkedList<NameValuePair>();
		for (Entry<String, String> entry : params.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			NameValuePair pair = new BasicNameValuePair(key, value);
			parameters.add(pair);
		}
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, "utf-8");
			httpPost.setEntity(entity);
			try {
				CloseableHttpResponse execute = createDefault.execute(httpPost);
				int statusCode = execute.getStatusLine().getStatusCode();
				if (statusCode == 200) {
					String result = EntityUtils.toString(execute.getEntity(), "utf-8");
					System.out.println(result);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
