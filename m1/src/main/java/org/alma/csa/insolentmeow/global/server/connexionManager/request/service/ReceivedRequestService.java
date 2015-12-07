package org.alma.csa.insolentmeow.global.server.connexionManager.request.service;

import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;
import org.alma.csa.insolentmeow.interfaces.service.RequiredService;

public class ReceivedRequestService extends RequiredService {

    public ReceivedRequestService(){
        super("receivedRequest");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        for(ProvidedService s : getParent().getProvidedServices()) {
            if (s.getServiceName().equals("securityCheckOut")) {
                s.performAction(arg);
            }
        }
    }
}
