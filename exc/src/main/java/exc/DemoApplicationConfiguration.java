package exc;

import java.util.List;

import javax.transaction.TransactionManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoApplicationConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class<?>[0];
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class<?>[] {WebAppConfig.class};
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] {"/"};
   }
   
   

   @Configuration
   @EnableWebMvc
   @EnableJpaRepositories
   @ComponentScan("exc")
   public static class WebAppConfig extends WebMvcConfigurerAdapter {

      @Override
      public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
         configurer.enable();
      }

      @Override
      public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
         converters.add(jackson2Converter());
      }

      @Bean
      public MappingJackson2HttpMessageConverter jackson2Converter() {
         MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
         converter.setObjectMapper(new ObjectMapper());
         return converter;
      }
      
      @Bean
      EmbeddedDatabase db() {
         return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
      }
      
      @Bean LocalContainerEntityManagerFactoryBean entityManagerFactory() {
         LocalContainerEntityManagerFactoryBean f = new LocalContainerEntityManagerFactoryBean();
         f.setDataSource(db());
         f.setJpaVendorAdapter(jpaVendorAdapter());
         f.setPackagesToScan("exc");
         return f;
      }
      
      @Bean JpaVendorAdapter jpaVendorAdapter() {
          HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
          hibernateJpaVendorAdapter.setShowSql(false);
          hibernateJpaVendorAdapter.setGenerateDdl(true);
          hibernateJpaVendorAdapter.setDatabase(Database.H2);
          return hibernateJpaVendorAdapter;
      }
      
      @Bean JpaTransactionManager transactionManager() {
         return new JpaTransactionManager(entityManagerFactory().getObject());
      }
   }

}
