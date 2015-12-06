package org.alma.csa.insolentmeow.global.server.connexionManager;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.Component;
import org.alma.csa.insolentmeow.global.server.connexionManager.database.port.DBQueryInPort;
import org.alma.csa.insolentmeow.global.server.connexionManager.database.port.DBQueryOutPort;
import org.alma.csa.insolentmeow.global.server.connexionManager.database.service.DBQueryInService;
import org.alma.csa.insolentmeow.global.server.connexionManager.database.service.DBQueryOutService;
import org.alma.csa.insolentmeow.global.server.connexionManager.request.port.ReceivedRequestPort;
import org.alma.csa.insolentmeow.global.server.connexionManager.request.port.ReceivedRequestResponsePort;
import org.alma.csa.insolentmeow.global.server.connexionManager.request.service.ReceivedRequestResponseService;
import org.alma.csa.insolentmeow.global.server.connexionManager.request.service.ReceivedRequestService;
import org.alma.csa.insolentmeow.global.server.connexionManager.security.port.SecurityCheckInPort;
import org.alma.csa.insolentmeow.global.server.connexionManager.security.port.SecurityCheckOutPort;
import org.alma.csa.insolentmeow.global.server.connexionManager.security.service.SecurityCheckInService;
import org.alma.csa.insolentmeow.global.server.connexionManager.security.service.SecurityCheckOutService;

public class ConnexionManager extends Component {

    DBQueryInPort dbQueryInPort;
    DBQueryOutPort dbQueryOutPort;
    DBQueryInService dbQueryInService;
    DBQueryOutService dbQueryOutService;
    ReceivedRequestPort receivedRequestPort;
    ReceivedRequestResponsePort receivedRequestResponsePort;
    ReceivedRequestService receivedRequestService;
    ReceivedRequestResponseService receivedRequestResponseService;
    SecurityCheckOutPort securityCheckOutPort;
    SecurityCheckInPort securityCheckInPort;
    SecurityCheckOutService securityCheckOutService;
    SecurityCheckInService securityCheckInService;

    public ConnexionManager(IContext context){
        super(context);
        dbQueryInPort = new DBQueryInPort();
        this.getContext().declare(dbQueryInPort,"DBQueryInPort");
        dbQueryOutPort = new DBQueryOutPort();
        this.getContext().declare(dbQueryOutPort,"DBQueryOutPort");
        dbQueryInService = new DBQueryInService();
        dbQueryOutService = new DBQueryOutService();
        receivedRequestPort = new ReceivedRequestPort();
        this.getContext().declare(receivedRequestPort,"receivedRequestPort");
        receivedRequestResponsePort = new ReceivedRequestResponsePort();
        this.getContext().declare(receivedRequestResponsePort,"receivedRequestResponsePort");
        receivedRequestService = new ReceivedRequestService();
        receivedRequestResponseService = new ReceivedRequestResponseService();
        securityCheckOutPort = new SecurityCheckOutPort();
        this.getContext().declare(securityCheckOutPort,"securityCheckOutPort");
        securityCheckInPort = new SecurityCheckInPort();
        this.getContext().declare(securityCheckInPort,"securityCheckInPort");
        securityCheckOutService = new SecurityCheckOutService();
        securityCheckInService = new SecurityCheckInService();
    }
}
