package org.alma.csa.insolentmeow.connector.mapping;

import java.util.Observable;
import org.alma.csa.insolentmeow.interfaces.connexions.AbstractConnexionPoint;
import org.alma.csa.insolentmeow.interfaces.connexions.port.ProvidedPort;
import org.alma.csa.insolentmeow.interfaces.connexions.role.ToRole;

public class MappingPortRole extends AbstractMapping {
	
	public MappingPortRole() {
		super();
	}
	
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}
}
