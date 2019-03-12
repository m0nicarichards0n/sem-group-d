package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void connection_test()
    {
        String location = "localhost:33060";
        app.connect(location);
        assertNotNull(app.con);
    }
//    @Test
//    void disconnection_Close() throws SQLException {
//        String location = "localhost:33060";
//        app.connect(location).;
//        app.disconnect();
//        assertTrue(app.con.isClosed());
//    }
//    @Test
//    void disconnection_CloseCatch() {
//        assertThrows(Exception.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                String location = "localhost:33060";
//                app.connect(location);
//                app.disconnect();
//            }
//        });
//
//    }
    @Test
    void test_countriesMenu(){
        ByteArrayInputStream testIn;
        final String testString = "Hello!";
        testIn = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        assertEquals(app.countriesMenu(), testString);
    }

    @Test
    void test_populationMenu(){
        ByteArrayInputStream testIn;
        final String testString = "Hello!";
        testIn = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        assertEquals(app.populationMenu(), testString);
    }
}