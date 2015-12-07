package org.alma.csa.insolentmeow.global.server.connexionManager.database.service;

import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;
import org.alma.csa.insolentmeow.interfaces.service.RequiredService;

public class DBQueryInService extends RequiredService {

    public DBQueryInService(){
        super("dbQueryIn");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        for(ProvidedService s : getParent().getProvidedServices()) {
            if (s.getServiceName().equals("receivedRequestResponse")) {
                s.performAction(arg);
            }
        }
    }
}
