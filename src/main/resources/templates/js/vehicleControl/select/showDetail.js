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
        async: false,
        success: function (result) {
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
                    value:result.data.arriveTime
                    // theme: 'grid'
                });
            }
        }

    });

});