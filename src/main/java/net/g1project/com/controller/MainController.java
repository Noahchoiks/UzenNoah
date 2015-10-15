package net.g1project.com.controller;

import net.g1project.com.controller.abstact.AbstractG1PageController;
import net.g1project.com.mnv.G1ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class MainController extends AbstractG1PageController{

	public static final String MAIN_CONTENTS_VIEW = "main";
	public static final String [] MAIN_CONTENTS_CONTROLLER = {"invoice"};
	
	@RequestMapping(value = "index")
	public ModelAndView index() {
		
		G1ModelAndView gmv = new G1ModelAndView();
		gmv.setContentsView(MAIN_CONTENTS_VIEW);
		gmv.setContentsController(MAIN_CONTENTS_CONTROLLER);
		
		return createPage(gmv);
	}

	
}
