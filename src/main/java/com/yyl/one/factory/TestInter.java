package com.yyl.one.factory;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author yangyuanliang
 * @version 1.9
 * @date 2025/2/2 19:10
 */
public class TestInter implements ImportBeanDefinitionRegistrar, ImportSelector {
	BeanDefinition beanDefinition;

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		registry.registerBeanDefinition("test",  beanDefinition);
	}

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[0];
	}
}
