package org.elasticsearch.index.analysis;

/**
 * Created by RogerHsu on 2016/12/13.
 */

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.KeywordTokenizer;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.settings.IndexSettings;

import java.io.Reader;

public class FubukiGapTokenTokenizerFactory extends AbstractTokenizerFactory {

    @Inject
    public FubukiGapTokenTokenizerFactory(Index index, @IndexSettings Settings indexSettings, @Assisted String name, @Assisted Settings settings) {
        super(index, indexSettings, name, settings);
    }

    @Override
    public Tokenizer create(Reader reader) {
        return new KeywordTokenizer(reader);
    }
}
