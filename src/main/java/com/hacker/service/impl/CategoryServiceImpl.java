package com.hacker.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hacker.exception.AccessReason;
import com.hacker.mapper.CategoryMapper;
import com.hacker.po.Category;
import com.hacker.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author Zero
 * @since 2022-06-12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public List<Category> listWithTree() {
        //1、查出所有分类
        List<Category> entities = baseMapper.selectList(null);
        if (entities == null) {
            throw AccessReason.NULL_POINT_EXCEPTION.exception("商品分类为空");
        }
        return entities.stream()  //找到所有的一级分类
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .peek((menu) -> menu.setChildren(getChildrens(menu, entities)))//当前菜单的子分类
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
    }

    /**
     * 递归查找所有菜单的子菜单
     *
     * @param root 当前菜单
     * @param all  所有菜单
     * @return 当前菜单子菜单
     */
    private List<Category> getChildrens(@NotNull(message = "当前菜单不能为空") Category root,
                                              @NotNull(message = "菜单列表不能为空") List<Category> all) {
        return all.stream().filter(categoryEntity -> categoryEntity.getParentCid().equals(root.getCatId()))
                .peek(categoryEntity ->
                        categoryEntity.setChildren(getChildrens(categoryEntity, all)))//1、找到子菜单
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
    }
}
