package com.xingji.frameproject.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;
@Slf4j
@Configuration
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})//排除默认配置
public class MultipartConfig{

    /**
        * 文件上传配置
        * @return
        */
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() throws IOException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true); //resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setMaxInMemorySize(100);
        resolver.setMaxUploadSize(1024* 1024 * 30);//上传文件大小 30M 30*1024*1024
        resolver.setUploadTempDir(new ClassPathResource("/static/temp"));//上传文件临时地址，要手动创建，否则启动时因为 target 包下没有启动报错
        log.debug("文件上传设置完成.......");
        return resolver;
    }
}
