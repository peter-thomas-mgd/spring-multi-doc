# spring-multi-doc
Expected behavior is that a multi-document properties file can be created with different sections separated by "#--- " characters,
for each section applicable to a given active profile. This works as expected when using a file named application.properties and allowing
Spring Boot to bootstrap the application normally.

However, if the default application properties file is overridden in a JUnit test class annotated with a test property source
(e.g. @TestPropertySource(locations="classpath:test.properties")), Spring Boot ignores the active profiles and simply references
the last value it finds for the property in the properties file.

This project demonstates the problem.
