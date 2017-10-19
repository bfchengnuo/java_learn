package com.bfchengnuo.controller;

import com.bfchengnuo.pojo.Girl;
import com.bfchengnuo.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by 冰封承諾Andy on 2017/10/18.
 * springMVC 默认支持 RESTful 风格，写法示例
 */
@Controller
@RequestMapping("rest/girl")
public class RestfulController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestfulController.class);

    @Resource
    private GirlService girlService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Girl> getGirl(@PathVariable("id") Integer id) {
        LOGGER.info("----------------->" + id);
        try {
            Girl girl = girlService.queryGirl(id);
            if (girl == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            // 200 可以进行简写
            return ResponseEntity.ok(girl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveGirl(Girl girl) {
        LOGGER.debug("-------------->" + girl.getName());
        try {
            if (girl.getName().isEmpty() || girl.getAge().toString().isEmpty()) {
                // 400 错误，参数不正确
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            Boolean flag = girlService.saveGirl(girl);
            if (flag) {
                // 新增成功，响应 201,如果返回是 void 可以使用 build 方法
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 新增失败
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateGirl(Girl girl) {
        LOGGER.debug("-------------->" + girl.getName());
        try {
            if (girl.getName().isEmpty() || girl.getId().toString().isEmpty()) {
                // 400 错误，参数不正确
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            Boolean flag = girlService.updateGirl(girl);
            if (flag) {
                // 修改成功，响应 204,如果返回是 void 可以使用 build 方法
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 新增失败
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteGirl(@RequestParam(value = "id",defaultValue = "0") Integer id) {
        try {
            if (id == 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            Boolean flag = girlService.deleteGirl(id);
            if (flag) {
                // 删除成功，响应 204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 新增失败
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
