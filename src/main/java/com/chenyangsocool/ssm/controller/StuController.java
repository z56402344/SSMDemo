package com.chenyangsocool.ssm.controller;

import com.chenyangsocool.ssm.model.StuBean;
import com.chenyangsocool.ssm.service.IStuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@RequestMapping("/stu")
//@Api(value = "测试信息", tags = {"测试相关接口"})//swagger控制器说明注解
@Api(value = "用户信息", description = "用户信息", produces = MediaType.APPLICATION_JSON)

public class StuController {

    @Resource
    private IStuService mStuService;

    @RequestMapping("/register_page")
    public String registerJsp(StuBean stuBean, Model model) {
        return "stu/register";
    }

    @RequestMapping("/register")
    public String register(StuBean stuBean, Model model) {
        System.out.println("用户注册："+stuBean.getName()+stuBean.getPwd());
        if (stuBean.getName() == null || stuBean.getPwd()== null || stuBean.getAge() == -1 ||stuBean.getSex()== -1){
            model.addAttribute("msg", "请填写完整信息");
            return "stu/register";
        }else {
            mStuService.register(stuBean);
            model.addAttribute("msg", "注册成功");
            //绑定对象到test/index.jsp
            return "stu/success";
        }
    }

    @RequestMapping("/login_page")
    public String loginJsp(StuBean stuBean, Model model) {
        return "stu/login";
    }

    @RequestMapping("/login")
    public String login(StuBean stuBean, Model model) {
        System.out.println("用户登录："+stuBean.getName()+stuBean.getPwd());
        StuBean stu = this.mStuService.login(stuBean.getName(),stuBean.getPwd());
        if (stu == null){
            model.addAttribute("msg", "登录失败");
            return "stu/success";
        }else{
            model.addAttribute("msg", "登录成功,查看个人信息");
            model.addAttribute("stu", stu);
            //绑定对象到test/index.jsp
            return "stu/index";
        }
    }

    @RequestMapping("/stu_page")
    public String showIndex(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        StuBean stu = this.mStuService.getModelById(id);
        //绑定对象到test/index.jsp
        model.addAttribute("stu", stu);
        return "stu/index";
    }
    //http://localhost:8081/ssm/test/viewCount_api?viewCount=10086
    @RequestMapping("/stuid_api")
    @ResponseBody
    @ApiOperation(value = "获取单个测试实例", notes = "传入一个id，获取该id对应的实例。",httpMethod = "GET")//swagger方法注解
    public StuBean viewCount(HttpServletRequest request, Model model) {
        int viewCount = Integer.parseInt(request.getParameter("id"));
        return this.mStuService.getModelById(viewCount);
    }

    @RequestMapping("/all_api")
    @ResponseBody
    @ApiOperation(value = "获取单个测试实例", notes = "传入一个id，获取该id对应的实例。",httpMethod = "GET")//swagger方法注解
    public List<StuBean> getAll(HttpServletRequest request, Model model) {
        return this.mStuService.getAll();
    }
}
