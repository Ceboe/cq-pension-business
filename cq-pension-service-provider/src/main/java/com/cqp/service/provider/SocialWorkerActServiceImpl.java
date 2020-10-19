package com.cqp.service.provider;

import com.cqp.mapper.SocialWorkerActMapper;
import com.cqp.model.SocialWorkerAct;
import com.cqp.service.api.SocialWorkerActService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:SocialWorkerAct业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SocialWorkerActServiceImpl implements SocialWorkerActService {

    @Autowired
    private SocialWorkerActMapper socialWorkerActMapper;


    /**
     * SocialWorkerAct条件+分页查询
     * @param socialWorkerAct 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SocialWorkerAct> findPage(SocialWorkerAct socialWorkerAct, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(socialWorkerAct);
        //执行搜索
        return new PageInfo<SocialWorkerAct>(socialWorkerActMapper.selectByExample(example));
    }

    /**
     * SocialWorkerAct分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SocialWorkerAct> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SocialWorkerAct>(socialWorkerActMapper.selectAll());
    }

    /**
     * SocialWorkerAct条件查询
     * @param socialWorkerAct
     * @return
     */
    @Override
    public List<SocialWorkerAct> findList(SocialWorkerAct socialWorkerAct){
        //构建查询条件
        Example example = createExample(socialWorkerAct);
        //根据构建的条件查询数据
        return socialWorkerActMapper.selectByExample(example);
    }


    /**
     * SocialWorkerAct构建查询对象
     * @param socialWorkerAct
     * @return
     */
    public Example createExample(SocialWorkerAct socialWorkerAct){
        Example example=new Example(SocialWorkerAct.class);
        Example.Criteria criteria = example.createCriteria();
        if(socialWorkerAct!=null){
            // 活动编号
            if(!StringUtils.isEmpty(socialWorkerAct.getSwaId())){
                    criteria.andEqualTo("swaId",socialWorkerAct.getSwaId());
            }
            // 活动内容
            if(!StringUtils.isEmpty(socialWorkerAct.getSwaContent())){
                    criteria.andEqualTo("swaContent",socialWorkerAct.getSwaContent());
            }
            // 开始时间
            if(!StringUtils.isEmpty(socialWorkerAct.getSwaBtime())){
                    criteria.andEqualTo("swaBtime",socialWorkerAct.getSwaBtime());
            }
            // 结束时间
            if(!StringUtils.isEmpty(socialWorkerAct.getSwaEtime())){
                    criteria.andEqualTo("swaEtime",socialWorkerAct.getSwaEtime());
            }
            // 组织名称
            if(!StringUtils.isEmpty(socialWorkerAct.getOrgName())){
                    criteria.andEqualTo("orgName",socialWorkerAct.getOrgName());
            }
            // 组织人数
            if(!StringUtils.isEmpty(socialWorkerAct.getOrgPnum())){
                    criteria.andEqualTo("orgPnum",socialWorkerAct.getOrgPnum());
            }
            // 组织负责人
            if(!StringUtils.isEmpty(socialWorkerAct.getOrgCharge())){
                    criteria.andEqualTo("orgCharge",socialWorkerAct.getOrgCharge());
            }
            // 院方负责人
            if(!StringUtils.isEmpty(socialWorkerAct.getSwaCharge())){
                    criteria.andEqualTo("swaCharge",socialWorkerAct.getSwaCharge());
            }
            // 备注
            if(!StringUtils.isEmpty(socialWorkerAct.getSwaRem())){
                    criteria.andEqualTo("swaRem",socialWorkerAct.getSwaRem());
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
        return socialWorkerActMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SocialWorkerAct
     * @param socialWorkerAct
     */
    @Override
    public int update(SocialWorkerAct socialWorkerAct){
        return socialWorkerActMapper.updateByPrimaryKey(socialWorkerAct);
    }

    /**
     * 增加SocialWorkerAct
     * @param socialWorkerAct
     */
    @Override
    public int add(SocialWorkerAct socialWorkerAct){
        return socialWorkerActMapper.insert(socialWorkerAct);
    }

    /**
     * 根据ID查询SocialWorkerAct
     * @param id
     * @return
     */
    @Override
    public SocialWorkerAct findById(Integer id){
        return  socialWorkerActMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SocialWorkerAct全部数据
     * @return
     */
    @Override
    public List<SocialWorkerAct> findAll() {
        return socialWorkerActMapper.selectAll();
    }
}
