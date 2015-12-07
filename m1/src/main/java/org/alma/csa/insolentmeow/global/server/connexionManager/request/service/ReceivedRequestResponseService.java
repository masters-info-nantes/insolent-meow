package org.alma.csa.insolentmeow.global.server.connexionManager.request.service;

import org.alma.csa.insolentmeow.interfaces.connexions.port.ProvidedPort;
import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;

public class ReceivedRequestResponseService extends ProvidedService {

    public ReceivedRequestResponseService(){
        super("receivedRequestResponse");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        ((ProvidedPort)getPorts().get(0)).diffuse(arg);
    }
}
