package org.alma.csa.insolentmeow.connector.attachement;

import java.util.Observable;
import java.util.Observer;

public class FromAttachement extends AbstractAttachement {
	
	public FromAttachement() {
		super();
	}
	
	public void update(Observable o, Object arg) {
		System.out.println(this.getClass().getName()+".update");
		this.setChanged();
		this.notifyObservers(arg);
	}
}
