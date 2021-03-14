// 重置添加员工表单中各信息值
function init_employee_form(){
    $("#emp-name, #job-name, #telephone, #join-date").val("");
    $("#dept-id").html("<option value=\"-1\" selected >--请选择--</option>");
}

//ajax查询部门信息追加至部门选择
function append_dept_html(){
    $.get("/dept/all", function (data) {
        let select = $("#dept-id");
        for (let i = 0; i < data.length; i++) {
            let option = $("<option></option>");
            option.html(data[i].deptName);
            option.attr("value", data[i].deptId);
            select.append(option);
        }
    });
}

// 模态框显示出来后触发事件
$('#add-employee-modal').on('shown.bs.modal', function () {
    init_employee_form();
    append_dept_html();
});

// 点击提交按钮后提交表单信息
$("#add-employee-submit").click(function(){
    $("#add-employee-form").submit();
});