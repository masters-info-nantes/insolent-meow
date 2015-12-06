package org.alma.csa.insolentmeow;

import org.alma.csa.insolentmeow.interfaces.connexions.port.*;
import org.alma.csa.insolentmeow.interfaces.connexions.role.*;

public interface IContext {
	public abstract void declare(RequiredPort port, String serviceName);
	public abstract void undeclare(RequiredPort port, String serviceName);
	public abstract void declare(ProvidedPort port, String serviceName);
	public abstract void undeclare(ProvidedPort port, String serviceName);
	
	public abstract void attach(FromRole role, String serviceName);
	public abstract void unattach(FromRole role, String serviceName);
	public abstract void attach(ToRole role, String serviceName);
	public abstract void unattach(ToRole role, String serviceName);
}
