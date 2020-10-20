layui.use(['element', 'form', 'laydate', 'layer', 'table'], function() {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table;

    element.on('tab(groupFilter)', function(data){
        if (data.index === 1) {
            table.render({
                elem: '#groupTable',
                height: 'full-170',
                url: '/user/findAllUserGroup.do', //数据接口
                limit: 10,
                limits: [ 10 ],
                request: {
                    pageName: 'page', //页码的参数名称，默认：page
                    limitName: 'limit' //每页数据量的参数名，默认：limit
                },
                response: {
                    statusName: 'code', //数据状态的字段名称，默认：code
                    statusCode: 0, //成功的状态码，默认：0
                    msgName: 'msg', //状态信息的字段名称，默认：msg
                    countName: 'count', //数据总数的字段名称，默认：count
                    dataName: 'data' //数据列表的字段名称，默认：data
                },
                page: true //开启分页
                ,cellMinWidth: 80
                ,cols: [[
                    { title: 'ID', fixed: 'left', sort: true, type: 'numbers' },
                    { field: 'groupName', title: '用户组名', sort: true },
                    { field: 'description', title: '用户组描述', width: 900 },
                    { fixed: 'right', title:"操作", align:"center", toolbar: '#barDemo' }
                ]]
            });

            // 监听工具条
            table.on('tool(groupTool)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                let data = obj.data; //获得当前行数据
                let layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                // let tr = obj.tr; //获得当前行 tr 的DOM对象

                if(layEvent === 'del'){ //删除
                    layer.confirm('真的删除么', function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        $.ajax({
                            type: "get",
                            url: "/user/deleteUserGroup.do?id=" + data.id,
                            success: function (result) {
                                console.log(result);
                            }

                        });
                        layer.msg('删除成功', {
                            time: 800,
                            icon: 1
                        }, function () {
                            table.reload('groupTable', {
                                url: '/user/findAllUserGroup.do?page=1&limit=10'
                            })
                        });

                    });
                } else if (layEvent === 'edit') { //编辑
                    layer.open({
                        type: 2,
                        title: '用户组信息修改',
                        content: [ 'userGroupModify.html?id=' + data.id, 'no' ],
                        area: [ '75%', '75%' ],
                        shadeClose: true,
                        move: false,
                        end: function() {
                            table.reload('groupTable', {
                                url:'/user/findAllUserGroup.do?page=1&limit=10'
                            })
                        }
                    });
                }
            });
        } else if (data.index === 2) {
            let groupId = $("#groupId");
            groupId.empty();
            groupId.append('<option value="">请选择用户组</option>');
            $.ajax({
                type: 'get',
                url: '/user/findAllUserGroup.do?page=1&limit=10',
                dataType: 'json',
                async: false,
                success: function (result) {
                    $.each(result.data, function (i, item) {
                        let option = '<option value="' + item.id + '">';
                        option += item.groupName;
                        option += '</option>';
                        $("#groupId").append(option);
                    });
                    form.render('select');
                }
            });
            let check = $("#check");
            check.empty();
            $.ajax({
                type: 'get',
                url: '/function/findAllFunctoin.do',
                dataType: 'json',
                async: false,
                success: function (result) {
                    console.log(result);
                    $.each(result.data, function (i, item) {
                        let content = '<input type="checkbox" id="' + item.id + '" name="' + item.id + '" lay-skin="primary" title="' + item.pageName + '">';
                        $("#check").append(content);
                        form.render('checkbox')
                    });
                }
            });

            form.on('select(changeGroup)', function (data) {

                for (let i = 1; i < 13; i++) {
                    $("#" + i).removeAttr('checked');
                }
                form.render();
                $.ajax({
                    type: 'get',
                    url:'/function/findFunctionByGroupId.do?groupId=' + data.value,
                    dataType: 'json',
                    async: false,
                    success: function (result) {
                        console.log(result);
                        $.each(result.data, function (i, item) {
                            let itemId = '#' + item.id;
                            $(itemId).attr('checked', 'checked');
                        })
                    }
                });
                form.render();
            });
        }
    });

    form.on('submit(addGroup)', function () {
        $.ajax({
            type: "post",
            url:  "/user/addUserGroup.do",
            data: $("#empForm").serialize(),
            success: function (result) {
                console.log(result);
                if (result.code ==0) {
                    layer.msg('用户组添加成功', {
                        time: 800
                    });
                    $("#resetForm").click();
                } else {
                    layer.msg(result.msg, {
                        time: 800
                    });
                }
            }

        });
        return false;
    });

    form.on('submit(addFunc)', function () {
        let data = $("#functionForm").serialize();
        console.log(data);
        let array = [];
        for (let i = 1; i < 13; i++) {
            let condition = $("#" + i).is(":checked");
            if (condition) {
                array.push(i);
            }
        }
        console.log(array);
        $.ajax({
            type: 'post',
            url: '/function/updateFunctionWithGroup.do',
            traditional:true,
            data: {
                'groupId': $("#groupId").val(),
                'array': array
            },
            dataType: 'json',
            async: false,
            success: function (result) {
                if (result.data == 0) {
                    layer.msg('添加成功')
                }
            }
        });
        return false;
    });
});