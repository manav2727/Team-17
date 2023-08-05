package com.db.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue
    private Long id;
    private Long bookid;
    private Long counterpartyid;
    private Long securityid;
    private Long quantity;
    private String status;
    private Long price;
    private Boolean buysell;
    private Date tradedate;
    private Date settlementdate;
	public Long getBookid() {
		return bookid;
	}
	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCounterpartyid() {
		return counterpartyid;
	}
	public void setCounterpartyid(Long counterpartyid) {
		this.counterpartyid = counterpartyid;
	}
	public Long getSecurityid() {
		return securityid;
	}
	public void setSecurityid(Long securityid) {
		this.securityid = securityid;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Boolean getBuysell() {
		return buysell;
	}
	public void setBuysell(Boolean buysell) {
		this.buysell = buysell;
	}
	public Date getTradedate() {
		return tradedate;
	}
	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}
	public Date getSettlementdate() {
		return settlementdate;
	}
	public void setSettlementdate(Date settlementdate) {
		this.settlementdate = settlementdate;
	}

}