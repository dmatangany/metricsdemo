package com.ayo.demo.aop;

import com.ayo.demo.model.Weight;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ConversionAspect {

	@Before(value="execution(* com.ayo.demo.controller.CustomerController.*(..))")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("Before running advice on method="+joinPoint.toString());
		System.out.println("Arguments Passed: " + Arrays.toString(joinPoint.getArgs()));
	}
}
