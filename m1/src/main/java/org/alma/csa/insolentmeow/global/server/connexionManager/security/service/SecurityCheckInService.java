package org.alma.csa.insolentmeow.global.server.connexionManager.security.service;

import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;
import org.alma.csa.insolentmeow.interfaces.service.RequiredService;

public class SecurityCheckInService extends RequiredService {

    public SecurityCheckInService(){
        super("securityCheckIn");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        for(ProvidedService s : getParent().getProvidedServices()) {
            if (s.getServiceName().equals("dbQueryOut")) {
                s.performAction(arg);
            }
        }
    }
}
