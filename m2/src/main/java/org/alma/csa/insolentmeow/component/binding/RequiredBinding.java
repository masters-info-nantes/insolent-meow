package org.alma.csa.insolentmeow.component.binding;

import java.util.Observable;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;

public class RequiredBinding extends AbstractBinding {
	
	public RequiredBinding() {
		super();
	}
	
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}
}
