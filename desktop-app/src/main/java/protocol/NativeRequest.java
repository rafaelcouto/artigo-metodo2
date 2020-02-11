package protocol;

import javax.xml.bind.annotation.XmlElement;

public class NativeRequest {

	@XmlElement(name = "message")
	private String message;

	@XmlElement(name = "module")
	private String module;

	@XmlElement(name = "device")
	private String device;

	@XmlElement(name = "action")
	private String action;

	public NativeRequest() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}
}
