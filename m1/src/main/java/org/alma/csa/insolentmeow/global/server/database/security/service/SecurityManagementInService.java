package org.alma.csa.insolentmeow.global.server.database.security.service;

import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;
import org.alma.csa.insolentmeow.interfaces.service.RequiredService;

public class SecurityManagementInService extends RequiredService {

    public SecurityManagementInService(){
        super("securityManagementIn");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        for(ProvidedService s : getParent().getProvidedServices()) {
            if (s.getServiceName().equals("securityManagementOut")) {
                s.performAction(arg);
            }
        }
    }
}
