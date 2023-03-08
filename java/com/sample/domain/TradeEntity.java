package com.sample.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;


@Entity
@Data
@Builder
@Table
public class TradeEntity {

	@Id
	@Column
	private String tradeId;
	@Column
	private Integer version;
	@Column
	private String counterpartyId;
	@Column
	private String bookId;
	@Column
	private LocalDate maturityDate;
	@Column
	private LocalDate createdDate;
	@Column
	private boolean isExpired;
	
	public TradeEntity() {}
	
	public TradeEntity(String tradeId, Integer version, String counterpartyId, String bookId, LocalDate maturityDate,
			LocalDate createdDate, boolean isExpired) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterpartyId = counterpartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.isExpired = isExpired;
	}
		
	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCounterpartyId() {
		return counterpartyId;
	}

	public void setCounterpartyId(String counterpartyId) {
		this.counterpartyId = counterpartyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public boolean getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(boolean idExpired) {
		this.isExpired = idExpired;
	}
	
	

	@Override
	public String toString() {
		return "TradeEntity [tradeId=" + tradeId + ", version=" + version + ", counterpartyId=" + counterpartyId
				+ ", bookId=" + bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate
				+ ", idExpired=" + isExpired + "]";
	}
}
