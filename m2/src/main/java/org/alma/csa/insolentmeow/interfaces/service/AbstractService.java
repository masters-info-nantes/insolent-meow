package org.alma.csa.insolentmeow.interfaces.service;

import java.util.ArrayList;
import java.util.List;
import org.alma.csa.insolentmeow.interfaces.IInterface;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;

public abstract class AbstractService implements IInterface {
	
	private List<AbstractPort> ports;
	
	public AbstractService() {
		super();
		this.ports = new ArrayList<AbstractPort>();
	}
	
	public void addPort(AbstractPort port) {
		this.ports.add(port);
	}
	
	public List<AbstractPort> getPorts() {
		return this.ports;
	}

	public abstract void performAction(Object arg);

}
