package com.chenyangsocool.ssm.service.impl;

import com.chenyangsocool.ssm.dao.StuDao;
import com.chenyangsocool.ssm.dao.TestDao;
import com.chenyangsocool.ssm.model.StuBean;
import com.chenyangsocool.ssm.model.Test;
import com.chenyangsocool.ssm.service.IStuService;
import com.chenyangsocool.ssm.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StuServiceImpl implements IStuService {
    @Resource
    private StuDao mStuDao;

    @Override
    public boolean register(StuBean stuBean) {
        return mStuDao.register(stuBean);
    }

    @Override
    public StuBean getModelById(int id) {
        return mStuDao.getModelById(id);
    }

    @Override
    public StuBean login(String name, String pwd) {
        return mStuDao.login(name,pwd);
    }

    @Override
    public List<StuBean> getAll() {
        return mStuDao.getAll();
    }
}