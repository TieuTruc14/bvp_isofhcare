package bvp.his.isofhcare.model.result;

public class DiagnosticResult {
    private Integer HIS_PatientHistory_ID;
    private String ServiceName;
    private Integer HIS_Service_ID;
    private String SummaryResult;
    private String First_Diagnostic;
    private String Discussion;
    private String Conclusion;
    private String Result;

    public DiagnosticResult() {
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

    public Integer getHIS_Service_ID() {
        return HIS_Service_ID;
    }

    public void setHIS_Service_ID(Integer HIS_Service_ID) {
        this.HIS_Service_ID = HIS_Service_ID;
    }

    public String getSummaryResult() {
        return SummaryResult;
    }

    public void setSummaryResult(String summaryResult) {
        SummaryResult = summaryResult;
    }

    public String getFirst_Diagnostic() {
        return First_Diagnostic;
    }

    public void setFirst_Diagnostic(String first_Diagnostic) {
        First_Diagnostic = first_Diagnostic;
    }

    public String getDiscussion() {
        return Discussion;
    }

    public void setDiscussion(String discussion) {
        Discussion = discussion;
    }

    public String getConclusion() {
        return Conclusion;
    }

    public void setConclusion(String conclusion) {
        Conclusion = conclusion;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }
}
