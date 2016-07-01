package fubuki.plugin;

import fubuki.rest.HelloWorldAction;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.rest.RestModule;

public class HelloWorldPlugin extends AbstractPlugin {

    public String name() {
        return "simple";
    }

    public String description() {
        return "simple Plugin";
    }

    @Override public void processModule(Module module) {
        if (module instanceof RestModule) {
            ((RestModule) module).addRestAction(HelloWorldAction.class);
        }
    }
}
