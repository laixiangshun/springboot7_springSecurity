package com.lai.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by lailai on 2017/9/21.
 * Spring Security配置类
 */
@Configuration
@EnableWebSecurity //开启Spring Security的功能
public class webSecurityConfig extends WebSecurityConfigurerAdapter
{
    /**
     * 通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。
     * 例如以上代码指定了/和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证
     * 通过formLogin()定义当需要用户登录时候，转到的登录页面
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index","/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    /**
     * configureGlobal(AuthenticationManagerBuilder auth)方法，
     * 在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("pwd").roles("USER");
    }
}
