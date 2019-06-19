package com.lhj.girlspringboot.dao;


import com.lhj.girlspringboot.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * jpa实现接口类 <类名,id类型>
 */
public interface GirlDao extends JpaRepository<Girl,Integer> {
    List<Girl> findByAge(Integer age);
}
