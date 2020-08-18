package com.ygjq.sso.controller;

import com.alibaba.fastjson.JSONObject;
import com.ygjq.sso.utils.HttpUtils;
import com.ygjq.sso.utils.LoginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

/**
 * @version V1.0
 * @ClassName:TestController
 * @Description:TODO
 * @author: wuhaibo
 * @date:2020/8/17 11:14
 */
@Controller
@RequestMapping("/api")
public class TestController {
    @Resource
    private LoginUtil login;

 private static  final Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping("/helloWord")
    public String helloWord() throws IOException {
        return "hello";
    }

    @RequestMapping("/index")
    public String index() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password,
                        HttpServletRequest request, HttpSession session, HttpServletResponse response, Model model) throws Exception {
        System.out.println(username + "," + password);

        String path = request.getRequestURL().toString();
        System.out.println("path:" + path);
        //登录成功
        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("username", "wuhaibo");
        map2.put("password", "liangxin03191996");
        String responseContent = HttpUtils.sendHttpRequest("http://131.107.26.10:8080//cas/v2/tickets", map2);
        System.out.println(responseContent);

        JSONObject jsonObject = JSONObject.parseObject(responseContent);
        System.out.println(jsonObject);
        if (jsonObject.getString("status").equals("true")) {
            String TGT = jsonObject.getString("TGT");
            Cookie cookie = new Cookie("CASTGC", TGT);
            cookie.setPath("/");
            response.addCookie(cookie);
            model.addAttribute("TGT", TGT);
            //model.addAttribute("responseUrl", "http://131.107.26.11:8888/sso/api/helloWord");
            model.addAttribute("responseUrl", "http://192.168.110.195:8888/sso/api/helloWord");
            //  ?token = xxxxx
         //String redirectUrl ="http://192.168.110.165:8099/CasTempServer/test/test1?ticket="+TGT+"&"+"responseUrl="+"http://192.168.110.195:8888/sso/api/helloWord";
          String redirectUrl = "http://131.107.26.10:8099/CasTempServer/test/test1?ticket=" + TGT + "&" + "responseUrl=" + "http://192.168.110.195:8888/sso/api/helloWord";
            return "redirect:" + redirectUrl;
        } else {
            System.out.println("用户名或密码错误！");
            //return  "登录ok!!";
            return "login";
        }

    }
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request, HttpSession session, HttpServletResponse response, Model model) throws Exception {
      session.invalidate();
        HashMap<String, String> map2 = new HashMap<String, String>();
        //String redirectUrl = "http://131.107.26.11:8888/sso/api/index" ;
        String redirectUrl = "http://192.168.110.195:8888/sso/api/index" ;
       String responseContent = HttpUtils.sendHttpRequest("http://131.107.26.10:8080/cas/logout?service="+redirectUrl, map2);
        logger.info("-------------------------"+responseContent);
        return "redirect:" + redirectUrl;
    }
    @RequestMapping("/orderManager")
    private String orderManager(){
        return "order";
    }
    @RequestMapping("/menuManager")
    private String menuManager(){
        return "menu";
    }
    @RequestMapping("/productManager")
    private String productManager(){
        return "product";
    }
}
