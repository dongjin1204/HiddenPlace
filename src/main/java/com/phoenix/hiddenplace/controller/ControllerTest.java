package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {

   
   @RequestMapping(value="/homepage/homeJspTest")
   public void test2(){
      System.out.println("jsp 파일 호출");
   }
   
   @RequestMapping(value="/bookmark/userBookMarkView")
   public String test3() {
	   
      return "/views/bookmark/userBookMarkView";
   }
   
   @RequestMapping(value="/routeBoard/myRoutSelectOne")
   public String test4() {
	   
      return "/views/routeBoard/myRoutSelectOne";
   }
   
   @RequestMapping(value="/homeview")
   public String homeView() {
      
      return "/views/homepage/homeView";
   }
   
   @RequestMapping(value="/loginview")
   public String loginView() {
      
      return "/views/user/userLoginView";
   }
   
   @RequestMapping(value="/userInsertview")
   public String userInsertview() {
      
      return "/views/user/userInsertView";
   }

}
