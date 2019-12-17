package bvp.his.isofhcare.model;

public class ServiceDetail {
    private String name;
    private Integer HIS_Service_ID;
    private String DoctorFullName;
    private String ServiceType;
    private String DoctorName;
    private String Location;
    private String RoomName;
    private Integer DoctorId;
    private Integer HIS_CheckUp_ID;
    private Integer DepartmentId;
    private Integer SequenceNo;
    private String DepartmentName;
    private Boolean IsPaid=false;

    public ServiceDetail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHIS_Service_ID() {
        return HIS_Service_ID;
    }

    public void setHIS_Service_ID(Integer HIS_Service_ID) {
        this.HIS_Service_ID = HIS_Service_ID;
    }

    public String getDoctorFullName() {
        return DoctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        DoctorFullName = doctorFullName;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public Integer getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(Integer doctorId) {
        DoctorId = doctorId;
    }

    public Integer getHIS_CheckUp_ID() {
        return HIS_CheckUp_ID;
    }

    public void setHIS_CheckUp_ID(Integer HIS_CheckUp_ID) {
        this.HIS_CheckUp_ID = HIS_CheckUp_ID;
    }

    public Integer getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        DepartmentId = departmentId;
    }

    public Integer getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        SequenceNo = sequenceNo;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public Boolean getPaid() {
        return IsPaid;
    }

    public void setPaid(Boolean paid) {
        IsPaid = paid;
    }
}
