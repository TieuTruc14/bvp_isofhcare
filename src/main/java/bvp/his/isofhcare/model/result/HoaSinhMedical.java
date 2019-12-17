package bvp.his.isofhcare.model.result;

public class HoaSinhMedical {
    private String HigherIndicator;
    private String LowerIndicator;
    private String ServiceName;
    private Integer HIS_Service_MedicalTest_ID;
    private String ResultState;
    private String Unit;
    private Integer HIS_Service_Union_ID;
    private String Result;
    private String NormalRange;
    private String Conclusion;

    public HoaSinhMedical() {
    }

    public String getHigherIndicator() {
        return HigherIndicator;
    }

    public void setHigherIndicator(String higherIndicator) {
        HigherIndicator = higherIndicator;
    }

    public String getLowerIndicator() {
        return LowerIndicator;
    }

    public void setLowerIndicator(String lowerIndicator) {
        LowerIndicator = lowerIndicator;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public Integer getHIS_Service_MedicalTest_ID() {
        return HIS_Service_MedicalTest_ID;
    }

    public void setHIS_Service_MedicalTest_ID(Integer HIS_Service_MedicalTest_ID) {
        this.HIS_Service_MedicalTest_ID = HIS_Service_MedicalTest_ID;
    }

    public String getResultState() {
        return ResultState;
    }

    public void setResultState(String resultState) {
        ResultState = resultState;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public Integer getHIS_Service_Union_ID() {
        return HIS_Service_Union_ID;
    }

    public void setHIS_Service_Union_ID(Integer HIS_Service_Union_ID) {
        this.HIS_Service_Union_ID = HIS_Service_Union_ID;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getNormalRange() {
        return NormalRange;
    }

    public void setNormalRange(String normalRange) {
        NormalRange = normalRange;
    }

    public String getConclusion() {
        return Conclusion;
    }

    public void setConclusion(String conclusion) {
        Conclusion = conclusion;
    }
}
