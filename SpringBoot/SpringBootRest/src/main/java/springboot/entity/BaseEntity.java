package springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.sql.Timestamp;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {
    @Column(name="createtime", updatable = false)
    @CreationTimestamp
    @CreatedDate
    protected Timestamp createtime;

    @Column(name="createdby",updatable = false)
    @CreatedBy
    protected String createdby;

    @Column(name="modifiedtime")
    @LastModifiedDate
    @UpdateTimestamp
    protected Timestamp modifiedtime;

    @Column(name="modifiedby")
    @LastModifiedBy
    protected String modifiedby;

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Timestamp getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Timestamp modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }
}
