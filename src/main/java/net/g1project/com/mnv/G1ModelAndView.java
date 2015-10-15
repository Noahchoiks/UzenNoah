package net.g1project.com.mnv;

import org.springframework.web.servlet.ModelAndView;

public class G1ModelAndView extends ModelAndView {

	
	
	
	//TODO : 1. 각 section별 VO 인스턴스 화 및 세분화 ex. Header & subHeader 
	//       2. MetaData info
	//       3. Page Title
	//       4. Marketing Tag(script)
	//		 5. css layer
	
	private String headerView;
	private String headerController[];
	
	private String contentsView;
	private String contentsController[];

	private String footerView;
	private String footerController[];
	
	
	
	public G1ModelAndView() {
		super();
	}
	
	
	
	public String getHeaderView() {
		return headerView;
	}
	public void setHeaderView(String headerView) {
		this.headerView = headerView;
	}
	public String[] getHeaderController() {
		return headerController;
	}
	public void setHeaderController(String[] headerController) {
		this.headerController = headerController;
	}




	public String getFooterView() {
		return footerView;
	}
	public void setFooterView(String footerView) {
		this.footerView = footerView;
	}
	public String[] getFooterController() {
		return footerController;
	}
	public void setFooterController(String[] footerController) {
		this.footerController = footerController;
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
