package org.alma.csa.insolentmeow.global.server;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.Configuration;
import org.alma.csa.insolentmeow.global.server.connexionManager.ConnexionManager;
import org.alma.csa.insolentmeow.global.server.database.Database;
import org.alma.csa.insolentmeow.global.server.port.ExternalReceivedRequestPort;
import org.alma.csa.insolentmeow.global.server.port.ExternalReceivedRequestResponsePort;
import org.alma.csa.insolentmeow.global.server.securityManager.SecurityManager;
import org.alma.csa.insolentmeow.global.server.securityQuery.SecurityQuery;
import org.alma.csa.insolentmeow.global.server.service.ExternalReceivedRequestResponseService;
import org.alma.csa.insolentmeow.global.server.service.ExternalReceivedRequestService;

public class Serveur extends Configuration {

    ConnexionManager connexionManager;
    SecurityManager securityManager;
    Database database;
    ExternalReceivedRequestPort externalReceivedRequestPort;
    ExternalReceivedRequestResponsePort externalReceivedRequestResponsePort;
    ExternalReceivedRequestService externalReceivedRequestService;
    ExternalReceivedRequestResponseService externalReceivedRequestResponseService;

    public Serveur(IContext context){
        super(context);
        connexionManager = new ConnexionManager(this);
        securityManager = new SecurityManager(this);
        database = new Database(this);
        externalReceivedRequestPort = new ExternalReceivedRequestPort();
        this.getContext().declare(externalReceivedRequestPort,"ExternalReceivedRequestPort");
        externalReceivedRequestResponsePort = new ExternalReceivedRequestResponsePort();
        this.getContext().declare(externalReceivedRequestResponsePort,"ExternalReceivedRequestResponsePort");
        externalReceivedRequestService = new ExternalReceivedRequestService();
        externalReceivedRequestResponseService = new ExternalReceivedRequestResponseService();
    }
}
