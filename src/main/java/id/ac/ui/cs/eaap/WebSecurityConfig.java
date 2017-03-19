package id.ac.ui.cs.eaap;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	DataSource dataSource;
	
	@Override	
	protected void configure(HttpSecurity http) throws Exception
	{					
		http.authorizeRequests()		
		.antMatchers("/login").permitAll()		
		.antMatchers("/js/**", "/css/**", "/img/**", "/fonts/**").permitAll()
		.antMatchers("/sekre/**").hasAuthority("sekre")
		.antMatchers("/student/**").hasAuthority("student")
		.anyRequest().authenticated().and()				
		.formLogin().defaultSuccessUrl("/", true).loginPage("/login").permitAll().and()
		.logout().permitAll().logoutSuccessUrl("/login?logout").and()
		.exceptionHandling().accessDeniedPage("/403").and()
		.csrf().disable();
	}
	
	@Autowired
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username, password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}
}
