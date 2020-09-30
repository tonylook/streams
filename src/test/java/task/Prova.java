package task;

import beans.Response;
import mockdata.MockData;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class Prova {
    @Test
    public void groupingAndCounting() throws Exception {
        AtomicInteger result = new AtomicInteger();
        MockData.getResponses().stream()
                .filter(res -> res.getQuestionId().equalsIgnoreCase("1") && res.getAnsweredIndex().intValue() == 1 || res.getQuestionId().equalsIgnoreCase("2") && res.getAnsweredIndex().intValue() == 0)
                .collect(Collectors.groupingBy(Response::getUserId))
                .forEach((user, response) -> {
                    AtomicBoolean iphone = new AtomicBoolean(false);
                    AtomicBoolean car = new AtomicBoolean(false);
                    response.forEach(elem -> {
                        if (elem.getQuestionId().equalsIgnoreCase("1") && elem.getAnsweredIndex().intValue() == 1) iphone.set(true);
                        if (elem.getQuestionId().equalsIgnoreCase("2") && elem.getAnsweredIndex().intValue() == 0) car.set(true);
                        if (car.get() && iphone.get()) result.getAndIncrement();
                    });
                });
        System.out.println(result);
    }
}
