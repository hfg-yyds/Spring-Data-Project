package com.hacker.service;

import com.hacker.po.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author Zero
 * @since 2022-06-12
 */
public interface CategoryService extends IService<Category> {
    /**
     * 以树形结构返回商品分类
     *
     * @return
     */
    List<Category> listWithTree();

}
