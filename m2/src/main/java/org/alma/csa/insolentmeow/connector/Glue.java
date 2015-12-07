package org.alma.csa.insolentmeow.connector;

import java.util.Observable;
import java.util.Observer;

public class Glue extends Observable implements Observer {
	
	public Glue() {
		super();
	}
	
	public void update(Observable o, Object arg) {
		System.out.println(this.getClass().getName()+".update");
		this.setChanged();
		this.notifyObservers(arg);
	}
}
