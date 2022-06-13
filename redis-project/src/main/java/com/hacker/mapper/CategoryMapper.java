package com.hacker.mapper;

import com.hacker.po.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品三级分类 Mapper 接口
 * </p>
 *
 * @author Zero
 * @since 2022-06-12
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
