package fubuki.rest;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.*;

import static org.elasticsearch.rest.RestRequest.Method.GET;

public class HelloWorldAction extends BaseRestHandler {

    @Inject
    public HelloWorldAction(Settings settings, Client client, RestController controller) {
        super(settings, controller, client);

        controller.registerHandler(GET, "/_hello/", this);
    }

    @Override
    protected void handleRequest(final RestRequest request, final RestChannel channel, final Client client) throws Exception {
        logger.info("HelloWorldAction.handleRequest called");
    }
}
