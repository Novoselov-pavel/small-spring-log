package com.npn.learning.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.npn.learning.spring")
@EnableAspectJAutoProxy
public class SpringConfig {

}
