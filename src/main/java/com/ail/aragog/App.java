package com.ail.aragog;

import com.spotify.apollo.AppInit;
import com.spotify.apollo.Environment;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;

public final class App {

    public static void main(String... args) throws LoadingException {
        HttpService.boot(App::init, "aragog", args);
    }

    static void init(Environment environment) {
        environment.routingEngine()
                .registerAutoRoute(Route.sync("GET", "/", rc -> "Hello world, my name is Aragog"));
    }
}