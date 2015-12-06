package org.alma.csa.insolentmeow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.alma.csa.insolentmeow.connector.attachement.*;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;
import org.alma.csa.insolentmeow.interfaces.connexions.role.*;

public class ContextTool implements IContext {
	
	private Map<String,List<RequiredPort>> requiredPorts;
	private Map<String,List<ProvidedPort>> providedPorts;
	
	private Map<String,List<FromRole>> fromRoles;
	private Map<String,List<ToRole>> toRoles;
	private Map<String,AbstractAttachement> attachements;
	
	public ContextTool() {
		this.requiredPorts = new HashMap<String,List<RequiredPort>>();
		this.providedPorts = new HashMap<String,List<ProvidedPort>>();
		
		this.fromRoles = new HashMap<String,List<FromRole>>();
		this.toRoles = new HashMap<String,List<ToRole>>();
		this.attachements = new HashMap<String,AbstractAttachement>();
	}
	
	public Map<String,List<RequiredPort>> getRequiredPorts() {
		return this.requiredPorts;
	}
	
	public Map<String,List<ProvidedPort>> getProvidedPorts() {
		return this.providedPorts;
	}
	
	public void declare(RequiredPort port, String serviceName) {
		List<RequiredPort> list = this.requiredPorts.get(serviceName);
		if(list == null) {
			list = new ArrayList<RequiredPort>();
			this.requiredPorts.put(serviceName,list);
		}
		list.add(port);
	}

	public void undeclare(RequiredPort port, String serviceName) {
		List<RequiredPort> list = this.requiredPorts.get(serviceName);
		if(list != null) {
			list.remove(port);
		}
		
	}

	public void declare(ProvidedPort port, String serviceName) {
		List<ProvidedPort> list = this.providedPorts.get(serviceName);
		if(list == null) {
			list = new ArrayList<ProvidedPort>();
			this.providedPorts.put(serviceName,list);
		}
		list.add(port);
	}

	public void undeclare(ProvidedPort port, String serviceName) {
		List<ProvidedPort> list = this.providedPorts.get(serviceName);
		if(list != null) {
			list.remove(port);
		}
	}
	
	public void attach(FromRole role, String serviceName) {
		AbstractAttachement attachement = this.attachements.get(serviceName);
		if(attachement == null) {
			attachement = new FromAttachement();
			this.attachements.put(serviceName,attachement);
			List<ProvidedPort> ports = this.providedPorts.get(serviceName);
			if(ports != null) {
				for(ProvidedPort p : ports) {
					p.addObserver(attachement);
				}
			}
		}
		List<FromRole> list = this.fromRoles.get(serviceName);
		if(list == null) {
			list = new ArrayList<FromRole>();
			this.fromRoles.put(serviceName,list);
		}
		list.add(role);
		attachement.addObserver(role);
	}

	public void unattach(FromRole role, String serviceName) {
		AbstractAttachement attachement = this.attachements.get(serviceName);
		if(attachement != null) {
			attachement.deleteObserver(role);
		}
		List<FromRole> list = this.fromRoles.get(serviceName);
		if(list != null) {
			list.add(role);
		}
	}

	public void attach(ToRole role, String serviceName) {
		AbstractAttachement attachement = this.attachements.get(serviceName);
		if(attachement == null) {
			attachement = new ToAttachement();
			this.attachements.put(serviceName,attachement);
			List<RequiredPort> ports = this.requiredPorts.get(serviceName);
			if(ports != null) {
				for(RequiredPort p : ports) {
					attachement.addObserver(p);
				}
			}
		}
		List<ToRole> list = this.toRoles.get(serviceName);
		if(list == null) {
			list = new ArrayList<ToRole>();
			this.toRoles.put(serviceName,list);
		}
		list.add(role);
		role.addObserver(attachement);
	}

	public void unattach(ToRole role, String serviceName) {
		AbstractAttachement attachement = this.attachements.get(serviceName);
		if(attachement != null) {
			role.deleteObserver(attachement);
		}
		List<ToRole> list = this.toRoles.get(serviceName);
		if(list != null) {
			list.add(role);
		}
	}

}
