package com.qf.api;

import com.qf.v16.common.pojo.ResultBean;

/**
 * @author yucan
 * @Date 2019/8/9
 */
public interface ISearchService {

    /***
     * 全景的数据同步
     * 将数据库的数据导入到索引库中（系统初始化，执行一次）
     * @return
     */
    public ResultBean synAllData();

    public ResultBean queryByKeywords(String keywords);

    public ResultBean updateById(Long id);
}
