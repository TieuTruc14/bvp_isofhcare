package bvp.his.isofhcare.model;

import bvp.his.isofhcare.constant.AppConst;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class PatientHistory {
    @JsonFormat(pattern = AppConst.DATE_FORMAT)
    private Date date;
    private int patientHistoryId;
    private String patientDocument;
    private String isofhCareId;
    private String value;
    @JsonFormat(pattern = AppConst.DATE_FORMAT)
    private Date appointmentDate;

    public PatientHistory() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPatientHistoryId() {
        return patientHistoryId;
    }

    public void setPatientHistoryId(int patientHistoryId) {
        this.patientHistoryId = patientHistoryId;
    }

    public String getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }

    public String getIsofhCareId() {
        return isofhCareId;
    }

    public void setIsofhCareId(String isofhCareId) {
        this.isofhCareId = isofhCareId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
