package org.alma.csa.insolentmeow.global.server.securityQuery;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.connector.Glue;
import org.alma.csa.insolentmeow.connector.SimpleConnector;
import org.alma.csa.insolentmeow.global.server.securityQuery.database.SqFromDatabase;
import org.alma.csa.insolentmeow.global.server.securityQuery.database.SqToDatabase;
import org.alma.csa.insolentmeow.global.server.securityQuery.security.SqFromSecurityMgr;
import org.alma.csa.insolentmeow.global.server.securityQuery.security.SqToSecurityMgr;

public class SecurityQuery extends SimpleConnector {

    SqFromSecurityMgr sqFromSecurityMgr;
    SqToSecurityMgr sqToSecurityMgr;
    SqToDatabase sqToDatabase;
    SqFromDatabase sqFromDatabase;

    public SecurityQuery(IContext context){
        super(context);
        sqFromSecurityMgr = new SqFromSecurityMgr();
        this.getContext().attach(sqFromSecurityMgr,"queryCheckOutPort");
        sqToSecurityMgr = new SqToSecurityMgr();
        this.getContext().attach(sqToSecurityMgr,"queryCheckInPort");
        sqToDatabase = new SqToDatabase();
        this.getContext().attach(sqToDatabase,"securityManagementInPort");
        sqFromDatabase = new SqFromDatabase();
        this.getContext().attach(sqFromDatabase,"securityManagementOutPort");
        this.map(sqFromSecurityMgr,"fromSecurityToDatabase");
        this.map(sqToDatabase,"fromSecurityToDatabase");
        this.map(sqFromDatabase,"fromDatabaseToSecurity");
        this.map(sqToSecurityMgr,"fromDatabaseToSecurity");
    }
}
