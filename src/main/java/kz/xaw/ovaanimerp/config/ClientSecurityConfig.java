package kz.xaw.ovaanimerp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

@Configuration
@Order(2)
public class ClientSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/registration/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .permitAll()
                .defaultSuccessUrl("/homepage.html", true)
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .rememberMe() //default to 2 weeks
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)) //21days
                .key("somethinglookslikekey")
                .rememberMeParameter("remember-me")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) //if csrf enable -> POST
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/login");
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                // allow anonymous resource requests
                .antMatchers(
                        "/favicon.ico",
                        "/**/*.css",
                        "/**/*.js"
                );
    }
}
