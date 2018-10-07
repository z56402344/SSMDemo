package com.chenyangsocool.ssm.dao;

import com.chenyangsocool.ssm.model.Test;

import java.util.List;

public interface TestDao {
    Test getModelById(int id);
    List<Test> getAll();
    Test getModelByViewCount(int viewCount);
}
