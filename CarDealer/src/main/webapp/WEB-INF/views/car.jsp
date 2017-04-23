<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>CarDealer</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc; cellpadding:10;
cellspacing:10;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333; cellpadding:10;
cellspacing:10;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0; cellpadding:10;
cellspacing:10;}
        .tg .tg-4eph{background-color:#f9f9f9}


a.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 10px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
     margin: 10px 15px 10px 8px;
}
a.btn{
background-color: #f44336;
    border: none;
    color: white;
    padding: 10px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
     margin: 10px 15px 10px 8px;
}
.table {
border: 1px; 

}
.th{ width:10%; 
}
.value{
margin: 10px 15px 10px 8px;
}

    </style>
</head>
<body>
<h1>
    Add a Car
</h1>

<c:url var="addAction" value="/car/add" ></c:url>

<form:form action="${addAction}" commandName="car">
<table>
    <c:if test="${!empty car.make}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="make">
                <spring:message text="Make"/>
            </form:label>
        </td>
        <td>
            <form:input path="make" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="model">
                <spring:message text="Model"/>
            </form:label>
        </td>
        <td>
            <form:input path="model" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty car.make}">
                <input type="submit"
                    value="<spring:message text="Edit Car"/>" />
            </c:if>
            <c:if test="${empty car.make}">
                <input type="submit"
                    value="<spring:message text="Add Car"/>" />
            </c:if>
        </td>
    </tr>
</table>    
</form:form>
<br>
<h3>Cars List</h3>
<c:if test="${!empty listCars}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Car Make</th>
        <th width="120">Car Model</th>
        <th width="60">Action</th>

    </tr>
    <c:forEach items="${listCars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.make}</td>
            <td>${car.model}</td>
            <td><a href="<c:url value='/edit/${car.id}' />"  class="button">Edit</a>
            <a href="<c:url value='/remove/${car.id}' />"  class="btn">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>