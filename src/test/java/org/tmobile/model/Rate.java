package org.tmobile.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Rate {

  @XmlElement(name = "Currency")
  private String currency;

  @XmlElement(name = "Code")
  private String code;

  @XmlElement(name = "Mid")
  private double mid;
}
