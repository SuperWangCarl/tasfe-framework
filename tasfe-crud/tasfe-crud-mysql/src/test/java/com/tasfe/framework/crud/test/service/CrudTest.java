package com.tasfe.framework.crud.test.service;

import com.tasfe.framework.crud.core.CrudTemplate;
import com.tasfe.framework.crud.test.model.entity.Member;
import com.tasfe.framework.crud.test.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Lait on 2017/4/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springs/spring-mybatis.xml"})
public class CrudTest {

    //@Autowired
    //CrudBusiness crudBusiness;

    //@Autowired
    //UserBusiness userBusiness;

    @Resource(name="mysql")
    CrudTemplate crudTemplate;

    //@Resource(name="mysqlTemplate")
    //CrudOperator<User> mysqlOperator;

    /**
     *  暂未实现
     */
    //@Resource(name="hiveTemplate")
    //CrudOperator<User> hiveOperator;

    private User getUser(){
        User u = new User();
        AtomicLong al = new AtomicLong();
        Random random = new Random();
        u.setUserId(Long.valueOf(random.nextInt()));
        u.setDeptId(1);
        u.setOrderId(random.nextInt());
        u.setEmail("lait.zhang@gmail.com");
        u.setMobilePhone("15801818092");
        return u;
    }

    private List<User> getUsers(int count){
        List<User> userList = new ArrayList<User>();
        for(int i=0;i<count;i++){
            userList.add(getUser());
        }
        return userList;
    }

    @Test
    public void testInsert() throws Exception {
        /*User user = getUser();
        crudTemplate.insert(user);

        crudTemplate.insertBatch(getUsers(10));*/


        Member member = new Member();
        member.setEmail("lait");
        member.setUserId(1L);
        member.setDeptId(1);
        member.setOrderId(111);
        crudTemplate.insert(member);

        // 自定义填充方式
        //User user1 = mysqlTemplate.forParam(user).exec("doXX").fill(User.class);

        //System.out.println("=========" + user);
    }



    @Test
    public void testGet() throws Exception {
        User user = crudTemplate.get(User.class,25L);

//        List<User> users = crudTemplate.gets(User.class,1L,2L,3L);
//        System.out.println(user +"====="+ users);

        List<User> users = crudTemplate.gets(user);
        System.out.println(user +"====="+ users.size());




        //User user11 = mysqlTemplate.get(User.class,1L);
        //User user1 = mysqlTemplate.forParam(user).exec("getUser").get();

        // 填充
        //User user1 = mysqlTemplate.forParam(user).exec("getUser").fill(User.class);
        //List<User> user1 = mysqlTemplate.get(user);
        //System.out.println(user11+ "--------------------------------" );

        //System.out.println(user +"====="+ users);
    }




    /*@Test
    public void testBusinessInsert() throws Exception {
        User u = getUser();
        crudBusiness.insert(u);


    }

    @Test
    public void testUBusinessInsert() throws Exception {
        User u = getUser();
        userBusiness.findUsers();
    }*/



    @Test
    public void testTemplateInsert() throws Exception {
        User u = getUser();
        crudTemplate.insert(u);
    }

    @Test
    public void testOperationInsert() throws Exception {
        User u = getUser();
        crudTemplate.insert(u);
    }


    @Test
    public void testOperationInsertBatch() throws Exception {
        List<User> userList = getUsers(10);
        //mysqlTemplate.batchInsert(userList);
        System.out.println("====" + userList.size());
        for(User user:userList){
            System.out.println(user.getUserId() + "::::" + user.getDeptId());
        }
    }



    
    
    @Test
    public void testOperationFind() throws Exception {
        List<User> userList = getUsers(10);
        //mysqlTemplate.batchInsert(userList);
        System.out.println("====" + userList.size());
        for(User user:userList){
            System.out.println(user.getUserId() + "::::" + user.getDeptId());
        }
    }
    



}