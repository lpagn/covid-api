package ar.edu.itba.infovis.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebMvc
@ComponentScan({"ar.edu.itba.infovis.api.controller","ar.edu.itba.infovis.persistance"})
@Configuration

public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/css/**").addResourceLocations("/static/css/**");
        registry.addResourceHandler("/static/js/**").addResourceLocations("/static/js/**");
        registry.addResourceHandler("/static/media/**").addResourceLocations("/static/media/**");
        //registry.addResourceHandler("/static/js/**").addResourceLocations("/build/static/js");
        registry.addResourceHandler("/index.html").addResourceLocations("/index.html");
        //registry.addResourceHandler("/**.png").addResourceLocations("/build/");
        //registry.addResourceHandler("/**.json").addResourceLocations("/build/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }

    @Bean
    public DataSource dataSource() {
        final SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setDriverClass(org.postgresql.Driver.class);

        //local
        ds.setUrl("jdbc:postgresql://localhost/api_infovis");
        ds.setUsername("luciopagni");
        ds.setPassword("luciopagni");

        //docker
//        ds.setUrl("jdbc:postgresql://192.168.1.114/docker");
//        ds.setUsername("docker");
//        ds.setPassword("docker");

        //db deploy
//		 ds.setUrl("jdbc:postgresql://localhost/paw-2020a-3");
//		 ds.setUsername("paw-2020a-3");
//		 ds.setPassword("hib0ZW2pd");
        return ds;
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource ds) {
        final DataSourceInitializer dsi = new DataSourceInitializer();
        dsi.setDataSource(ds);
        //dsi.setDatabasePopulator(databasePopulator());
        return dsi;
    }

//    @Value("classpath:schema.sql")
//    private Resource schemaSql;

//    private DatabasePopulator databasePopulator() {
//        final ResourceDatabasePopulator dbp = new ResourceDatabasePopulator();
//        dbp.addScript(schemaSql);
//        return dbp;
//    }
}
