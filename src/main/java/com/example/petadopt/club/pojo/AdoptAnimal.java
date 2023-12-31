package com.example.petadopt.club.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Mr Wu
 * @create: 2019-08-20 14:23
 */
@Data
public class AdoptAnimal {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer petId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date adoptTime;
    private Integer state;

    @TableField(exist = false)
    private Pet pet;
    @TableField(exist = false)
    private User user;

}
