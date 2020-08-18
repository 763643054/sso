package com.ygjq.sso.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;

/**
 * ClassName:CasConfig
 * Package:com.yuguang.pachong.config
 * Description:TODO
 * 单点登录客户端配置
 * @date:2020/8/13 15:00
 * @author:梁鑫
 */
@Component
@ConfigurationProperties(prefix ="cas")
public class CasConfigParam {
    private String name;
   // static final String separator = ",";
    private String encoding;
    private String characterEncoding;
    private String loginUserHandle;
    private String singleSignOut;
    private String order;

    private String skipUrls; //需要放行的url,多个可以使用|分隔，遵循正则

    private String casServerUrlPrefix;
    private String casServerLoginUrl;
    private String serverName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getCharacterEncoding() {
        return characterEncoding;
    }

    public void setCharacterEncoding(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    public String getLoginUserHandle() {
        return loginUserHandle;
    }

    public void setLoginUserHandle(String loginUserHandle) {
        this.loginUserHandle = loginUserHandle;
    }

    public String getSingleSignOut() {
        return singleSignOut;
    }

    public void setSingleSignOut(String singleSignOut) {
        this.singleSignOut = singleSignOut;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSkipUrls() {
        return skipUrls;
    }

    public void setSkipUrls(String skipUrls) {
        this.skipUrls = skipUrls;
    }

    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }

    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }

    public String getCasServerLoginUrl() {
        return casServerLoginUrl;
    }

    public void setCasServerLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
//    public String getIgnoreFilters() {
//        return skipUrls;
//    }
//    public void setIgnoreFilters(String ignoreFilters) {
//        this.skipUrls = skipUrls;
//    }
//    public List<String> getValidateFilters() {
//        return Arrays.asList(validateFilters.split(separator));
//    }
//    public void setValidateFilters(String validateFilters) {
//        this.validateFilters = validateFilters;
//    }
//    public List<String> getSignOutFilters() {
//        return Arrays.asList(signOutFilters.split(separator));
//    }
//    public void setSignOutFilters(String signOutFilters) {
//        this.signOutFilters = signOutFilters;
//    }
//    public List<String> getAuthFilters() {
//        return Arrays.asList(authFilters.split(separator));
//    }
//    public void setAuthFilters(String authFilters) {
//        this.authFilters = authFilters;
//    }
//    public List<String> getAssertionFilters() {
//        return Arrays.asList(assertionFilters.split(separator));
//    }
//    public void setAssertionFilters(String assertionFilters) {
//        this.assertionFilters = assertionFilters;
//    }
//    public List<String> getRequestWrapperFilters() {
//        return Arrays.asList(requestWrapperFilters.split(separator));
//    }
//    public void setRequestWrapperFilters(String requestWrapperFilters) {
//        this.requestWrapperFilters = requestWrapperFilters;
//    }
//    public String getCasServerUrlPrefix() {
//        return casServerUrlPrefix;
//    }
//    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
//        this.casServerUrlPrefix = casServerUrlPrefix;
//    }
//    public String getCasServerLoginUrl() {
//        return casServerLoginUrl;
//    }
//    public void setCasServerLoginUrl(String casServerLoginUrl) {
//        this.casServerLoginUrl = casServerLoginUrl;
//    }
//    public String getServerName() {
//        return serverName;
//    }
//    public void setServerName(String serverName) {
//        this.serverName = serverName;
//    }
//    public boolean isRedirectAfterValidation() {
//        return redirectAfterValidation;
//    }
//    public void setRedirectAfterValidation(boolean redirectAfterValidation) {
//        this.redirectAfterValidation = redirectAfterValidation;
//    }
//    public boolean isUseSession() {
//        return useSession;
//    }
//    public void setUseSession(boolean useSession) {
//        this.useSession = useSession;
//    }
//    public String getSingleSignOut() {
//        return singleSignOut;
//    }
//
//    public void setSingleSignOut(String singleSignOut) {
//        this.singleSignOut = singleSignOut;
//    }


}
