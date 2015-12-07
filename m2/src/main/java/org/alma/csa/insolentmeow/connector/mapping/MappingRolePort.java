package org.alma.csa.insolentmeow.connector.mapping;

import java.util.Observable;
import java.util.Observer;
import org.alma.csa.insolentmeow.interfaces.connexions.AbstractConnexionPoint;
import org.alma.csa.insolentmeow.interfaces.connexions.port.RequiredPort;
import org.alma.csa.insolentmeow.interfaces.connexions.role.FromRole;

public class MappingRolePort extends AbstractMapping {
	
	public MappingRolePort() {
		super();
	}
	
	public void update(Observable o, Object arg) {
		System.out.println(this.getClass().getName()+".update");
		this.setChanged();
		this.notifyObservers(arg);
	}
}
