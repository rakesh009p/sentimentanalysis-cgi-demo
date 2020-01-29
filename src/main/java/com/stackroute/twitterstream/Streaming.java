package com.stackroute.twitterstream;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Streaming {
    WebClient client = WebClient.builder()
            .baseUrl("https://api.twitter.com/1.1/")
//            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    @GetMapping("/tweets")
    public Flux<Object> getTweets() {
        List<Object> myArray = new ArrayList<>();
        Flux<?> response = Flux.fromIterable(myArray);


        return client.get()
                .uri("users/show.json?screen_name=narendramodi")
                .header("Authorization", "OAuth oauth_consumer_key=\"xN0D23oQ9ZvnNOPtHdOd1BQTW\",oauth_token=\"950068702078148608-USL05uK9I3LQrdmyj0bj6NFmOCbLOsv\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1575525786\",oauth_nonce=\"MrJbWq\",oauth_version=\"1.0\",oauth_signature=\"tq%2FisDEw9T0puohszyq09KSz%2BHI%3D\"")
                .retrieve()
                .bodyToFlux(Object.class);


    }

    public static void main(String[] args) {
        Streaming streams = new Streaming();
        Mono<List<Object>> collect = streams.getTweets().collect(Collectors.toList());
        System.out.println(collect);
    }


}
