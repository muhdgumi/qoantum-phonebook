package com.qoantum.phonebook.common;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * An entity that will be extended by all entities
 */
@Getter
@Setter
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractEntity implements Entity {

    private static final long serialVersionUID = 9007260780140055087L;

    @Id
    @GeneratedValue(generator = "optimized-sequence")
    @GenericGenerator(
            name = "optimized-sequence",
            strategy = "enhanced-sequence",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "prefer_sequence_per_entity", value = "true"),
                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    private Long id;

    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    @Override
    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass().equals(obj.getClass())) {
            final Entity entity = (Entity) obj;
            return Objects.equals(this.getId(), entity.getId()) || this.getId().equals(entity.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getId() != null ? this.getId().hashCode() : 31;
    }

    @Override
    public int compareTo(Entity o) {
        return this.getId().compareTo(o.getId());
    }
}
