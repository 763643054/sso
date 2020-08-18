package com.ygjq.sso.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @ClassName:ParamConfig
 * @Description:TODO
 * @author: wuhaibo
 * @date:2020/8/17 15:48
 */
@Component
public class ParamConfig {
    @Value("${sso.loginName}")
    private String loginName;
    @Value("${sso.password}")
    private String password;
    @Value("${sso.webUrl}")
    private String webUrl;

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
