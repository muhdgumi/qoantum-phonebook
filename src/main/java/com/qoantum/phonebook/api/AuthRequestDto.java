package com.qoantum.phonebook.api;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Authentication request dto
 */
@Getter
@Setter
@XmlRootElement(name = "authRequestDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthRequestDto implements Serializable {

    private static final long serialVersionUID = -550386005931269873L;

    private String username;

    private String password;
}
