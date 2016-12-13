package org.elasticsearch.index.analysis;

/**
 * Created by RogerHsu on 2016/12/13.
 */
public class FubukiGapProcessor extends AnalysisModule.AnalysisBinderProcessor  {

    @Override
    public void processTokenFilters(TokenFiltersBindings tokenFiltersBindings) {
        tokenFiltersBindings.processTokenFilter("fubuki_gap", FubukiGapTokenFilterFactory.class);
    }

    @Override
    public void processAnalyzers(AnalyzersBindings analyzersBindings) {
        analyzersBindings.processAnalyzer("fubuki_gap", FubukiGapAnalyzerProvider.class);
    }


    @Override
    public void processTokenizers(TokenizersBindings tokenizersBindings) {
        tokenizersBindings.processTokenizer("fubuki_gap", FubukiGapTokenTokenizerFactory.class);
    }
}