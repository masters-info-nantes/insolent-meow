package org.alma.csa.insolentmeow.global.server.database.query.service;

import org.alma.csa.insolentmeow.interfaces.service.ProvidedService;
import org.alma.csa.insolentmeow.interfaces.service.RequiredService;

public class QueryDatabaseInService extends RequiredService {

    public QueryDatabaseInService(){
        super("queryDatabaseIn");
    }

    @Override
    public void performAction(Object arg) {
        System.out.println(this.getClass().getName()+".performAction");
        for(ProvidedService s : getParent().getProvidedServices()) {
            if (s.getServiceName().equals("queryDatabaseOut")) {
                s.performAction(arg);
            }
        }
    }
}
