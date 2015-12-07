package org.alma.csa.insolentmeow.interfaces.connexions.port;

import java.util.ArrayList;
import java.util.List;
import org.alma.csa.insolentmeow.component.AbstractComponent;
import org.alma.csa.insolentmeow.interfaces.connexions.AbstractConnexionPoint;
import org.alma.csa.insolentmeow.interfaces.service.*;

public abstract class AbstractPort extends AbstractConnexionPoint {
	
	private AbstractComponent parent;
	private List<AbstractService> services;
	private String portName;
	
	public AbstractPort(String portName) {
		super();
		this.services = new ArrayList<AbstractService>();
		this.portName = portName;
	}
	
	public AbstractComponent getParent() {
		return this.parent;
	}
	
	public void setParent(AbstractComponent parent) {
		this.parent = parent;
	}
	
	public void addService(AbstractService service) {
		this.services.add(service);
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public List<AbstractService> getServices() {
		return this.services;
	}
}
