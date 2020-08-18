package com.ygjq.sso.utils;

import com.ygjq.sso.config.ParamConfig;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @ClassName:Login
 * @Description:TODO
 * @author: wuhaibo
 * @date:2020/8/17 15:40
 */
@Component
public class LoginUtil {
   @Resource
   private ParamConfig paramConfig;
   public   CloseableHttpClient loadLoginUserClient() throws IOException {

      BasicCookieStore cookieStore = new BasicCookieStore();
      // 全局用这一个httpClient对象模拟真实的一个浏览器中操作
      CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
      CloseableHttpResponse respLogin = null;
      try {
         // 模拟用户登录
         // 指向一个没有验证码的登录页面
         HttpPost httpLogin = new HttpPost(paramConfig.getWebUrl());
         List<NameValuePair> naps = new ArrayList<>();
         // 用户名对应的key
         naps.add(new BasicNameValuePair("username", paramConfig.getLoginName()));
         // 密码对应的key
         naps.add(new BasicNameValuePair("password", paramConfig.getPassword()));
         naps.add(new BasicNameValuePair("lt", "LT-85-jNid2kWFB57w0vvUDhFWddzYyJuKXc"));
         naps.add(new BasicNameValuePair("execution", "e1s1"));
         naps.add(new BasicNameValuePair("_eventId", "submit"));
         httpLogin.setEntity(new UrlEncodedFormEntity(naps));
         respLogin = httpClient.execute(httpLogin);
         HttpEntity entity = respLogin.getEntity();
         EntityUtils.consume(entity);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (respLogin != null) {
            respLogin.close();
         }
      }
      return httpClient;
   }

}
