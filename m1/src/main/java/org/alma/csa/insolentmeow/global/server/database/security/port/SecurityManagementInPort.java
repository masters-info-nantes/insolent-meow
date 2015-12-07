package org.alma.csa.insolentmeow.global.server.database.security.port;

import org.alma.csa.insolentmeow.interfaces.connexions.port.RequiredPort;
import org.alma.csa.insolentmeow.interfaces.service.RequiredService;

public class SecurityManagementInPort extends RequiredPort {

    public SecurityManagementInPort(){
        super("securityManagementIn");
    }
}
