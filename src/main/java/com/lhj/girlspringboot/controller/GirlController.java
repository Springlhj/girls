package com.lhj.girlspringboot.controller;

import com.lhj.girlspringboot.controller.vo.GirlQueryVo;
import com.lhj.girlspringboot.controller.vo.GirlUpdateVo;
import com.lhj.girlspringboot.dao.GirlDao;
import com.lhj.girlspringboot.entity.Girl;
import com.lhj.girlspringboot.entity.ResponseData;
import com.lhj.girlspringboot.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.lhj.girlspringboot.utils.ResponseDataUtil;

import javax.validation.Valid;
import java.util.List;
//返回json数据格式
@RestController
@RequestMapping(value = "/girl")
public class GirlController {
    @Autowired
    private GirlDao girlDao;
    @Autowired
    private GirlService girlService;
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    /**
     * 增加  (对返回的格式进行了统一处理,采用的是ResponseData对象,固定返回的格式)
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseData<Girl> insert(@RequestBody @Valid GirlUpdateVo girlUpdateVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return null;
//            return ResponseDataUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        //建造实体对象
        Girl girl = girlUpdateVo.buildEntity();
//        Girl save = girlDao.save(girl);
        return ResponseDataUtil.success(girlDao.save(girl));
    }
    /**
     * 根据年龄查询女生
     * @param girlQueryVo 返回列表
     * @return
     */
    @RequestMapping(value = "/findByAge",method = RequestMethod.POST)
    public List<Girl> findByAge(@RequestBody GirlQueryVo girlQueryVo){
        return girlDao.findByAge(girlQueryVo.getAge());
    }

    /**
     * 查询所有女生列表
     * @return 返回list列表
     */
    @RequestMapping(value = "/findAllGirl",method = RequestMethod.GET)
    public List<Girl> findAllGirl(){
        logger.info("验证Before是在方法执行前还是在方法执行后");
        return girlDao.findAll();
    }
    /**
     * 根据id删除
     * @return
     */
    @RequestMapping(value = "/deleteGirl",method = RequestMethod.GET)
    public String deleteGirl(@RequestParam Integer id){
        girlDao.delete(id);
        return "删除成功";
    }

    /**
     * 利用@PathVariable注解 获取url路径中的值
     * @param id 要查询的id
     * @return 查询到的女生对象
     */
    @RequestMapping(value = "/selectOneGirl/{id}",method = RequestMethod.GET)
    public Girl selectOneGirl(@PathVariable("id")Integer id){
        Girl one = girlDao.findOne(id);
        return one;
    }
    /**
     * 修改更新
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestBody GirlUpdateVo girlUpdateVo){
        //建造实体对象
        Girl girl = girlUpdateVo.buildEntity();
        Girl save = girlDao.save(girl);
        return "修改后的年龄为:"+save.getAge()+",cupsize为:"+save.getCupSize();
    }
    /**
     * 增加两个
     * @return
     */
    @RequestMapping(value = "/insertTwoGirl",method = RequestMethod.POST)
    public void insertTwoGirl(@RequestBody List<Girl> girls){
        List<Girl> list = girlService.insertGirls(girls);
        for (Girl girl : list) {
            System.out.println("增加了"+list.size()+"个，id为"+girl.getId()+"的女生");
        }
    }

    /**
     * 为了解决业务逻辑在service层处理,controller层不需要再接受它返回的信息,所以引入了异常Exception
     * 默认的Exception它只接受message这个字段,但我们还要返回code(错误状态码)字段,所以才定义自定义异常(GirlException)
     * 有异常就得捕获它,所以写了一个捕获异常的类(ExceptionHandle)
     * 最后把code和message给它定义成枚举,方便做统一管理
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/getAge/{id}",method = RequestMethod.GET)
    public void getage(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
