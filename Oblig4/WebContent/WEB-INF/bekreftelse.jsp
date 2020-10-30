<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${fornavn}<br />
		&nbsp;&nbsp;&nbsp;${etternavn}<br />
		&nbsp;&nbsp;&nbsp;${mobilnummer}<br /> &nbsp;&nbsp;&nbsp;${kjonn}
	</p>
	<form action="deltagerliste">
    	<div class="pure-controls">
    		<input type="submit" value="Gå til deltagerlisten" class="pure-button pure-button-primary"/>
    	</div>
    </form>
</body>
</html>