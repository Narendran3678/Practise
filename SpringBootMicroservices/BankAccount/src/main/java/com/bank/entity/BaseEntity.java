package com.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
    @CreatedDate
    @CreationTimestamp
    @Column(name="createdtime",updatable = false)
    private LocalDateTime createdTime;

    @CreatedBy
    @Column(name="createdby",updatable = false)
    private String createdBy;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name="modifiedtime",updatable = true)
    private LocalDateTime modifiedTime;

    @LastModifiedBy
    @Column(name="modifiedby",updatable = true)
    private String modifiedBy;
}
