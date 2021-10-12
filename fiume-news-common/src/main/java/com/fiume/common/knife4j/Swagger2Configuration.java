package com.fiume.common.knife4j;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : Fiume
 * @since : 2021/10/9 18:32
 */
@EnableSwagger2
@Configuration
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger2Configuration {

    public static final String TAG_1 = "channel";
    public static final String TAG_2 = "sensitive";
    public static final String TAG_3 = "AdLogin";


    @Bean("defaultApi2")
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .groupName("1.0")
                .tags(new Tag(TAG_1,"频道管理API"))
                .tags(new Tag(TAG_2,"敏感词管理API"))
                .tags(new Tag(TAG_3,"admin登录管理API"))
                .select()
                //要扫描的API基础包
                .apis(RequestHandlerSelectors.basePackage("com.fiume"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo() {

        return new ApiInfoBuilder()
                .title("fiume资讯-平台管理API文档")
                .description("平台管理服务API")
                .contact(new Contact("fiume", "", "fanfan1003216996@126.com"))
                .version("1.0.0")
                .build();
    }

}
