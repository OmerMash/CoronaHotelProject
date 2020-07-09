//package com.CoronaHotel.test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforEach;
//
//class LoginTest {
//	Login loginControlle;
//	
//	public void SetUp() {
//		Login loginController= new Login();
//	}
//    
//    //@Disabled - test not working/ quieting 
//    //RepeatedTest(5) - running 5 times 
//    //BeforEach - THIS ONE WILL RUN BEFOR EACH TEST 
//    //AfterEach - THIS ONE WILL RUN AFTER EACH TEST 
//    //BeforAll- THIS ONE WILL RUN BEFOR ALL TEST 
//    //AfterAll- THIS ONE WILL RUN AFTER ALL TEST 
//	@Test
//	public void loginFailedWhenUsernameIsEmpty() {
//    	//LoginController loginController= new LoginController();
//    	try{
//    		loginController.Login(" ","123");
//    		Assertions.fail("The Login success but should failed");
//    	}catch (IllegalArgumentException e) {
//    		Assertions.assertEquals("UserName or password must not be null", e.getMessage());
//    	}
//    }
//    @Test
//    	public void loginFailedWhenPasswordIsEmpty() {
//        	//LoginController loginController= new LoginController();
//        	try{
//        		loginController.Login("123"," ");
//        		Assertions.fail("The Login success but should failed");
//        	}catch (IllegalArgumentException e) {
//        		Assertions.assertEquals("UserName or password must not be null", e.getMessage());
//        	}
//        }
//    	
//    	
//	
//	}
//
//}
