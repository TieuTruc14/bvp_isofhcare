package bvp.his.isofhcare.result;

import org.springframework.data.domain.Sort;

public interface ISort {
    /**
     * sort by id giam dan
     *
     * @return
     */
    default Sort getSortDESC() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        return Sort.by(order);
    }


    /**
     * Sort by Id tang dan
     *
     * @return
     */
    default Sort getSortASC() {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");
        return Sort.by(order);
    }
}
