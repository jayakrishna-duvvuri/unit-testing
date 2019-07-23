package com.jay.unittesting.controller;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    String actualResponse = "{\"id\":1,\"name\":\"name\",\"price\":25,\"quantity\":20}";

    @Test
    public void jsonAssert_StrictTrue_ExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\": 1, \"name\":\"name\",\"price\":25,\"quantity\":20}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\": 1, \"name\":\"name\",\"price\":25}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeChars() throws JSONException {
        String expectedResponse = "{id: 1, name:name, price:25}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
