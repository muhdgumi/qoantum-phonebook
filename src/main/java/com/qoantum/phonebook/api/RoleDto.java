package com.qoantum.phonebook.api;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Role data object
 */
@Getter
@Setter
@XmlRootElement(name = "roleDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoleDto implements Serializable {

    private static final long serialVersionUID = 3006822590816701818L;

    private Long id;

    private String name;
}
