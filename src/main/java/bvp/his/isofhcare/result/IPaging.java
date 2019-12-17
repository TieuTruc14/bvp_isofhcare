package bvp.his.isofhcare.result;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface IPaging extends ISort {
    default Pageable getDefaultPage(int page, int size) {
        return getPaging(page, size, getSortDESC());
    }

    default Pageable getPaging(int page, int size, Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }

    default Pageable getPaging(int page, int size) {
        return PageRequest.of(page - 1, size);
    }

    default Pageable getDefaultPageASC(int page, int size) {
        return getPaging(page, size, getSortASC());
    }
}
