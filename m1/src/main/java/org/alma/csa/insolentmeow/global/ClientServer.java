package org.alma.csa.insolentmeow.global;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.Configuration;
import org.alma.csa.insolentmeow.global.client.Client;
import org.alma.csa.insolentmeow.global.client.port.ClientLogOutput;
import org.alma.csa.insolentmeow.global.rpc.RPC;
import org.alma.csa.insolentmeow.global.server.Serveur;

public class ClientServer extends Configuration {

    Client client;
    Serveur serveur;
    RPC rpc;
    ClientLogOutput clientLogOutput;

    public ClientServer(IContext context){
        super(context);
        client = new Client(this);
        serveur = new Serveur(this);
        rpc = new RPC(this);
        clientLogOutput = new ClientLogOutput();
        clientLogOutput.setParent(this);
        addProvidedPorts(clientLogOutput);
        this.getContext().declare(clientLogOutput,"clientLogOutput");
        this.bind(clientLogOutput,"logOutput");
    }

    public void run(){
        client.getProvidedServices().get(0).performAction("hello");
    }
}
