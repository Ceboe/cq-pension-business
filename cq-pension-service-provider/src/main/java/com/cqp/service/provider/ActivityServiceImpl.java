package com.cqp.service.provider;

import com.cqp.mapper.ActivityMapper;
import com.cqp.model.Activity;
import com.cqp.service.api.ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Activity业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;


    /**
     * Activity条件+分页查询
     * @param activity 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Activity> findPage(Activity activity, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(activity);
        //执行搜索
        return new PageInfo<Activity>(activityMapper.selectByExample(example));
    }

    /**
     * Activity分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Activity> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Activity>(activityMapper.selectAll());
    }

    /**
     * Activity条件查询
     * @param activity
     * @return
     */
    @Override
    public List<Activity> findList(Activity activity){
        //构建查询条件
        Example example = createExample(activity);
        //根据构建的条件查询数据
        return activityMapper.selectByExample(example);
    }


    /**
     * Activity构建查询对象
     * @param activity
     * @return
     */
    public Example createExample(Activity activity){
        Example example=new Example(Activity.class);
        Example.Criteria criteria = example.createCriteria();
        if(activity!=null){
            // 活动id
            if(!StringUtils.isEmpty(activity.getActId())){
                    criteria.andEqualTo("actId",activity.getActId());
            }
            // 活动名称
            if(!StringUtils.isEmpty(activity.getActName())){
                    criteria.andEqualTo("actName",activity.getActName());
            }
            // 活动内容
            if(!StringUtils.isEmpty(activity.getActType())){
                    criteria.andEqualTo("actType",activity.getActType());
            }
            // 活动内容
            if(!StringUtils.isEmpty(activity.getActContent())){
                    criteria.andEqualTo("actContent",activity.getActContent());
            }
            // 活动地点
            if(!StringUtils.isEmpty(activity.getActPlace())){
                    criteria.andEqualTo("actPlace",activity.getActPlace());
            }
            // 负责人
            if(!StringUtils.isEmpty(activity.getActCharge())){
                    criteria.andEqualTo("actCharge",activity.getActCharge());
            }
            // 开始时间
            if(!StringUtils.isEmpty(activity.getActBtime())){
                    criteria.andEqualTo("actBtime",activity.getActBtime());
            }
            // 结束时间
            if(!StringUtils.isEmpty(activity.getActEtime())){
                    criteria.andEqualTo("actEtime",activity.getActEtime());
            }
            // 备注
            if(!StringUtils.isEmpty(activity.getActRem())){
                    criteria.andEqualTo("actRem",activity.getActRem());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public int delete(Integer id){
        return activityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Activity
     * @param activity
     */
    @Override
    public int update(Activity activity){
        return activityMapper.updateByPrimaryKey(activity);
    }

    /**
     * 增加Activity
     * @param activity
     */
    @Override
    public int add(Activity activity){
        return activityMapper.insert(activity);
    }

    /**
     * 根据ID查询Activity
     * @param id
     * @return
     */
    @Override
    public Activity findById(Integer id){
        return  activityMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Activity全部数据
     * @return
     */
    @Override
    public List<Activity> findAll() {
        return activityMapper.selectAll();
    }
}
