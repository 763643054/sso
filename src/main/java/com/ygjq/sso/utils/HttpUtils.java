package com.ygjq.sso.utils;



import org.springframework.util.StreamUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @ClassName: HttpUtils
 * @Description: TODO
 * @Author: liujianfu
 * @Date: 2020/08/16 10:44:19
 * @Version: V1.0
 **/
public class HttpUtils {
    public static String sendHttpRequest(String httpUrl, Map<String,String> params) throws Exception{
        //1. 请求地址 https://way.jd.com/jisuapi/query4
        URL url = new URL(httpUrl);
        //2. 开启连接 Http
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //3. 设置请求的方式
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        connection.setDoOutput(true);
        //4. 设置请求携带的参数进行发送！
        if (params!=null && params.size()>0){
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append("&")
                        .append(entry.getKey())
                        .append("=")
                        .append(entry.getValue());
            }
            // 去除第一个 & 的符号
            connection.getOutputStream().write(sb.substring(1).getBytes("UTF-8"));

        }
        //6.发送请求
        connection.connect();
        //7. 接受响应
        String response = StreamUtils.copyToString(connection.getInputStream(), Charset.forName("UTF-8"));
        return  response;
    }
}
