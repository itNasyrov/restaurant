<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <%--<link ref="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="css/bootstrap.min.css">
<body>
<script type="text/javascript">
    var service = "/document";
    var RestGet = function (id) {
        $.ajax({
                type: 'GET',
                url: service + '/get/id/' + id,
                datatype: 'json',
                async: false,
            success: function (result) {
                    $('#response').html(JSON.stringify(result));
                },
                error: function (jqXHR, textstatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            }
        );
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
                error: function (jqXHR, textstatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            }
        );
    };
    var RestPut = function (name) {
        var JSONObject = {
            'name': name
        };
        $.ajax({
                type: 'PUT',
                url: service + '/add',
                contentType: "application/json;charset=utf-8",
                datatype: 'json',
                async: false,
                data: JSON.stringify(JSONObject),
            success: function (result) {
                    $('#response').html(JSON.stringify(result));
                },
                error: function (jqXHR, textstatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            }
        );
    };
</script>
<div class="panel panel-default">
    <div class="panel-heading">
        REST API FOR DOCUMENTS
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
                <td>Get all documents</td>
                <td><code><strong>Get</strong>document/all</code></td>
                <td>
                    <button type="button" onclick="RestGetAll()">try</button>
                </td>
            </tr>
            <tr>
                <td>Get Document by ID</td>
                <td>
                    id: <input id="getDocumentId" value="">
                    <button type="button" onclick="RestGet($('#getDocumentId').val())">Try</button>
                </td>
            </tr>
            <tr>
                <td>Add Document</td>
                <td><code><strong>Post</strong>document/add</code></td>
                <form class="form-inline">
                    id: <input id="postname" value="name">
                    <button type="button" onclick="RestPut($('#postname').val())">Try</button>
                </form>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <strong>RESPONSE</strong>
        </div>
        <div class="panel-body" id="response">
        </div>

    </div>


</div>
</body>
</html>
