package com.test.multidoc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
public class ExpectedPropertyValuesTest {

	@Autowired private Environment environment;
	@Autowired PropertyValues propertyValues;

	@Test
	public void shouldLoadTestProfile() {

		String[] profiles = this.environment.getActiveProfiles();
		assertThat(profiles[0]).isEqualTo("default");

		// this is what we expect if the feature is working correctly
		assertThat(propertyValues.getMultiDocProperty()).isEqualTo("default multi-doc value");
	}
}
