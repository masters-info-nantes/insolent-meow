package org.alma.csa.insolentmeow.component.binding;

import java.util.Observable;
import java.util.Observer;
import org.alma.csa.insolentmeow.component.AbstractComponent;
import org.alma.csa.insolentmeow.interfaces.connexions.port.AbstractPort;

public abstract class AbstractBinding extends Observable implements Observer {
	
	private AbstractComponent parent;
	
	public AbstractBinding() {
		super();
	}
	
	public AbstractComponent getParent() {
		return this.parent;
	}
	
	public void setParent(AbstractComponent parent) {
		this.parent = parent;
	}
	
}
