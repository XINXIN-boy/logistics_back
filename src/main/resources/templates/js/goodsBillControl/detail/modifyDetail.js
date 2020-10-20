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
        success: function (result) {
            console.log(result);
            $.each(result.data, function (i, item) {
                let temp_id = '#' + i;
                $(temp_id).val(item);
            });

            // 审核
            if (result.ifAudit == true) {
                $("#ifAudit").attr('checked', 'checked');
                form.render('checkbox');
            }

            // 有效
            if (result.validity == true) {
                $("#validity").attr('checked', 'checked');
                form.render('checkbox');
            }

            // 结账
            if (result.ifSettleAccounts == true) {
                $("#ifSettleAccounts").attr('checked', 'checked');
                form.render('checkbox');
            }

            // 日期
            laydate.render({
                elem: '#sendGoodsDate',
                type: 'date',
                value: result.data.sendGoodsDate
                // theme: 'grid'
            });
            if (result.data.factDealDate != null && result.data.factDealDate !== '') {
                laydate.render({
                    elem: '#factDealDate',
                    type: 'date',
                    value: result.data.factDealDate
                    // theme: 'grid'
                });
            }
            laydate.render({
                elem: '#predeliveryDate',
                type: 'date',
                value:result.data.predeliveryDate
                // theme: 'grid'
            });
            laydate.render({
                elem: '#writeDate',
                type: 'date',
                value: result.data.writeDate
                // theme: 'grid'
            });
        }
    });

    form.on('submit(modifyGoodsBill)', function () {

        $("#goodsBillForm :input").each(function () {
            $(this).removeAttr("disabled");
        });

        $.ajax({
            type: 'post',
            url: '/goodsBill/updateGoodsBill.do?goodsBillCode=' + goodsBillCode,
            data: $("#goodsBillForm").serialize(),
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

    lay('.test-item').each(function () {
        laydate.render({
            elem: this,
            trigger: 'click'
        })
    });

    $.ajax({
        type: "get",
        url: "/customer/findAll.do?page=1&limit=10",
        success: function (result) {
            $.each(result.data, function (i, item) {
                let option = "<option value='" + item.customerCode + "'>";
                option += item.customerCode;
                option += "</option>";
                $("#sendGoodsCustomerNo").append(option);
                $("#receiveGoodsCustomerCode").append(option);
                form.render();
            });
        }

    });

    form.on('select(changeSend)', function (data) {
        // ajax
        $.ajax({
            type: 'get',
            url: '/customer/findCustomerByCode.do?customerCode=' + data.value,
            success: function (result) {
                $("#sendGoodsCustomer").val(result.data.customer);
                $("#sendGoodsCustomerTel").val(result.data.phone);
                $("#sendGoodsCustomerAddr").val(result.data.address);
            }
        });
    });

    form.on('select(changeSend2)', function (data) {
        // ajax
        $.ajax({
            type: 'get',
            url: '/customer/findCustomerByCode.do?customerCode=' + data.value,
            success: function (result) {
                $("#receiveGoodsCustomer").val(result.data.customer);
                $("#receiveGoodsCustomerTel").val(result.data.phone);
                $("#receiveGoodsCustomerAddr").val(result.data.address);
            }
        });
    });

});