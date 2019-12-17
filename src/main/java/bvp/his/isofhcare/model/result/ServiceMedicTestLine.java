package bvp.his.isofhcare.model.result;

public class ServiceMedicTestLine {
    private String HigherIndicator;
    private String LowerIndicator;
    private String NameLine;
    private String ResultState;
    private String NormalRange;
    private Integer HIS_Service_Detail_ID;
    private String Unit;
    private String Result;
    private String Conclusion;

    public ServiceMedicTestLine() {
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

    public String getNameLine() {
        return NameLine;
    }

    public void setNameLine(String nameLine) {
        NameLine = nameLine;
    }

    public String getResultState() {
        return ResultState;
    }

    public void setResultState(String resultState) {
        ResultState = resultState;
    }

    public String getNormalRange() {
        return NormalRange;
    }

    public void setNormalRange(String normalRange) {
        NormalRange = normalRange;
    }

    public Integer getHIS_Service_Detail_ID() {
        return HIS_Service_Detail_ID;
    }

    public void setHIS_Service_Detail_ID(Integer HIS_Service_Detail_ID) {
        this.HIS_Service_Detail_ID = HIS_Service_Detail_ID;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getConclusion() {
        return Conclusion;
    }

    public void setConclusion(String conclusion) {
        Conclusion = conclusion;
    }
}
