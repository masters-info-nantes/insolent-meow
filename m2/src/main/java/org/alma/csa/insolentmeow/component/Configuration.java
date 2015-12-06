package org.alma.csa.insolentmeow.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.alma.csa.insolentmeow.ContextTool;
import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.*;
import org.alma.csa.insolentmeow.component.binding.*;
import org.alma.csa.insolentmeow.connector.*;
import org.alma.csa.insolentmeow.interfaces.service.*;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;
import org.alma.csa.insolentmeow.interfaces.connexions.role.*;

public class Configuration extends AbstractComponent implements IContext {
	
	private ContextTool contextTool;
	
	private List<AbstractComponent> composites;
	private List<AbstractConnector> connectors;
	
	private Map<String,List<ProvidedPort>> internalProvidedPorts;
	private Map<String,List<RequiredPort>> internalRequiredPorts;
	
	private Map<String,List<ProvidedConfigPort>> providedPorts;
	private Map<String,List<RequiredConfigPort>> requiredPorts;
	private Map<String,AbstractBinding> bindings;
	
	public Configuration(IContext context) {
		super(context);
		this.contextTool = new ContextTool();
		
		this.composites = new ArrayList<AbstractComponent>();
		this.connectors = new ArrayList<AbstractConnector>();
		
		this.internalProvidedPorts = new HashMap<String,List<ProvidedPort>>();
		this.internalRequiredPorts = new HashMap<String,List<RequiredPort>>();
		
		this.providedPorts = new HashMap<String,List<ProvidedConfigPort>>();
		this.requiredPorts = new HashMap<String,List<RequiredConfigPort>>();
		this.bindings = new HashMap<String,AbstractBinding>();
	}
	
	public List<AbstractComponent> getComponents() {
		return this.composites;
	}
	
	public List<AbstractConnector> getConnectors() {
		return this.connectors;
	}
	
	public void addComponent(AbstractComponent component) {
		this.composites.add(component);
	}
	
	public void addConnector(AbstractConnector connector) {
		this.connectors.add(connector);
	}
	
	public List<ProvidedService> getProvidedServices() {
		List<ProvidedService> res = new ArrayList<ProvidedService>();
		for(List<ProvidedPort> lp : this.internalProvidedPorts.values()) {
			for(ProvidedPort p : lp) {
				for(AbstractService s : p.getServices()) {
					try {
						res.add((ProvidedService)s);
					} catch(ClassCastException ex) {}
				}
			}
		}
		return res;
	}
	
	public List<RequiredService> getRequiredServices() {
		List<RequiredService> res = new ArrayList<RequiredService>();
		for(List<RequiredPort> lp : this.internalRequiredPorts.values()) {
			for(RequiredPort p : lp) {
				for(AbstractService s : p.getServices()) {
					try {
						res.add((RequiredService)s);
					} catch(ClassCastException ex) {}
				}
			}
		}
		return res;
	}
	
	// for binding
	
	public void bind(RequiredConfigPort port, String serviceName) {
		AbstractBinding binding = this.bindings.get(serviceName);
		if(binding == null) {
			binding = new RequiredBinding();
			this.bindings.put(serviceName,binding);
			List<RequiredPort> ports = this.contextTool.getRequiredPorts().get(serviceName);
			if(ports != null) {
				for(RequiredPort p : ports) {
					binding.addObserver(p);
					List<RequiredPort> internalList = this.internalRequiredPorts.get(serviceName);
					if(internalList == null) {
						internalList = new ArrayList<RequiredPort>();
						this.internalRequiredPorts.put(serviceName,internalList);
					}
					internalList.add(p);
				}
			}
		}
		List<RequiredConfigPort> list = this.requiredPorts.get(serviceName);
		if(list == null) {
			list = new ArrayList<RequiredConfigPort>();
			this.requiredPorts.put(serviceName,list);
		}
		list.add(port);
		port.addObserver(binding);
	}
	
	public void unbind(RequiredConfigPort port, String serviceName) {
		AbstractBinding binding = this.bindings.get(serviceName);
		if(binding != null) {
			port.deleteObserver(binding);
		}
		List<RequiredConfigPort> list = this.requiredPorts.get(serviceName);
		if(list != null) {
			list.remove(port);
		}
	}
	
	public void bind(ProvidedConfigPort port, String serviceName) {
		AbstractBinding binding = this.bindings.get(serviceName);
		if(binding == null) {
			binding = new ProvidedBinding();
			this.bindings.put(serviceName,binding);
			List<ProvidedPort> ports = this.contextTool.getProvidedPorts().get(serviceName);
			if(ports != null) {
				for(ProvidedPort p : ports) {
					p.addObserver(binding);
					List<ProvidedPort> internalList = this.internalProvidedPorts.get(serviceName);
					if(internalList == null) {
						internalList = new ArrayList<ProvidedPort>();
						this.internalProvidedPorts.put(serviceName,internalList);
					}
					internalList.add(p);
				}
			}
		}
		List<ProvidedConfigPort> list = this.providedPorts.get(serviceName);
		if(list == null) {
			list = new ArrayList<ProvidedConfigPort>();
			this.providedPorts.put(serviceName,list);
		}
		list.add(port);
		binding.addObserver(port);
	}
	
	public void unbind(ProvidedConfigPort port, String serviceName) {
		AbstractBinding binding = this.bindings.get(serviceName);
		if(binding != null) {
			binding.deleteObserver(port);
		}
		List<ProvidedConfigPort> list = this.providedPorts.get(serviceName);
		if(list != null) {
			list.remove(port);
		}
	}
	
	// IContext methods
	
	public void declare(RequiredPort port, String serviceName) {
		this.contextTool.declare(port,serviceName);
	}

	public void undeclare(RequiredPort port, String serviceName) {
		this.contextTool.undeclare(port,serviceName);
		this.internalRequiredPorts.remove(port);
	}

	public void declare(ProvidedPort port, String serviceName) {
		this.contextTool.declare(port,serviceName);
	}

	public void undeclare(ProvidedPort port, String serviceName) {
		this.contextTool.undeclare(port,serviceName);
		this.internalProvidedPorts.remove(port);
	}

	
	public void attach(FromRole role, String serviceName) {
		this.contextTool.attach(role,serviceName);
	}

	public void unattach(FromRole role, String serviceName) {
		this.contextTool.unattach(role,serviceName);
	}

	public void attach(ToRole role, String serviceName) {
		this.contextTool.attach(role,serviceName);
	}

	public void unattach(ToRole role, String serviceName) {
		this.contextTool.unattach(role,serviceName);
	}
	
}
