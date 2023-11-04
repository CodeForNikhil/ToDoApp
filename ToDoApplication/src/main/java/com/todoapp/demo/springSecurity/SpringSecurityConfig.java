package com.todoapp.demo.springSecurity;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SpringSecurityConfig {

	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createNewUser("Nikhil", "Dummy");
		UserDetails userDetails2 = createNewUser("NikhilN", "Dummy");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER","ADMIN")
				.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//For H2 database to be enabled, as without this, the h2-console would not work. 
	//require to disable csrf - cross site routing forgery (Spring Security has enabled it for security purpose)
	//frameoptions also needs to be disabled as disables the X-Frame-Options header, which is a security feature that prevents your web pages from being embedded in frames on other websites. Disabling this feature allows your pages to be embedded in iframes, which can be useful for certain use cases.
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity sec) throws Exception {
		sec.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		sec.formLogin(withDefaults());
        sec.csrf(csrf -> csrf.disable());
        sec.headers(headers -> headers.frameOptions().disable());
		
		return sec.build();
	}
}
