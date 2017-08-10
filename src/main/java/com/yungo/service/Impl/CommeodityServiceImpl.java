package com.yungo.service.Impl;

import com.yungo.dao.CommodityMapper;
import com.yungo.entity.Commodity;
import com.yungo.service.CommodityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cx on 17-8-3.
 */
@Service("commeodityService")
public class CommeodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper mapper;
    @Override
    public List<Commodity> findAll() {
        return mapper.findAll();
    }

    @Override
    public Commodity findById(int id) {
        return mapper.findById(id);
    }
}
