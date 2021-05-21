package com.zinio.zenith.models.identity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.zinio.zenith.util.json.CustomSqlTimestampSerializer;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by ducnguyen on 9/23/16.
 */
@Entity
@Table(name = "zen_identity.users", schema = "zen_identity", catalog = "",
        indexes = {
                @Index(name = "emaildirectory_unique", columnList = "email,directory_id", unique = true),
                @Index(name = "IDX_1483A5E92C94069F", columnList = "directory_id"),
                @Index(name = "IDX_directory_remote", columnList = "directory_id,remote_identifier"),
                @Index(name = "legacy_identifier", columnList = "legacy_identifier")
        })
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UsersEntity {
    private long id;
    private Long directoryId;
    private String email;
    private String password;
    private String remoteIdentifier;
    private String avatarUrl;
    private short encryptionMode;
    private short status;
    private String firstName;
    private String lastName;
    @JsonDeserialize(using = CustomSqlTimestampSerializer.class)
    private Timestamp lastLoginDate;
    @JsonDeserialize(using = CustomSqlTimestampSerializer.class)
    private Timestamp createdAt;
    @JsonDeserialize(using = CustomSqlTimestampSerializer.class)
    private Timestamp modifiedAt;
    private Long createdBy;
    private String legacyIdentifier;
    private String countryCode;
    private Byte registrationStatus;
    @JsonDeserialize(using = CustomSqlTimestampSerializer.class)
    private Timestamp registeredAt;
    private Long modifiedBy;
    private Byte createdByType;
    private Byte type;
    private String internalNotes;
    private Integer lastLoginProjectId;
    private Integer lastLoginApplicationId;
    private Integer lastLoginNewsstandId;
    private Integer lastLoginDeviceId;
    private Short gender;
    private Short purchaseStatus;
    @JsonDeserialize(using = CustomSqlTimestampSerializer.class)
    private Timestamp lastPurchasedAt;
    private Short emailStatus;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "directory_id", nullable = true)
    public Long getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(Long directoryId) {
        this.directoryId = directoryId;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "remote_identifier", nullable = true, length = 255)
    public String getRemoteIdentifier() {
        return remoteIdentifier;
    }

    public void setRemoteIdentifier(String remoteIdentifier) {
        this.remoteIdentifier = remoteIdentifier;
    }

    @Basic
    @Column(name = "avatar_url", nullable = true, length = 255)
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Basic
    @Column(name = "encryption_mode", nullable = false)
    public short getEncryptionMode() {
        return encryptionMode;
    }

    public void setEncryptionMode(short encryptionMode) {
        this.encryptionMode = encryptionMode;
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
    @Column(name = "first_name", nullable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "last_login_date", nullable = true)
    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
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
    @Column(name = "modified_at", nullable = false)
    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Basic
    @Column(name = "created_by", nullable = true)
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
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
    @Column(name = "country_code", nullable = true, length = 2)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "registration_status", nullable = true)
    public Byte getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(Byte registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    @Basic
    @Column(name = "registered_at", nullable = true)
    public Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Timestamp registeredAt) {
        this.registeredAt = registeredAt;
    }

    @Basic
    @Column(name = "modified_by", nullable = true)
    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "created_by_type", nullable = true)
    public Byte getCreatedByType() {
        return createdByType;
    }

    public void setCreatedByType(Byte createdByType) {
        this.createdByType = createdByType;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "internal_notes", nullable = true, length = 255)
    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }

    @Basic
    @Column(name = "last_login_project_id", nullable = true)
    public Integer getLastLoginProjectId() {
        return lastLoginProjectId;
    }

    public void setLastLoginProjectId(Integer lastLoginProjectId) {
        this.lastLoginProjectId = lastLoginProjectId;
    }

    @Basic
    @Column(name = "last_login_application_id", nullable = true)
    public Integer getLastLoginApplicationId() {
        return lastLoginApplicationId;
    }

    public void setLastLoginApplicationId(Integer lastLoginApplicationId) {
        this.lastLoginApplicationId = lastLoginApplicationId;
    }

    @Basic
    @Column(name = "last_login_newsstand_id", nullable = true)
    public Integer getLastLoginNewsstandId() {
        return lastLoginNewsstandId;
    }

    public void setLastLoginNewsstandId(Integer lastLoginNewsstandId) {
        this.lastLoginNewsstandId = lastLoginNewsstandId;
    }

    @Basic
    @Column(name = "last_login_device_id", nullable = true)
    public Integer getLastLoginDeviceId() {
        return lastLoginDeviceId;
    }

    public void setLastLoginDeviceId(Integer lastLoginDeviceId) {
        this.lastLoginDeviceId = lastLoginDeviceId;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "purchase_status", nullable = true)
    public Short getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(Short purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    @Basic
    @Column(name = "last_purchased_at", nullable = true)
    public Timestamp getLastPurchasedAt() {
        return lastPurchasedAt;
    }

    public void setLastPurchasedAt(Timestamp lastPurchasedAt) {
        this.lastPurchasedAt = lastPurchasedAt;
    }

    @Basic
    @Column(name = "email_status", nullable = true)
    public Short getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(Short emailStatus) {
        this.emailStatus = emailStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (encryptionMode != that.encryptionMode) return false;
        if (status != that.status) return false;
        if (directoryId != null ? !directoryId.equals(that.directoryId) : that.directoryId != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (remoteIdentifier != null ? !remoteIdentifier.equals(that.remoteIdentifier) : that.remoteIdentifier != null)
            return false;
        if (avatarUrl != null ? !avatarUrl.equals(that.avatarUrl) : that.avatarUrl != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (lastLoginDate != null ? !lastLoginDate.equals(that.lastLoginDate) : that.lastLoginDate != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(that.modifiedAt) : that.modifiedAt != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (legacyIdentifier != null ? !legacyIdentifier.equals(that.legacyIdentifier) : that.legacyIdentifier != null)
            return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (registrationStatus != null ? !registrationStatus.equals(that.registrationStatus) : that.registrationStatus != null)
            return false;
        if (registeredAt != null ? !registeredAt.equals(that.registeredAt) : that.registeredAt != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createdByType != null ? !createdByType.equals(that.createdByType) : that.createdByType != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (internalNotes != null ? !internalNotes.equals(that.internalNotes) : that.internalNotes != null)
            return false;
        if (lastLoginProjectId != null ? !lastLoginProjectId.equals(that.lastLoginProjectId) : that.lastLoginProjectId != null)
            return false;
        if (lastLoginApplicationId != null ? !lastLoginApplicationId.equals(that.lastLoginApplicationId) : that.lastLoginApplicationId != null)
            return false;
        if (lastLoginNewsstandId != null ? !lastLoginNewsstandId.equals(that.lastLoginNewsstandId) : that.lastLoginNewsstandId != null)
            return false;
        if (lastLoginDeviceId != null ? !lastLoginDeviceId.equals(that.lastLoginDeviceId) : that.lastLoginDeviceId != null)
            return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (purchaseStatus != null ? !purchaseStatus.equals(that.purchaseStatus) : that.purchaseStatus != null)
            return false;
        if (lastPurchasedAt != null ? !lastPurchasedAt.equals(that.lastPurchasedAt) : that.lastPurchasedAt != null)
            return false;
        if (emailStatus != null ? !emailStatus.equals(that.emailStatus) : that.emailStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (directoryId != null ? directoryId.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (remoteIdentifier != null ? remoteIdentifier.hashCode() : 0);
        result = 31 * result + (avatarUrl != null ? avatarUrl.hashCode() : 0);
        result = 31 * result + (int) encryptionMode;
        result = 31 * result + (int) status;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (lastLoginDate != null ? lastLoginDate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (legacyIdentifier != null ? legacyIdentifier.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (registrationStatus != null ? registrationStatus.hashCode() : 0);
        result = 31 * result + (registeredAt != null ? registeredAt.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createdByType != null ? createdByType.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (internalNotes != null ? internalNotes.hashCode() : 0);
        result = 31 * result + (lastLoginProjectId != null ? lastLoginProjectId.hashCode() : 0);
        result = 31 * result + (lastLoginApplicationId != null ? lastLoginApplicationId.hashCode() : 0);
        result = 31 * result + (lastLoginNewsstandId != null ? lastLoginNewsstandId.hashCode() : 0);
        result = 31 * result + (lastLoginDeviceId != null ? lastLoginDeviceId.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (purchaseStatus != null ? purchaseStatus.hashCode() : 0);
        result = 31 * result + (lastPurchasedAt != null ? lastPurchasedAt.hashCode() : 0);
        result = 31 * result + (emailStatus != null ? emailStatus.hashCode() : 0);
        return result;
    }

    
}
