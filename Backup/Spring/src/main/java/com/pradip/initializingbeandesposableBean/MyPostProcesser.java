package com.pradip.initializingbeandesposableBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyPostProcesser implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("\n\nThis is postProcessAfterInitialization"+arg0+" "+arg1+"\n\n");
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("\n\nThis is postProcessAfterInitialization"+arg0+" "+arg1+"\n\n");
		return arg0;
	}

}
