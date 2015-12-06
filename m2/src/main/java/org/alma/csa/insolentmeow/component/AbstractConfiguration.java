package org.alma.csa.insolentmeow.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.alma.csa.insolentmeow.component.binding.*;
import org.alma.csa.insolentmeow.connector.AbstractConnector;
import org.alma.csa.insolentmeow.connector.attachement.*;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;
import org.alma.csa.insolentmeow.interfaces.connexions.role.*;

public abstract class AbstractConfiguration extends AbstractComponent {
	private List<AbstractComponent> composites;
	private List<AbstractConnector> connectors;
	
	private Map<String,List<AbstractPort>> ports;// service name => port
	private Map<String,List<AbstractRole>> roles;// service name => role
	private Map<String,AbstractAttachement> attachements;
	
	private Map<String,AbstractPort> externalPorts;
	private Map<String,AbstractPort> internalPorts;
	private Map<String,AbstractBinding> bindings;
	
	public AbstractConfiguration(AbstractConfiguration context) {
		super(context);
		composites = new ArrayList<AbstractComponent>();
		connectors = new ArrayList<AbstractConnector>();
		
		ports = new HashMap<String,List<AbstractPort>>();
		roles = new HashMap<String,List<AbstractRole>>();
		attachements = new HashMap<String,AbstractAttachement>();
		
		externalPorts = new HashMap<String,AbstractPort>();
		internalPorts = new HashMap<String,AbstractPort>();
		bindings = new HashMap<String,AbstractBinding>();
	}
	
	public AbstractConfiguration() {
		this(null);
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
	
	// for attachement
	
	private void attachPort(AbstractPort port, String serviceName) {
		List<AbstractPort> portsList = this.ports.get(serviceName);
		if(portsList == null) {
			portsList = new ArrayList<AbstractPort>();
			this.ports.put(serviceName,portsList);
		}
		portsList.add(port);
	}
	
	private void attachRole(AbstractRole role, String serviceName) {
		List<AbstractRole> rolesList = this.roles.get(serviceName);
		if(rolesList == null) {
			rolesList = new ArrayList<AbstractRole>();
			this.roles.put(serviceName,rolesList);
		}
		rolesList.add(role);
	}
		
	public void attach(RequiredPort port, String serviceName) {
		this.attachPort(port,serviceName);
		AbstractAttachement attachement = this.attachements.get(serviceName);
		if(attachement == null) {
			attachement = new FromAttachement();
			attachement.setParent(this);
			this.attachements.put(serviceName,attachement);
		}
		attachement.addObserver(port);
	}
	
	public void attach(ProvidedPort port, String serviceName) {
		this.attachPort(port,serviceName);
		AbstractAttachement attachement = this.attachements.get(serviceName);
		if(attachement == null) {
			attachement = new ToAttachement();
			attachement.setParent(this);
			this.attachements.put(serviceName,attachement);
		}
		port.addObserver(attachement);
	}
	
	public void attach(FromRole role, String serviceName) {
		this.attachRole(role,serviceName);
		AbstractAttachement attachement = this.attachements.get(serviceName);
		if(attachement == null) {
			attachement = new FromAttachement();
			attachement.setParent(this);
			this.attachements.put(serviceName,attachement);
		}
		role.addObserver(attachement);
	}
	
	public void attach(ToRole role, String serviceName) {
		this.attachRole(role,serviceName);
		AbstractAttachement attachement = this.attachements.get(serviceName);
		if(attachement == null) {
			attachement = new ToAttachement();
			attachement.setParent(this);
			this.attachements.put(serviceName,attachement);
		}
		attachement.addObserver(role);
	}

	// for binding
	
	private void bindInternal(AbstractPort port, String serviceName) {
		this.internalPorts.put(serviceName,port);
	}
	
	private void bindExternal(AbstractPort port, String serviceName) {
		this.externalPorts.put(serviceName,port);
	}
	
	public void bind(RequiredConfigPort port, String serviceName) {
		this.bindExternal(port,serviceName);
		AbstractBinding binding = this.bindings.get(serviceName);
		if(binding == null) {
			binding = new RequiredBinding();
			binding.setParent(this);
			this.bindings.put(serviceName,binding);
		}
		port.addObserver(binding);
	}
	
	public void bind(RequiredPort port, String serviceName) {
		this.bindInternal(port,serviceName);
		AbstractBinding binding = this.bindings.get(serviceName);
		if(binding == null) {
			binding = new RequiredBinding();
			binding.setParent(this);
			this.bindings.put(serviceName,binding);
		}
		binding.addObserver(port);
	}
	
	public void bind(ProvidedConfigPort port, String serviceName) {
		this.bindExternal(port,serviceName);
		AbstractBinding binding = this.bindings.get(serviceName);
		if(binding == null) {
			binding = new ProvidedBinding();
			binding.setParent(this);
			this.bindings.put(serviceName,binding);
		}
		binding.addObserver(port);
	}
	
	public void bind(ProvidedPort port, String serviceName) {
		this.bindInternal(port,serviceName);
		AbstractBinding binding = this.bindings.get(serviceName);
		if(binding == null) {
			binding = new ProvidedBinding();
			binding.setParent(this);
			this.bindings.put(serviceName,binding);
		}
		port.addObserver(binding);
	}
	
	
}
