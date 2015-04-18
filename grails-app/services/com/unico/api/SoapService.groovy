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

    @WebMethod(operationName = 'gcd')
    int gcd() {
        Integer gcd=-1
        List messages=JmsNumber.listOrderById([max:2 ]);
        if(messages){
            Integer num1=messages?.get(0)?.num
            Integer num2=messages?.get(1)?.num
            gcd=computeGcd(num1,num2)
            messages*.delete()
            jmsService.send(queue:'msg.gcd', gcd)
        }
        return gcd
    }

    @WebMethod(operationName = 'gcdList')
    List<Gcd> gcdList() {
        List<Gcd> messages = Gcd.listOrderById();
        return messages
    }

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
