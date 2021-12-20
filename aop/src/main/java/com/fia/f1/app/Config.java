package com.fia.f1.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.fia.f1")
@EnableAspectJAutoProxy
public class Config {
}
