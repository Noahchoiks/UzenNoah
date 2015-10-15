package net.g1project.com.controller.abstact;

import net.g1project.com.constants.G1WebConstants;
import net.g1project.com.mnv.G1ModelAndView;
import net.g1project.com.service.DummyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class AbstractG1PageController {

	@Autowired
	protected DummyService dummyService;

	public ModelAndView createPage(G1ModelAndView g1ModelAndView) {
		// get ModelMap
		ModelMap mav = (ModelMap) g1ModelAndView.getModel();

		// add Contents View Name & Contents View Controller Names

		mav.addAttribute(G1WebConstants.G1_CONTENTS_VIEW_NAME,
				g1ModelAndView.getContentsView());
		mav.addAttribute(G1WebConstants.G1_CONTENTS_VIEW_CONTROLLERS,
				g1ModelAndView.getContentsController());

		// TODO Layout Config
		return new ModelAndView(G1WebConstants.G1_LAYOUT_MAIN, mav);
	}
}
