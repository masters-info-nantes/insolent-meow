package org.alma.csa.insolentmeow.interfaces.connexions.role;

import java.util.Observable;
import java.util.Observer;

public class ToRole extends AbstractRole {
	
	public ToRole() {
		super();
	}
	
	public void update(Observable o, Object arg) {
		System.out.println(this.getClass().getName()+".update");
		this.setChanged();
		this.notifyObservers(arg);
	}
}
