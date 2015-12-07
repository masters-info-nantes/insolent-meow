package org.alma.csa.insolentmeow.global.server.securityManager.query.service;

import org.alma.csa.insolentmeow.interfaces.connexions.port.ProvidedPort;
import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;

public class QueryCheckOutService extends ProvidedService {

    public QueryCheckOutService(){
        super("queryCheckOut");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        ((ProvidedPort)getPorts().get(0)).diffuse(arg);
    }
}
