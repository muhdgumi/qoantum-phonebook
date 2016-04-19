package com.qoantum.phonebook.api;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Group data object
 */
@Getter
@Setter
@XmlRootElement(name = "groupDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupDto implements Serializable {

    private static final long serialVersionUID = -3422817869722189781L;

    private Long id;

    private String name;

    private Long parentId;

    private List<Long> subGroupIds;
}
