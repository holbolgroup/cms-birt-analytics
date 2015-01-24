package com.javahonk.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.javahonk.core.BirtEngineFactory;
import com.javahonk.core.BirtView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.javahonk.controller", "com.javahonk.model"})
public class DispatcherServletConfiguration extends WebMvcConfigurerAdapter{
	
	
	@Bean 
	public BirtView birtView(){ 
		BirtView bv = new BirtView();
		System.out.println("Inside birt view !!!");
		//bv.setReportFormatRequestParameter("ReportFormat");
		//bv.setReportNameRequestParameter("ReportName");
		bv.setBirtEngine( this.engine().getObject() );
		return bv; 
	}
	
	@Bean public BeanNameViewResolver beanNameResolver(){ 
		BeanNameViewResolver br = new BeanNameViewResolver();
		br.setOrder(1);
		return br; 
	}
	
	@Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(2);
        return viewResolver;
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

	@Bean
	protected BirtEngineFactory engine(){ 
		BirtEngineFactory factory = new BirtEngineFactory() ;  
		//factory.setLogLevel( Level.FINEST);
		//factory.setLogDirectory ( new File ("c:/logs"));
		//factory.setLogDirectory( new FileSystemResource("/logs"));

		return factory ; 
	}

}
