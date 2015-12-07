package org.alma.csa.insolentmeow.global.client.service;

import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;
import org.alma.csa.insolentmeow.interfaces.service.RequiredService;

public class SendRequestResponseService extends RequiredService{

    public SendRequestResponseService(){
        super("sendRequestResponse");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        for(ProvidedService s : getParent().getProvidedServices()) {
            if (s.getServiceName().equals("logOutput")) {
                s.performAction(arg);
            }
        }
    }
}
