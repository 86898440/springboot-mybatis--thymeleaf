package com.yungo.service;

import com.yungo.entity.Commodity;
import java.util.List;

/**
 * Created by cx on 17-8-3.
 */
public interface CommodityService {
    List<Commodity> findAll();
    Commodity findById(int id);
}
