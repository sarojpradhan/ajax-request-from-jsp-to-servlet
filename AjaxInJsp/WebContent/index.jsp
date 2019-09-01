<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ajax in JSP</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>

	<form>
		<pre>
			Name: <input type="text" name="name" id="fullname" /><br>
			Email: <input type="email" name="email" id="email" /><br>
			Address: <input name="address" id="address" /> <br>
			<input type="submit" value="Send" id="btSend" /> <br>
		</pre>

	</form>

	<p id="result"></p>

	<script>
		//ajax request to AjaxServlet
		$(document).ready(function() {

			$("#btSend").on('click', function(e) {
				e.preventDefault();
				var full_name = $('#fullname').val();
				var email = $('#email').val();
				var address = $('#address').val();
				$.ajax({
					type : 'POST',
					url : 'AjaxServlet',
					data : {
						fullname : full_name,
						email : email,
						address : address
					},
					success : function(result) {
						$('#result').html(result);
					}
				});
			});
		});
	</script>

</body>
</html>