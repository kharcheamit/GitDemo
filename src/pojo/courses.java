package pojo;

import java.util.List;

public class courses {

	private List<WebAutomation> WebAutomation;
	private List<api> API;
	private List<Mobile> mobile;
	
	public List<pojo.WebAutomation> getWebAutomation() {
		return WebAutomation;
	}
	public void setWebAutomation(List<pojo.WebAutomation> webAutomation) {
		WebAutomation = webAutomation;
	}
	public List<api> getAPI() {
		return API;
	}
	public void setAPI(List<api> aPI) {
		API = aPI;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	
	
	
}
