<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result Convert</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container" style="margin-top: 50px;">
    <h2 class="text-center">Result</h2>
    <form class="form-horizontal">
        <div class="form-group">
            <label class="control-label col-sm-4" for="rate">Exchange rate (VND/USD):</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="rate" value="${rate}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-4" for="amount">USD:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="amount" value="${amount}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-4" for="result">VND:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="result" value="${result}" readonly>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-6">
                <a href="/caculate" class="btn btn-primary">Back</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>

