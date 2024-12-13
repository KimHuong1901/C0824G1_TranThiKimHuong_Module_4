<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <title>Currency Converter</title>
  <style>
    .form-container {
      max-width: 50%;
    }
  </style>
</head>
<body>
<div class="container">
<h1>Convert form USD to VND</h1>
  <div class="form-container">
<form action="/caculate/result" method="post">
  <div class="form-group">
    <label for="rate">Exchange rate (VND/USD): </label>
    <input type="text" class="form-control" id="rate" name = "rate" value="24000" readonly>
  </div>
  <div class="form-group">
    <label for="amount">Amount USD</label>
    <input type="text" class="form-control" id="amount" name = "amount" placeholder="Enter the amount USD">
  </div>
  <button type="submit" class="btn btn-primary">Convert</button>
</form>
</div>
</div>
</body>
</html>
