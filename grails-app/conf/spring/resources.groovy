import org.springframework.jms.connection.SingleConnectionFactory
import org.apache.activemq.ActiveMQConnectionFactory
// Place your Spring DSL code here
beans = {
    jmsConnectionFactory(SingleConnectionFactory) {
        targetConnectionFactory = { ActiveMQConnectionFactory cf ->
            brokerURL = 'vm://localhost'
        }
    }
}
