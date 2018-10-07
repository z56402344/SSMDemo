package com.chenyangsocool.ssm.service.impl;

import com.chenyangsocool.ssm.dao.TestDao;
import com.chenyangsocool.ssm.model.Test;
import com.chenyangsocool.ssm.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements ITestService {
    @Resource
    private TestDao testDao;

    @Override
    public Test getModelById(int id) {
        return testDao.getModelById(id);
    }

    @Override
    public List<Test> getAll() {
        return testDao.getAll();
    }

    @Override
    public Test getModelByViewCount(int viewCount) {
        return testDao.getModelByViewCount(viewCount);
    }
}