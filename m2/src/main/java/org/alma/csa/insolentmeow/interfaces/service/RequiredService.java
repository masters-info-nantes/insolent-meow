package org.alma.csa.insolentmeow.interfaces.service;

import java.util.ArrayList;
import java.util.List;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;

public abstract class RequiredService extends AbstractService {
	
	public RequiredService(String serviceName) {
		super(serviceName);
	}
	
	public void addPort(RequiredPort port) {
		super.addPort(port);
	}
	
}
