package com.exercise.onlinestore.main;

import com.exercise.onlinestore.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductTest {
    private Product product;
    @BeforeEach
    void setUp() {
        product = new Product("Bowtruckle", 20000, "", 0);
    }

    @Test
    void getName(){
        String expResult = "Bowtruckle";
        assertEquals(expResult, product.getName());
    }
    @Test
    void price(){
        double expResult = 20000;
        assertEquals(expResult, product.getPrice());
    }

    @Test
    public void TestAddProduct(){
        ArrayList<Product> productListToGiveWhenFunctionCalled = new ArrayList<>();
        productListToGiveWhenFunctionCalled.add(new Product("Bowtruckle",50000, "",0));

        ProductDatabase connectionMock = mock(ProductDatabase.class);
        when(connectionMock.getAllProducts()).thenReturn(productListToGiveWhenFunctionCalled);

        String name = "Bowtruckle";
        Double price = 50000.0;

        ProductSystem productSystem = new ProductSystem(connectionMock);
        boolean successful = productSystem.addProduct(name, price);

        System.out.println(name + " = " + productSystem.currentlyAddedProduct.getName());
        System.out.println(price + " = " + productSystem.currentlyAddedProduct.getPrice());
        System.out.println("Success: " + successful);
        assertEquals(name, productSystem.currentlyAddedProduct.getName());
        assertEquals(price, productSystem.currentlyAddedProduct.getPrice());
        assertTrue(successful);
    }

    @Test
    public void testProductDatabase(){
        ProductDatabase productDatabase = mock(ProductDatabase.class);

        when(productDatabase.getProductbyName("Bowtruckle")).thenReturn(new Product("Bowtruckle",50000, "",0));
        when(productDatabase.getProductbyName("Demiguise")).thenReturn(new Product("Demiguise",300000, "",0));

        Product p1 = productDatabase.getProductbyName("Bowtruckle");
        assert (p1.getName().equals("Bowtruckle"));
        assert (p1.getPrice() == 50000);

        Product p2 = productDatabase.getProductbyName("Demiguise");
        assert (p2.getName().equals("Demiguise"));
        assert (p2.getPrice() == 300000);
    }
}


