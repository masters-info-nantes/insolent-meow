package org.alma.csa.insolentmeow.component.binding;

import org.alma.csa.insolentmeow.interfaces.connexions.port.*;

public class ProvidedBinding extends AbstractBinding {
	
	public ProvidedBinding(ProvidedPort from, ProvidedConfigPort to) {
		super(from,to);
	}
	
	public ProvidedPort getFrom() {
		return (ProvidedPort)super.getFrom();
	}
	
	public ProvidedConfigPort getTo() {
		return (ProvidedConfigPort)super.getTo();
	}
}
