package org.alma.csa.insolentmeow.global.server.connexionManager.security.service;

import org.alma.csa.insolentmeow.interfaces.connexions.port.ProvidedPort;
import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;

public class SecurityCheckOutService extends ProvidedService {

    public SecurityCheckOutService(){
        super("securityCheckOut");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        ((ProvidedPort)getPorts().get(0)).diffuse(arg);
    }
}
