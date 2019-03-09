package com.eShoppingCart.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.eShoppingCart.dao.ProductDao;
import com.eShoppingCart.model.Product;
import com.eShoppingCart.service.ProductService;
import com.eShoppingCart.service.impl.ProductServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
	@Mock
    private static ProductDao productRepository;

    @InjectMocks
    private static ProductService productService = new ProductServiceImpl();

    private Product product;

    @Test
    public void testFindAccount() {

        Integer productId = new Integer(32);

        product = new Product();
        product.setId(productId);
        product.setName("T-shirt");
        product.setDescription("sdfsfsafd");

        Mockito.when(productRepository.getProductById(productId)).thenReturn(product);

        Product retrivedProduct = productService.getProductById(productId);

        Assert.assertEquals(product, retrivedProduct);

    }
    
}
