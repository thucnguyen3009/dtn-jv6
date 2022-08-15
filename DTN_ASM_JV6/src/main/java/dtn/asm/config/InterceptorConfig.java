package dtn.asm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dtn.asm.interceptor.BlockLogin;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	BlockLogin blockLogin;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(blockLogin).addPathPatterns("/login.html","/register.html").excludePathPatterns("");
	}

}
