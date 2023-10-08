package com.example.petadopt.club.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Mr Wu
 * @create: 2019-09-05 09:59
 */
@Data
public class Apply {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String telephone;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applyTime;
    private Integer state;

}
