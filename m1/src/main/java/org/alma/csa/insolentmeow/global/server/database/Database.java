package org.alma.csa.insolentmeow.global.server.database;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.Component;
import org.alma.csa.insolentmeow.global.server.database.query.port.QueryDatabaseInPort;
import org.alma.csa.insolentmeow.global.server.database.query.port.QueryDatabaseOutPort;
import org.alma.csa.insolentmeow.global.server.database.query.service.QueryDatabaseInService;
import org.alma.csa.insolentmeow.global.server.database.query.service.QueryDatabaseOutService;
import org.alma.csa.insolentmeow.global.server.database.security.port.SecurityManagementInPort;
import org.alma.csa.insolentmeow.global.server.database.security.port.SecurityManagementOutPort;
import org.alma.csa.insolentmeow.global.server.database.security.service.SecurityManagementInService;
import org.alma.csa.insolentmeow.global.server.database.security.service.SecurityManagementOutService;

public class Database extends Component {

    SecurityManagementInPort securityManagementInPort;
    SecurityManagementOutPort securityManagementOutPort;
    SecurityManagementInService securityManagementInService;
    SecurityManagementOutService securityManagementOutService;
    QueryDatabaseInPort queryDatabaseInPort;
    QueryDatabaseOutPort queryDatabaseOutPort;
    QueryDatabaseInService queryDatabaseInService;
    QueryDatabaseOutService queryDatabaseOutService;

    public Database(IContext context){
        super(context);
        securityManagementInPort = new SecurityManagementInPort();
            addRequiredPorts(securityManagementInPort);
            securityManagementInPort.setParent(this);
            this.getContext().declare(securityManagementInPort,"securityManagementInPort");
        securityManagementOutPort = new SecurityManagementOutPort();
            addProvidedPorts(securityManagementOutPort);
            securityManagementOutPort.setParent(this);
            this.getContext().declare(securityManagementOutPort,"securityManagementOutPort");
        securityManagementInService = new SecurityManagementInService();
            addRequiredServices(securityManagementInService);
            securityManagementInService.setParent(this);
        securityManagementOutService = new SecurityManagementOutService();
            addProvidedServices(securityManagementOutService);
            securityManagementOutService.setParent(this);
        queryDatabaseInPort = new QueryDatabaseInPort();
            addRequiredPorts(queryDatabaseInPort);
            queryDatabaseInPort.setParent(this);
            this.getContext().declare(queryDatabaseInPort,"queryDatabaseInPort");
        queryDatabaseOutPort = new QueryDatabaseOutPort();
            addProvidedPorts(queryDatabaseOutPort);
            queryDatabaseOutPort.setParent(this);
            this.getContext().declare(queryDatabaseOutPort,"queryDatabaseOutPort");
        queryDatabaseInService = new QueryDatabaseInService();
            addRequiredServices(queryDatabaseInService);
            queryDatabaseInService.setParent(this);
        queryDatabaseOutService = new QueryDatabaseOutService();
            addProvidedServices(queryDatabaseOutService);
            queryDatabaseOutService.setParent(this);
        securityManagementInPort.addService(securityManagementInService);
        securityManagementInService.addPort(securityManagementInPort);
        securityManagementOutPort.addService(securityManagementOutService);
        securityManagementOutService.addPort(securityManagementOutPort);
        queryDatabaseInPort.addService(queryDatabaseInService);
        queryDatabaseInService.addPort(queryDatabaseInPort);
        queryDatabaseOutPort.addService(queryDatabaseOutService);
        queryDatabaseOutService.addPort(queryDatabaseOutPort);
    }
}
