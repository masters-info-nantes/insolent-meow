package org.alma.csa.insolentmeow.interfaces.connexions.port;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.alma.csa.insolentmeow.component.AbstractComponent;
import org.alma.csa.insolentmeow.interfaces.service.*;

public class ProvidedPort extends AbstractPort {

	public ProvidedPort() {
		super();
	}
	
	public void diffuse(Object obj) {
		this.setChanged();
		this.notifyObservers(obj);
	}
	
	public void addService(ProvidedService service) {
		super.addService(service);
	}
	
}
