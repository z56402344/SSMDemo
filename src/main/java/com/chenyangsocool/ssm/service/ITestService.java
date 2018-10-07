package com.chenyangsocool.ssm.service;

import com.chenyangsocool.ssm.model.Test;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface ITestService {
    public Test getModelById(int id);
    public List<Test> getAll();
    public Test getModelByViewCount(int viewCount);
}