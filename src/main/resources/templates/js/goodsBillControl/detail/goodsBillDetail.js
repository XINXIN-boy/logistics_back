layui.use(['element', 'form', 'laydate', 'layer', 'table'], function () {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table;
    let array = ['待发', '未到', '未结'];

    refresh(0);

    // 监听工具条
    table.on('tool(goodsBillTool)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        let data = obj.data; //获得当前行数据
        let layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        let tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'del'){ //删除
            layer.confirm('真的删除么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令
                $.ajax({
                    type: "get",
                    url:  "/goodsBill/updateDel.do?goodsBillCode=" + data.goodsBillId,
                    success: function (result) {
                        console.log(result);
                    }
                });
                layer.msg('删除成功', {
                    time: 800
                })
            });
        } else if(layEvent === 'edit'){ //编辑
            layer.open({
                type: 2,
                title: '货运单信息修改',
                content: [ 'modifyDetail.html?goodsBillId=' + data.goodsBillId ],
                area: [ '85%', '85%' ],
                shadeClose: true,
                move: false,
                end: function() {
                    table.reload('goodsBillTable1', {
                        url:'/goodsBill/findGoodsBillByEvent.do?eventName=' + array[0]
                    })
                }
            });
        }  else if (layEvent === 'detail') {
            layer.open({
                type: 2,
                title: '货运单详细信息',
                content: ['showDetail.html?goodsBillId=' + data.goodsBillId ],
                area: ['85%', '85%'],
                shadeClose: true,
                move: false,
            });
        }

    });

    element.on('tab(demo)', function (data) {

        refresh(data.index);

        // 监听工具条
    });

    function refresh(id) {
        table.render({
            elem: '#goodsBillTable' + (id + 1),
            height: 'full-170',
            url:  '/goodsBill/findGoodsBillByEvent.do?eventName=' + (id !== 3 ? array[id] : ''),
            limit: 10,
            limits: [10],
            request: {
                pageName: 'page' //页码的参数名称，默认：page
                , limitName: 'limit' //每页数据量的参数名，默认：limit
            },
            response: {
                statusName: 'code', //数据状态的字段名称，默认：code
                statusCode: 0, //成功的状态码，默认：0
                msgName: 'msg', //状态信息的字段名称，默认：msgz
                countName: 'count', //数据总数的字段名称，默认：count
                dataName: 'data' //数据列表的字段名称，默认：data
            },
            initSort: {
                field: 'occurTime' //排序字段，对应 cols 设定的各字段名
                ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
            },
            page: true //开启分页
            , cellMinWidth: 60
            , cols: [[
                {title: 'ID', fixed: 'left', type: 'numbers', align: 'center'},
                {field: 'goodsBillId', title: '货运单编号', align: 'center'},
                {field: 'eventName', title: '事件名称', align: "center"},
                {field: 'remark', title: '备注', align: 'center'},
                {field: 'occurTime', title: '发生时间', align: "center",sort: true },
                {fixed: 'right', title: "操作", align: "center", toolbar: '#barDemo' + (id+1), width: 200}
            ]]
        });
    }

});

function createTime(v){
    let dateTime;
    let date = new Date();
    date.setTime(v);
    let y = date.getFullYear();
    let m = date.getMonth() + 1;
    m = m < 10 ? '0' + m : m;
    let d = date.getDate();
    d = d < 10 ? "0" + d : d;
    dateTime = y + "-" + m + "-" + d;
    return dateTime;
}
