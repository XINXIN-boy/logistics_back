package com.itqf.service;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Function;
import com.itqf.vo.VoGroupWithFunction;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/517:47
 * description:
 */
public interface FunctionService {

    int insertNewFunction(VoGroupWithFunction voGroupWithFunction);


    void updateFunctionWithGroup(int groupId, int[] array);

    List<Function> findFunction(String loginId);

    JsonMessage findAllFunctoin();

    JsonMessage findFunctionByGroupId(int groupId);


}
