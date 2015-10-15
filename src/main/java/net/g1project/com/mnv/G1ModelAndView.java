package net.g1project.com.mnv;

import org.springframework.web.servlet.ModelAndView;

public class G1ModelAndView extends ModelAndView {

	private String contentsView;
	private String contentsController[];

	public G1ModelAndView() {
		super();
	}

	public String getContentsView() {
		return contentsView;
	}

	public void setContentsView(String contentsView) {
		this.contentsView = contentsView;
	}

	public String[] getContentsController() {
		return contentsController;
	}

	public void setContentsController(String... contentsController) {
		this.contentsController = contentsController;
	}

}
