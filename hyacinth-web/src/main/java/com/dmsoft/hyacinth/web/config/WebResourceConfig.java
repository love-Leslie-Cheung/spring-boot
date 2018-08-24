/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Can.Guan on 2017/11/14.
 */
@Configuration
public class WebResourceConfig extends WebMvcConfigurerAdapter {

//    @Value("${app.path.root}")
//    private String rootDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/css/**", "/views/static/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/static/fonts/**", "/views/static/fonts/**")
                .addResourceLocations("classpath:/static/fonts/");
        registry.addResourceHandler("/static/webfonts/**")
                .addResourceLocations("classpath:/static/webfonts/");
        registry.addResourceHandler("/static/js/**", "/views/static/js/**")
                .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/static/images/**", "/views/static/images/**")
                .addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("/static/png/**", "/views/static/png/**")
                .addResourceLocations("classpath:/static/png/");
        registry.addResourceHandler("/static/upload/commodity/**")
                .addResourceLocations("classpath:/static/upload/commodity/");
        registry.addResourceHandler("/static/upload/default/**")
                .addResourceLocations("classpath:/static/upload/default/");
        registry.addResourceHandler("/static/upload/box/**")
                .addResourceLocations("classpath:/static/upload/box/");
        registry.addResourceHandler("/fragment/**")
                .addResourceLocations("classpath:/templates/fragment/");

//        String commodityPicUploadPath = rootDir + AppConstant.UPLOAD_PIC_COMMODITY;
//        if (commodityPicUploadPath != null) {
//            commodityPicUploadPath.replace("：", ":");
//            String filePath = (commodityPicUploadPath.contains(":") ? commodityPicUploadPath.split(":")[1] : commodityPicUploadPath);
//            registry.addResourceHandler(filePath + "/**")
//                    .addResourceLocations("file:///" + commodityPicUploadPath + "/");
//        }
    }
}
