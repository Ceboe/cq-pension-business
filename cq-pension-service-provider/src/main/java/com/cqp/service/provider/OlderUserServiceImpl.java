package com.cqp.service.provider;

import com.cqp.mapper.OlderUserMapper;
import com.cqp.model.OlderUser;
import com.cqp.service.api.OlderUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:OlderUser业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OlderUserServiceImpl implements OlderUserService {

    @Autowired
    private OlderUserMapper olderUserMapper;


    /**
     * OlderUser条件+分页查询
     * @param olderUser 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OlderUser> findPage(OlderUser olderUser, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(olderUser);
        //执行搜索
        return new PageInfo<OlderUser>(olderUserMapper.selectByExample(example));
    }

    /**
     * OlderUser分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OlderUser> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OlderUser>(olderUserMapper.selectAll());
    }

    /**
     * OlderUser条件查询
     * @param olderUser
     * @return
     */
    @Override
    public List<OlderUser> findList(OlderUser olderUser){
        //构建查询条件
        Example example = createExample(olderUser);
        //根据构建的条件查询数据
        return olderUserMapper.selectByExample(example);
    }


    /**
     * OlderUser构建查询对象
     * @param olderUser
     * @return
     */
    public Example createExample(OlderUser olderUser){
        Example example=new Example(OlderUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(olderUser!=null){
            // 编号
            if(!StringUtils.isEmpty(olderUser.getId())){
                    criteria.andEqualTo("id",olderUser.getId());
            }
            // 登录账号（老人编号）
            if(!StringUtils.isEmpty(olderUser.getOpId())){
                    criteria.andEqualTo("opId",olderUser.getOpId());
            }
            // 登录密码
            if(!StringUtils.isEmpty(olderUser.getOpPassword())){
                    criteria.andEqualTo("opPassword",olderUser.getOpPassword());
            }
            // 是否可用
            if(!StringUtils.isEmpty(olderUser.getCanUse())){
                    criteria.andEqualTo("canUse",olderUser.getCanUse());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        olderUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OlderUser
     * @param olderUser
     */
    @Override
    public void update(OlderUser olderUser){
        olderUserMapper.updateByPrimaryKey(olderUser);
    }

    /**
     * 增加OlderUser
     * @param olderUser
     */
    @Override
    public void add(OlderUser olderUser){
        olderUserMapper.insert(olderUser);
    }

    /**
     * 根据ID查询OlderUser
     * @param id
     * @return
     */
    @Override
    public OlderUser findById(Integer id){
        return  olderUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OlderUser全部数据
     * @return
     */
    @Override
    public List<OlderUser> findAll() {
        return olderUserMapper.selectAll();
    }
}
