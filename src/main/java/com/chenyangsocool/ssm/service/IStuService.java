package com.chenyangsocool.ssm.service;

import com.chenyangsocool.ssm.model.StuBean;
import com.chenyangsocool.ssm.model.Test;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface IStuService {
    public boolean register(StuBean stuBean);
    public StuBean getModelById(int id);
    public StuBean login(String name, String pwd);
    public List<StuBean> getAll();
}