package org.alma.csa.insolentmeow.global.server.port;

import org.alma.csa.insolentmeow.interfaces.connexions.port.RequiredConfigPort;

public class ExternalReceivedRequestPort extends RequiredConfigPort {

    public ExternalReceivedRequestPort(){
        super("externalReceivedRequest");
    }
}
