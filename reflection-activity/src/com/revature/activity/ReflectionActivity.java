package com.revature.activity;

import com.revature.exercise.Blue;
import com.revature.exercise.Red;
import com.revature.exercise.SecretClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ReflectionActivity {

	/*
	 * Find all of the following: 1. What fields does the secret class have? 2. What
	 * methods does the secret class have? 3. What are the modifiers on the fields
	 * and the methods? 4. What happens when you call each of the methods? 5. What
	 * are the values of the fields? 6. What annotations are used in the
	 * secretclass? 7. What fields do the annotations have? 8. Which fields in the
	 * secret class use the annotations? 9. What are the values of those
	 * annotations' fields on each class field? 10. What annotation(s) does the
	 * class itself have, and what are the values of the field(s) on them?
	 */

	static SecretClass secret = new SecretClass();
	static Class secretObj = secret.getClass();
	static Field[] fields = secretObj.getDeclaredFields();

	static Class<SecretClass> secretClass = SecretClass.class;
	static Class<Red> redClass = Red.class;
	static Class<Blue> blueClass = Blue.class;
	static Class superClass = secretObj.getSuperclass();
	static int modifier = secretObj.getModifiers();
	static String mod = Modifier.toString(modifier), name = secretObj.getName();
	static Annotation[] testAnno = secretClass.getAnnotations();
	static Method[] classMethods = secretObj.getDeclaredMethods();

	public static void main(String[] args) throws Exception {

		/**
		 * 
		 */

		System.out.println("\n-- Refelections Activity\n");

		System.out.println("Name: " + name);

		System.out.println("Modifier: " + mod);

		System.out.println("Superclass: " + superClass.getName());

		/**
		 * 
		 */

		System.out.println("\n-- Fields and Annotations");

		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println("[" + field.getName().toUpperCase() + "] = " + field.get(secret));
		}

		for (Field field : fields) {
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println("anno: " + annotation.annotationType().getSimpleName());
			}
		}

		for (Annotation annos : testAnno) {
			System.out.println(annos.toString());
		}

		System.out.println("\n[RED CLASS]");
		Method[] redMethods = redClass.getMethods();

		for (Method mR : redMethods) {

			if (mR.getDefaultValue() != null) {
				System.out.println(mR.getName() + ": " + mR.getDefaultValue());
			}
		}

		System.out.println("\n[BLUE CLASS]");
		Method[] blueMethods = blueClass.getMethods();

		for (Method bR : blueMethods) {
			if (bR.getDefaultValue() != null) {
				System.out.println(bR.getName() + ": " + bR.getDefaultValue());
			}
		}

		/*
		 * 
		 */

		System.out.println("\n-- Secret Class Methods\n");


		for (Method method : classMethods) {
			System.out.println("[METHOD] = " + method.getName() + "()");
			if (method.getParameterCount() > 0) {
				System.out.println("# of Params: " + method.getParameterCount());
			}
			if (method.getName().equals("getMessage")) {
				System.out.println("   Output: " + secret.getMessage() + "\n");
			}
			if (method.getName().equals("getStaticMessage")) {
				System.out.println("   Output: " + secret.getStaticMessage() + "\n");
			}
		}

	}

	/*
	 * Example using the class and annotation below:
	 * 
	 * 1. the fields are name and number 2. the method is getName 3. name is public,
	 * number is public/static, getName() is public
	 * 
	 * 4. the method returns the value of the name field
	 * 
	 * 5. the value of name is "Ash", the value of number is 30
	 * 
	 * 6. the annotation is Hello
	 * 
	 * 7. the Hello annotation has a "value" field 8. the number field uses the
	 * Hello annotation 9. the "value" field of Hello is "num" on the number field
	 * 10. the class has the Hello field and its value is the default, "world"
	 * 
	 * @Hello public class Example { private String name = "Ash";
	 * 
	 * @Hello(value="num") private static int number = 30; public String getName() {
	 * return this.name; } }
	 * 
	 * @interface Hello { String value() default "world"; }
	 */
}
