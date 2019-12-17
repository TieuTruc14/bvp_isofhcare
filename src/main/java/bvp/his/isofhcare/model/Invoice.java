package bvp.his.isofhcare.model;

import java.math.BigDecimal;

public class Invoice {
    private Integer HIS_PatientHistory_ID;
    private BigDecimal Amount;
    private String InvoiceNo;

    public Invoice() {
    }

    public Integer getHIS_PatientHistory_ID() {
        return HIS_PatientHistory_ID;
    }

    public void setHIS_PatientHistory_ID(Integer HIS_PatientHistory_ID) {
        this.HIS_PatientHistory_ID = HIS_PatientHistory_ID;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        InvoiceNo = invoiceNo;
    }
}
