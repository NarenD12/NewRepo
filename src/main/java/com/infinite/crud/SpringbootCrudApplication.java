package com.infinite.crud;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCrudApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		final String chrs = "0123456789ABCDEFTUVWXYZ";

		final SecureRandom secureRandom = SecureRandom.getInstanceStrong();

		final String customTag = secureRandom
		    .ints(9, 0, chrs.length()) // 9 is the length of the string you want
		    .mapToObj(i -> chrs.charAt(i))
		    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
		    .toString();

		System.out.println(customTag);
		SpringApplication.run(SpringbootCrudApplication.class, args);
	}
}
