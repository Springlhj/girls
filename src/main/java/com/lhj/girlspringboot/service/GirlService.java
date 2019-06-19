package com.lhj.girlspringboot.service;

import com.lhj.girlspringboot.entity.Girl;

import java.util.List;
public interface GirlService {
    List<Girl> insertGirls(List<Girl> girls);
    void getAge(Integer id) throws Exception;
    Girl findOne(Integer id);
}
