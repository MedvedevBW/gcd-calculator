package com.bwsw.test.gcdcalculator.services;

import com.bwsw.test.gcdcalculator.common.GcdCalculator;
import com.bwsw.test.gcdcalculator.config.AppConfig;
import com.bwsw.test.gcdcalculator.entities.GcdCalculationRequest;
import com.bwsw.test.gcdcalculator.entities.GcdCalculationResponse;
import com.bwsw.test.gcdcalculator.rabbitmq.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@EnableRabbit
@Service
public class GcdCalculatingService {
    private static final Logger logger = LoggerFactory.getLogger(GcdCalculatingService.class);
    private final RabbitTemplate rabbitTemplate;
    private AppConfig config;
    private Producer<GcdCalculationResponse> producer;

    @Autowired
    public GcdCalculatingService(RabbitTemplate rabbitTemplate, AppConfig config, Producer<GcdCalculationResponse> producer) {
        this.rabbitTemplate = rabbitTemplate;
        this.config = config;
        this.producer = producer;
    }

    @RabbitListener(queues = "${app.rabbitmq.questionQueue}")
    public void recieveMessage(GcdCalculationRequest request) {
        logger.info("recieveMessage: {}", request);
        String exchange = config.getAppExchange();
        String routingKey = config.getAppRoutingKey();

        try {
            long result = GcdCalculator.calculateGcd(request.getFirst(), request.getSecond());
            logger.info("Calculated gcd for arguments: {} and {} is {}", request.getFirst(), request.getSecond(), result);
            producer.sendMessage(
                rabbitTemplate,
                exchange,
                routingKey,
                new GcdCalculationResponse(request.getId(), result)
            );
        } catch (Throwable exception) {
            logger.error("Can not calculate gcd and send response, exceptin with message: {} was thrown", exception.getMessage());
            producer.sendMessage(
                    rabbitTemplate,
                    exchange,
                    routingKey,
                    new GcdCalculationResponse(request.getId(), exception.getMessage())
            );
        }
    }
}
