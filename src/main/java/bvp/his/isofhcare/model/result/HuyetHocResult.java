package bvp.his.isofhcare.model.result;

import java.util.List;

public class HuyetHocResult {
    private List<HuyetHocMedical> ListMedical;
    private Integer GroupId;

    public HuyetHocResult() {
    }

    public List<HuyetHocMedical> getListMedical() {
        return ListMedical;
    }

    public void setListMedical(List<HuyetHocMedical> listMedical) {
        ListMedical = listMedical;
    }

    public Integer getGroupId() {
        return GroupId;
    }

    public void setGroupId(Integer groupId) {
        GroupId = groupId;
    }
}
