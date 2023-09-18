package com.example.petadopt.club.service;

import com.example.petadopt.club.pojo.Apply;
import com.github.pagehelper.PageInfo;

public interface ApplyService {
    PageInfo<Apply> allApply(Integer state, Integer pageNum, Integer pageSize);
    Apply findByid(Integer id);
    int updateApply(Apply apply);
    int del(Integer id);
    Integer create(Apply apply);
}
