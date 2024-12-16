<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>TimeZoneClock</title>
</head>
<body>
<h2>Current Local Times Around the World</h2>
<span>Current time in ${city}: <strong>${date}</strong></span>
<form id ="loacle" action="world-clock" method ="get">
  <select name ="city" onchange = "document.getElementById('locale').submit()">
    <option value ="Asia/Ho_Chi_Minh" selected> Select a city</option>
    <option value="Asia/Ho_Chi_Minh"> Ho Chi Minh</option>
    <option value="Singapore">Singapore</option>
    <option value="Asia/Hong_Kong">Asia/Hong_Kong</option>
    <option value="Asia/Tokyo">Asia/Tokyo</option>
    <option value="Asia/Seoul">Asia/Seoul</option>
    <option value="Europe/London">Europe/London</option>
  </select>

</form>
</body>
</html>