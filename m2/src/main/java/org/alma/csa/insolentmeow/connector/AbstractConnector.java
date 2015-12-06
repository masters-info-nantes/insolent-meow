package org.alma.csa.insolentmeow.connector;

import java.util.ArrayList;
import java.util.List;
import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.interfaces.connexions.role.*;

public abstract class AbstractConnector {
	private IContext context;
	private List<FromRole> fromRoles;
	private List<ToRole> toRoles;
	
	public AbstractConnector(IContext context) {
		super();
		this.context = context;
		this.fromRoles = new ArrayList<FromRole>();
		this.toRoles = new ArrayList<ToRole>();
	}
	
	public IContext getContext() {
		return this.context;
	}
	
	public List<ToRole> getToRoles() {
		return this.toRoles;
	}
	
	public List<FromRole> getFromRoles() {
		return this.fromRoles;
	}
	
	public void addToRoles(ToRole toRole) {
		this.toRoles.add(toRole);
		toRole.setParent(this);
	}
	
	public void addFromRoles(FromRole fromRole) {
		this.fromRoles.add(fromRole);
		fromRole.setParent(this);
	}
}
