package org.alma.csa.insolentmeow.component;

import java.util.ArrayList;
import java.util.List;
import org.alma.csa.insolentmeow.connector.AbstractConnector;

public abstract class AbstractConfiguration extends AbstractComponent {
	private List<AbstractComponent> composites;
	private List<AbstractConnector> connectors;
	
	public AbstractConfiguration(AbstractConfiguration context) {
		super(context);
		composites = new ArrayList<AbstractComponent>();
		connectors = new ArrayList<AbstractConnector>();
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
	
}
