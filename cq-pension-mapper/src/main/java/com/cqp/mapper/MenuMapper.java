package com.cqp.mapper;
import com.cqp.model.Menu;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Menu的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface MenuMapper extends Mapper<Menu> {

    @Select("select menu_id menuId,level,name,icon,url,parent from menu where menu_id in " +
            "(select menu_id from perm_menu where per_id in " +
            "  (select per_id from role_perm where role_id = #{roleId}))")
    public List<Menu> getMenuForRole(Integer roleId);
}
