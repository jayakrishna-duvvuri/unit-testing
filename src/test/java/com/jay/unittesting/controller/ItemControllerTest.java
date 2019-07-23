package com.jay.unittesting.controller;

import com.jay.unittesting.business.ItemBusinessService;
import com.jay.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
@RunWith(SpringRunner.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception {
        //call GET "/dummy-item" application.json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"name\",\"price\":25,\"quantity\":20}"))
                .andReturn();

        //JSONAssert.
        //verify "Hello World"
        //assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {

        when(businessService.retrieveHardCodedItem()).thenReturn(new Item(2, "Item2", 10, 10));
        //call GET "/dummy-item" application.json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id: 2, name:Item2, price:10}"))
                .andReturn();


        //JSONAssert.
        //verify "Hello World"
        //assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }


    @Test
    public void retrieveAllItems_basic() throws Exception {

        when(businessService.retrieveAllItems()).thenReturn(Arrays.asList( new Item(2, "Item2", 10, 10)
                                                                            , new Item(3, "Item3", 20, 10)
                                                                            ));
        //call GET "/dummy-item" application.json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[ {id:3, name:Item3, price:20}, {id:2,name:Item2,price:10}]"))
                .andReturn();


        //JSONAssert.
        //verify "Hello World"
        //assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }
}
