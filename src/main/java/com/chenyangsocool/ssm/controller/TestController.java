package com.chenyangsocool.ssm.controller;

import com.chenyangsocool.ssm.model.Test;
import com.chenyangsocool.ssm.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/test")
//@Api(value = "测试信息", tags = {"测试相关接口"})//swagger控制器说明注解
@Api(value = "用户信息", description = "用户信息", produces = MediaType.APPLICATION_JSON)
public class TestController {

    @Resource
    private ITestService testService;

    @RequestMapping("/index_page")
    public String showIndex(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Test test = this.testService.getModelById(id);
        //绑定对象到test/index.jsp
        model.addAttribute("test", test);
        return "test/index";
    }

    @RequestMapping("/viewCount_page")
    public String showViewCount(HttpServletRequest request, Model model) {
        int viewCount = Integer.parseInt(request.getParameter("viewCount"));
        Test test = this.testService.getModelByViewCount(viewCount);
        //绑定对象到test/index.jsp
        model.addAttribute("test", test);
        return "test/index";
    }

    @RequestMapping("/index_api")
    @ResponseBody
    @ApiOperation(value = "获取单个测试实例", notes = "传入一个id，获取该id对应的实例。",httpMethod = "GET")//swagger方法注解
    public Test Index(HttpServletRequest request,Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        return this.testService.getModelById(id);
    }

    //http://localhost:8081/ssm/test/viewCount_api?viewCount=10086
    @RequestMapping("/viewCount_api")
    @ResponseBody
    @ApiOperation(value = "获取单个测试实例", notes = "传入一个id，获取该id对应的实例。",httpMethod = "GET")//swagger方法注解
    public Test viewCount(HttpServletRequest request,Model model) {
        int viewCount = Integer.parseInt(request.getParameter("viewCount"));
        return this.testService.getModelByViewCount(viewCount);
    }

    //http://localhost:8081/ssm/test/all_api
    @RequestMapping("/all_api")
    @ResponseBody
    @ApiOperation(value = "获取单个测试实例", notes = "传入一个id，获取该id对应的实例。",httpMethod = "GET")//swagger方法注解
    public List<Test> getAll(HttpServletRequest request, Model model) {
        return this.testService.getAll();
    }
}