layui.use(['element', 'form', 'laydate', 'layer', 'table', 'jquery'], function() {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table,
        $ = layui.jquery;

    lay('.test-item').each(function () {
        laydate.render({
            elem: this,
            trigger: 'click'
        })
    });

    laydate.render({
        elem: '#writeDate',
        value: new Date()
    });

    laydate.render({
        elem: '#sendGoodsDate',
        value: new Date()
    });

    let employeeId = $.cookie('loginId');
    $("#writeBillPerson").val(employeeId);
    $("#employeeCode").val(employeeId);

    $.ajax({
        type: "get",
        url: "/customer/findAll.do?page=1&limit=10",
        async: false,
        success: function (result) {
            $.each(result.data, function (i, item) {
                let option = "<option value='" + item.customerCode+ "'>";
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

    form.on('switch(checkSettle)', function(data){
        if (data.elem.checked === true) {
            $("#ifSettleAccounts").val('true');
        } else {
            $("#ifSettleAccounts").val('false');
        }
        // form.render();
    });

    // 货运单信息添加
    // $("#addGoodsBill").click(function () {
    form.on('submit(addGoodsBill)', function () {

        $("#goodsBillForm :input").each(function () {
            $(this).removeAttr("disabled");
        });
        $("#factDealDate").attr("disabled", "disabled");
        $("#transferFee").attr("disabled", "disabled");
        $("#moneyOfChangePay").attr("disabled", "disabled");

        $.ajax({
            type: "post",
            url:  "/goodsBill/addGoodsBill.do",
            data: $("#goodsBillForm").serialize(),
            dataType: "json",
            async: false,
            success: function (result) {
                if (result.code == 0) {
                    layer.msg('货运单添加成功', {
                        time: 800,
                        icon: 1
                    });
                    layer.open({
                        type: 2,
                        title: '货运单编号：' + result.data,
                        content: [ 'editGoods.html?id=' + result.data, 'no' ],
                        area: [ '85%', '85%' ],
                        shadeClose: true,
                        move: false
                    });
                    $("#resetForm").click();
                } else {
                    layer.msg('货运单添加失败', {
                        time: 800,
                        icon: 2
                    });
                }
                console.log(result.data);
            }
        });
        return false;
    });

});