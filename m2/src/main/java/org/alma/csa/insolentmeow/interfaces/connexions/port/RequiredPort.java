package org.alma.csa.insolentmeow.interfaces.connexions.port;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.alma.csa.insolentmeow.component.AbstractComponent;
import org.alma.csa.insolentmeow.interfaces.service.*;

public class RequiredPort extends AbstractPort implements Observer {
	
	public RequiredPort() {
		super();
	}
	
	public void update(Observable o, Object arg) {
		for(AbstractService s : this.getServices()) {
			s.performAction(arg);
		}
	}
	
	public void addService(RequiredService service) {
		super.addService(service);
	}
}
