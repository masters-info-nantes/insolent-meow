package org.alma.csa.insolentmeow.global.server.securityManager.security.service;

import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;
import org.alma.csa.insolentmeow.interfaces.service.RequiredService;

public class SecurityAuthInService extends RequiredService {

    public SecurityAuthInService(){
        super("securityAuthIn");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        for(ProvidedService s : getParent().getProvidedServices()) {
            if (s.getServiceName().equals("queryCheckOut")) {
                s.performAction(arg);
            }
        }
    }
}
