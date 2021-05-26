package eci.edu.arsw.ecihorarios.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FilterRegistrationConfiguration {

    @Bean
    public FilterRegistrationBean jwtFilter()
    {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter() );
        registrationBean.addUrlPatterns( "/api/*" );
        System.out.println("\n "+registrationBean+" \n");

        return registrationBean;
    }

}