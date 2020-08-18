package com.ygjq.sso.config;

import com.bonc.sso.client.SSOFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:CasConfig1
 * Package:com.yuguang.pachong.config
 * Description:TODO
 *
 * @date:2020/8/13 20:18
 * @author:梁鑫
 */
@Configuration
public class CasConfig {

    public static Logger logger= LoggerFactory.getLogger(CasConfig.class);

    @Autowired
    private CasConfigParam casConfigParam;

    private static boolean casEnabled = true;



    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> singleSignOutHttpSessionListener() {
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> listener = new ServletListenerRegistrationBean<SingleSignOutHttpSessionListener>();
        listener.setEnabled(casEnabled);
        listener.setListener(new SingleSignOutHttpSessionListener());
        listener.setOrder(1);
        return listener;
    }

    /**
     * 该过滤器用于实现单点登出功能，单点退出配置，一定要放在其他filter之前
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean singleSignOutFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new SSOFilter());

        filterRegistration.addInitParameter("serverName", casConfigParam.getServerName());
        filterRegistration.addInitParameter("casServerUrlPrefix", casConfigParam.getCasServerUrlPrefix());
        filterRegistration.addInitParameter("casServerLoginUrl", casConfigParam.getCasServerLoginUrl());
        filterRegistration.addInitParameter("singleSignOut", casConfigParam.getSingleSignOut());
        filterRegistration.addInitParameter("skipUrls", casConfigParam.getSkipUrls());
        filterRegistration.addInitParameter("loginUserHandle", casConfigParam.getLoginUserHandle());

        filterRegistration.addInitParameter("encoding;", casConfigParam.getEncoding());
        filterRegistration.addInitParameter("characterEncoding", casConfigParam.getCharacterEncoding());

        filterRegistration.addUrlPatterns("/*");

        filterRegistration.setOrder(3);
        return filterRegistration;
    }

    /**
     * 该过滤器负责用户的认证工作
     *
     * @return
     */
//    @Bean
//    public FilterRegistrationBean authenticationFilter() {
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new AuthenticationFilter());
//        filterRegistration.setEnabled(casEnabled);
//
//        if (null != casConfigParam) {
//
//            if (casConfigParam.getAuthFilters().size() > 0) {
//                filterRegistration.setUrlPatterns(casConfigParam.getAuthFilters());
//            } else {
//                filterRegistration.addUrlPatterns("/*");
//            }
//            if (casConfigParam.getIgnoreFilters() != null) {
//                filterRegistration.addInitParameter("ignorePattern", casConfigParam.getIgnoreFilters());
//            }
//            filterRegistration.addInitParameter("casServerLoginUrl", casConfigParam.getCasServerLoginUrl());
//            filterRegistration.addInitParameter("serverName", casConfigParam.getServerName());
//            filterRegistration.addInitParameter("useSession", casConfigParam.isUseSession() ? "true" : "false");
//            filterRegistration.addInitParameter("redirectAfterValidation", casConfigParam.isRedirectAfterValidation() ? "true" : "false");
//            filterRegistration.setOrder(4);
//            return filterRegistration;
//        }else {
//            logger.error("配置文件cas部分缺失");
//            return null;
//        }
//
//    }

    /**
     * 该过滤器负责对Ticket的校验工作,使用CAS 3.0协议
     *
     * @return
     */
//    @Bean
//    public FilterRegistrationBean cas30ProxyReceivingTicketValidationFilter() {
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new Cas30ProxyReceivingTicketValidationFilter());
//        filterRegistration.setEnabled(casEnabled);
//        if (casConfigParam.getValidateFilters().size() > 0) {
//            filterRegistration.setUrlPatterns(casConfigParam.getValidateFilters());
//        } else {
//            filterRegistration.addUrlPatterns("/*");
//        }
//        filterRegistration.addInitParameter("casServerUrlPrefix", casConfigParam.getCasServerUrlPrefix());
//        filterRegistration.addInitParameter("serverName", casConfigParam.getServerName());
//        filterRegistration.setOrder(5);
//        return filterRegistration;
//    }

//    @Bean
//    public FilterRegistrationBean httpServletRequestWrapperFilter() {
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new HttpServletRequestWrapperFilter());
//        filterRegistration.setEnabled(true);
//        if (casConfigParam.getRequestWrapperFilters().size() > 0) {
//            filterRegistration.setUrlPatterns(casConfigParam.getRequestWrapperFilters());
//        } else {
//            filterRegistration.addUrlPatterns("/*");
//        }
//        filterRegistration.setOrder(6);
//        return filterRegistration;
//    }

    /**
     * 该过滤器使得可以通过org.jasig.cas.client.util.AssertionHolder来获取用户的登录名。
     * 比如AssertionHolder.getAssertion().getPrincipal().getName()。
     * 这个类把Assertion信息放在ThreadLocal变量中，这样应用程序不在web层也能够获取到当前登录信息
     *
     * @return
     */
//    @Bean
//    public FilterRegistrationBean assertionThreadLocalFilter() {
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new AssertionThreadLocalFilter());
//        filterRegistration.setEnabled(true);
//        if (casConfigParam.getAssertionFilters().size() > 0) {
//            filterRegistration.setUrlPatterns(casConfigParam.getAssertionFilters());
//        } else {
//            filterRegistration.addUrlPatterns("/*");
//        }
//        filterRegistration.setOrder(7);
//        return filterRegistration;
//    }
//    @Bean
//    public FilterRegistrationBean FetchCasTicketFilter() {
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new FetchCasTicketFilter());
//        filterRegistration.setEnabled(true);
//        filterRegistration.setOrder(4);
//        return filterRegistration;
//    }
}
