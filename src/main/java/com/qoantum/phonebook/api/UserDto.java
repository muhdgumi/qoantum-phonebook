package com.qoantum.phonebook.api;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * User data object
 */
@Getter
@Setter
@XmlRootElement(name = "userDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDto implements Serializable {

    private static final long serialVersionUID = -4351609764329999313L;

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private Date dateOfBirth;

    private Date startOfUser;

    private Date endOfUser;
}
