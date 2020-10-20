package com.itqf.service.impl;

import com.itqf.commen.JsonMessage;
import com.itqf.dao.FunctionDao;
import com.itqf.entity.Function;
import com.itqf.entity.Functionwithgroup;
import com.itqf.service.FunctionService;
import com.itqf.vo.VoGroupWithFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/517:48
 * description:
 */
@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionDao functionDao ;

    @Transactional
    @Override
    public int insertNewFunction(VoGroupWithFunction voGroupWithFunction) {


        return 0;
    }

    @Transactional
    @Override
    public void updateFunctionWithGroup(int groupId, int[] array) {

        List<Integer> list = new LinkedList<>();
        for (int i : array) {
            list.add(i);
        }

        List<Function> allFunctoin = functionDao.findAllFunctoin();

        for (Integer functionid : list) {
            if (functionDao.findByFunctionIdAndGroupId(functionid,groupId) == null) {

                Functionwithgroup functionwithgroup = new Functionwithgroup();
                functionwithgroup.setFunctionId(functionid);
                functionwithgroup.setGroupId(groupId);
                functionDao.insertFunctionWithGroup(functionwithgroup);
            }
        }
    }

    @Override
    public List<Function> findFunction(String loginId) {

      List<Function>  list =  functionDao.findFunction(loginId) ;

        return list;
    }

    @Override
    public JsonMessage findAllFunctoin() {
        JsonMessage jsonMessage = new JsonMessage();
        List<Function> list = functionDao.findAllFunctoin();
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setData(list);
            jsonMessage.setMsg("查询成功！");
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("查询失败！");
        }
        return jsonMessage;
    }

    @Override
    public JsonMessage findFunctionByGroupId(int groupId) {
        JsonMessage jsonMessage = new JsonMessage();
        List<Function> list = functionDao.findFunctionByGroupId(groupId);
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setData(list);
            jsonMessage.setMsg("查询成功！");
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("查询失败！");
        }
        return jsonMessage;
    }
}
