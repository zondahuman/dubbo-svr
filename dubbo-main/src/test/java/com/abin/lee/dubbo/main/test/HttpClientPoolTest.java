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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: tinkpad
 * Date: 16-4-22
 * Time: 下午10:23
 * To change this template use File | Settings | File Templates.
 */
public class HttpClientPoolTest {
    private static final String httpUrl ="http://localhost:9000/http/list?keyword=lee";
    public static void main(String[] args) throws IOException {

            int total = 1000;
            try {
                ExecutorService executorService = Executors.newCachedThreadPool();
                CountDownLatch countDownLatch = new CountDownLatch(total);
                for (int i = 0; i < total; i++) {
                    executorService.execute(new executeTask(countDownLatch, httpUrl));
                }
                countDownLatch.await();
                if(!executorService.isShutdown())
                    executorService.shutdown();
                executorService.isTerminated();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static class executeTask extends Thread{
        private CountDownLatch countDownLatch;
        private String httpUrl;

        executeTask(CountDownLatch countDownLatch, String httpUrl){
            this.httpUrl = httpUrl;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            CloseableHttpClient httpclient = HttpClientUtil.getHttpClient();
            try {
            System.out.println("executeTask--httpURL="+httpUrl);
            System.out.println(""+httpclient.getConnectionManager());
            HttpGet httpget = new HttpGet(httpUrl);
            System.out.println("Executing request " + httpget.getRequestLine());
            HttpResponse responseBody = httpclient.execute(httpget);
            System.out.println("----------------------------------------");
            System.out.println(EntityUtils.toString(responseBody.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            countDownLatch.countDown();
            System.out.println("countDownLatch.getCount()="+countDownLatch.getCount());
        }
    }
}
