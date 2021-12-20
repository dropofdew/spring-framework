package com.pole2win.spi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CustomAutoConfigurationRegistrar.class)
public class CustomAutoConfiguration {
}
