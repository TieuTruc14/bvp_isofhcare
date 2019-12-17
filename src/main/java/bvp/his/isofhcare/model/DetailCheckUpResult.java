package bvp.his.isofhcare.model;

import java.util.Date;

public class DetailCheckUpResult {
    private Date timeGoIn;
    private String patientValue;
    private String patientName;
    private PatientResult PatientResult;
    private Integer patientHistoryId;

    public DetailCheckUpResult() {
    }

    public Date getTimeGoIn() {
        return timeGoIn;
    }

    public void setTimeGoIn(Date timeGoIn) {
        this.timeGoIn = timeGoIn;
    }

    public String getPatientValue() {
        return patientValue;
    }

    public void setPatientValue(String patientValue) {
        this.patientValue = patientValue;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public bvp.his.isofhcare.model.PatientResult getPatientResult() {
        return PatientResult;
    }

    public void setPatientResult(bvp.his.isofhcare.model.PatientResult patientResult) {
        PatientResult = patientResult;
    }

    public Integer getPatientHistoryId() {
        return patientHistoryId;
    }

    public void setPatientHistoryId(Integer patientHistoryId) {
        this.patientHistoryId = patientHistoryId;
    }
}
