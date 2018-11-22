<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:forEach var="park" items="${parks }">
	<c:set var="url" value="img/parks/${park.parkCode.toLowerCase()}.jpg" />
	<c:url var="pictureUrl" value="${url }" />
	<div class ="parkdetails">
		<div class="parkimages">
			<a href="parkDetail?parkCode=${park.parkCode }">
			<img class="click frame" src="${pictureUrl }" style="border-radius:20px; width:40vw"/></a>
		</div>
		<div class="parkInfo">
			<ul>
				<li><b>${park.parkName }</b></li>
				  <i> - ${park.state } - </i>
				  <br>
				<li>${park.parkDescription }</li>
				<br>
			</ul>
		</div>
	</div>


</c:forEach>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />


