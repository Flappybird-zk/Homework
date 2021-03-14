<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: suker
  Date: 2021/3/14
  Time: 9:21 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理系统-首页</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!--自定义css-->
    <link href="${pageContext.request.contextPath}/resources/css/my.css" rel="stylesheet"/>

</head>
<body>
<div class="container">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">员工管理</a></li>
            <li><a href="#">首页</a></li>
        </ol>
    </div>
    <div class="row margin-bottom-1">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-employee-modal">新增员工</button>
    </div>
    <!--员工列表-->
    <div class="row">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>员工号</th>
                <th>姓名</th>
                <th>部门</th>
                <th>职位</th>
                <th>入职时间</th>
                <th>联系方式</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employeeList}" var="employee">
                <tr>
                    <td>${employee.empId}</td>
                    <td>${employee.empName}</td>
                    <td>${employee.department.deptName}</td>
                    <td>${employee.jobName}</td>
                    <td><fmt:formatDate value="${employee.joinDate}" pattern="yyyy-MM-dd"/></td>
                    <td>${employee.telephone}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <!--添加员工模态框-->
    <div class="modal fade" id="add-employee-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">新增员工</h4>
                </div>
                <div class="modal-body">
                    <form id="add-employee-form" action="/employee/add" method="post">
                        <div class="form-group">
                            <label for="emp-name" class="control-label">姓名:</label>
                            <input type="text" class="form-control" id="emp-name" name="empName" required />
                        </div>
                        <div class="form-group">
                            <label class="control-label">部门:</label>
                            <select class="form-control" name="deptId" id="dept-id">
                                <option value="-1" selected >--请选择--</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="job-name" class="control-label">职位:</label>
                            <input type="text" class="form-control" id="job-name" name="jobName" />
                        </div>
                        <div class="form-group">
                            <label for="join-date" class="control-label">入职日期:</label>
                            <input type="text" class="form-control" id="join-date" name="joinDate" required/>
                        </div>

                        <div class="form-group">
                            <label for="telephone" class="control-label">联系方式:</label>
                            <input type="text" class="form-control" id="telephone" name="telephone" required/>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="add-employee-submit">提交</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<!--自定义js-->
<script src="${pageContext.request.contextPath}/resources/js/my.js">
</script>
</html>
