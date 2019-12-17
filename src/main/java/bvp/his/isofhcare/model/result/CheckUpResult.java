package bvp.his.isofhcare.model.result;

import java.util.List;

public class CheckUpResult {
    private String DiseaseDiagnostic;
    private String DoctorAdviceTxt;
    private String Diagnostic;
    private Integer HIS_Service_ID;
    private String Other_DiseaseDiagnostic;
    private Integer HIS_PatientHistory_ID;
    private String ServiceName;
    private String Note;
    private String DoctorAdvice;
    private String First_Diagnostic;
    private String ListExternalMedicine;
    private Integer HIS_Service_Union_ID;
    private List<MedicineResult> ListMedicine;

    public CheckUpResult() {
    }

    public String getDiseaseDiagnostic() {
        return DiseaseDiagnostic;
    }

    public void setDiseaseDiagnostic(String diseaseDiagnostic) {
        DiseaseDiagnostic = diseaseDiagnostic;
    }

    public String getDoctorAdviceTxt() {
        return DoctorAdviceTxt;
    }

    public void setDoctorAdviceTxt(String doctorAdviceTxt) {
        DoctorAdviceTxt = doctorAdviceTxt;
    }

    public String getDiagnostic() {
        return Diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        Diagnostic = diagnostic;
    }

    public Integer getHIS_Service_ID() {
        return HIS_Service_ID;
    }

    public void setHIS_Service_ID(Integer HIS_Service_ID) {
        this.HIS_Service_ID = HIS_Service_ID;
    }

    public String getOther_DiseaseDiagnostic() {
        return Other_DiseaseDiagnostic;
    }

    public void setOther_DiseaseDiagnostic(String other_DiseaseDiagnostic) {
        Other_DiseaseDiagnostic = other_DiseaseDiagnostic;
    }

    public Integer getHIS_PatientHistory_ID() {
        return HIS_PatientHistory_ID;
    }

    public void setHIS_PatientHistory_ID(Integer HIS_PatientHistory_ID) {
        this.HIS_PatientHistory_ID = HIS_PatientHistory_ID;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getDoctorAdvice() {
        return DoctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        DoctorAdvice = doctorAdvice;
    }

    public String getFirst_Diagnostic() {
        return First_Diagnostic;
    }

    public void setFirst_Diagnostic(String first_Diagnostic) {
        First_Diagnostic = first_Diagnostic;
    }

    public List<MedicineResult> getListMedicine() {
        return ListMedicine;
    }

    public void setListMedicine(List<MedicineResult> listMedicine) {
        ListMedicine = listMedicine;
    }

    public String getListExternalMedicine() {
        return ListExternalMedicine;
    }

    public void setListExternalMedicine(String listExternalMedicine) {
        ListExternalMedicine = listExternalMedicine;
    }

    public Integer getHIS_Service_Union_ID() {
        return HIS_Service_Union_ID;
    }

    public void setHIS_Service_Union_ID(Integer HIS_Service_Union_ID) {
        this.HIS_Service_Union_ID = HIS_Service_Union_ID;
    }
}
