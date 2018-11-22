<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />


<form:form action="survey" method="POST" modelAttribute="survey">

	<div class="row">	
		<div class="col-md-3">
			<form:label path="parkCode"> Favorite National Park :</form:label>
		</div>
		<div class="col-md-5">
			<form:select path="parkCode" name="parkCode" class="form-control">
			<form:option value="">Select option</form:option>
			<c:forEach var="park" items="${parks }">
				<form:option value="${park.parkCode }">${park.parkName }</form:option>
			</c:forEach>
			</form:select> 
			<form:errors path="parkCode" cssClass="error"/>	
		</div>		
	</div>
	<div class="row">			
		<div class=col-md-3>
			<label for="emailAddress">Email: </label> 
		</div>
		<div class="col-md-5">
			<form:input path="emailAddress" class="form-control" placeholder="enter email"/> 
			<form:errors path="emailAddress" cssClass="error"/>		
		</div>
	</div>			
	<div class="row">
		<div class="col-md-3">
			<form:label path="state">State: </form:label> 
		</div>
		<div class="col-md-5">
			<form:select path="state" name = "state" class="form-control">
				<form:option value="">Select option</form:option>
				<form:option value="AL">Alabama</form:option>
				<form:option value="AK">Alaska</form:option>
				<form:option value="AZ">Arizona</form:option>
				<form:option value="AR">Arkansas</form:option>
				<form:option value="CA">California</form:option>
				<form:option value="CO">Colorado</form:option>
				<form:option value="CT">Connecticut</form:option>
				<form:option value="DE">Delaware</form:option>
				<form:option value="DC">District Of Columbia</form:option>
				<form:option value="FL">Florida</form:option>
				<form:option value="GA">Georgia</form:option>
				<form:option value="HI">Hawaii</form:option>
				<form:option value="ID">Idaho</form:option>
				<form:option value="IL">Illinois</form:option>
				<form:option value="IN">Indiana</form:option>
				<form:option value="IA">Iowa</form:option>
				<form:option value="KS">Kansas</form:option>
				<form:option value="KY">Kentucky</form:option>
				<form:option value="LA">Louisiana</form:option>
				<form:option value="ME">Maine</form:option>
				<form:option value="MD">Maryland</form:option>
				<form:option value="MA">Massachusetts</form:option>
				<form:option value="MI">Michigan</form:option>
				<form:option value="MN">Minnesota</form:option>
				<form:option value="MS">Mississippi</form:option>
				<form:option value="MO">Missouri</form:option>
				<form:option value="MT">Montana</form:option>
				<form:option value="NE">Nebraska</form:option>
				<form:option value="NV">Nevada</form:option>
				<form:option value="NH">New Hampshire</form:option>
				<form:option value="NJ">New Jersey</form:option>
				<form:option value="NM">New Mexico</form:option>
				<form:option value="NY">New York</form:option>
				<form:option value="NC">North Carolina</form:option>
				<form:option value="ND">North Dakota</form:option>
				<form:option value="OH">Ohio</form:option>
				<form:option value="OK">Oklahoma</form:option>
				<form:option value="OR">Oregon</form:option>
				<form:option value="PA">Pennsylvania</form:option>
				<form:option value="RI">Rhode Island</form:option>
				<form:option value="SC">South Carolina</form:option>
				<form:option value="SD">South Dakota</form:option>
				<form:option value="TN">Tennessee</form:option>
				<form:option value="TX">Texas</form:option>
				<form:option value="UT">Utah</form:option>
				<form:option value="VT">Vermont</form:option>
				<form:option value="VA">Virginia</form:option>
				<form:option value="WA">Washington</form:option>
				<form:option value="WV">West Virginia</form:option>
				<form:option value="WI">Wisconsin</form:option>
				<form:option value="WY">Wyoming</form:option>
			</form:select> 
			<form:errors path="state" cssClass="error"/>	
		</div>
	</div>	
	<div class="row">
		<div class="col-md-3">
			<form:label path="activityLevel">Activity Level:</form:label> 
		</div>
		<div class="col-md-5">
			<form:select path="activityLevel" name = "activityLevel" class="form-control">
				<form:option value=""> Select option </form:option>
				<form:option value="inactive"> Inactive</form:option>
				<form:option value="sedentary"> Sedentary </form:option>
				<form:option value="active"> Active </form:option>
				<form:option value="extremely active"> Extreeeeemly Active</form:option>
			</form:select>
			<form:errors path="activityLevel" cssClass="error"/>	
		</div>
	</div>				
	<div class="row">
		<div class="offset-md-4">
			<button class="btn btn-primary" type="submit" >Submit <i class="fa fa-paper-plane"></i></button>
		</div>
	</div>
	
</form:form>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />


