package com.qoantum.phonebook.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
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

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdDate;

    @XmlElementWrapper(name = "roles")
    @XmlElement(name = "role")
    private List<String> roles;

    @XmlElementWrapper(name = "groups")
    @XmlElement(name = "group")
    private List<Long> groups;

    public boolean isRolePresent(final String role) { return roles.contains(role); }

    public boolean isMemberOf(final Long groupId) { return groups.contains(groupId); }
}
