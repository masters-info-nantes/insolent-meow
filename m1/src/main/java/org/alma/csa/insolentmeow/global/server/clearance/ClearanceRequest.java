package org.alma.csa.insolentmeow.global.server.clearance;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.connector.Glue;
import org.alma.csa.insolentmeow.connector.SimpleConnector;
import org.alma.csa.insolentmeow.global.server.clearance.connexion.CrFromConnexionMgr;
import org.alma.csa.insolentmeow.global.server.clearance.connexion.CrToConnexionMgr;
import org.alma.csa.insolentmeow.global.server.clearance.security.CrFromSecurityMgr;
import org.alma.csa.insolentmeow.global.server.clearance.security.CrToSecurityMgr;

public class ClearanceRequest extends SimpleConnector {

    CrFromConnexionMgr crFromConnexionMgr;
    CrToConnexionMgr crToConnexionMgr;
    CrFromSecurityMgr crFromSecurityMgr;
    CrToSecurityMgr crToSecurityMgr;

    public ClearanceRequest(IContext context){
        super(context);
        crFromConnexionMgr = new CrFromConnexionMgr();
        this.getContext().attach(crFromConnexionMgr,"securityCheckOutPort");
        crToConnexionMgr = new CrToConnexionMgr();
        this.getContext().attach(crToConnexionMgr,"securityCheckInPort");
        crFromSecurityMgr = new CrFromSecurityMgr();
        this.getContext().attach(crFromSecurityMgr,"securityAuthOutPort");
        crToSecurityMgr = new CrToSecurityMgr();
        this.getContext().attach(crToSecurityMgr,"securityAuthInPort");
        this.map(crFromConnexionMgr,"fromConnexionToSecurity");
        this.map(crToSecurityMgr,"fromConnexionToSecurity");
        this.map(crFromSecurityMgr,"fromSecurityToConnexion");
        this.map(crToConnexionMgr,"fromSecurityToConnexion");
    }
}
