package org.alma.csa.insolentmeow.global;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.Configuration;
import org.alma.csa.insolentmeow.global.client.Client;
import org.alma.csa.insolentmeow.global.client.port.ClientLogOutput;
import org.alma.csa.insolentmeow.global.rpc.RPC;
import org.alma.csa.insolentmeow.global.server.Serveur;

public class ClientServer extends Configuration {

    Client client;
    RPC rpc;
    Serveur serveur;
    ClientLogOutput clientLogOutput;

    public ClientServer(IContext context){
        super(context);
        client = new Client(this);
        rpc = new RPC(this);
        serveur = new Serveur(this);
        clientLogOutput = new ClientLogOutput();
        this.getContext().declare(clientLogOutput,"ClientLogOutput");
    }
}
