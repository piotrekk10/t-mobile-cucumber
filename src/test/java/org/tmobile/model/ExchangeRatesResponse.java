package org.tmobile.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "ArrayOfExchangeRatesTable")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRatesResponse {

    @XmlElement(name = "ExchangeRatesTable")
    private ExchangeRatesTable exchangeRatesTable;
}
