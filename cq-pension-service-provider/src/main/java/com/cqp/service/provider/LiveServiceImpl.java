package com.cqp.service.provider;

import com.cqp.mapper.LiveMapper;
import com.cqp.model.Live;
import com.cqp.service.api.LiveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Live业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class LiveServiceImpl implements LiveService {

    @Autowired
    private LiveMapper liveMapper;


    /**
     * Live条件+分页查询
     * @param live 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Live> findPage(Live live, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(live);
        //执行搜索
        return new PageInfo<Live>(liveMapper.selectByExample(example));
    }

    /**
     * Live分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Live> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Live>(liveMapper.selectAll());
    }

    /**
     * Live条件查询
     * @param live
     * @return
     */
    @Override
    public List<Live> findList(Live live){
        //构建查询条件
        Example example = createExample(live);
        //根据构建的条件查询数据
        return liveMapper.selectByExample(example);
    }


    /**
     * Live构建查询对象
     * @param live
     * @return
     */
    public Example createExample(Live live){
        Example example=new Example(Live.class);
        Example.Criteria criteria = example.createCriteria();
        if(live!=null){
            // 入住id
            if(!StringUtils.isEmpty(live.getLiveId())){
                    criteria.andEqualTo("liveId",live.getLiveId());
            }
            // 老人编号
            if(!StringUtils.isEmpty(live.getOpId())){
                    criteria.andEqualTo("opId",live.getOpId());
            }
            // 入住时间
            if(!StringUtils.isEmpty(live.getLiveTime())){
                    criteria.andEqualTo("liveTime",live.getLiveTime());
            }
            // 床位编号
            if(!StringUtils.isEmpty(live.getBedId())){
                    criteria.andEqualTo("bedId",live.getBedId());
            }
            // 入驻协议
            if(!StringUtils.isEmpty(live.getLivePro())){
                    criteria.andEqualTo("livePro",live.getLivePro());
            }
            // 退住时间
            if(!StringUtils.isEmpty(live.getEndTime())){
                    criteria.andEqualTo("endTime",live.getEndTime());
            }
            // 退住协议
            if(!StringUtils.isEmpty(live.getEndPro())){
                    criteria.andEqualTo("endPro",live.getEndPro());
            }
            // 餐饮规格编号
            if(!StringUtils.isEmpty(live.getElId())){
                    criteria.andEqualTo("elId",live.getElId());
            }
            // 基础护理项编号
            if(!StringUtils.isEmpty(live.getNpId())){
                    criteria.andEqualTo("npId",live.getNpId());
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
        liveMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Live
     * @param live
     */
    @Override
    public void update(Live live){
        liveMapper.updateByPrimaryKey(live);
    }

    /**
     * 增加Live
     * @param live
     */
    @Override
    public void add(Live live){
        liveMapper.insert(live);
    }

    /**
     * 根据ID查询Live
     * @param id
     * @return
     */
    @Override
    public Live findById(Integer id){
        return  liveMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Live全部数据
     * @return
     */
    @Override
    public List<Live> findAll() {
        return liveMapper.selectAll();
    }
}
