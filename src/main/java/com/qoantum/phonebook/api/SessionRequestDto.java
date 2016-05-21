package com.qoantum.phonebook.api;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Session request dto
 */
@Getter
@Setter
@XmlRootElement(name = "sessionRequestDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class SessionRequestDto implements Serializable {

    private static final long serialVersionUID = 7049972726986660172L;

    private String token;
}
