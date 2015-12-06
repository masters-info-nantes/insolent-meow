package org.alma.csa.insolentmeow.interfaces.connexions.port;

import java.util.ArrayList;
import java.util.List;
import org.alma.csa.insolentmeow.component.AbstractComponent;
import org.alma.csa.insolentmeow.interfaces.connexions.AbstractConnexionPoint;
import org.alma.csa.insolentmeow.interfaces.service.*;

public abstract class AbstractPort extends AbstractConnexionPoint {
	
	private AbstractComponent parent;
	private List<AbstractService> services;
	
	public AbstractPort() {
		super();
		this.services = new ArrayList<AbstractService>();
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
	
	public List<AbstractService> getServices() {
		return this.services;
	}
}
