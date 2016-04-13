package com.qoantum.phonebook.common;

import java.io.Serializable;

/**
 * All entities that will be persisted has to implement this clazz
 */
public interface Entity extends Serializable, Cloneable, Comparable<Entity> {

    /**
     * The identifier of an entity
     *
     * @return Long the entity identifier
     */
    Long getId();

    /**
     * The status of a persisted entity
     *
     * @return RecordStatus entity status
     */
    RecordStatus getRecordStatus();

    /**
     * Set the status of a record
     *
     * @param recordStatus the status of the record
     */
    void setRecordStatus(RecordStatus recordStatus);
}
