package com.example.petadopt.club.service.impl;

import com.example.petadopt.club.dao.AdoptAnimalMapper;
import com.example.petadopt.club.pojo.AdoptAnimal;
import com.example.petadopt.club.dao.PetMapper;
import com.example.petadopt.club.dao.UserMapper;
import com.example.petadopt.club.pojo.Pet;
import com.example.petadopt.club.pojo.User;
import com.example.petadopt.club.service.AdoptAnimalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.petadopt.club.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdoptAnimalServiceImpl implements AdoptAnimalService {
    @Resource
    private AdoptAnimalMapper adoptAnimalMapper;

    @Resource
    private UserMapper userMapper;
    @Resource
    private PetMapper petMapper;
    @Resource
    private UserService userService;
    @Override
    public PageInfo<AdoptAnimal> allAdoptAnimal(String userName, Integer pageNum, Integer pageSize, Integer state) {
        List<User> users = userService.findByName(userName, state);
        List<Integer> userIds = new ArrayList<>();
        for (User user : users){
            userIds.add(user.getId());
        }
        PageHelper.startPage(pageNum,pageSize);
        EntityWrapper wrapper = new EntityWrapper();
        if (state != null){
            wrapper.eq("state", state);
        }
        if (users != null){
            wrapper.in("user_id", userIds);
        }
        List<AdoptAnimal> list = adoptAnimalMapper.selectList(wrapper);
        for(AdoptAnimal a : list){
            User u = userMapper.selectById(a.getUserId());
            a.setUser(u);
            Pet pet = petMapper.selectById(a.getPetId());
            a.setPet(pet);
        }
        PageInfo<AdoptAnimal> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    @Override
    public Integer create(AdoptAnimal adoptAnimal) {
        return adoptAnimalMapper.insert(adoptAnimal);
    }

    @Override
    public PageInfo<AdoptAnimal> all(String adoptTime,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EntityWrapper<AdoptAnimal> wrapper = new EntityWrapper<>();
        if(adoptTime!=null && !"".equals(adoptTime)){
            wrapper.like("adopt_time",adoptTime);
        }
        List<AdoptAnimal> list = adoptAnimalMapper.selectList(wrapper.eq("state",1));
        for(AdoptAnimal a : list){
            Pet pet = petMapper.selectById(a.getPetId());
            a.setPet(pet);
            User user = userMapper.selectById(a.getUserId());
            a.setUser(user);
        }
        PageInfo<AdoptAnimal> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int update(Integer id, Integer state) {
        AdoptAnimal adoptAnimal = adoptAnimalMapper.selectById(id);
        adoptAnimal.setState(state);
        Integer integer = adoptAnimalMapper.updateById(adoptAnimal);
        return integer;
    }


}
