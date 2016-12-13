package org.elasticsearch.index.analysis;

/**
 * Created by RogerHsu on 2016/12/13.
 */

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.settings.IndexSettings;
import org.apache.lucene.analysis.Analyzer;

public class FubukiGapAnalyzerProvider extends AbstractIndexAnalyzerProvider{

    private final Analyzer analyzer;

    @Inject
    public FubukiGapAnalyzerProvider(Index index, @IndexSettings Settings indexSettings, Environment env, @Assisted String name, @Assisted Settings settings) {
        super(index, indexSettings, name, settings);
        analyzer = new StandardAnalyzer();
    }

    @Override
    public Analyzer get() {
        return this.analyzer;
    }
}
