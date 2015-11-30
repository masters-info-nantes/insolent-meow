package org.alma.csa.insolentmeow.component.binding;

import org.alma.csa.insolentmeow.interfaces.connexions.port.AbstractPort;

public abstract class AbstractBinding {
	
	private AbstractPort from;
	private AbstractPort to;
	
	public AbstractBinding(AbstractPort from, AbstractPort to) {
		this.from = from;
		this.to = to;
	}
	
	public AbstractPort getFrom() {
		return this.from;
	}
	
	public AbstractPort getTo() {
		return this.to;
	}
	
	public void transmit(Object signal) {
		this.to.receive(signal);
	}
}
