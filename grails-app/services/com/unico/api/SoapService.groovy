package com.unico.api

import org.grails.cxf.utils.EndpointType
import org.grails.cxf.utils.GrailsCxfEndpoint

import javax.jws.WebMethod
import javax.jws.WebResult

@GrailsCxfEndpoint(address = '/soap',expose=EndpointType.SIMPLE)
class SoapService {

//    static expose = ['cxf']
//    static expose = EndpointType.JAX_WS

    def jmsService

    @WebResult(name = 'gcd')
    @WebMethod(operationName = 'gcd')
    int gcd() {
        List messages=JmsNumber.listOrderById([max:2 ]);
        Integer num1=messages?.get(0)?.num
        Integer num2=messages?.get(1)?.num
        Integer gcd=computeGcd(num1,num2)
        messages*.delete()
        jmsService.send(queue:'msg.gcd', gcd)
        return gcd
    }

    @WebResult(name = 'gcdList')
    @WebMethod(operationName = 'gcdList')
    List<Gcd> gcdList() {
        List<Gcd> messages = Gcd.listOrderById();
        return messages
    }

    @WebResult(name = 'gcdSum')
    @WebMethod(operationName = 'gcdSum')
    int  gcdSum() {
        List<Gcd> messages = Gcd.listOrderById();
        Integer sum=(messages*.gcd).sum()
        return sum
    }

    private int computeGcd(int a, int b) {
        return b == 0 ? a : computeGcd(b, a % b)
    }
}
