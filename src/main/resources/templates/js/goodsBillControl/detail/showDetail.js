layui.use(['element', 'form', 'laydate', 'jquery', 'layer', 'table'], function() {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table,
        $ = layui.jquery;

    let goodsBillCode = window.location.href.split("=")[1];
    $.ajax({
        type: "get",
        url: "/goodsBill/findGoodsBillByCode.do?goodsBillCode=" + goodsBillCode,
        async: false,
        success: function (result) {
            $.each(result.data, function (i, item) {
                let temp_id = '#' + i;
                $(temp_id).val(item);
            });

            // 审核
            if (result.data.ifAudit == true) {
                $("#ifAudit").attr('checked', 'checked');
                form.render('checkbox');
            }

            // 有效
            if (result.data.validity == true) {
                $("#validity").attr('checked', 'checked');
                form.render('checkbox');
            }

            // 结账
            if (result.data.ifSettleAccounts == true) {
                $("#ifSettleAccounts").attr('checked', 'checked');
                form.render('checkbox');
            }

            // 日期
            laydate.render({
                elem: '#sendGoodsDate',
                type: 'date',
                value:result.data.sendGoodsDate
                // theme: 'grid'
            });
            laydate.render({
                elem: '#predeliveryDate',
                type: 'date',
                value:result.data.predeliveryDate
                // theme: 'grid'
            });
            if (result.data.factDealDate != null && result.data.factDealDate !== '') {
                laydate.render({
                    elem: '#factDealDate',
                    type: 'date',
                    value:result.data.factDealDate
                    // theme: 'grid'
                });
            }

            laydate.render({
                elem: '#writeDate',
                type: 'date',
                value: result.writeDate
                // theme: 'grid'
            });
        }

    });

});