package org.alma.csa.insolentmeow.interfaces.connexions.port;

import java.util.Observable;
import java.util.Observer;
import org.alma.csa.insolentmeow.component.AbstractComponent;

public class RequiredConfigPort extends RequiredPort {
	
	public RequiredConfigPort() {
		super();
	}
	
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}
}
