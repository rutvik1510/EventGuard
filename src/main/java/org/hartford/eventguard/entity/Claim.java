package org.hartford.eventguard.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;


    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private PolicySubscription subscription;

    private String claimReason;

    private LocalDate incidentDate;

    private Double claimAmountRequested;

    private Double approvedAmount;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status;


    @ManyToOne
    @JoinColumn(name = "reviewed_by")
    private User reviewedBy;


    @ManyToOne
    @JoinColumn(name = "surveyor_id")
    private User surveyor;

    private String investigationReport;

    public Claim() {}

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public PolicySubscription getSubscription() {
        return subscription;
    }

    public void setSubscription(PolicySubscription subscription) {
        this.subscription = subscription;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public Double getClaimAmountRequested() {
        return claimAmountRequested;
    }

    public void setClaimAmountRequested(Double claimAmountRequested) {
        this.claimAmountRequested = claimAmountRequested;
    }

    public Double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(Double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }

    public User getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(User reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public User getSurveyor() {
        return surveyor;
    }

    public void setSurveyor(User surveyor) {
        this.surveyor = surveyor;
    }

    public String getInvestigationReport() {
        return investigationReport;
    }

    public void setInvestigationReport(String investigationReport) {
        this.investigationReport = investigationReport;
    }
}