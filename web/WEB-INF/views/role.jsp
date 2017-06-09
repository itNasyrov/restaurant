<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Role</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <%--<script src="js/jquery.min.js" type="text/javascript"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<script type="text/javascript">
    var service = '/role';
    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + "/get/id/" + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
    var RestPut = function (client_name) {
        var JSONObject = {
            'name': client_name
        };
        $.ajax({
            type: 'PUT',
            url: service + "/add",
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
    var RestPost = function () {
        var JSONObject = {
            'id': $('#putId').val(),
            'name': $('#putName').val()
           // 'description': $('#putDescription').val()
        };
        $.ajax({
            type: 'POST',
            url: service + "/update",
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
            datatype: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + "/delete/" + id,
            datatype: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

</script>

<div class="panel panel-default">
    <div class="panel-heading">
        REST API For Roles
    </div>

    <div class="panel-body">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Get all roles</td>
                <td><code><strong>GET</strong>/role/all</code></td>
                <td>
                    <button type="button" onclick="RestGetAll()">Try</button>
                </td>
            </tr>
            <tr>
                <td>Get role by id</td>
                <td>
                    id: <input id="getRoleId" value=""/>
                    <button type="button" onclick="RestGet($('#getRoleId').val())">Try</button>
                </td>
            </tr>
            <tr>
                <td>Add role</td>
                <td><code><strong>PUT</strong>/role/add</code></td>
                <td>
                    <form class="form-inline">
                        name: <input type="text" id="postName" value="roleName"/>
                        <button type="button" onclick="RestPut($('#postName').val())">Try
                        </button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Update role</td>
                <td><code>POST</code>/role/update</td>
                <td>
                    <form class="form-inline">
                        id: <input type="text" id="putId" value="roleId"/>
                        <br>
                        name: <input type="text" id="putName" value="roleName"/>
                        <br>
                        <button type="button" onclick="RestPost()">Try</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Delete role by id</td>
                <td><code><strong>DELETE</strong>/role/delete/{id}</code></td>
                <td>
                    Id: <input id="RoleIdForDelete" value=""/>
                    <button type="button" onclick="RestDelete($('#RoleIdForDelete').val())">Try</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <strong>RESPONSE</strong>
        </div>
        <div class="panel-body" id="response"></div>
    </div>
</div>
</body>
</html>
