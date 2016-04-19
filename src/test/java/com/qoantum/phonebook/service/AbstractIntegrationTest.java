package com.qoantum.phonebook.service;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Abstract integration test
 */
@Ignore
@ActiveProfiles("DEV")
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication(scanBasePackages = {"com.qoantum.phonebook"})
@SpringApplicationConfiguration(classes = AbstractIntegrationTest.class)
public class AbstractIntegrationTest {

    public static void main(String[] args) {
        SpringApplication.run(AbstractIntegrationTest.class, args);
    }
}
