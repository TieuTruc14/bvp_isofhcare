package bvp.his.isofhcare.model.result;

import bvp.his.isofhcare.constant.AppConst;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ResultCheckUpParent {
    @JsonFormat(pattern = AppConst.DATE_FORMAT)
    private Date timeGoIn;
    private String patientValue;
    private String patientName;
    private ServicePatient patientResult;
    private Integer patientHistoryId;
    private String PatientDocument;

    public ResultCheckUpParent() {
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

    public ServicePatient getPatientResult() {
        return patientResult;
    }

    public void setPatientResult(ServicePatient patientResult) {
        this.patientResult = patientResult;
    }

    public Integer getPatientHistoryId() {
        return patientHistoryId;
    }

    public void setPatientHistoryId(Integer patientHistoryId) {
        this.patientHistoryId = patientHistoryId;
    }

    public String getPatientDocument() {
        return PatientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        PatientDocument = patientDocument;
    }
}
