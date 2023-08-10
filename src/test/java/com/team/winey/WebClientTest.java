package com.team.winey;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.team.winey.wine.model.Match;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebClientTest {

    @Test
    public void webClient() {
        // 기본 설정으로 생성

        TcpClient tcpClient = TcpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                });

        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)) // to unlimited memory size
                .build();

        WebClient wc = WebClient
                .builder()
                .exchangeStrategies(exchangeStrategies)
                .baseUrl("https://www.vivino.com")
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)

                .build();


        String jsonStr = wc.get().uri(uriBuilder ->
                        uriBuilder.path("/api/explore/explore")
                                .queryParam("country_code", "KR")
                                .queryParam("currency_code", "KRW")
                                .queryParam("grape_filter", "varietal")
                                .queryParam("min_rating", "1")
                                .queryParam("price_range_max", "500000")
                                .queryParam("price_range_min", "0")
                                .queryParam("wine_type_ids", "1")
                                .queryParam("wine_type_ids", "2")
                                .queryParam("wine_type_ids", "3")
                                .queryParam("wine_type_ids", "4")
                                .queryParam("wine_type_ids", "7")
                                .queryParam("wine_type_ids", "24")
                                .queryParam("page", "2")
                                .queryParam("language", "en")
                                .build()
                ).retrieve()
                .bodyToMono(String.class)
                .block();


        ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode jsonNode = null;

        try {
            jsonNode = om.readTree(jsonStr);
            List<Match> list = om.convertValue(jsonNode.path("explore_vintage").path("matches"), new TypeReference<List<Match>>() {});
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
