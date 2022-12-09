package com.exercise.onlinestore.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class OrderTest {
    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order("Anders Andersson", 12345, "Bowtruckle", 1);
    }

    @Test
    void getCustNameTest() {
        String expResult = "Anders Andersson";
        assertEquals(expResult, order.getCustName(), "Input value is equal to value shown.");
    }

    @Test
    void getCustNameNullTest() {
        try {
            order.setCustName(null);
            order.getCustName();
            fail("Null value in getCustName() should trigger an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("getCustName captured a Null value exception " + e);
        } catch (Exception e) {
            fail("Wrong exeption thrown for getCustName()");
        }
    }

    @Test
    void getCustNameThatDosentExistTest() {
        try {
            order.getCustName().equals("Bosse Bildoktorn");
            fail("Null value in getCustName() should trigger an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("getCustName captured a Null value exception " + e);
        } catch (Exception e) {
            fail("Wrong exeption thrown for getCustName()");
        }
    }

    @Test
    void setCustNameInvalid() {
        try {
            order.setCustName(null);
            fail("Null value in setCustName() should trigger an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("setCustName captured a Null value exception " + e);
        } catch (Exception e) {
            fail("Wrong exeption thrown for setCustName()");
        }
    }

    @Test
    void getOrderNr() {
        int expResult = 12345;
        assertEquals(expResult, order.getOrderNr());
    }

    @Test
    void setOrderNrInvalid() {
        try {
            order.setOrderNr(-1234);
            fail("Negative order number set in setOrderNr(). Should trigger an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("setOrderNr() captured a negative value " + e);
        } catch (Exception e) {
            fail("Wrong exeption thrown for setOrderNr()");
        }
    }

    @Test
    void setOrderNr() {
        order.setOrderNr(56789);
        int expResult = 56789;
        assertEquals(expResult, order.getOrderNr());
    }

/*    @Test
    void getItemOrdered() {
    }

    @Test
    void setItemOrdered() {
    }

    @Test
    void getQuantity() {
    }

    @Test
    void setQuantity() {
    }*/
}