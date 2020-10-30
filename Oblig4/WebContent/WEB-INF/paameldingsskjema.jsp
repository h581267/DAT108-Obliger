<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmeldingsskjema</title>
</head>
<body>
    <h2>Påmelding</h2>
    <form method="post" class="pure-form pure-form-aligned">
        <fieldset>
            <div class="pure-control-group">
                <label for="fornavn">Fornavn:</label> <input type="text"
                    name="fornavn" value="" /> 
                    <font color="red">${ffornavn}</font>
            </div>
            <div class="pure-control-group">
                <label for="etternavn">Etternavn:</label> <input type="text"
                    name="etternavn" value="" /> 
                    <font color="red">${fetternavn}</font>
            </div>
            <div class="pure-control-group">
                <label for="mobil">Mobil (8 siffer):</label> <input type="text"
                    name="mobil" value="" /> 
                    <font color="red">${fmobilnummer}</font>
            </div>
            <div class="pure-control-group">
                <label for="password">Passord:</label> <input type="password"
                    name="passord" value="" /> 
                    <font color="red">${fpassord}</font>
            </div>
            <div class="pure-control-group">
                <label for="passordRepetert">Passord repetert:</label> <input
                    type="password" name="passordRepetert"
                    value="" /> 
                    <font color="red">${frpassord}</font>
            </div>
            <div class="pure-control-group">
                <label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
                    value="Mann"
                     />mann
                <input type="radio" name="kjonn" value="Kvinne"
                     />kvinne
                <font color="red">${fkjonn}</font>
            </div>
            <div class="pure-controls">
                <button type="submit" class="pure-button pure-button-primary">Meld
                    meg på</button>
            </div>
        </fieldset>
    </form>



</body>
</html>