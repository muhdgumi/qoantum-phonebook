package com.qoantum.phonebook.api;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Session dto for authentication
 */
@Getter
@Setter
@XmlRootElement(name = "authSessionDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthSessionDto implements Serializable {

    private static final long serialVersionUID = -3306151213289474322L;

    private String token;

    private Long userId;

    private String userName;

    private Date createdDate;

    private List<String> roles;

    private List<Long> groups;


}
