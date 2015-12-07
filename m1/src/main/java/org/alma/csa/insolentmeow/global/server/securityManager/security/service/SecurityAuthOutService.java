package org.alma.csa.insolentmeow.global.server.securityManager.security.service;

import org.alma.csa.insolentmeow.interfaces.connexions.port.ProvidedPort;
import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;

public class SecurityAuthOutService extends ProvidedService {

    public SecurityAuthOutService(){
        super("securityAuthOut");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        ((ProvidedPort)getPorts().get(0)).diffuse(arg);
    }
}
