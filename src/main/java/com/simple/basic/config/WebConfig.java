//package com.simple.basic.config;
//
//
//
//import javax.sql.DataSource;
//
//import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.simple.basic.controller.TestController;
//
//@Configuration
////@PropertySource("classpath:/application.properties")//해당파일참저
//public class WebConfig implements WebMvcConfigurer {
//	//IOC팩토리
//	@Autowired
//	private ApplicationContext applicationContext;
//	
//	//application.properties 값을 직접 참조
//	@Value("${spring.datasource.url}")
//	private String url;
//	@Value("${server.port}")
//	private String port;
//	
//	@Bean
//	public void test(){
//		System.out.println("테스트빈 생성!");
//		System.out.println("application프로펄티 안에 값:" + url);
//		System.err.println(" 포트값:" + port);
//		//IOC컨테이너 안에 객체수
//		int count =applicationContext.getBeanDefinitionCount();
//		System.out.println("IOC컨테이너 안에 객체수:" + count);
//		//컨트롤러 빈
//		TestController t=applicationContext.getBean(TestController.class);
//		System.out.println("IOC컨테이너 안에 생성된 컨트롤러:" + t);
//	
//	//내부적으로 만들어진 db커넥션
//	DataSource ds =applicationContext.getBean(DataSource.class);
//	try {
//		System.out.println(ds.getConnection());
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	}
//}
