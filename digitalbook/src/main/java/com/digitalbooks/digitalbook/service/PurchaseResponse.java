package com.digitalbooks.digitalbook.service;

public class PurchaseResponse {

	private String purchaseId;

	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public PurchaseResponse(String purchaseId) {
		super();
		this.purchaseId = purchaseId;
	}

}
