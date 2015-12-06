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
        this.getContext().declare(securityManagementInPort,"securityManagementInPort");
        securityManagementOutPort = new SecurityManagementOutPort();
        this.getContext().declare(securityManagementOutPort,"securityManagementOutPort");
        securityManagementInService = new SecurityManagementInService();
        securityManagementOutService = new SecurityManagementOutService();
        queryDatabaseInPort = new QueryDatabaseInPort();
        this.getContext().declare(queryDatabaseInPort,"queryDatabaseInPort");
        queryDatabaseOutPort = new QueryDatabaseOutPort();
        this.getContext().declare(queryDatabaseOutPort,"queryDatabaseOutPort");
        queryDatabaseInService = new QueryDatabaseInService();
        queryDatabaseOutService = new QueryDatabaseOutService();
    }
}
