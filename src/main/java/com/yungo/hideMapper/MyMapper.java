package com.yungo.hideMapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by cx on 17-8-3.
 */
    public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
        //TODO
        //FIXME 特别注意，该接口不能被扫描到，否则会出错

}
