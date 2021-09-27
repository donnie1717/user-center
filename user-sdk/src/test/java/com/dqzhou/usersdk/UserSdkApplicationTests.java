package com.dqzhou.usersdk;

import com.dqzhou.usersdk.config.CommonProperties;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserSdkApplicationTests {

    private Logger logger = LoggerFactory.getLogger(UserSdkApplicationTests.class);

    @Autowired
    private CommonProperties commonProperties;

    @Test
    void testGetProperties() {
        logger.info("region is {}", commonProperties.getRegion());
    }

    @Test
    void contextLoads() {
    }

}
