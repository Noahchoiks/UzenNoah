package net.g1project.com.controller.abstractController;

import net.g1project.com.constants.G1WebConstants;
import net.g1project.com.mnv.G1ModelAndView;
import net.g1project.com.service.DummyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class AbstractG1PageController {

	public Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected DummyService dummyService;

	
	
	
	
	public ModelAndView createPage(G1ModelAndView g1ModelAndView) {
		// get ModelMap
		ModelMap mav = (ModelMap) g1ModelAndView.getModel();

		// add Contents View Name & Contents View Controller Names
		setHeaderContents(mav,g1ModelAndView);
		setBodyContents(mav,g1ModelAndView);
		setFooterContents(mav,g1ModelAndView);
		
		
		// TODO Layout Config
		return new ModelAndView(G1WebConstants.G1_LAYOUT_MAIN, mav);
	}

	private void setHeaderContents(ModelMap mav, G1ModelAndView g1ModelAndView) {
		mav.addAttribute(G1WebConstants.G1_HEADER_CONTENTS_VIEW_NAME,
				g1ModelAndView.getHeaderView());
		mav.addAttribute(G1WebConstants.G1_HEADER_CONTENTS_VIEW_CONTROLLERS,
				g1ModelAndView.getHeaderController());
	}

	private void setBodyContents(ModelMap mav, G1ModelAndView g1ModelAndView) {
		mav.addAttribute(G1WebConstants.G1_CONTENTS_VIEW_NAME,
				g1ModelAndView.getContentsView());
		mav.addAttribute(G1WebConstants.G1_CONTENTS_VIEW_CONTROLLERS,
				g1ModelAndView.getContentsController());

	}

	private void setFooterContents(ModelMap mav, G1ModelAndView g1ModelAndView) {
		mav.addAttribute(G1WebConstants.G1_FOOTER_CONTENTS_VIEW_NAME,
				g1ModelAndView.getFooterView());
		mav.addAttribute(G1WebConstants.G1_FOOTER_CONTENTS_VIEW_CONTROLLERS,
				g1ModelAndView.getFooterController());
	}
}
