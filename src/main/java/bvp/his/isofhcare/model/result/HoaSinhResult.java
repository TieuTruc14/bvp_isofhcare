package bvp.his.isofhcare.model.result;

import java.util.List;

public class HoaSinhResult {
    private List<HoaSinhMedical> ListMedical;
    private Integer GroupId;

    public HoaSinhResult() {
    }

    public List<HoaSinhMedical> getListMedical() {
        return ListMedical;
    }

    public void setListMedical(List<HoaSinhMedical> listMedical) {
        ListMedical = listMedical;
    }

    public Integer getGroupId() {
        return GroupId;
    }

    public void setGroupId(Integer groupId) {
        GroupId = groupId;
    }
}
