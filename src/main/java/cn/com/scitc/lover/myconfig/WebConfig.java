package cn.com.scitc.lover.myconfig;

import cn.com.scitc.lover.common.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //移除用户
    public  final static String SESSION_KEY = "loginUser";
    public  final static  String MSG = "msg";
    public  final static  String SESSION_KEY1 = "loginAdmin";
    public final static String SESSION_KEY2 = "stutas";
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//    避免cookie经过多次重定向，建议分开写排除不适用数据形式
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/mine")
               .addPathPatterns("/user/mycomment")
                .addPathPatterns("/user/mylike")
                .addPathPatterns("/user/comment");
    }
//    配置静态支援
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/music/**")
                .addResourceLocations("file:/Users/mac/Desktop/music/");
    }
}
