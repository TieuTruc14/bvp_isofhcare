package bvp.his.isofhcare.model;

public class Profile {
    private String Value;
    private Integer Age;
    private Boolean IsContract;
    private String PhoneNumber;
    private Boolean IsPriority;
    private String PatientDocument;
    private Integer ProvinceId;
    private Integer DistrictId;
    private Integer ZoneId;
    private String PatientName;
    private String GenderId;
    private Long Birthday;
    private Long Created;
    private String Address;
    private Integer CountryId;
    private Long TimeGoIn;

    public Profile() {
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Boolean getContract() {
        return IsContract;
    }

    public void setContract(Boolean contract) {
        IsContract = contract;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Boolean getPriority() {
        return IsPriority;
    }

    public void setPriority(Boolean priority) {
        IsPriority = priority;
    }

    public String getPatientDocument() {
        return PatientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        PatientDocument = patientDocument;
    }

    public Integer getProvinceId() {
        return ProvinceId;
    }

    public void setProvinceId(Integer provinceId) {
        ProvinceId = provinceId;
    }

    public Integer getDistrictId() {
        return DistrictId;
    }

    public void setDistrictId(Integer districtId) {
        DistrictId = districtId;
    }

    public Integer getZoneId() {
        return ZoneId;
    }

    public void setZoneId(Integer zoneId) {
        ZoneId = zoneId;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getGenderId() {
        return GenderId;
    }

    public void setGenderId(String genderId) {
        GenderId = genderId;
    }

    public Long getBirthday() {
        return Birthday;
    }

    public void setBirthday(Long birthday) {
        Birthday = birthday;
    }

    public Long getCreated() {
        return Created;
    }

    public void setCreated(Long created) {
        Created = created;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getCountryId() {
        return CountryId;
    }

    public void setCountryId(Integer countryId) {
        CountryId = countryId;
    }

    public Long getTimeGoIn() {
        return TimeGoIn;
    }

    public void setTimeGoIn(Long timeGoIn) {
        TimeGoIn = timeGoIn;
    }
}
