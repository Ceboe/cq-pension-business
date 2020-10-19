package com.cqp.service.provider;

import com.cqp.mapper.RoomMapper;
import com.cqp.model.Room;
import com.cqp.service.api.RoomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Room业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;


    /**
     * Room条件+分页查询
     * @param room 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Room> findPage(Room room, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(room);
        //执行搜索
        return new PageInfo<Room>(roomMapper.selectByExample(example));
    }

    /**
     * Room分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Room> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Room>(roomMapper.selectAll());
    }

    /**
     * Room条件查询
     * @param room
     * @return
     */
    @Override
    public List<Room> findList(Room room){
        //构建查询条件
        Example example = createExample(room);
        //根据构建的条件查询数据
        return roomMapper.selectByExample(example);
    }


    /**
     * Room构建查询对象
     * @param room
     * @return
     */
    public Example createExample(Room room){
        Example example=new Example(Room.class);
        Example.Criteria criteria = example.createCriteria();
        if(room!=null){
            // id
            if(!StringUtils.isEmpty(room.getRoomId())){
                    criteria.andEqualTo("roomId",room.getRoomId());
            }
            // 对应楼层id
            if(!StringUtils.isEmpty(room.getFloId())){
                    criteria.andEqualTo("floId",room.getFloId());
            }
            // 房号
            if(!StringUtils.isEmpty(room.getRoomNum())){
                    criteria.andEqualTo("roomNum",room.getRoomNum());
            }
            // 房间类型
            if(!StringUtils.isEmpty(room.getRoomType())){
                    criteria.andEqualTo("roomType",room.getRoomType());
            }
            // 是否向阳
            if(!StringUtils.isEmpty(room.getRoomSun())){
                    criteria.andEqualTo("roomSun",room.getRoomSun());
            }
            // 是否特护
            if(!StringUtils.isEmpty(room.getRoomSpe())){
                    criteria.andEqualTo("roomSpe",room.getRoomSpe());
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
        return roomMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Room
     * @param room
     */
    @Override
    public int update(Room room){
        return roomMapper.updateByPrimaryKey(room);
    }

    /**
     * 增加Room
     * @param room
     */
    @Override
    public int add(Room room){
        return roomMapper.insert(room);
    }

    /**
     * 根据ID查询Room
     * @param id
     * @return
     */
    @Override
    public Room findById(Integer id){
        return  roomMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Room全部数据
     * @return
     */
    @Override
    public List<Room> findAll() {
        return roomMapper.selectAll();
    }
}
