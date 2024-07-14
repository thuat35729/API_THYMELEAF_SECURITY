package com.example.advanced_thymeleaf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;
@Configuration
public class I18NConfig implements WebMvcConfigurer {
    @Bean("messageSource")
    public MessageSource getMessageSource(){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setDefaultEncoding("utf-8");
        ms.setBasenames("classpath:i18n/message", "classpath:i18n/global");
        return ms;
    }
    @Bean("localeResolver")
    public LocaleResolver getLocaleResolver(){
        CookieLocaleResolver cookie = new CookieLocaleResolver();// lưu thay đôi vào cookie để lần sau vào giữ nguyên
        cookie.setDefaultLocale(new Locale("vi"));
        cookie.setCookiePath("/");
        cookie.setCookieMaxAge(10*24*60*60);//10 ngày 24h 60p 60s
        return cookie;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");//chỉ ra tham số làm thay đôi ngôn ngữ
        registry.addInterceptor(lci)
                .addPathPatterns("/**")//chắn tất cả
                .excludePathPatterns("/img/**");//bỏ qua
    }
}
