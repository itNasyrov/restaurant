<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link ref="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
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
                <td>Get Document by ID</td>
                <td>
                    id: <input id="getDocumentId" value="">
                    <button type="button" onclick="RestGet($('#getDocumentId').val())">Try</button>
                </td>
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
