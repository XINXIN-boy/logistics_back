layui.use(['element', 'form', 'laydate', 'jquery', 'layer', 'table'], function() {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table,
        $ = layui.jquery;

    let goodsRevertBillCode = window.location.href.split("=")[1];
    $.ajax({
        type: "get",
        url: "/vehicle/findCargoReceiptBygoodsRevertBillCode.do?goodsRevertBillCode=" + goodsRevertBillCode,
        success: function (result) {
            console.log(result);
            $.each(result.data, function (i, item) {
                let temp_id = '#' + i;
                $(temp_id).val(item);
            });

            // 日期
            laydate.render({
                elem: '#signTime',
                type: 'date',
                value: result.data.signTime
                // theme: 'grid'
            });
            if (result.startCarryTime != null && result.startCarryTime !== '') {
                laydate.render({
                    elem: '#startCarryTime',
                    type: 'date',
                    value: result.data.startCarryTime
                    // theme: 'grid'
                });
            }
            if (result.arriveTime != null && result.arriveTime !== '') {
                laydate.render({
                    elem: '#arriveTime',
                    type: 'date',
                    value: result.data.arriveTime
                    // theme: 'grid'
                });
            }
        }
    });

    form.on('submit(update)', function () {

        $("#cargoReceiptForm :input").each(function () {
            $(this).removeAttr("disabled");
        });

        $("#arriveTime").attr("disabled", "disabled");

        $.ajax({
            type: 'post',
            url: '/vehicle/updateCargoreceipt.do',
            data: $("#cargoReceiptForm").serialize(),
            dataType: "json",
            success: function (result) {
                console.log(result);
                if (result.code == 0) {
                    layer.msg('更新成功', {
                        time: 800,
                        icon: 1
                    }, function () {
                        let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    });
                } else {
                    layer.msg('更新失败', {
                        time: 800,
                        icon: 2
                    });
                }
            }

        });
        return false;
    });
    form.on('submit(send)', function () {

        $("#cargoReceiptForm :input").each(function () {
            $(this).removeAttr("disabled");
        });

        $("#arriveTime").attr("disabled", "disabled");

        $.ajax({
            type: 'get',
            url: '/vehicle/submitCargoreceipt.do',
            data: $("#cargoReceiptForm").serialize(),
            dataType: "json",
            success: function (result) {
                console.log(result);
                if (result.code  === 0) {
                    layer.msg('发货成功', {
                        time: 800,
                        icon: 1
                    }, function () {
                        let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    });
                } else {
                    layer.msg('发货失败', {
                        time: 800,
                        icon: 2
                    });
                }
            }

        });
        return false;
    });

    lay('.test-item').each(function () {
        laydate.render({
            elem: this,
            trigger: 'click'
        })
    });

});