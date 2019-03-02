package com.harrylee.base.web;

import com.harrylee.base.BaseApplicationTests;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author harrylee
 */
public class UserControllerTest extends BaseApplicationTests {

    @Autowired
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
                .param("userName", "哈瑞")
                .param("loginName", "harry.lee")
                .param("password", "123456")
                .param("age", "180")
                .param("sex", "男")
                .param("remark", "一个好人")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("success")));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
                .param("userName", "sherry.ding")
                .param("loginName", "舍瑞")
                .param("password", "@#$%^&*")
                .param("age", "-1")
                .param("sex", "woman")
                .param("remark", "one women")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("failure")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/user"))
                .andDo(print());
    }

}