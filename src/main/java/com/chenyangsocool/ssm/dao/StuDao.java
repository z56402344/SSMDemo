package com.chenyangsocool.ssm.dao;

import com.chenyangsocool.ssm.model.StuBean;

import java.util.List;

public interface StuDao {
    boolean register(StuBean stuBean);
    StuBean getModelById(int id);
    StuBean login(String name, String  pwd);
    List<StuBean> getAll();
}
