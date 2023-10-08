package com.example.petadopt.club.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-08-20 14:18
 */
@Data
public class User {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private Integer age;
    private String telephone;
    private String Email;
    private String address;
    private String pic;
    private Integer state;
    @TableField(exist = false)
    List<Comment> commentList;
    @TableField(exist = false)
    List<AdoptAnimal> animalList;

}
