package org.alma.csa.insolentmeow.global.client;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.Component;
import org.alma.csa.insolentmeow.global.client.port.LogOutput;
import org.alma.csa.insolentmeow.global.client.port.SendRequestPort;
import org.alma.csa.insolentmeow.global.client.port.SendRequestResponsePort;
import org.alma.csa.insolentmeow.global.client.service.SendRequestResponseService;
import org.alma.csa.insolentmeow.global.client.service.SendRequestService;


public class Client extends Component{

    LogOutput logOutput;
    SendRequestPort sendRequestPort;
    SendRequestResponsePort sendRequestResponsePort;
    SendRequestService sendRequestService;
    SendRequestResponseService sendRequestResponseService;

    public Client(IContext context){
        super(context);
        logOutput = new LogOutput();
        this.getContext().declare(logOutput,"LogOutput");
        sendRequestPort = new SendRequestPort();
        this.getContext().declare(sendRequestPort,"SendRequestPort");
        sendRequestResponsePort = new SendRequestResponsePort();
        this.getContext().declare(sendRequestResponsePort,"SendRequestResponsePort");
        sendRequestService = new SendRequestService();
        sendRequestResponseService = new SendRequestResponseService();
        sendRequestPort.addService(sendRequestService);
        sendRequestService.addPort(sendRequestPort);
        sendRequestResponsePort.addService(sendRequestResponseService);
        sendRequestResponseService.addPort(sendRequestResponsePort);
    }
}
