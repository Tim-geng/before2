package com.baidu.test;

import com.baidu.pojo.User;
import com.baidu.service.UserService;
import com.baidu.util.DESUTIL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MyTest {
    @Resource
    UserService userService;
    @Test
    public  void method(){
        User user =new User();
        user.setName("张三丰");
        user.setPassword(DESUTIL.encode("abcdefg"));
        user.setLoginId("admin");
        user.setPhone("15620263150");
        user.setSex(1);
        user.getCreateDate(new Date());
        user.setEmail("abc@qq.com");
        System.out.println(userService.add(user));
    }
}
