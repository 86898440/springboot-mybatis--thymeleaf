package com.yungo.dao;

import com.yungo.entity.Commodity;
import com.yungo.hideMapper.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Created by cx on 17-8-3.
 */
public interface CommodityMapper extends MyMapper{
    List<Commodity> findAll();

    Commodity findById(@Param("id") int id);
}
