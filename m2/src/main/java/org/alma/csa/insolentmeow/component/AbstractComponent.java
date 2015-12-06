package org.alma.csa.insolentmeow.component;

import java.util.ArrayList;
import java.util.List;
import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.interfaces.service.*;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;

public abstract class AbstractComponent {
	
	private IContext context;  
	private List<ProvidedPort> providedPorts;
	private List<RequiredPort> requiredPorts;
	
	public AbstractComponent(IContext context) {
		super();
		this.context = context;
		this.providedPorts = new ArrayList<ProvidedPort>();
		this.requiredPorts = new ArrayList<RequiredPort>();
	}
	
	public abstract List<ProvidedService> getProvidedServices();
	public abstract List<RequiredService> getRequiredServices();
	
	public IContext getContext() {
		return this.context;
	}
	
	public List<ProvidedPort> getProvidedPorts() {
		return this.providedPorts;
	}
	
	public List<RequiredPort> getRequiredPorts() {
		return this.requiredPorts;
	}
	
	public void addProvidedPorts(ProvidedPort providedPort) {
		this.providedPorts.add(providedPort);
		providedPort.setParent(this);
	}
	
	public void addRequiredPorts(RequiredPort requiredPort) {
		this.requiredPorts.add(requiredPort);
		requiredPort.setParent(this);
	}
}
