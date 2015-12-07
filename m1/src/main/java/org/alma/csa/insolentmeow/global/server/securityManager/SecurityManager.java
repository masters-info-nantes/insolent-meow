package org.alma.csa.insolentmeow.global.server.securityManager;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.Component;
import org.alma.csa.insolentmeow.global.server.securityManager.query.port.QueryCheckInPort;
import org.alma.csa.insolentmeow.global.server.securityManager.query.port.QueryCheckOutPort;
import org.alma.csa.insolentmeow.global.server.securityManager.query.service.QueryCheckInService;
import org.alma.csa.insolentmeow.global.server.securityManager.query.service.QueryCheckOutService;
import org.alma.csa.insolentmeow.global.server.securityManager.security.port.SecurityAuthInPort;
import org.alma.csa.insolentmeow.global.server.securityManager.security.port.SecurityAuthOutPort;
import org.alma.csa.insolentmeow.global.server.securityManager.security.service.SecurityAuthInService;
import org.alma.csa.insolentmeow.global.server.securityManager.security.service.SecurityAuthOutService;

public class SecurityManager extends Component {

    SecurityAuthInPort securityAuthInPort;
    SecurityAuthOutPort securityAuthOutPort;
    SecurityAuthInService securityAuthInService;
    SecurityAuthOutService securityAuthOutService;
    QueryCheckInPort queryCheckInPort;
    QueryCheckOutPort queryCheckOutPort;
    QueryCheckInService queryCheckInService;
    QueryCheckOutService queryCheckOutService;

    public SecurityManager(IContext context){
        super(context);
        securityAuthInPort = new SecurityAuthInPort();
        this.getContext().declare(securityAuthInPort,"securityAuthInPort");
        securityAuthOutPort = new SecurityAuthOutPort();
        this.getContext().declare(securityAuthOutPort,"securityAuthOutPort");
        securityAuthInService = new SecurityAuthInService();
        securityAuthOutService = new SecurityAuthOutService();
        queryCheckInPort = new QueryCheckInPort();
        this.getContext().declare(queryCheckInPort,"queryCheckInPort");
        queryCheckOutPort = new QueryCheckOutPort();
        this.getContext().declare(queryCheckOutPort,"queryCheckOutPort");
        queryCheckInService = new QueryCheckInService();
        queryCheckOutService = new QueryCheckOutService();
        securityAuthInPort.addService(securityAuthInService);
        securityAuthInService.addPort(securityAuthInPort);
        securityAuthOutPort.addService(securityAuthOutService);
        securityAuthOutService.addPort(securityAuthOutPort);
        queryCheckInPort.addService(queryCheckInService);
        queryCheckInService.addPort(queryCheckInPort);
        queryCheckOutPort.addService(queryCheckOutService);
        queryCheckOutService.addPort(queryCheckOutPort);

    }
}
