package com.test.multidoc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
@TestPropertySource(locations="classpath:test.properties")
public class UnexpectedPropertyValuesTest {

	@Autowired private Environment environment;
	@Autowired PropertyValues propertyValues;

	@Test
	public void shouldLoadTestProfile() {

		String[] profiles = this.environment.getActiveProfiles();
		assertThat(profiles[0]).isEqualTo("default");

		String multiDocProperty = propertyValues.getMultiDocProperty();

		// this the value we would expect if the feature was working as expected
		assertThat(multiDocProperty).isNotEqualTo("default multi-doc value");

		// instead, the property value is overridden by the value in the "test" section of the test.properties file even
		// though the active profile is set to "default"
		assertThat(multiDocProperty).isEqualTo("multi-doc value from test doc section");
	}
}
