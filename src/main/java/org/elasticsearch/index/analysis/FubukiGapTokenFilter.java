package org.elasticsearch.index.analysis;

/**
 * Created by root on 2016/12/13.
 */


import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.util.CharArraySet;

import java.io.IOException;

public class FubukiGapTokenFilter extends TokenFilter{

    private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);
    private final PositionIncrementAttribute posIncAttribute = addAttribute(PositionIncrementAttribute.class);
    private final PositionLengthAttribute positionLengthAttribute = addAttribute(PositionLengthAttribute.class);
    private final OffsetAttribute offsetAttribute = addAttribute(OffsetAttribute.class);


    public FubukiGapTokenFilter(TokenStream in) {
        super(in);
    }

    @Override
    public final boolean incrementToken() throws IOException {

        int gap = 0;
        while (input.incrementToken()) {
            String str = termAttribute.toString();


            if (str.equalsIgnoreCase("test") || str.equalsIgnoreCase("\n")) {
                gap += 1;
                //positionLengthAttribute.setPositionLength(29);
            } else {
                if (gap > 0) {
                    posIncAttribute.setPositionIncrement(100 * gap);
                    gap = 0;
                }

                return true;
            }

        }
        return false;
    }

    @Override
    public final void reset() throws IOException {
        super.reset();
    }
}
