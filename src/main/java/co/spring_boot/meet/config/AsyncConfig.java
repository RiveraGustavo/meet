package co.spring_boot.meet.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import co.spring_boot.meet.async.BuscarListener;


@Configuration
@ConditionalOnProperty(
    name = "app.rabbitmq.enabled",
    havingValue = "true",
    matchIfMissing = false)
public class AsyncConfig {
    private static final String QUEUE_NAME = "busca-persona";
    private static final String EXCHANGE_NAME = "servicios";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean 
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange)
            .with("meetings.buscar.persona");
    }

    @Bean
    public RabbitAdmin rabbitAdmin(
        ConnectionFactory connectionFactory,
        Queue queue,
        TopicExchange exchange,
        Binding binding) {

        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareExchange(exchange);
        rabbitAdmin.declareBinding(binding);
        return rabbitAdmin;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(BuscarListener listener) {
        return new MessageListenerAdapter(listener, "recibirMensaje");
    }
    @Bean 
    public SimpleMessageListenerContainer container(
        ConnectionFactory connectionFactory, 
        MessageListenerAdapter listenerAdapter) {

        SimpleMessageListenerContainer container;
        container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

}
