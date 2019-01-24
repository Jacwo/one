package service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import service.Hello;

/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2019年01月24日 19:32
 */
public class Client {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(Hello.class);
        factory.setAddress("http://192.168.20.221:8080/cxf");
        Hello hello = (Hello) factory.create();
        String xml = hello.sayHello("zhangsan");
        String str = hello.sayJsonStr("liqineng");
        //ParseJsonStr(str);
    }

    private static void ParseJsonStr(String str) {

    }
}
