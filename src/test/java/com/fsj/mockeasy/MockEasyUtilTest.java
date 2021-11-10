package com.fsj.mockeasy; 

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MockEasyUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>11月 10, 2021</pre> 
* @version 1.0 
*/ 
public class MockEasyUtilTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: readAttributeValue(Object obj) 
* 
*/ 
@Test
public void testReadAttributeValue() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: getDefaultBean(Class object) 
* 
*/ 
@Test
public void testGetDefaultBean() throws Exception {
    System.out.println(JSON.toJSONString(MockEasyUtil.getDefaultBean(MockTestDTO.class)));
} 

} 
