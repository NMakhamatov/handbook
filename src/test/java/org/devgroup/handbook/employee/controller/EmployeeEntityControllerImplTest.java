package org.devgroup.handbook.employee.controller;

import org.devgroup.handbook.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
                , classes = Main.class)//MOCK(Default) : Loads a web ApplicationContext and provides a mock web environment. Embedded servers are not started when using this annotation. If a web environment is not available on your classpath, this mode transparently falls back to creating a regular non-web ApplicationContext. It can be used in conjunction with @AutoConfigureMockMvc or @AutoConfigureWebTestClient for mock-based testing of your web application.
//RANDOM_PORT: Loads a WebServerApplicationContext and provides a real web environment. Embedded servers are started and listen on a random port.
//        DEFINED_PORT: Loads a WebServerApplicationContext and provides a real web environment. Embedded servers are started and listen on a defined port (from your application.properties or on the default port of 8080).
//        NONE: Loads an ApplicationContext by using SpringApplication but does not provide any web environment (mock or otherwise).
public class EmployeeEntityControllerImplTest {
    @Test
    public void findById() throws Exception {
    }

    @Test
    public void createEmployee() throws Exception {
    }

    @Test
    public void transferEmployee() throws Exception {
    }

    @Test
    public void changeEmployee() throws Exception {
    }

    @Test
    public void removeEmployee() throws Exception {
    }

}