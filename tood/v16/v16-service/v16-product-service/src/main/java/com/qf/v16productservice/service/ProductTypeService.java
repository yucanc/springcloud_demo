package com.qf.v16productservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.v16.api.IProductTypeService;
import com.qf.v16.common.base.BaseServiceImpl;
import com.qf.v16.common.base.IBaseDao;
import com.qf.v16.entity.TProductType;
import com.qf.v16.mapper.TProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yucan
 * @Date 2019/8/9
 */
@Service
public class ProductTypeService extends BaseServiceImpl<TProductType> implements IProductTypeService {

    @Autowired
    private TProductTypeMapper productTypeMapper;

    @Override
    public IBaseDao<TProductType> getBaseDao() {
        return null;
    }
}
