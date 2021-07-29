package edu.lingnan.service.impl;

import edu.lingnan.mapper.TbContactsMapper;
import edu.lingnan.pojo.*;
import edu.lingnan.service.TbContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 18364
 */
@Service
@SuppressWarnings("all")
public class TbContactsServiceImpl implements TbContactsService {

    @Autowired
    TbContactsMapper tbContactsMapper;


    @Override
    public TbContacts selectIdByName(String name) {
        return tbContactsMapper.selectIdByName(name);
    }

    @Override
    public List<User> selectDoSandian(int id) {
        return tbContactsMapper.selectDoSandian(id);
    }

    @Override
    public List<User> selectDoZheXian(int id) {
        return tbContactsMapper.selectDoZheXian(id);
    }

    @Override
    public List<User> selectDoZhuZhuang(int id) {
        return tbContactsMapper.selectDoZhuZhuang(id);
    }

    @Override
    public List<User> selectDoThirdD(int id) {
        return tbContactsMapper.selectDoThirdD(id);
    }

    @Override
    public int selectAll() {
        return tbContactsMapper.selectAll();
    }

    @Override
    public int selectCallSum() {
        return tbContactsMapper.selectCallSum();
    }

    @Override
    public int selectCallTimeSum() {
        return tbContactsMapper.selectCallTimeSum();
    }

    @Override
    public List<IndexResult> selectIndex() {
        return tbContactsMapper.selectIndex();
    }

    @Override
    public List<Sandian> selectQin(int id) {
        return tbContactsMapper.selectQin(id);
    }

    @Override
    public List<Bintu> selectBinTu(int id) {
        return tbContactsMapper.selectBinTu(id);
    }


}
