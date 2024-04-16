package com.erp.erp_backend.quality.infrastructure.port.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    T create(T entity);
    boolean createAll(Optional<List<T>> entities);
    Optional<T> read(ID id);
    boolean update(Optional<T> entity);
    void delete(ID id);
}
