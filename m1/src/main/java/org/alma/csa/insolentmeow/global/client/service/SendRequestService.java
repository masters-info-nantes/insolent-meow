package org.alma.csa.insolentmeow.global.client.service;

import org.alma.csa.insolentmeow.interfaces.connexions.port.ProvidedPort;
import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;


public class SendRequestService extends ProvidedService{

    public SendRequestService(){
        super("sendRequest");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        ((ProvidedPort)this.getPorts().get(0)).diffuse(arg);
    }
}
