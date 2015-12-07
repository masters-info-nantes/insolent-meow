package org.alma.csa.insolentmeow.connector.attachement;

import java.util.Observable;

public class ToAttachement extends AbstractAttachement {
	
	public ToAttachement() {
		super();
	}
	
	public void update(Observable o, Object arg) {
		System.out.println(this.getClass().getName()+".update");
		this.setChanged();
		this.notifyObservers(arg);
	}
}
