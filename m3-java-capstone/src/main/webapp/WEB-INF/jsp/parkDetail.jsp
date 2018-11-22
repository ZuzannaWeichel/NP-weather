<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:set var="url" value="img/parks/${park.parkCode.toLowerCase()}.jpg" />
<c:url var="pictureUrl" value="${url }" />

<div style="">
	<div>
		<img class= "frame" src="${pictureUrl }" style="width: 100%; border-radius:20px;" />
		
		
	</div>
	<br>
	<div>
		<h3>${park.parkName }</h3> 
			<div class="quote"><i><b>" ${park.inspirationalQuote }"</b></i></div>
			<div class="author">- ${park.inspirationalQuoteSource } </div>
		
		<ul>	
			<li><b>State:</b> ${park.state }</li>
			<li><b>Acreage:</b> ${park.acreage }</li>
			<li><b>Elevation in Feet:</b> ${park.elevationInFeet }</li>
			<li><b>Miles of trail:</b> ${park.milesOfTrail }</li>
			<li><b>Number of Camp sites:</b> ${park.numberOfCampsites }</li>
			<li><b>Climate:</b> ${park.climate }</li>
			<li><b>Year Founded:</b> ${park.yearFounded }</li>
			<li><b>Visitor Count:</b> ${park.annualVisitorCount }</li>
			<li><b>Description:</b> ${park.parkDescription }</li>
			<li><b>Entry fee:</b> $${park.entryFee }</li>
			<li><b>Number of Animal Species:</b> ${park.numberOfAnimalSpecies }</li>

		</ul>
	</div>
</div>

<div class="weather-disp row" style="font-size:.9em">
	<div class="col-md-2"> 
		<form id="tempForm" action="parkDetail" method="POST" >
			<input type="hidden" name="parkCode" value="${park.parkCode }" /> 
			<div class="btn-group btn-group-toggle" data-toggle="buttons">
			  <label class="btn btn-info btn-sm ${temperature == 'C' ? 'active': ''}">
			    <input onclick="$('#tempForm').submit()" name="temperature" value ="C" type="checkbox" > &#176;C
			  </label>
			  <label class="btn btn-info btn-sm ${temperature == 'F' ? 'active': ''}">
			    <input onclick="$('#tempForm').submit()" name="temperature" value ="F" type="checkbox" > &#176;F
			  </label>
			</div>
		</form>
		<br/>
		<div>Today:<br/>+ 4 days</div>
	</div>
	<c:forEach items="${weatherList}" var="weather">

		<div class="col-md-2 sunAndCloud">
			<c:set var="url" value="img/weather/${weather.forecast}.png" />
			<c:url var="pictureUrl" value="${url}" />
			<img src="${pictureUrl }" style="width: 10vw;" />
		
			<c:choose>
				
				<c:when test="${temperature == 'C'}">
					<c:set var="tempH" value="${((weather.high) -32) * (5/9)}" />
					
					<text style="color:red;">H:</text>
					<fmt:formatNumber type="number" maxFractionDigits="1" value="${tempH}" />&#176;C &nbsp
					
					<c:set var="tempL" value="${((weather.low) -32) * (5/9)}"  />
					
					<text style="color:blue;">L:</text>
					<fmt:formatNumber type="number" maxFractionDigits="1" value="${tempL}" />&#176;C 
				</c:when>
				<c:otherwise>
					<text style="color:red;">H:</text>
					<c:out value="${weather.high}" />&#176;F &nbsp
					<text style="color:blue;">L:</text>
					<c:out value="${weather.low}" />&#176;F 
				</c:otherwise>
			</c:choose>
				
	
			<c:if test="${weather.advisory.length() > 0 }">
			<span style="font-size:.8em;">Advisory:
			<c:out value="${weather.advisory}" /></span>
			</c:if>
		</div>
	
	</c:forEach>

</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />