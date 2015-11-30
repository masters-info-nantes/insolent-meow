package org.alma.csa.insolentmeow.component;

import java.util.ArrayList;
import java.util.List;
import org.alma.csa.insolentmeow.interfaces.service.*;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;

public abstract class AbstractComponent {
	
	private AbstractConfiguration context;  
	private List<ProvidedPort> providedPorts;
	private List<RequiredPort> requiredPorts;
	
	public AbstractComponent(AbstractConfiguration context) {
		super();
		this.context = context;
		this.providedPorts = new ArrayList<ProvidedPort>();
		this.requiredPorts = new ArrayList<RequiredPort>();
	}
	
	public abstract List<ProvidedService> getProvidedServices();
	public abstract List<RequiredService> getRequiredServices();
	
	public List<ProvidedPort> getProvidedPorts() {
		return this.providedPorts;
	}
	
	public List<RequiredPort> getRequiredPorts() {
		return this.requiredPorts;
	}
	
	public void addProvidedPorts(ProvidedPort providedPort) {
		this.providedPorts.add(providedPort);
		providedPort.setContext(this.context);
	}
	
	public void addRequiredPorts(RequiredPort requiredPort) {
		this.requiredPorts.add(requiredPort);
		requiredPort.setContext(this.context);
	}
}
