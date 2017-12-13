package com.ail.aragog;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.spotify.apollo.Environment;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public final class Aragog {

    private static final Logger log = LoggerFactory.getLogger(Aragog.class);

    public static void main(String... args) throws LoadingException {
        HttpService.boot(Aragog::init, "aragog", args);
    }

    static void init(Environment environment) {
        // do any other config here
        initializeFirebase();

        environment.routingEngine()
                .registerAutoRoute(Route.sync("GET", "/", rc -> "Hello world, my name is Aragog\n"));
    }

    public static void initializeFirebase() {
        FirebaseOptions options = null;
        options = new FirebaseOptions.Builder()
                .setServiceAccount(getServiceCredentials())
                .setDatabaseUrl("https://aragog-83d4e.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);
    }

    public static FileInputStream getServiceCredentials() {
        try {
            return new FileInputStream("./src/main/resources/aragog-83d4e-firebase-adminsdk-qzbrz-69aee7a24b.json");
        } catch (FileNotFoundException e) {
            log.error(e.getLocalizedMessage());
        }
        return null;
    }
}
