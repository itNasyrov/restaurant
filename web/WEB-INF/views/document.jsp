<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<script type="text/javascript">

    var service = '/document';
    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/id/' + id,
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

    var RestPut = function (name) {
        var document = {"name" : name};
        $.ajax({
            type: 'PUT',
            url: service + '/add',
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(document),
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

    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
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

    var RestUpdate = function (id, name) {
        var document = {
            "id": id,
            "name" : name
        };

        $.ajax({
            type: 'POST',
            url: service + '/update',
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(document),
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

</script>

<div class="panel panel-default">
    <div class="panel-heading">
        REST API for Documents
    </div>

    <div class="panel panel-body">
        <table class="table">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Get document by id</td>
                    <td>
                        id: <input id="getDocumentId" value="">
                        <button type="button" onclick="RestGet($('#getDocumentId').val())">Try</button>
                    </td>
                </tr>
                <tr>
                    <td>Add document</td>
                    <td>
                        name: <input id="putName" value="">
                        <button type="button" onclick="RestPut($('#putName').val())">Try</button>
                    </td>
                </tr>
                <tr>
                    <td>Get all documents</td>
                    <td>
                       <button type="button" onclick="RestGetAll()">Try</button>
                    </td>
                </tr>
                <tr>
                    <td>Delete document by Id</td>
                    <td>
                        id: <input id="deleteDocumentId" value="">
                        <button type="button" onclick="RestDelete($('#deleteDocumentId').val())">Try</button>
                    </td>
                </tr>
                <tr>
                    <td>Update document</td>
                    <td>
                        id: <input id="updateDocumentId" value="">&nbsp;
                        name: <input id="updateDocumentName" value="">
                        <button type="button" onclick="RestUpdate($('#updateDocumentId').val(),
                                                                  $('#updateDocumentName').val())">Try</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-heading">
        RESPONSE
    </div>
    <div class="panel-body" id="response"></div>
</div>

</body>
</html>
