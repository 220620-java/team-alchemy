package com.revature.activity;

import com.revature.exercise.SecretClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ReflectionActivity {

	/*
	 * Find all of the following: 
	 * 1. What fields does the secret class have? 
	 * 2. What methods does the secret class have? 
	 * 3. What are the modifiers on the fields and the methods? 
	 * 4. What happens when you call each of the methods? 
	 * 5. What are the values of the fields? 
	 * 6. What annotations are used in the secretclass? 
	 * 7. What fields do the annotations have? 
	 * 8. Which fields in the secret class use the annotations? 
	 * 9. What are the values of those annotations' fields on each class field? 
	 * 10. What annotation(s) does the class itself have, and what are the values of the field(s) on them?
	 */
	
	
	public static void main(String[] args) {
		
		Class<SecretClass> secret = SecretClass.class;
		
		String className = secret.getName();
		
		System.out.println(className + "\n");
		
		//Annotation[] annotations = secret.getAnnotations();
		
		
		int classModifiers = secret.getModifiers();
		
		System.out.println("isPublic: " + Modifier.isPublic(classModifiers) + "\n");
		
		Method[] classMethods = secret.getMethods();
		
		for(Method method : classMethods) {
			System.out.println("------------------");
			System.out.println("method name: " + method.getName() + "\n");
			System.out.println("return type: " + method.getReturnType());
			System.out.println("param count: " + method.getParameterCount());
			System.out.println();
			
			if(method.getParameterCount() > 0) {
				
				Class[] parameterType = method.getParameterTypes();
				
				for(Class parameter : parameterType) {
					
					System.out.println(parameter.getName());
					
				}
				System.out.println();

			}
		}
		 SecretClass secret2 = new SecretClass();
		 
		 System.out.println(secret2.getMessage() + "\n" + secret2.getStaticMessage() + "\n\n");
		

		// Hacker Man:
		// https://i.ytimg.com/vi/GUlWIxrZp9M/maxresdefault.jpg
		
		// Rick roll:
		// https://www.youtube.com/watch?v=agnblS47F18
	}

	
	
	/*
	 * Example using the class and annotation below:
	 * 
	 * 1. the fields are name and number 
	 * 2. the method is getName 3. name is public,
	 * number is public/static, getName() is public 
	 * 
	 * 4. the method returns the value
	 * of the name field 5. the value of name is "Ash", the value of number is 30 6.
	 * the annotation is Hello 7. the Hello annotation has a "value" field 8. the
	 * number field uses the Hello annotation 9. the "value" field of Hello is "num"
	 * on the number field 10. the class has the Hello field and its value is the
	 * default, "world"
	 * 
	 * @Hello public class Example { private String name = "Ash";
	 * 
	 * @Hello(value="num") private static int number = 30; public String getName() {
	 * return this.name; } }
	 * 
	 * @interface Hello { String value() default "world"; }
	 */
}
