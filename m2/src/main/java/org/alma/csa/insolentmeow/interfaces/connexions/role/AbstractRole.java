package org.alma.csa.insolentmeow.interfaces.connexions.role;

import java.util.Observable;
import java.util.Observer;
import org.alma.csa.insolentmeow.connector.AbstractConnector;
import org.alma.csa.insolentmeow.interfaces.connexions.AbstractConnexionPoint;

public abstract class AbstractRole extends AbstractConnexionPoint implements Observer {
	
	private AbstractConnector parent;
	
	public AbstractRole() {
		super();
	}
	
	public AbstractConnector getParent() {
		return this.parent;
	}
	
	public void setParent(AbstractConnector parent) {
		this.parent = parent;
	}
	
}
