package ir.maktab.config;
import ir.maktab.service.ManagerDetailsServiceImpl;
import ir.maktab.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsServiceImpl userDetailsService;
    private final ManagerDetailsServiceImpl managerDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService, ManagerDetailsServiceImpl managerDetailsService) {
        this.userDetailsService = userDetailsService;
        this.managerDetailsService = managerDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser() yourself define
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

        auth.userDetailsService(managerDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/",
                        "/api/mail/send" ,
                        "/error" ,
                        "/user/filter",
                        "/user/register",
                        "/user/confirm-account",
                        "/management/login",
                        "/customer/login",
                        "/expert/login",
                        "/customer/register",
                        "/expert/register",
                        "/order/record",
                        "/email/**",
                        "/superService/record",
                        "/subService/record",
                        "/expert/chooseService",
                        "/subService/addExpert",
                        "/offer/addOffersToOrder",
                        "/expert/addOffer",
                        "/expert/changePass",
                        "/customer/changePass",
                        "/expert/showComment",
                        "/customerList/",
                        "/management/managerPage",
                        "/comment/record",
                        "/resources/**").permitAll()
                .antMatchers("/filter")
                .hasRole("MANAGER") // for access
                .antMatchers("/record")
                .hasAnyRole("MANAGER","CUSTOMER","EXPERT")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("emailAddress")
                .passwordParameter("password")
               // .failureForwardUrl("/failLogin")
                 .loginProcessingUrl("/login")
                 .successForwardUrl("/login")
                 .and()
                .logout()
                .logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
}
