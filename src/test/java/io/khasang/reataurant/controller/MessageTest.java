package io.khasang.reataurant.controller;

import io.khasang.restaurant.model.Message;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageTest {
    @Before
    public void beforAction(){
        System.out.println("berof test");
    }

    @Test
    public void testGetVal(){
        Message message=new Message(4,"qwerty");
        Assert.assertEquals(6,message.getVal());
    }

    @After
    public void afterAction(){
        System.out.println("after test");
    }
}
