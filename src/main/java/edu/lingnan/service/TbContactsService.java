package edu.lingnan.service;

import edu.lingnan.pojo.*;

import java.util.List;

/**
 * @author 18364
 */
public interface TbContactsService {
    /**
     * 根据前端传过来的姓名，然后获取到id
     *
     * @param name
     * @return
     */
    TbContacts selectIdByName(String name);

    /**
     * 第一个业务，做散点图的数据封装。
     * 返回的数据 year-month-day id callnum
     * 散点图 x轴时间，y轴次数
     *
     * @param id
     * @return
     */
    List<User> selectDoSandian(int id);

    /**
     * 第二个业务，做折线图
     * 通话时间统计。
     *
     * @param id
     * @return
     */
    List<User> selectDoZheXian(int id);

    /**
     * 第三个业务，做柱状图
     * 用户每个月的通话次数
     *
     * @param id
     * @return
     */
    List<User> selectDoZhuZhuang(int id);

    /**
     * 第四个业务，做3d图
     * 用户每个月的通话时间统计
     * @param id
     * @return
     */
    List<User> selectDoThirdD(int id);

    /**
     * 第五个业务
     * 返回平台全部用户
     */
    int selectAll();

    /**
     * 第六个的业务
     * 返回全部用户的通话次数总和
     * @return
     */
    int selectCallSum();

    /**
     * 第七个业务
     * 返回全部用户的通话时间和
     *
     * @return
     */
    int selectCallTimeSum();

    /**
     * 第八个业务
     * 返回大屏上的表格数据
     * @return
     */
    List<IndexResult> selectIndex();

    /**
     * 亲密度
     * @param id
     * @return
     */
    List<Sandian> selectQin(int id);

    /**
     * 亲密度
     * @param id
     * @return
     */
    List<Bintu> selectBinTu(int id);
}
