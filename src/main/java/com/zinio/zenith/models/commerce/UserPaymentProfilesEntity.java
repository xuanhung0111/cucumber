package com.zinio.zenith.models.commerce;

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
@Table(name = "zen_commerce.user_payment_profiles", schema = "zen_commerce", catalog = "",
        indexes = {
                @Index(
                        name = "user_unique",
                        columnList = "user_id,payment_handler",
                        unique = true
                )
        }
)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserPaymentProfilesEntity {
    private long id;
    private long userId;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postalCode;
    private String countryCode;
    private String provinceCode;
    private String paymentHandler;
    private String remoteIdentifier;
    private String remoteToken;
    private String type;
    private String provider;
    private String last4;
    private String cardHolderName;
    private Byte expirationMonth;
    private Short expirationYear;
    private int version;
    @JsonDeserialize(using = CustomSqlTimestampSerializer.class)
    private Timestamp createdAt;
    @JsonDeserialize(using = CustomSqlTimestampSerializer.class)
    private Timestamp lastUsedAt;
    private Long projectId;
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
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "address", nullable = true, columnDefinition = "TEXT")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "postal_code", nullable = true, length = 100)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "country_code", nullable = true, length = 3)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "province_code", nullable = true, length = 255)
    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Basic
    @Column(name = "payment_handler", nullable = false, length = 100)
    public String getPaymentHandler() {
        return paymentHandler;
    }

    public void setPaymentHandler(String paymentHandler) {
        this.paymentHandler = paymentHandler;
    }

    @Basic
    @Column(name = "remote_identifier", nullable = true, length = 100)
    public String getRemoteIdentifier() {
        return remoteIdentifier;
    }

    public void setRemoteIdentifier(String remoteIdentifier) {
        this.remoteIdentifier = remoteIdentifier;
    }

    @Basic
    @Column(name = "remote_token", nullable = false, length = 50)
    public String getRemoteToken() {
        return remoteToken;
    }

    public void setRemoteToken(String remoteToken) {
        this.remoteToken = remoteToken;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "provider", nullable = true, length = 50)
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Basic
    @Column(name = "last4", nullable = false, length = 4)
    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    @Basic
    @Column(name = "card_holder_name", nullable = false, length = 255)
    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @Basic
    @Column(name = "expiration_month", nullable = true)
    public Byte getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Byte expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Basic
    @Column(name = "expiration_year", nullable = true)
    public Short getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Short expirationYear) {
        this.expirationYear = expirationYear;
    }

    @Basic
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
    @Column(name = "last_used_at", nullable = false)
    public Timestamp getLastUsedAt() {
        return lastUsedAt;
    }

    public void setLastUsedAt(Timestamp lastUsedAt) {
        this.lastUsedAt = lastUsedAt;
    }

    @Basic
    @Column(name = "project_id", nullable = true)
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

        UserPaymentProfilesEntity that = (UserPaymentProfilesEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (version != that.version) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (provinceCode != null ? !provinceCode.equals(that.provinceCode) : that.provinceCode != null) return false;
        if (paymentHandler != null ? !paymentHandler.equals(that.paymentHandler) : that.paymentHandler != null)
            return false;
        if (remoteIdentifier != null ? !remoteIdentifier.equals(that.remoteIdentifier) : that.remoteIdentifier != null)
            return false;
        if (remoteToken != null ? !remoteToken.equals(that.remoteToken) : that.remoteToken != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (provider != null ? !provider.equals(that.provider) : that.provider != null) return false;
        if (last4 != null ? !last4.equals(that.last4) : that.last4 != null) return false;
        if (cardHolderName != null ? !cardHolderName.equals(that.cardHolderName) : that.cardHolderName != null)
            return false;
        if (expirationMonth != null ? !expirationMonth.equals(that.expirationMonth) : that.expirationMonth != null)
            return false;
        if (expirationYear != null ? !expirationYear.equals(that.expirationYear) : that.expirationYear != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (lastUsedAt != null ? !lastUsedAt.equals(that.lastUsedAt) : that.lastUsedAt != null) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(that.modifiedAt) : that.modifiedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        result = 31 * result + (paymentHandler != null ? paymentHandler.hashCode() : 0);
        result = 31 * result + (remoteIdentifier != null ? remoteIdentifier.hashCode() : 0);
        result = 31 * result + (remoteToken != null ? remoteToken.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (last4 != null ? last4.hashCode() : 0);
        result = 31 * result + (cardHolderName != null ? cardHolderName.hashCode() : 0);
        result = 31 * result + (expirationMonth != null ? expirationMonth.hashCode() : 0);
        result = 31 * result + (expirationYear != null ? expirationYear.hashCode() : 0);
        result = 31 * result + version;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (lastUsedAt != null ? lastUsedAt.hashCode() : 0);
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
        return result;
    }
}
