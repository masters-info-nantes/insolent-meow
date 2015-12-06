package org.alma.csa.insolentmeow.connector.mapping;

import java.util.Observable;
import java.util.Observer;
import org.alma.csa.insolentmeow.component.AbstractComponent;
import org.alma.csa.insolentmeow.interfaces.connexions.AbstractConnexionPoint;

public abstract class AbstractMapping extends Observable implements Observer {
	private AbstractComponent parent;
	
	public AbstractMapping() {
		super();
	}
	
	public AbstractComponent getParent() {
		return this.parent;
	}
	
	public void setParent(AbstractComponent parent) {
		this.parent = parent;
	}
}
