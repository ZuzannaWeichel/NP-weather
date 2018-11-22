package com.techelevator.npgeek.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDAO;
import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.WeatherDAO;


@Controller
@SessionAttributes("temperature")
public class HomeController {

	@Autowired
	public ParkDAO parkDAO;
	
	@Autowired
	public WeatherDAO weatherDAO;
	
	@Autowired
	public SurveyDAO surveyDAO;
	
	@RequestMapping("/")
	public String displayHomePage(HttpServletRequest request) {
		request.setAttribute("parks", parkDAO.getAllParks());
		
		return "homePage";
	}
	
	@RequestMapping("/parkDetail")
	public String viewParkDetail(HttpServletRequest request) {
		Park park = parkDAO.getParkByParkCode(request.getParameter("parkCode"));
		request.setAttribute("park", park);
		
		List<Weather> weatherList = weatherDAO.getWeatherByParkCode(request.getParameter("parkCode"));
		request.setAttribute("weatherList", weatherList);

		return "parkDetail";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.POST)
	public String changeTempScale(HttpServletRequest request, ModelMap modelMap) {
		Park park = parkDAO.getParkByParkCode(request.getParameter("parkCode"));
		request.setAttribute("park", park);
		List<Weather> weatherList = weatherDAO.getWeatherByParkCode(request.getParameter("parkCode"));
		
		String temperature = request.getParameter("temperature");
		
		modelMap.addAttribute("temperature", temperature);
		modelMap.addAttribute("weatherList", weatherList);
			
		return "parkDetail";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String viewSurveyPage(@Valid @ModelAttribute("survey") Survey survey, BindingResult result, HttpServletRequest request) {
		request.setAttribute("parks", parkDAO.getAllParks());
		
		if(result.hasErrors()) {
			return "survey";
		}
		surveyDAO.saveSurvey(survey);
		
		return "redirect:/favParks";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurveyPage(HttpServletRequest request, Model model) {
		request.setAttribute("parks", parkDAO.getAllParks());
		
		if(! model.containsAttribute("survey")) {
			model.addAttribute("survey", new Survey());
		}
		
		return "survey";
	}
	
	@RequestMapping("/favParks")
	public String viewFavParks(HttpServletRequest request) {
		
		Map<String,Integer> favMap = surveyDAO.getAllSurveys();
		request.setAttribute("favMap", favMap);
		request.setAttribute("parks", parkDAO.getFavParks(favMap));
		
		return "favParks";
	}
}
