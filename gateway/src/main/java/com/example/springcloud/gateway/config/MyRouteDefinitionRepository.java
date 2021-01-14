package com.example.springcloud.gateway.config;

import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Component
public class MyRouteDefinitionRepository implements RouteDefinitionRepository {

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> list = new ArrayList<RouteDefinition>();
        RouteDefinition routeDefinition = new RouteDefinition();

        // route_id: authorization-server
        //  uri: lb://authorization-server:6000
      // predicates: [{"name":"Path","args":{"pattern":"/authorization-server/**"}}]
        //  filters: [{"name":"StripPrefix","args":{"parts":"1"}}]

        routeDefinition.setId("dubbo-consumer");
        try {
            routeDefinition.setUri(new URI("lb://spring-cloud-alibaba-dubbo-client"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicateDefinition.setName("Path");
        Map<String, String> predicates = new HashMap<>();
        predicates.put("pattern", "/spring-cloud-alibaba-dubbo-client/**");
        predicateDefinition.setArgs(predicates);

        Map<String, String> filters = new HashMap<>();
        filters.put("parts", "1");
        FilterDefinition filterDefinition = new FilterDefinition();
        filterDefinition.setName("StripPrefix");
        filterDefinition.setArgs(filters);

        routeDefinition.setPredicates(Arrays.asList(predicateDefinition));
        routeDefinition.setFilters(Arrays.asList(filterDefinition));

        list.add(routeDefinition);
        return Flux.fromIterable(list);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }
}
