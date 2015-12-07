package org.alma.csa.insolentmeow.connector;

import org.alma.csa.insolentmeow.IContext;

public class SimpleConnector extends AbstractConnector {
	private Glue glue;
	
	public SimpleConnector(IContext context,Glue glue) {
		super(context);
		this.glue = glue;
	}
	
	public Glue getGlue() {
		return this.glue;
	}
	
	public void setGlue(Glue glue) {
		this.glue = glue;
	}
}
