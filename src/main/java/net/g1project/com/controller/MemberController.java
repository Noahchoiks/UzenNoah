package net.g1project.com.controller;

import net.g1project.com.constants.G1WebConstants;
import net.g1project.com.controller.abstact.AbstractG1PageController;
import net.g1project.com.mnv.G1ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController extends AbstractG1PageController {

	public static String MEMBER_CONTENTS_VIEW = "member";
	public static String[] MEMBER_CONTENTS_CONTROLLER = { "member" };

	public static String MEMBER_JOIN_CONTENTS_VIEW = "memberJoin";
	public static String[] MEMBER_JOIN_CONTENTS_CONTROLLER = { "invoice" };

	@RequestMapping
	public ModelAndView member() {

		G1ModelAndView gmv = new G1ModelAndView();
		gmv.setHeaderView(G1WebConstants.G1_LAYOUT_HEADER);
		gmv.setFooterView(G1WebConstants.G1_LAYOUT_FOOTER);
		gmv.setContentsView(MEMBER_CONTENTS_VIEW);
		gmv.setContentsController(MEMBER_CONTENTS_CONTROLLER);

		return createPage(gmv);
	}


	
	@RequestMapping(value = "/confirm")
	public ModelAndView confirm() {


		G1ModelAndView gmv = new G1ModelAndView();
		gmv.setHeaderView(G1WebConstants.G1_LAYOUT_HEADER);
		gmv.setFooterView(G1WebConstants.G1_LAYOUT_FOOTER);
		gmv.setContentsView(MEMBER_JOIN_CONTENTS_VIEW);
		gmv.setContentsController(MEMBER_JOIN_CONTENTS_CONTROLLER);

		return createPage(gmv);
	}

}
