package com.lhj.girlspringboot.service.impl;

import com.lhj.girlspringboot.entity.Girl;
import com.lhj.girlspringboot.dao.GirlDao;
import com.lhj.girlspringboot.enums.ExceptionEnum;
import com.lhj.girlspringboot.girlException.GirlException;
import com.lhj.girlspringboot.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现类
 */
@Service
public class GirlServiceImpl implements GirlService {
    @Autowired
    private GirlDao girlDao;
    @Override
    public List<Girl> insertGirls(List<Girl> girls) {
        List<Girl> save = girlDao.save(girls);
        return save;
    }

    @Override
    public void getAge(Integer id) throws Exception{
        Girl girl = girlDao.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            //返回"你还在上小学吧"
            throw new GirlException(ExceptionEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回"你可能在上初中"
            throw new GirlException(ExceptionEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个女生信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlDao.findOne(id);
    }

}
