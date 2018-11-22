<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div>
	<table class="table table-sm">
		<tr>
			<th class="mpp"><b>The Most Popular Parks</b></th>
			<th class="votes"># of votes</th>
			<th>Name</th>
			<th>Location</th>
			 
		</tr>
	<c:forEach var="park" items="${parks}" >
		<tr>
			<c:set var="url" value="img/parks/${park.parkCode.toLowerCase()}.jpg" />
			<c:url var="pictureUrl" value="${url }" />
			<td>
			<a href="parkDetail?parkCode=${park.parkCode }">
			<img class="click frame" src="${pictureUrl }" style="border-radius:10px; width:20vw"/></a></td>
			<td class="votes">${favMap.get(park.parkCode) }</td>
			<td>${park.parkName }</td>
			<td>${park.state }</td>
		
		</tr>
	</c:forEach>

	</table>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
