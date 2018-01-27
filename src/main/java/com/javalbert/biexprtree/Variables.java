/*
   Copyright 2018 Albert Shun-Dat Chan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package com.javalbert.biexprtree;

import java.util.Objects;
import java.util.regex.Pattern;

final class Variables {
	private static final Pattern INVALID_NAME = Pattern.compile("[^a-zA-Z0-9_$]|^[0-9]");

	static String validateName(String name) {
		Objects.requireNonNull(name, "name must not be null");
		
		if ("".equals(name) || INVALID_NAME.matcher(name).find()) {
			throw new IllegalArgumentException(
					"Variable names must contain only alphanumeric, underscore, or dollar sign"
					+ " characters, and must not start with a number"
					);
		}
		return name;
	}
	
	private Variables() {}
}
