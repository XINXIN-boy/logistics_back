layui.use(['element', 'form', 'laydate', 'layer', 'table'], function() {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table;

    let employeeCode = window.location.href.split("=")[1];
    $.ajax({
        type: "get",
        url: "/employee/findEmployeeByCode.do?employeeCode=" + employeeCode,
        success: function (result) {
            $("#employeeCode").val(result.data.employeeCode);
            $("#employeeName").val(result.data.employeeName);
            $("#department").val(result.data.department);
            $("#position").val(result.data.position);
            form.render('select');
            $(":radio[name='gender'][value='" + result.data.gender + "']").prop("checked", "checked");
            form.render("radio");
            laydate.render({
                elem: '#birthday',
                type: 'date',
                value: new Date(result.data.birthday)
                // theme: 'grid'
            });

        }
    });
    
    $("#modifyEmp").click(function (){
        $.ajax({
            type: "post",
            url:  "/employee/updateEmployee.do?employeeCode=" + employeeCode,
            data: $("#empForm").serialize(),
            dataType: "json",
            success: function (result) {
                console.log(result);
                if (result.code ==0) {
                    layer.msg('更新成功', {
                        time: 800
                    }, function () {
                        let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    });
                }
            }
        });
    })



});