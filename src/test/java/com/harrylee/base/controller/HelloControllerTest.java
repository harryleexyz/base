package com.harrylee.base.controller;

import com.harrylee.base.BaseApplicationTests;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author harrylee
 */
public class HelloControllerTest extends BaseApplicationTests {

    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello World")));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello/name?name=harrylee")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello harrylee")));
    }


}