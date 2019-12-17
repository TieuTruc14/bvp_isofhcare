package bvp.his.isofhcare.model.result;

import java.util.List;

public class HuyetHocMedical {
    private String ServiceName;
    private Integer HIS_Service_MedicalTest_ID;
    private Integer HIS_Service_Union_ID;
    private List<ServiceMedicTestLine> ServiceMedicTestLine;

    public HuyetHocMedical() {
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

    public Integer getHIS_Service_Union_ID() {
        return HIS_Service_Union_ID;
    }

    public void setHIS_Service_Union_ID(Integer HIS_Service_Union_ID) {
        this.HIS_Service_Union_ID = HIS_Service_Union_ID;
    }

    public List<bvp.his.isofhcare.model.result.ServiceMedicTestLine> getServiceMedicTestLine() {
        return ServiceMedicTestLine;
    }

    public void setServiceMedicTestLine(List<bvp.his.isofhcare.model.result.ServiceMedicTestLine> serviceMedicTestLine) {
        ServiceMedicTestLine = serviceMedicTestLine;
    }
}
