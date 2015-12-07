package org.alma.csa.insolentmeow;

// m2
import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;
import org.alma.csa.insolentmeow.interfaces.connexions.role.*;
// m1
import org.alma.csa.insolentmeow.global.ClientServer;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World! M0");
		ClientServer cs = new ClientServer(new IContext() {
			public void declare(RequiredPort port, String serviceName){}
			public void undeclare(RequiredPort port, String serviceName){}
			public void declare(ProvidedPort port, String serviceName){}
			public void undeclare(ProvidedPort port, String serviceName){}
			public void attach(FromRole role, String serviceName){}
			public void unattach(FromRole role, String serviceName){}
			public void attach(ToRole role, String serviceName){}
			public void unattach(ToRole role, String serviceName){}
		});
		cs.run();
	}
}
