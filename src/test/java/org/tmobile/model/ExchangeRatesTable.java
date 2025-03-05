package org.tmobile.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRatesTable {

  @XmlElement(name = "Table")
  private String table;

  @XmlElement(name = "No")
  private String no;

  @XmlElement(name = "EffectiveDate")
  private String effectiveDate;

  @XmlElementWrapper(name = "Rates")
  @XmlElement(name = "Rate")
  private List<Rate> rates;
}
