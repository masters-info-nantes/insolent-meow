package org.alma.csa.insolentmeow.component.binding;

import org.alma.csa.insolentmeow.interfaces.connexions.port.*;

public class RequiredBinding extends AbstractBinding {
	
	public RequiredBinding(RequiredConfigPort from, RequiredPort to) {
		super(from,to);
	}
	
	public RequiredConfigPort getFrom() {
		return (RequiredConfigPort)super.getFrom();
	}
	
	public RequiredPort getTo() {
		return (RequiredPort)super.getTo();
	}
}
