package com.test.multidoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertyValues {

    @Autowired private Environment environment;

    @Value("${constant-prop}") private String constantProperty;
    @Value("${override-prop}") private String overrideProperty;
    @Value("${multi-doc-prop}") private String multiDocProperty;

    private static final Logger log = LoggerFactory.getLogger(PropertyValues.class);

    public String getMultiDocProperty() {

        String[] profiles = this.environment.getActiveProfiles();

        log.info("Active environment profile: " + profiles[0]);
        log.info("Value of [constant-prop]: " + constantProperty);
        log.info("Value of [override-prop]: " + overrideProperty);
        log.info("Value of [multi-doc-prop]: " + multiDocProperty);

        return multiDocProperty;
    }
}
