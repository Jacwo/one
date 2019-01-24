package service;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import service.impl.HelloImpl;

/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2019年01月24日 18:03
 */
public class MainServer {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setAddress("http://192.168.20.221:8080/cxf");
        factory.setServiceClass(HelloImpl.class);
        Server server = factory.create();
        server.start();
    }
}
