package com.hacker.controller;

import com.hacker.result.R;
import com.hacker.service.CategoryService;
import com.hacker.redis.RedisService;
import com.hacker.service.RedisStringTestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author Zero
 * @since 2022-06-12
 */
@RestController
@RequestMapping("/pms/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisStringTestService redisStringService;
    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     */
    @GetMapping("/list/tree")
    @ApiOperation(value = "查出所有分类以及子分类，以树形结构组装起来")
    public R<?> list() {
        return R.run(() -> categoryService.listWithTree());
    }

}
