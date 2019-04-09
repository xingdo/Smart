package com.demo.controller;

import com.demo.domain.Employee;
import com.demo.service.IEmployeeService;
import com.demo.utils.AjaxResult;
import com.demo.utils.PhoneNumUtil;
import com.demo.utils.SendTelMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
* 验证接口
* */
@RestController
public class RegisterController {
    @Autowired
    private IEmployeeService employeeService;
    //验证码
    private String num;
    /*
   发送短信验证码
   * */
    @RequestMapping(value = "/getNum",method = RequestMethod.GET)
    public String phone(String phone){
        String random = PhoneNumUtil.getRandom();
        SendTelMsgUtils.sendMsgTo(phone,random);
        num=random;
        return num;
    }
    /*
     * 提交验证,,验证信息是什么?
     * */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public AjaxResult phoneNum(Employee employee,String rannum){
        if (rannum!=null&&!"".equals(rannum)&&!StringUtils.isEmpty(employee.getPassword())&&!StringUtils.isEmpty(employee.getPolicecode())){
            //判断生成的验证码，跟输入的验证码是否相同
            if (rannum.equals(num)){

                employeeService.insert(employee);
                return AjaxResult.getAjaxResult().setLog(true).setMsg("验证成功");
            }else{
                return AjaxResult.getAjaxResult().setLog(false).setMsg("验证码错误");
            }
        }else{
            return AjaxResult.getAjaxResult().setLog(false).setMsg("请输入完整信息");
        }
    }
    /*
     * 修改密码
     * */
    @RequestMapping(value = "/changePwd",method = RequestMethod.POST)
    public AjaxResult changePwd(String password,String phone,String rannum) {
        if (rannum != null && !"".equals(rannum) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(phone)) {
            //判断生成的验证码，跟输入的验证码是否相同
            if (rannum.equals(num)) {
                Employee employee = employeeService.queryOne(phone);
                if (employee==null){
                    return AjaxResult.getAjaxResult().setLog(false).setMsg("该用户不存在");
                }else{
                    employee.setPassword(password);
                    employeeService.update(employee);
                    return AjaxResult.getAjaxResult().setLog(true).setMsg("修改密码成功");
                }
            }else {
                return AjaxResult.getAjaxResult().setLog(false).setMsg("验证码错误");
            }
        }else{
            return AjaxResult.getAjaxResult().setLog(false).setMsg("请输入完整信息");
        }
    }
}
