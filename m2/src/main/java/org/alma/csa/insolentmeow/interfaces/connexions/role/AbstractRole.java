package org.alma.csa.insolentmeow.interfaces.connexions.role;

import org.alma.csa.insolentmeow.component.AbstractConfiguration;
import org.alma.csa.insolentmeow.interfaces.connexions.IConnexionPoint;

public abstract class AbstractRole implements IConnexionPoint {
	
	private AbstractConfiguration context;
	
	public AbstractConfiguration getContext() {
		return this.context;
	}
	
	public void setContext(AbstractConfiguration context) {
		this.context = context;
	}
}
