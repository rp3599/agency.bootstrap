<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<title>Error</title>
</head>
	<body bgcolor="white">
		<h6>
			${url}
		</h6>
		<p>
			${exception.message}
		</p>
	</body>
</html>