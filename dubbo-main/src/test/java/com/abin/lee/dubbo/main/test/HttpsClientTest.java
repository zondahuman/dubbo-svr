package com.abin.lee.dubbo.main.test;

import com.abin.lee.dubbo.common.util.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 16-4-22
 * Time: 下午10:23
 * To change this template use File | Settings | File Templates.
 */
public class HttpsClientTest {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            CloseableHttpClient httpclient = HttpClientUtil.getHttpsClient();
            System.out.println(""+httpclient.getConnectionManager());
            try {
                HttpGet httpget = new HttpGet("https://www.baidu.com/");

                System.out.println("Executing request " + httpget.getRequestLine());

                // Create a custom response handler
                ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                    @Override
                    public String handleResponse(
                            final HttpResponse response) throws ClientProtocolException, IOException {
                        int status = response.getStatusLine().getStatusCode();
                        if (status >= 200 && status < 300) {
                            HttpEntity entity = response.getEntity();
                            return entity != null ? EntityUtils.toString(entity) : null;
                        } else {
                            throw new ClientProtocolException("Unexpected response status: " + status);
                        }
                    }

                };
                String responseBody = httpclient.execute(httpget, responseHandler);
                System.out.println("----------------------------------------");
                System.out.println(responseBody);
                System.out.println("这次是第"+i+ "次");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                httpclient.close();
            }
        }
    }
}
