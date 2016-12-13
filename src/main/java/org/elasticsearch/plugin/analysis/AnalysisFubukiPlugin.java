package org.elasticsearch.plugin.analysis;

import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.index.analysis.FubukiGapProcessor;


/**
 * Created by RogerHsu on 2016/12/13.
 */
public class AnalysisFubukiPlugin extends AbstractPlugin {

    @Override
    public String name() {
        return "kkbox-fubuki";
    }

    @Override
    public String description() {
        return "kkbox-fubuki-gap";
    }

    public void onModule(AnalysisModule module) {
        module.addProcessor(new FubukiGapProcessor());
    }
}
