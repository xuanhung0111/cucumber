package com.zinio.zenith.models.entitlement;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.zinio.zenith.util.json.CustomSqlTimestampSerializer;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by ducnguyen on 9/23/16.
 */
@Entity
@Table(name = "zen_entitlement.issue_entitlements", schema = "zen_entitlement", catalog = "",
        indexes = {
                @Index(name = "entitlement_unique", columnList = "user_id,device_id,project_id,status,issue_id,order_id", unique = true),
                @Index(name = "IDX_device_ie", columnList = "device_id,status,issue_id")
        })
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IssueEntitlementsEntity {
    private long id;
    private long userId;
    private long deviceId;
    private long issueId;
    private long publicationId;
    private long projectId;
    private String legacyIdentifier;
    private Short type;
    private short status;
    @JsonDeserialize(using = CustomSqlTimestampSerializer.class)
    private Timestamp createdAt;
    private long orderId;
    private Long deliveryId;
    @JsonDeserialize(using = CustomSqlTimestampSerializer.class)
    private Timestamp modifiedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "device_id", nullable = false)
    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "issue_id", nullable = false)
    public long getIssueId() {
        return issueId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    @Basic
    @Column(name = "publication_id", nullable = false)
    public long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(long publicationId) {
        this.publicationId = publicationId;
    }

    @Basic
    @Column(name = "project_id", nullable = false)
    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "legacy_identifier", nullable = true, length = 255)
    public String getLegacyIdentifier() {
        return legacyIdentifier;
    }

    public void setLegacyIdentifier(String legacyIdentifier) {
        this.legacyIdentifier = legacyIdentifier;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "order_id", nullable = false)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "delivery_id", nullable = true)
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "modified_at", nullable = true)
    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IssueEntitlementsEntity that = (IssueEntitlementsEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (deviceId != that.deviceId) return false;
        if (issueId != that.issueId) return false;
        if (publicationId != that.publicationId) return false;
        if (projectId != that.projectId) return false;
        if (status != that.status) return false;
        if (orderId != that.orderId) return false;
        if (legacyIdentifier != null ? !legacyIdentifier.equals(that.legacyIdentifier) : that.legacyIdentifier != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (deliveryId != null ? !deliveryId.equals(that.deliveryId) : that.deliveryId != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(that.modifiedAt) : that.modifiedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (deviceId ^ (deviceId >>> 32));
        result = 31 * result + (int) (issueId ^ (issueId >>> 32));
        result = 31 * result + (int) (publicationId ^ (publicationId >>> 32));
        result = 31 * result + (int) (projectId ^ (projectId >>> 32));
        result = 31 * result + (legacyIdentifier != null ? legacyIdentifier.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (deliveryId != null ? deliveryId.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
        return result;
    }
}
