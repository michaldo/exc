package exc;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExcApp extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Configuration
	@EnableWebMvc
	@ComponentScan("exc")
	public static class WebAppConfig extends WebMvcConfigurerAdapter {

		@Override
		public void configureDefaultServletHandling(
				DefaultServletHandlerConfigurer configurer) {
			configurer.enable();
		}
		
		
		
		@Override
		public void configureMessageConverters(
				List<HttpMessageConverter<?>> converters) {
			// TODO Auto-generated method stub
			//super.configureMessageConverters(converters);
			converters.add(jackson2Converter());
		}



		@Bean
	    public MappingJackson2HttpMessageConverter jackson2Converter() {
	        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	        converter.setObjectMapper(new ObjectMapper());
	        return converter;
	    }
	}

}
