package com.itqf.controller;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Function;
import com.itqf.service.FunctionService;
import com.itqf.vo.VoGroupWithFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/517:45
 * description:
 */
@RestController
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private FunctionService functionService ;



    /**
     * 有bug
     * @param voGroupWithFunction
     * @return
     */
    @RequestMapping("/addNewFunction.do")
    public JsonMessage addNewFunction(VoGroupWithFunction voGroupWithFunction){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            functionService.insertNewFunction(voGroupWithFunction);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
        } catch (Exception e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage;
    }

    @RequestMapping("updateFunctionWithGroup.do")
    public JsonMessage updateFunctionWithGroup(@RequestParam("groupId") int groupId, @RequestParam("array") int[] array){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            functionService.updateFunctionWithGroup(groupId , array) ;
            jsonMessage.setCode(0);
            jsonMessage.setMsg("更新成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("更新失败！");
        }


        return jsonMessage ;
    }



    @RequestMapping("/findAllFunctoin.do")
    public JsonMessage findAllFunctoin(){
        JsonMessage jsonMessage = functionService.findAllFunctoin();
        return jsonMessage;
    }

    @RequestMapping("/findFunctionByGroupId.do")
    public JsonMessage findFunctionByGroupId(int groupId){
        JsonMessage jsonMessage = functionService.findFunctionByGroupId(groupId);
        return jsonMessage;
    }

    @RequestMapping("/findFunction.do")
    public JsonMessage findFunction(String loginId){
        JsonMessage jsonMessage = new JsonMessage();
        List<Function> list = functionService.findFunction(loginId);

       if (list!= null && list.size()>0 ){
           jsonMessage.setCode(0);
           jsonMessage.setData(list);
       }else {
           jsonMessage.setCode(1);
           jsonMessage.setMsg("没有权限");
       }
        return jsonMessage;
    }


}
