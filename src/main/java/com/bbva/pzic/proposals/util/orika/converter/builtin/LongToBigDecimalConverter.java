package com.bbva.pzic.proposals.util.orika.converter.builtin;

import com.bbva.pzic.proposals.util.orika.converter.BidirectionalConverter;
import com.bbva.pzic.proposals.util.orika.metadata.Type;

import java.math.BigDecimal;

/**
 * Created on 14/12/2015.
 *
 * @author Entelgy
 */
public class LongToBigDecimalConverter extends BidirectionalConverter<Long, BigDecimal> {

    @Override
    public BigDecimal convertTo(Long source, Type<BigDecimal> destinationType) {
        return source == null ? null : new BigDecimal(source);
    }

    @Override
    public Long convertFrom(BigDecimal source, Type<Long> destinationType) {
        return source == null ? null : source.longValue();
    }
}
