package com.xingji.frameproject.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xingji.frameproject.annotation.Log;
import com.xingji.frameproject.mybatis.entity.Loginin;
import com.xingji.frameproject.mybatis.entity.Operationlog;
import com.xingji.frameproject.service.LogininService;
import com.xingji.frameproject.service.OperationlogService;
import com.xingji.frameproject.util.JwtTokenUtil;
import com.xingji.frameproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录日志（表控制层）
 */
@Slf4j
@RestController
@RequestMapping("/operationlog")
public class OperationlogController {
    /**
     * 服务对象
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private LogininService logininService;
    @Resource
    private OperationlogService operationlogService;
    @Resource
    private HttpServletRequest request;
    /**
     * 单条件查询、多条件查询，查询所有登录日志
     * @param operator
     * @param currentPage
     * @param pagesize
     * @param logintime
     * @return
     */
    @Log("test111")
    @GetMapping("/findloginlogbycondition")
    public AjaxResponse findLogbycondition(String operator, Integer currentPage, Integer pagesize , String logintime, String operatorType) {
        System.out.println("operator:"+operator+"-------currenPage:"+currentPage+"------pagesize:"+pagesize+"---------logintime:"+logintime+"---------operatorType:"+operatorType);
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pagesize);
        List<Loginin> list = null;
        Loginin loginin=new Loginin();
        //时间和操作员有一个不为空时
        if(((logintime!=null && logintime!="") &&(!logintime.equals("") && !logintime.equals(null)))
                || ((operator!=null && operator!="")&&(!operator.equals("")&&!operator.equals(null)))
                || ((operatorType!=null && operatorType!="")&&(!operatorType.equals("")&&!operatorType.equals(null)))){
            System.out.println("-------------------insert");
            //时间和操作员and操作员类别都不为空，通过三者查询
            if(((logintime!=null && logintime!="") &&(!logintime.equals("") && !logintime.equals(null)))
                    && ((operator!=null && operator!="")&&(!operator.equals("") && !operator.equals(null)))
                    && ((operatorType!=null && operatorType!="")&&(!operatorType.equals("")&&!operatorType.equals(null)))){
                System.out.println("-----------findlogbyLogintimeAndOperatorAndoperatorType");
                char i = logintime.charAt(9);
                int num = Integer.parseInt(String.valueOf(i));
                System.out.println("-----------"+num);
                num=num+1;
                String as=String.valueOf(num);
                StringBuilder sb=new StringBuilder(as);
                String time=logintime.substring(0,9);
                System.out.println("--------------"+time);
                sb.insert(0,time);
                time=sb.toString();
                System.out.println("char:"+i+ "String as:"+as+"Num:"+num+"time:"+time);
                System.out.println("操作类型是："+operatorType);
                logintime=time=time+"%";
                operatorType="%"+operatorType+"%";
                list=logininService.findlogbyLogintimeAndOperatorAndOperatorType(logintime,operator,operatorType);
                System.out.println(">>>>>>>>>>>>>>"+list);
            }
            //时间和操作员不为空
            else if(((logintime!=null && logintime!="") && (!logintime.equals("") && !logintime.equals(null)))
            && ((operator!=null && operator!="")&&(!operator.equals("")&&!operator.equals(null)))){
                System.out.println("-----------findlogbyLogintimeAndOperator");
                char i = logintime.charAt(9);
                int num = Integer.parseInt(String.valueOf(i));
                System.out.println("-----------"+num);
                num=num+1;
                String as=String.valueOf(num);
                StringBuilder sb=new StringBuilder(as);
                String time=logintime.substring(0,9);
                System.out.println("--------------"+time);
                sb.insert(0,time);
                time=sb.toString();
                System.out.println("char:"+i+ "String as:"+as+"Num:"+num+"time:"+time);
                time=time+"%";
                list=logininService.findlogbyLogintimeAndOperator(time,operator);
            }
            //操作员和操作员类别
            else if(((operator!=null && operator!="")&&(!operator.equals("") && !operator.equals(null)))
                    && ((operatorType!=null && operatorType!="")&&(!operatorType.equals("")&&!operatorType.equals(null)))){
                System.out.println("-----------findlogByOperatorAndOperatorType");
                operatorType="%"+operatorType+"%";
                list=logininService.findlogByOperatorAndOperatorType(operator,operatorType);
            }
            //时间和操作员类别不为空
            else if(((logintime!=null && logintime!="") &&(!logintime.equals("") && !logintime.equals(null)))
                    && ((operatorType!=null && operatorType!="")&&(!operatorType.equals("")&&!operatorType.equals(null)))){
                System.out.println("-----------findlogByOperatorTypeAndLogintime");
                char i = logintime.charAt(9);
                int num = Integer.parseInt(String.valueOf(i));
                System.out.println("-----------"+num);
                num=num+1;
                String as=String.valueOf(num);
                StringBuilder sb=new StringBuilder(as);
                String time=logintime.substring(0,9);
                System.out.println("--------------"+time);
                sb.insert(0,time);
                time=sb.toString();
                System.out.println("char:"+i+ "String as:"+as+"Num:"+num+"time:"+time);
                time=time+"%";
                operatorType="%"+operatorType+"%";
                list=logininService.findlogByOperatorTypeAndLogintime(time,operatorType);
            }
            //时间不为空，通过时间查询
            else if((logintime!=null && logintime!="") && (!logintime.equals("")) && !logintime.equals(null)){
                System.out.println("-----------findlogbyLogintime");
                char i = logintime.charAt(9);
                int num = Integer.parseInt(String.valueOf(i));
                System.out.println("-----------"+num);
                num=num+1;
                String as=String.valueOf(num);
                StringBuilder sb=new StringBuilder(as);
                String time=logintime.substring(0,9);
                System.out.println("--------------"+time);
                sb.insert(0,time);
                time=sb.toString();
                System.out.println("char:"+i+ "String as:"+as+"Num:"+num+"time:"+time);
                time=time+"%";
                list=logininService.findlogbyLogintime(time);
            }
            //操作员类别不为空
            else if ((operatorType!=null && operatorType!="")&&(!operatorType.equals("") && !operatorType.equals(null))){
                System.out.println("------------------findlogByOperatorType");
                operatorType="%"+ operatorType+ "%";
                list=logininService.findlogByOperatorType(operatorType);
                System.out.println(">>>>>>>>>>>>>>"+list);
            }
            //操作员不为空，通过操作员查询
            else if((operator!=null && operator!="")&&(!operator.equals("") && !operator.equals(null))){
                System.out.println("______________findlogByOperator");
                list=logininService.findlogByOperator(operator);
            }
        }else{
            //查询所有
            System.out.println("-------------findAll");
            list=logininService.findAll(loginin);

        }
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
   }


    /**
     * 单条件查询、多条件查询，查询所有操作日志
     * @param currentPage
     * @param pagesize
     * @param createtime
     * @param input
     * @param operator
     * @return
     */
    @GetMapping("/findoperationlogbycondition")
    public AjaxResponse findoperatorLogByCondition(Integer currentPage, Integer pagesize,String createtime ,String input,String operator) {
        System.out.println("operator: "+operator+"-------currenPage: "+currentPage+"------pagesize: "
                +pagesize+"----------createtime: "+createtime+"-------input: "+input);
        if((input!=null && input!="") && (!input.equals("") && !input.equals(null))){
            input="%"+input+"%";
        }
        Map<String,Object> map=new HashMap<>();
        Page<Object> page= PageHelper.startPage(currentPage,pagesize);
        List<Operationlog> list = null;
        Operationlog operationlog=new Operationlog();
        //时间,操作员,操作内容有一个不为空时
        if(((createtime!=null && createtime!="") &&(!createtime.equals("") && ! createtime.equals(null)))
                || ((operator!=null && operator!="")&&(!operator.equals("")&&! operator.equals(null)))
                || ((input!=null && input!="") && (!input.equals("") && !input.equals(null)))){
                System.out.println("-------------------insert");
            //三个参数都不为空时
            if(((createtime!=null && createtime!="") &&(!createtime.equals("") && !createtime.equals(null)))
                    && ((operator!=null && operator!="")&&(!operator.equals("") && !operator.equals(null)))
                    && ((input!=null && input!="") && (!input.equals("") && !input.equals(null)))){
                System.out.println("-----------findbyCreateTimeAndOperatorAndInput");
                char i = createtime.charAt(9);
                int num = Integer.parseInt(String.valueOf(i));
                System.out.println("-----------"+num);
                num=num+1;
                String as=String.valueOf(num);
                StringBuilder sb=new StringBuilder(as);
                String time=createtime.substring(0,9);
                System.out.println("--------------"+time);
                sb.insert(0,time);
                time=sb.toString();
                System.out.println("char:"+i+ "String as:"+as+"Num:"+num+"time:"+time);
                time=time+"%";
                list=operationlogService.findbyCreateTimeAndOperatorAndInput(time,operator,input);
            }
            //时间和操作员不为空时
            else if(((createtime!=null && createtime!="") && (!createtime.equals("") && !createtime.equals(null)))
                    && ((operator!=null && operator!="")&&(!operator.equals("") && !operator.equals(null)))){
                System.out.println("-----------findbyCreateTimeAndOperator");
                char i = createtime.charAt(9);
                int num = Integer.parseInt(String.valueOf(i));
                System.out.println("-----------"+num);
                num=num+1;
                String as=String.valueOf(num);
                StringBuilder sb=new StringBuilder(as);
                String time=createtime.substring(0,9);
                System.out.println("--------------"+time);
                sb.insert(0,time);
                time=sb.toString();
                System.out.println("char:"+i+ "String as:"+as+"Num:"+num+"time:"+time);
                time=time+"%";
                list=operationlogService.findbyCreateTimeAndOperator(time,operator);
            }
            //操作员和操作内容不为空时
            else if(((operator!=null && operator!="")&&(!operator.equals("") && !operator.equals(null)))
                    && ((input!=null && input!="") && (!input.equals("") && !input.equals(null)))){
                System.out.println("______________findbyInputAndOperator");
                list=operationlogService.findbyInputAndOperator(operator,input);
            }
            //时间和操作内容不为空时
            else if(((createtime!=null && createtime!="") && (!createtime.equals("") && !createtime.equals(null)))
                    && ((input!=null && input!="") && (!input.equals("") && !input.equals(null)))){
                System.out.println("______________findbyCreateTimeAndInput");
                char i = createtime.charAt(9);
                int num = Integer.parseInt(String.valueOf(i));
                System.out.println("-----------"+num);
                num=num+1;
                String as=String.valueOf(num);
                StringBuilder sb=new StringBuilder(as);
                String time=createtime.substring(0,9);
                System.out.println("--------------"+time);
                sb.insert(0,time);
                time=sb.toString();
                System.out.println("char:"+i+ "String as:"+as+"Num:"+num+"time:"+time);
                time=time+"%";
                list=operationlogService.findbyCreateTimeAndInput(time,input);
            }
            //时间不为空时
            else if((createtime!=null && createtime!="") && (!createtime.equals("") && !createtime.equals(null))){
                System.out.println("______________findbyCreateTime");
                char i = createtime.charAt(9);
                int num = Integer.parseInt(String.valueOf(i));
                System.out.println("-----------"+num);
                num=num+1;
                String as=String.valueOf(num);
                StringBuilder sb=new StringBuilder(as);
                String time=createtime.substring(0,9);
                System.out.println("--------------"+time);
                sb.insert(0,time);
                time=sb.toString();
                System.out.println("char:"+i+ "String as:"+as+"Num:"+num+"time:"+time);
                time=time+"%";
                list=operationlogService.findbyCreateTime(time);
            }
            //操作内容不为空时
            else if((input!=null && input!="") && (!input.equals("") && !input.equals(null))){
                System.out.println("______________findbyInput");
                list=operationlogService.findbyInput(input);
            }
            //操作员不为空时
            else if((operator!=null && operator!="") && (!operator.equals("") && !operator.equals(null))){
                System.out.println("______________findbyOperator");
                list=operationlogService.findbyOperator(operator);
            }
        }else{
            list=operationlogService.findAll(operationlog);
        }
        map.put("total",page.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
}
