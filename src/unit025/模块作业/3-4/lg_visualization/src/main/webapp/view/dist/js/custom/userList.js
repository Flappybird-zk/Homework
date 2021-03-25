var prePage=  0; //当前页的前一页
var nextPage = 0; //当前页的后一页
var isFirstPage=false; //是否为首页
var isLastPage=false; //是否为尾也

//1.页面加载,调用一个分页查询一页数据的方法
$(function(){
    findByPage(1);  //页面初始化查询第一页数据.
})

//2.查询后台的数据,动态展示的方法
function findByPage(pageNum){
    //每次查询的时候都会生成新的tr  li ,所以方法之前要清空这两项
    $("tbody tr").remove();
    $("li[name='myli']").remove();

    //2.1 发送ajax请求,查询后台的数据
    $.post("/lg_visualization/user/list.do","pageNum="+pageNum+"&pageSize=10", function(data){
        //初始化成员
        prePage = data.data.prePage;
        nextPage = data.data.nextPage;
        isFirstPage = data.data.isFirstPage;
        isLastPage = data.data.isLastPage;

        //2.2 获取到查询到的一页数据list,循环生成  tr td ,把数据嵌套到tr td, 放到tbody
        var list = data.data.list;
        //2.3循环查到的一页用户数据
        for(var i=0; i<list.length; i++){
            var $tr = $("<tr>\n" +
                "   <th>"+list[i].id+"</th>\n" +
                "    <th>"+list[i].username+"</th>\n" +
                "    <th>"+list[i].email+"</th>\n" +
                "    <th>"+list[i].phone+"</th>\n" +
                "    <th>"+list[i].createTime+"</th>\n" +
                "    <th>"+list[i].updateTime+"</th>\n" +
                "    <th><a href='javascript:void(0)' class='text-inverse pr-10' title='Edit' data-toggle='modal' data-target='#editUserModal' onclick='showEditUser("+list[i].id+")'><i class=\"zmdi zmdi-edit txt-warning\"></i></a>" +
                "<a href='javascript:void(0)' class='text-inverse' title='Delete' data-toggle='tooltip' onclick='deleteById("+list[i].id+")'><i class='zmdi zmdi-delete txt-danger'></i></a></th>\n" +
                "    </tr>");
            $("tbody").append($tr);
        }

        //3.动态生成页码
        var totalPage =  data.data.pages;
        for(var i = 0 ; i < totalPage ; i++){
            var $li = $("<li name='myli'><a href='#' onclick='findByPage("+(i+1)+")'>"+(i+1)+"</a></li>");
            //所以要把li标签添加到页面
            $("li:last").before($li);
            //判断当前页是那一页
            if(data.data.pageNum == (i+1)){
                $li.prop("class","active");
            }
        }

    } ,"json")
}

//点击向左的方法
function left(){
    //1.判断当前页是否为首页,如果是首页,return停止方法
    if(isFirstPage){
        return;
    }
    //2.如果不是首页,调用findByPage(前一页)
    findByPage(prePage)

}

//点击向右的方法
function right(){
    //1.判断当前页是否为尾页,如果是首页,return停止方法
    if(isLastPage){
        return;
    }

    //2.如果不是尾页,调用findByPage(后一页)
    findByPage(nextPage)
}


//添加用户的方法
function save(){
    //获取数据
    var name = $("#addName").val();
    var pwd = $("#addPwd").val();
    var pwd2 = $("#addPwd2").val();
    var email = $("#addEmail").val();
    var phone = $("#addPhone").val();

    if(pwd != pwd2){
        $("#errMsg").html("两次密码不一致");
    }

    $.post("/lg_visualization/user/add.do",{"username":name,"password":pwd,"email":email,"phone":phone},function(data){
        if(data.status == 0){
            alert("添加成功");
            location.reload();
        }else{
            alert("添加失败 "+data.msg)
        }
    })
}

//删除用户
function deleteById(id){
    //1.询问用户是否确认删除
    var flag =  window.confirm("您是否确认删除?");
    if(!flag){
        return;
    }
    //2.发送ajax请求删除后台数据,参数id
    $.post("/lg_visualization/user/deleteUser.do","id="+id,function(data){
        if(data.status == 0){
            location.reload();
        }
    },"json")
}

// 显示修改的用户信息
function showEditUser(userId){
    $.post("/lg_visualization/user/info.do", "id=" + userId, function (data) {
        $("#editUserId").val(userId);
        $("#editUsername").val(data.data.username);
        $("#editEmail").val(data.data.email);
        $("#editPhone").val(data.data.phone);
    }, "json");
};

/**
 * 显示检测用户信息
 * @param msg
 * @param type
 */
function editUserTip(content, msgType="success", heading=""){
    var msgMap = {"success": "#4aa23c", "info": "#fd7397", "warning": "#f8b32d", "error": "#f33923"};
    if(!(msgType in msgMap)) msgType = "success";
    $.toast({
        // heading: heading,
        text: content,
        position: "top-center",
        loaderBg: msgMap[msgType],
        icon: msgType,
        allowToastClose: false,
        hideAfter: 1500,
        stack: 6
    });
};

/**
 * 更新用户信息
 */
$("#editUserSave").click(function(){
    //获取数据
    var user = {
        "id": $("#editUserId").val(),
        "username": $("#editUsername").val(),
        "email": $("#editEmail").val(),
        "phone": $("#editPhone").val()
    };
    var patternPhone = /^(13[0-9]|14[5|7|9]|15[1|2|3|5|6|7|8|9]|17[1|2|3|5|6|7|8]|18[0-9]|19[1|8|9])\d{8}$/,
        patternEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if (!patternEmail.test(user.email)) {
        editUserTip("邮箱格式不可用", "error");
        return;
    }
    if (!patternPhone.test(user.phone)) {
        editUserTip("手机号码格式不可用", "error");
        return;
    }
    $.post("/lg_visualization/user/editUser.do", user, function (data) {
        if (data.status == 0) {
            editUserTip(data.msg);
            setTimeout("location.reload()", 2000);
        } else {
           editUserTip(data.msg, "error");
        }
    })
});