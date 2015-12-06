package org.alma.csa.insolentmeow.connector.attachement;

import java.util.Observable;
import java.util.Observer;
import org.alma.csa.insolentmeow.component.AbstractComponent;

public abstract class AbstractAttachement extends Observable implements Observer {
	private AbstractComponent parent;
	
	public AbstractAttachement() {
		super();
	}
	
	public AbstractComponent getParent() {
		return this.parent;
	}
	
	public void setParent(AbstractComponent parent) {
		this.parent = parent;
	}
}
