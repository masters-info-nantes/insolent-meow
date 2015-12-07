package org.alma.csa.insolentmeow.global.server.securityManager.query.service;

import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;
import org.alma.csa.insolentmeow.interfaces.service.RequiredService;

public class QueryCheckInService extends RequiredService {

    public QueryCheckInService(){
        super("queryCheckIn");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        for(ProvidedService s : getParent().getProvidedServices()) {
            if (s.getServiceName().equals("securityAuthOut")) {
                s.performAction(arg);
            }
        }
    }
}
