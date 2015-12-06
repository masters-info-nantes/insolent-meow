package org.alma.csa.insolentmeow.connector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.alma.csa.insolentmeow.ContextTool;
import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.connector.mapping.*;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;
import org.alma.csa.insolentmeow.interfaces.connexions.role.*;

public class ComplexConnector extends AbstractConnector implements IContext {
	
	private ContextTool contextTool;
	
	private Map<String,List<FromRole>> fromRoles;
	private Map<String,List<ToRole>> toRoles;
	private Map<String,AbstractMapping> mappings;
	
	public ComplexConnector(IContext context) {
		super(context);
		this.contextTool = new ContextTool();
		
		this.fromRoles = new HashMap<String,List<FromRole>>();
		this.toRoles = new HashMap<String,List<ToRole>>();
		this.mappings = new HashMap<String,AbstractMapping>();
	}
	
	// for mapping
	
	public void map(FromRole role, String serviceName) {
		AbstractMapping mapping = this.mappings.get(serviceName);
		if(mapping == null) {
			mapping = new MappingRolePort();
			this.mappings.put(serviceName,mapping);
			List<RequiredPort> ports = this.contextTool.getRequiredPorts().get(serviceName);
			if(ports != null) {
				for(RequiredPort p : ports) {
					mapping.addObserver(p);
				}
			}
		}
		List<FromRole> list = this.fromRoles.get(serviceName);
		if(list == null) {
			list = new ArrayList<FromRole>();
			this.fromRoles.put(serviceName,list);
		}
		list.add(role);
		role.addObserver(mapping);
	}
	
	public void unmap(FromRole role, String serviceName) {
		AbstractMapping mapping = this.mappings.get(serviceName);
		if(mapping != null) {
			role.deleteObserver(mapping);
		}
		List<FromRole> list = this.fromRoles.get(serviceName);
		if(list != null) {
			list.remove(role);
		}
	}
	
	public void map(ToRole role, String serviceName) {
		AbstractMapping mapping = this.mappings.get(serviceName);
		if(mapping == null) {
			mapping = new MappingPortRole();
			this.mappings.put(serviceName,mapping);
			List<ProvidedPort> ports = this.contextTool.getProvidedPorts().get(serviceName);
			if(ports != null) {
				for(ProvidedPort p : ports) {
					p.addObserver(mapping);
				}
			}
		}
		List<ToRole> list = this.toRoles.get(serviceName);
		if(list == null) {
			list = new ArrayList<ToRole>();
			this.toRoles.put(serviceName,list);
		}
		list.add(role);
		mapping.addObserver(role);
	}
	
	public void unmap(ToRole role, String serviceName) {
		AbstractMapping mapping = this.mappings.get(serviceName);
		if(mapping != null) {
			mapping.deleteObserver(role);
		}
		List<ToRole> list = this.toRoles.get(serviceName);
		if(list != null) {
			list.remove(role);
		}
	}
	
	
	// IContext methods
	
	public void declare(RequiredPort port, String serviceName) {
		this.contextTool.declare(port,serviceName);
	}

	public void undeclare(RequiredPort port, String serviceName) {
		this.contextTool.undeclare(port,serviceName);
	}

	public void declare(ProvidedPort port, String serviceName) {
		this.contextTool.declare(port,serviceName);
	}

	public void undeclare(ProvidedPort port, String serviceName) {
		this.contextTool.undeclare(port,serviceName);
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
