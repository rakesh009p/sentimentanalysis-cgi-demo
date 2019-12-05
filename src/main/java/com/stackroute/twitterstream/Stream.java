package com.stackroute.twitterstream;




import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Stream {
    WebClient client = WebClient.builder()
            .baseUrl("https://api.twitter.com/1.1")
//            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    @GetMapping("/tweets")
    public Flux<?> getTweets() {
        List<Object> myArray = new ArrayList<>();
        Flux<?> response = Flux.fromIterable(myArray);
        System.out.println(response);

        return client.get()
                .uri("/users/show.json?screen_name=narendramodi")
                .header("Authorization", "OAuth oauth_consumer_key=\"xN0D23oQ9ZvnNOPtHdOd1BQTW\",oauth_token=\"950068702078148608-USL05uK9I3LQrdmyj0bj6NFmOCbLOsv\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1575525786\",oauth_nonce=\"MrJbWq\",oauth_version=\"1.0\",oauth_signature=\"tq%2FisDEw9T0puohszyq09KSz%2BHI%3D\"")
                .retrieve()
                .bodyToFlux(Object.class);



//        ,oauth_signature="tnnArxj06cWHq44gCs1OSKk/jLY=  ",oauth_nonce="kYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cg\,oauth_timestamp="1566389000",

    }




}
