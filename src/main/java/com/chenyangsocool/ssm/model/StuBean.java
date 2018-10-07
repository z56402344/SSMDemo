package com.chenyangsocool.ssm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Stu",description="Stu")//对类进行swagger注解
public class StuBean {
    @ApiModelProperty(value="学生id",name="id")//对类的字段属性进行swagger注解
    private int id;

    @ApiModelProperty(value="名字",name="name")
    private String name;

    @ApiModelProperty(value="密码",name="pwd")
    private String pwd;

    @ApiModelProperty(value="年龄",name="age")
    private int age = -1;

    @ApiModelProperty(value="性别",name="sex")
    private int sex = -1;

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
