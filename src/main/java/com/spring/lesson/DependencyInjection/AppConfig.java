package com.spring.lesson.DependencyInjection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Application Config
 */

@Configuration
@ComponentScan(basePackages = {"com.spring.lesson.DependencyInjection"})
public class AppConfig {
}