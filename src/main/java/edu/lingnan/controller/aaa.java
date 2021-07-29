package edu.lingnan.controller;


import com.alibaba.fastjson.JSONObject;
import edu.lingnan.pojo.*;
import edu.lingnan.service.TbContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 18364
 */
@Controller
@SuppressWarnings("all")
public class aaa {
    @Autowired
    TbContactsService tbContactsService;


    /**
     * 从idex页面发起请求，获得前端的姓名参数，保存在session里面。
     *
     * @param username
     * @return
     */
    @RequestMapping("/toBI")
    public String toBI(String username, HttpServletRequest request) {
        System.out.println(username);
        request.getSession().setAttribute("userid", tbContactsService.selectIdByName(username).getId());
        return "bi";
    }

    /**
     * 第一个图，散点图。获取用户每天的通话次数
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "sanDianTu", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Sandian> sanDianTu(HttpServletRequest request, HttpSession session) {
        System.out.println("sandiantu");
        //从session里面获取id，然后查询返回
        System.out.println(request.getSession().getAttribute("userid"));
        List<User> userid =
                tbContactsService.selectDoSandian((Integer) session.getAttribute("userid"));
        ArrayList<Sandian> sandians = new ArrayList<>();
        for (User user : userid) {
            sandians.add(new Sandian(user.getYear() + "-" + user.getMonth() + "-" + user.getDay(), user.getCallNum()));
        }
        return sandians;
    }

    /**
     * 第二个图的业务，获取用户每次通话时间。
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "zheXianTu", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Sandian> zheXianTu(HttpSession session) {
        System.out.println("zheXianTu");
        //从session里面获取id，然后查询返回
//        System.out.println(request.getSession().getAttribute("userid"));
        List<User> userid =
                tbContactsService.selectDoZheXian((Integer) session.getAttribute("userid"));
        ArrayList<Sandian> sandians = new ArrayList<>();
        for (User user : userid) {
            sandians.add(new Sandian(user.getYear() + "-" + user.getMonth() + "-" + user.getDay(), user.getCallNum()));
        }
        return sandians;
    }

    /**
     * 第三个图的业务，获取用户每个月的通话次数。
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "zhuZhuangTu", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Sandian> zhuZhuangTu(HttpServletRequest request, HttpSession session) {
        System.out.println("zhuZhuangTu");
        //从session里面获取id，然后查询返回
        System.out.println(request.getSession().getAttribute("userid"));
        List<User> userid =
                tbContactsService.selectDoZhuZhuang((Integer) session.getAttribute("userid"));
        ArrayList<Sandian> sandians = new ArrayList<>();
        for (User user : userid) {
            sandians.add(new Sandian(user.getYear() + "-" + user.getMonth(), user.getCallNum()));
        }
        return sandians;
    }


    @RequestMapping(value = "ThirdD", produces = "application/json;charset=utf-8")
    @ResponseBody
    public ArrayList<ThirdD> ThirdD(HttpServletRequest request, HttpSession session) {
        System.out.println("ThirdD");
        //从session里面获取id，然后查询返回
        System.out.println(request.getSession().getAttribute("userid"));
        List<User> userid =
                tbContactsService.selectDoThirdD((Integer) session.getAttribute("userid"));
        ArrayList<ThirdD> ThirdD = new ArrayList<>();
        for (User user : userid) {
            ThirdD.add(new ThirdD(user.getYear(), user.getMonth(), user.getCallNum()));
        }
        return ThirdD;
    }

    @RequestMapping(value = "allUser", produces = "application/json;charset=utf-8")
    @ResponseBody
    public int allUser() throws IOException {
        int i = tbContactsService.selectAll();
        return i;
    }

    @RequestMapping(value = "selectCallSum", produces = "application/json;charset=utf-8")
    @ResponseBody
    public int selectCallSum() throws IOException {
        int i = tbContactsService.selectCallSum();
        return i;
    }

    @RequestMapping(value = "selectCallTimeSum", produces = "application/json;charset=utf-8")
    @ResponseBody
    public int selectCallTimeSum() throws IOException {
        int i = tbContactsService.selectCallTimeSum();
        return i;
    }

    @RequestMapping(value = "selectIndex", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Index selectIndex() {
        List<IndexResult> indexResults = tbContactsService.selectIndex();
        System.out.println(indexResults);
        ArrayList callNum = new ArrayList<>();
        ArrayList callTimeNum = new ArrayList<>();
        for (IndexResult indexResult : indexResults) {
            callNum.add(indexResult.getCallNum());
            callTimeNum.add(indexResult.getCallTimeNum());
        }
        Index index = new Index(callNum, callTimeNum);
        System.out.println(index);
        return index;
    }


    @RequestMapping(value = "selectQin", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Sandian> selectQin(HttpServletRequest request, HttpSession session) {
        List<Sandian> userid =
                tbContactsService.selectQin((Integer) session.getAttribute("userid"));
        ArrayList<Sandian> sandians = new ArrayList<>();
        for (Sandian sandian : userid) {
            sandians.add(new Sandian(sandian.getXZhou(), sandian.getYZhou()));
        }
        return sandians;
    }


    @RequestMapping(value = "selectBinTu", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Bintu> selectBinTu(HttpServletRequest request, HttpSession session) {
        List<Bintu> userid =
                tbContactsService.selectBinTu((Integer) session.getAttribute("userid"));
        ArrayList<Bintu> sandians = new ArrayList<>();
        for (Bintu sandian : userid) {
            sandians.add(new Bintu(sandian.getName(), sandian.getValue()));
        }
        return sandians;
    }
}
