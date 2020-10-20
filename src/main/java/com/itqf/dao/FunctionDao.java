package com.itqf.dao;

import com.itqf.entity.Function;
import com.itqf.entity.Functionwithgroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/517:54
 * description:
 */
@Repository
public interface FunctionDao {

    void insertFunctionWithGroup(Functionwithgroup functionwithgroup);

    List<Function> findFunction(String loginId);

    List<Function> findAllFunctoin();

    List<Function> findFunctionByGroupId(int groupId);

    Functionwithgroup findByFunctionIdAndGroupId(@Param("functionid") int functionid , @Param("groupId") int groupId);



}
