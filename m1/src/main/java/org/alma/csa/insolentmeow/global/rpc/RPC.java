package org.alma.csa.insolentmeow.global.rpc;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.connector.Glue;
import org.alma.csa.insolentmeow.connector.SimpleConnector;
import org.alma.csa.insolentmeow.global.rpc.client.FromClient;
import org.alma.csa.insolentmeow.global.rpc.client.ToClient;
import org.alma.csa.insolentmeow.global.rpc.server.FromServer;
import org.alma.csa.insolentmeow.global.rpc.server.ToServer;

public class RPC extends SimpleConnector {

    FromClient fromClient;
    ToClient toClient;
    FromServer fromServer;
    ToServer toServer;

    public RPC(IContext context){
        super(context, new Glue());
        fromClient = new FromClient();
        this.getContext().attach(fromClient,"sendRequestPort");
        toClient = new ToClient();
        this.getContext().attach(toClient,"sendRequestResponsePort");
        fromServer = new FromServer();
        this.getContext().attach(fromServer,"request");
        toServer = new ToServer();
        this.getContext().attach(toServer,"requestResponse");
    }
}
