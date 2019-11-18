package com.tingyu.study.springboot.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 1、开启网站安全功能，
 * 2、@EnableWebSecurity该注解被@Configuration标注，因此该配置类不需要再标注@Configuration
 * 
 * @author Essionshy
 *
 */
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	/**
	 * HttpSecurity http 配置请求映射访问权限 permitAll()
	 * 
	 */
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").permitAll() // 服务器根目录允许所有角色访问
				.antMatchers("/level1/**").hasRole("VIP1")
				.antMatchers("/level2/**").hasRole("VIP2")
				.antMatchers("/level3/**").hasRole("VIP3");
		// 开启自动配置的登录功能
		http.formLogin();
		// 设置自定义登录页面http.formLogin().loginPage("/userLogin");
		// post提交http.formLogin().loginProcessingUrl("/userLogin");
		// 开启自动配置的注销功能，默认跳转到登录页面
		http.logout().logoutSuccessUrl("/");
		// http.logout().logoutSuccessUrl("/home");自定义注销后跳转页面路径

	}
	/**
	 * 定义认证规则 ，模拟用户信息保存在内存中
	 * AuthenticationManagerBuilder
	 */
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
								.withUser("z3").password("123456").roles("VIP1","VIP2")
								.and()
								.withUser("li4").password("777777").roles("VIP1","VIP3")
								.and()
								.withUser("wang5").password("777777").roles("VIP2","VIP3");
	}

	
}
