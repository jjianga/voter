package org.jjianga.voter.interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    public static final String SWAGGER_SCAN_VOTER_PACKAGE = "org.jjianga.voter.connector";
    public static final String ADMIN_VERSION = "1.0.0";
    
    /**
     * 插件配置
     */
    @Bean
    public Docket customDocket(){
//        ParameterBuilder ticketPar = new ParameterBuilder();
//        ticketPar.name("Authorization").description("认证token") 
//        	.modelRef(new ModelRef("string")).parameterType("header")
//        	.required(false).build(); 	//header中的ticket参数非必填，传空也可以
//      pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
//        List<Parameter> pars = new ArrayList<Parameter>();
//        .globalOperationParameters(pars)
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("优酷选手打分系统 接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_VOTER_PACKAGE))//api接口包扫描路径
                .apis(predicate)
                .build()
                .apiInfo(apiInfo());
    }
    
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口列表")	//页面标题
                .contact(new Contact("jjianga", "", "120928521@qq.com")) //创建人
                .version("1.0")	//版本号
                .description("org.jjianga.voter.connector 项目接口公示")		//描述
                .build();
    }
    
    Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
        @Override
        public boolean apply(RequestHandler input) {
            if (input.isAnnotatedWith(ApiOperation.class))//只有添加了ApiOperation注解的method才在API中显示
                return true;
            return false;
        }
    };
}