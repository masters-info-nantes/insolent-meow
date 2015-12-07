package org.alma.csa.insolentmeow.component;

import java.util.ArrayList;
import java.util.List;
import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.interfaces.service.*;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;

public class Component extends AbstractComponent {
	
	private List<ProvidedService> providedServices;
	private List<RequiredService> requiredServices;
	
	public Component(IContext context) {
		super(context);
		this.providedServices = new ArrayList<ProvidedService>();
		this.requiredServices = new ArrayList<RequiredService>();
	}
	
	public List<ProvidedService> getProvidedServices() {
		return this.providedServices;
	}
	
	public List<RequiredService> getRequiredServices() {
		return this.requiredServices;
	}
	
	public void addProvidedServices(ProvidedService service) {
		this.providedServices.add(service);
	}
	
	public void addRequiredServices(RequiredService service) {
		this.requiredServices.add(service);
	}
	
}
