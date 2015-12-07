package org.alma.csa.insolentmeow.connector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.connector.Glue;
import org.alma.csa.insolentmeow.interfaces.connexions.role.*;

public class SimpleConnector extends AbstractConnector {
	
	private Map<String,List<FromRole>> fromRoles;
	private Map<String,List<ToRole>> toRoles;
	private Map<String,Glue> glues;
	
	public SimpleConnector(IContext context) {
		super(context);
		this.glues = new HashMap<String,Glue>();
		this.fromRoles = new HashMap<String,List<FromRole>>();
		this.toRoles = new HashMap<String,List<ToRole>>();
	}
	
	public void map(FromRole role, String serviceName) {
		Glue glue = this.glues.get(serviceName);
		if(glue == null) {
			glue = new Glue();
			this.glues.put(serviceName,glue);
		}
		role.addObserver(glue);
	}
	
	public void unmap(FromRole role, String serviceName) {
		Glue glue = this.glues.get(serviceName);
		if(glue != null) {
			role.deleteObserver(glue);
		}
	}
	
	public void map(ToRole role, String serviceName) {
		Glue glue = this.glues.get(serviceName);
		if(glue == null) {
			glue = new Glue();
			this.glues.put(serviceName,glue);
		}
		glue.addObserver(role);
	}
	
	public void unmap(ToRole role, String serviceName) {
		Glue glue = this.glues.get(serviceName);
		if(glue != null) {
			glue.deleteObserver(role);
		}
	}
}
