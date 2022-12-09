package com.exercise.onlinestore.test;

import com.exercise.onlinestore.main.Billing;
import com.exercise.onlinestore.main.HelloApplication;
import javafx.application.Application;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BillingTest {

    @BeforeClass
    public static void javaFXInitializer() throws InterruptedException {
        Thread thread = new Thread("JavaFX Init Thread") {
            public void run() {
                Application.launch(HelloApplication.class);
            }
        };
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
    }

    @Test
    public void next() {
        Billing obj = new Billing();
        obj.email.setText("asd@gmail.com");

        Boolean check = false;
        if (obj.email.getText().matches(obj.getpattern())) {
            check = true;
        }
        assertEquals(check, true);
    }

    @Test
    public void getpattern() {


        Billing obj = new Billing();

        obj.getpattern();
        Boolean check = false;
        String email = "asd@gmail.com";
        if (email.matches(obj.getpattern())) {
            check = true;
        }


        assertEquals(check, true);


    }
}