package com.cqp.service.provider;

import com.cqp.mapper.IllHistoryMapper;
import com.cqp.model.IllHistory;
import com.cqp.service.api.IllHistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:IllHistory业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class IllHistoryServiceImpl implements IllHistoryService {

    @Autowired
    private IllHistoryMapper illHistoryMapper;


    /**
     * IllHistory条件+分页查询
     * @param illHistory 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<IllHistory> findPage(IllHistory illHistory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(illHistory);
        //执行搜索
        return new PageInfo<IllHistory>(illHistoryMapper.selectByExample(example));
    }

    /**
     * IllHistory分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<IllHistory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<IllHistory>(illHistoryMapper.selectAll());
    }

    /**
     * IllHistory条件查询
     * @param illHistory
     * @return
     */
    @Override
    public List<IllHistory> findList(IllHistory illHistory){
        //构建查询条件
        Example example = createExample(illHistory);
        //根据构建的条件查询数据
        return illHistoryMapper.selectByExample(example);
    }


    /**
     * IllHistory构建查询对象
     * @param illHistory
     * @return
     */
    public Example createExample(IllHistory illHistory){
        Example example=new Example(IllHistory.class);
        Example.Criteria criteria = example.createCriteria();
        if(illHistory!=null){
            // id
            if(!StringUtils.isEmpty(illHistory.getIhId())){
                    criteria.andEqualTo("ihId",illHistory.getIhId());
            }
            // 老人id
            if(!StringUtils.isEmpty(illHistory.getOpId())){
                    criteria.andEqualTo("opId",illHistory.getOpId());
            }
            // 疾病
            if(!StringUtils.isEmpty(illHistory.getIhDis())){
                    criteria.andEqualTo("ihDis",illHistory.getIhDis());
            }
            // 是否痊愈
            if(!StringUtils.isEmpty(illHistory.getIhCure())){
                    criteria.andEqualTo("ihCure",illHistory.getIhCure());
            }
            // 复发可能
            if(!StringUtils.isEmpty(illHistory.getRecurPos())){
                    criteria.andEqualTo("recurPos",illHistory.getRecurPos());
            }
            // 注意事项
            if(!StringUtils.isEmpty(illHistory.getIhAttention())){
                    criteria.andEqualTo("ihAttention",illHistory.getIhAttention());
            }
            // 记录人
            if(!StringUtils.isEmpty(illHistory.getIhRec())){
                    criteria.andEqualTo("ihRec",illHistory.getIhRec());
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
        illHistoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改IllHistory
     * @param illHistory
     */
    @Override
    public void update(IllHistory illHistory){
        illHistoryMapper.updateByPrimaryKey(illHistory);
    }

    /**
     * 增加IllHistory
     * @param illHistory
     */
    @Override
    public void add(IllHistory illHistory){
        illHistoryMapper.insert(illHistory);
    }

    /**
     * 根据ID查询IllHistory
     * @param id
     * @return
     */
    @Override
    public IllHistory findById(Integer id){
        return  illHistoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询IllHistory全部数据
     * @return
     */
    @Override
    public List<IllHistory> findAll() {
        return illHistoryMapper.selectAll();
    }
}
