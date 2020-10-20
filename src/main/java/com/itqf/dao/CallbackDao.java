package com.itqf.dao;

import com.itqf.entity.Callbackinfo;
import org.springframework.stereotype.Repository;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/1718:53
 * description:
 */
@Repository
public interface CallbackDao {
    Callbackinfo findByGoodsBillIdAndType(Callbackinfo callbackinfo);

}
