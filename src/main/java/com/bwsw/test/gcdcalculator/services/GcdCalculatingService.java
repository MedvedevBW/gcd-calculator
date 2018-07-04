package com.bwsw.test.gcdcalculator.services;

import com.bwsw.test.gcdcalculator.common.GcdCalculator;
import com.bwsw.test.gcdcalculator.entities.GcdCalculationRequest;
import com.bwsw.test.gcdcalculator.entities.GcdResultResponse;
import com.bwsw.test.gcdcalculator.rabbitmq.Producer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GcdCalculatingService {
    @Autowired
    Producer<GcdResultResponse> producer;

    @RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedMessage(GcdCalculationRequest request) {
        try {
            int result = GcdCalculator.calculateGcd(request.getFirstNumber(), request.getSecondNumber());
            producer.produceMsg(new GcdResultResponse(request.getId(), result));
        } catch (Throwable exception){
            producer.produceMsg(new GcdResultResponse(request.getId(), exception.getMessage()));
        }
    }
}
