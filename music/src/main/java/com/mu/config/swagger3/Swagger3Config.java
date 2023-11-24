package com.mu.config.swagger3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ConditionalOnProperty(value = "springfox.documentation.enabled", havingValue = "true", matchIfMissing = true)
public class Swagger3Config {

    /**
     * 是否开启swagger，生产环境一般关闭，所以这里成变量
     */
    @Value("${swagger.enable}")
    private Boolean enable;
    /**
     * 项目应用名
     */
    @Value("${swagger.application-name}")
    private String applicationName;
    /**
     * 项目版本信息
     */
    @Value("${swagger.application-version}")
    private String applicationVersion;
    /**
     * 项目描述信息
     */
    @Value("${swagger.application-description}")
    private String applicationDescription;

    /**
     * 配置了Swagger的Docket的bean实例：Swagger3 需要配置成 DocumentationType.OAS_30
     * enable()：是否启动Swagger，如果为False，则Swagger不能在浏览器中访问
     * apiInfo()：配置api文档元信息
     * select()：选择哪些接口作为swagger的doc发布，一般和apis()一起使用
     * apis(RequestHandlerSelectors.XXX)：配置要扫描的方式
     * RequestHandlerSelectors.basePackage()：指定要扫描的包
     * RequestHandlerSelectors.any()：扫描全部
     * RequestHandlerSelectors.none()：不扫描
     * RequestHandlerSelectors.withClassAnnotation()：扫描类上的注解，参数是注解的反射对象
     * RequestHandlerSelectors.withMethodAnnotation()：扫描方法上的注解，参数是注解的反射对象
     * 例如：RequestHandlerSelectors.withClassAnnotation(ApiOperation.class)
     * paths()：过滤什么路径，一般跟在select()之后，根据请求路径定义当前Docket需要包含控制器的哪些方法。
     * PathSelectors.none()：不扫描
     * PathSelectors.any()：扫描所有请求路径
     * PathSelectors.ant("/*")：匹配Ant样式的路径模式
     * PathSelectors.regex("/cat/.*")：匹配正则指定的正则表达式路径
     * pathMapping()：默认请求都是以 / 根路径开始.如果我们的应用不是部署在根路径，
     * 比如以/platform 部署，则可以通过一下方式设置请求的统一前缀。最终调用接口后会和paths拼接在一起.
     * 如接口为：/v1/api/list，那么swagger-ui页面则显示/platform/v1/api/list
     * <p>
     * build：工厂模式
     * 注意：Docket.select().xxx.build()必须一起使用
     * select() 返回的是一个ApiSelectorBuilder对象，而我们需要的却是Docket对象，
     * 因此，ApiSelectorBuilder类中提供了一个方法 --> build() 方法返回的是一个Docket对象。
     */
    @Bean
    public Docket docketA() {
        return new Docket(DocumentationType.OAS_30)
                .enable(enable)
                .groupName("A")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }

    @Bean
    public Docket docketB() {
        return new Docket(DocumentationType.OAS_30)
                .enable(enable)
                .groupName("B")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }

    /**
     * ApiInfo：主要返回接口和接口创建者的信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(applicationName)
                .description(applicationDescription)
                .contact(new Contact("Dream丶小强", "http://www.baidu.com", "984129236@qq.com"))
                .version(applicationVersion)
                .build();
    }

    /*@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }*/
}
