package com.unico.api

class RestController {

    def index() {
        render "please refer api docs."
    }

    def jmsService


    def push(Integer num1,Integer num2) {
        if (num1 && num2) {
            jmsService.send(queue:'msg.new', num1)
            jmsService.send(queue:'msg.new', num2)
            render(contentType: 'application/json'){
                [result: 'CREATED']
            }
            return
        }
        render(contentType: 'application/json'){
            [result: 'Please give valid inputs']
        }

    }

    def list() {
        List messages =  JmsNumber.listOrderById()
        messages=messages?messages*.num:[]
        render(contentType: 'application/json') {
            [messages: messages]
        }

    }
}
