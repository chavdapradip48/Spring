package com.pradip.springcloud;

import java.util.function.Function;

public class ToLowerCase implements Function<String , String>{

	@Override
	public String apply(String t) {
		return new StringBuffer(t).toString().toLowerCase();
	}

}
