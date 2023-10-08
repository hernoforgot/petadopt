package com.example.petadopt;

import com.example.petadopt.club.dao.AdminMapper;
import com.example.petadopt.club.pojo.Admins;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PetadoptApplicationTests {

    @Resource(shareable = false)
    private AdminMapper adminMapper;
    @Test
    void contextLoads() {
        List<Admins> admins = (List<Admins>) adminMapper.selectOne(null);
        admins.forEach(System.out::println);
    }

}
