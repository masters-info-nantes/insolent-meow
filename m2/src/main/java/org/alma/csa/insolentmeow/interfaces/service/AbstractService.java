package org.alma.csa.insolentmeow.interfaces.service;

import java.util.ArrayList;
import java.util.List;

import org.alma.csa.insolentmeow.component.AbstractComponent;
import org.alma.csa.insolentmeow.interfaces.IInterface;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;

public abstract class AbstractService implements IInterface {

	private AbstractComponent parent;
	private List<AbstractPort> ports;
	private String serviceName;

	public AbstractService(String serviceName) {
		super();
		this.ports = new ArrayList<AbstractPort>();
		this.serviceName = serviceName;
	}

	public AbstractComponent getParent() {
		return this.parent;
	}

	public void setParent(AbstractComponent parent) {
		this.parent = parent;
	}


	public void addPort(AbstractPort port) {
		this.ports.add(port);
	}
	
	public List<AbstractPort> getPorts() {
		return this.ports;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public abstract void performAction(Object arg);

}
