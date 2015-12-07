package org.alma.csa.insolentmeow.global.client;

import org.alma.csa.insolentmeow.IContext;
import org.alma.csa.insolentmeow.component.Component;
import org.alma.csa.insolentmeow.global.client.port.LogOutputPort;
import org.alma.csa.insolentmeow.global.client.port.SendRequestPort;
import org.alma.csa.insolentmeow.global.client.port.SendRequestResponsePort;
import org.alma.csa.insolentmeow.global.client.service.LogOutputService;
import org.alma.csa.insolentmeow.global.client.service.SendRequestResponseService;
import org.alma.csa.insolentmeow.global.client.service.SendRequestService;


public class Client extends Component{

    LogOutputPort logOutputPort;
    LogOutputService logOutputService;
    SendRequestPort sendRequestPort;
    SendRequestResponsePort sendRequestResponsePort;
    SendRequestService sendRequestService;
    SendRequestResponseService sendRequestResponseService;

    public Client(IContext context){
        super(context);
        logOutputPort = new LogOutputPort();
            addProvidedPorts(logOutputPort);
            logOutputPort.setParent(this);
            this.getContext().declare(logOutputPort,"logOutput");
        logOutputService = new LogOutputService();
            addProvidedServices(logOutputService);
            logOutputService.setParent(this);
        sendRequestPort = new SendRequestPort();
            addProvidedPorts(sendRequestPort);
            sendRequestPort.setParent(this);
            this.getContext().declare(sendRequestPort,"sendRequestPort");
        sendRequestResponsePort = new SendRequestResponsePort();
            addRequiredPorts(sendRequestResponsePort);
            sendRequestResponsePort.setParent(this);
            this.getContext().declare(sendRequestResponsePort,"sendRequestResponsePort");
        sendRequestService = new SendRequestService();
            sendRequestService.setParent(this);
            addProvidedServices(sendRequestService);
        sendRequestResponseService = new SendRequestResponseService();
            sendRequestResponseService.setParent(this);
            addRequiredServices(sendRequestResponseService);
        logOutputPort.addService(logOutputService);
        logOutputService.addPort(logOutputPort);
        sendRequestPort.addService(sendRequestService);
        sendRequestService.addPort(sendRequestPort);
        sendRequestResponsePort.addService(sendRequestResponseService);
        sendRequestResponseService.addPort(sendRequestResponsePort);
    }
}
