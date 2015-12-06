package org.alma.csa.insolentmeow.global.server;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.Configuration;
import org.alma.csa.insolentmeow.global.server.clearance.ClearanceRequest;
import org.alma.csa.insolentmeow.global.server.connexionManager.ConnexionManager;
import org.alma.csa.insolentmeow.global.server.database.Database;
import org.alma.csa.insolentmeow.global.server.port.ExternalReceivedRequestPort;
import org.alma.csa.insolentmeow.global.server.port.ExternalReceivedRequestResponsePort;
import org.alma.csa.insolentmeow.global.server.securityManager.SecurityManager;
import org.alma.csa.insolentmeow.global.server.securityQuery.SecurityQuery;
import org.alma.csa.insolentmeow.global.server.service.ExternalReceivedRequestResponseService;
import org.alma.csa.insolentmeow.global.server.service.ExternalReceivedRequestService;
import org.alma.csa.insolentmeow.global.server.sql.SQLQuery;

public class Serveur extends Configuration {

    ConnexionManager connexionManager;
    SecurityManager securityManager;
    Database database;
    ClearanceRequest clearanceRequest;
    SQLQuery sqlQuery;
    SecurityQuery securityQuery;
    ExternalReceivedRequestPort externalReceivedRequestPort;
    ExternalReceivedRequestResponsePort externalReceivedRequestResponsePort;
    ExternalReceivedRequestService externalReceivedRequestService;
    ExternalReceivedRequestResponseService externalReceivedRequestResponseService;

    public Serveur(IContext context){
        super(context);
        connexionManager = new ConnexionManager(this);
        securityManager = new SecurityManager(this);
        database = new Database(this);
        clearanceRequest = new ClearanceRequest(this);
        sqlQuery = new SQLQuery(this);
        securityQuery = new SecurityQuery(this);
        externalReceivedRequestPort = new ExternalReceivedRequestPort();
        this.getContext().declare(externalReceivedRequestPort,"Request");
        externalReceivedRequestResponsePort = new ExternalReceivedRequestResponsePort();
        this.getContext().declare(externalReceivedRequestResponsePort,"RequestResponse");
        externalReceivedRequestService = new ExternalReceivedRequestService();
        externalReceivedRequestResponseService = new ExternalReceivedRequestResponseService();
        this.bind(externalReceivedRequestPort,"Request");
        this.bind(externalReceivedRequestResponsePort,"RequestResponse");
    }
}
