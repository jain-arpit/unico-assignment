package com.unico.api

import grails.plugin.jms.Queue
import grails.transaction.Transactional

@Transactional
class MessageService {

    static exposes = ["jms"]

    @Queue(name = 'msg.new')
    def createMessage(num) {
        def messageInstance = new JmsNumber(num: num)
        if (messageInstance.save(flush: true)) {
            log.info "Saved num: id = ${messageInstance.id}"
        } else {
            log.warn 'Could not save num'
        }
        // explicitly return null to prevent unwanted replyTo queue attempt
        return null
    }

    @Queue(name = 'msg.gcd')
    def gcdInstance(num) {
        def gcdInstance = new Gcd(gcd: num)
        if (gcdInstance.save(flush: true)) {
            log.info "Saved gcd: id = ${gcdInstance.id}"
        } else {
            log.warn 'Could not save gcd'
        }
        // explicitly return null to prevent unwanted replyTo queue attempt
        return null
    }


}
