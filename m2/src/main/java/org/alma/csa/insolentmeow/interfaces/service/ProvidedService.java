package org.alma.csa.insolentmeow.interfaces.service;

import java.util.ArrayList;
import java.util.List;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;

public abstract class ProvidedService extends AbstractService {
	
	public ProvidedService(String serviceName) {
		super(serviceName);
	}
	
	public void addPort(ProvidedPort port) {
		super.addPort(port);
	}
	
	public void sendToPort(Object obj) {
		System.out.println(this.getClass().getName()+".sendToPort");
		for(AbstractPort p : this.getPorts()) {
			try {
				((ProvidedPort)p).diffuse(obj);
			} catch(ClassCastException ex) {}
		}
	}
}
