package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Firm;

import java.util.List;

public interface FirmDao extends BasicDao<Firm> {
/**
*  Create Firm at DB
*
*  @param firm - firm
*  @return firm
*/
    Firm addFirm(Firm firm);

    /**
     * Find list od firns in DB
     *
     * @param name - firm name
     * @return - list of firms with that name
     */
    List<Firm> findByName(String name);
}
