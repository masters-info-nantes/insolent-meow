package org.alma.csa.insolentmeow.global;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.Configuration;
import org.alma.csa.insolentmeow.global.client.port.ClientLogOutput;

public class ClientServer extends Configuration {

    public ClientServer(IContext context){
        super(context);
        ClientLogOutput clientLogOutput = new ClientLogOutput();
        this.getContext().declare(clientLogOutput,"ClientLogOutput");
    }
}
