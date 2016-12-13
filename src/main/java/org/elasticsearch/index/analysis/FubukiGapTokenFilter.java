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

        if (!input.incrementToken()) {
            return false;
        }

        String str = termAttribute.toString();

        final int posIncrement = posIncAttribute.getPositionIncrement();

        if (str.equalsIgnoreCase("test")) {
            posIncAttribute.setPositionIncrement(100);
            //positionLengthAttribute.setPositionLength(29);
            return true;
        }

        return true;
    }

    @Override
    public final void reset() throws IOException {
        super.reset();
    }
}
