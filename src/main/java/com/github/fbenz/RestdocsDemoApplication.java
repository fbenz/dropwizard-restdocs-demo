package com.github.fbenz;

import com.github.fbenz.resources.BookResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RestdocsDemoApplication extends Application<RestdocsDemoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RestdocsDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-restdocs-demo";
    }

    @Override
    public void initialize(final Bootstrap<RestdocsDemoConfiguration> bootstrap) {
        // Perform initialization here
    }

    @Override
    public void run(final RestdocsDemoConfiguration configuration, final Environment environment) {
        environment.jersey().register(new BookResource());
    }

}
