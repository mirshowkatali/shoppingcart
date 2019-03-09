package com.eShoppingCart.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestBeanConfig.class)
public class RegistrationControllerTest {

	@InjectMocks
    private RegisterController registerController;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
    }

    @Test
    public void testUserController () throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status()
                                                .isOk();
        
        ResultMatcher doneView = MockMvcResultMatchers.view()
                                                      .name("registerCustomer");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/register");
       

        builder = MockMvcRequestBuilders.post("/register")
                                        .param("username", "abcd")
                                        .param("customerEmail", "mirshowkat09@gmail.com")
                                        .param("password", "abc123");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(doneView);

    }
}