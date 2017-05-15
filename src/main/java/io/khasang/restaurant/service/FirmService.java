package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.Firm;

import java.util.List;

public interface FirmService {

/**
 * Create firm at DB
 *
 * @param - firm for creation
 * @return firm
 */
   Firm addFirm(Firm firm);

/**
 * Receive all firm
 *
 * @return all firms from DB
 */
    List<Firm> getFirmList();

/**
 * Delete firm by id
 *
 * @param id - id of firm for deleting
 */
    Firm deleteFirm(long id);

/**
 * Recevive firm by id
 *
 * @param id - id firm
 * @return firm
 */
    Firm getFirmById(long id);

/**
 * Update firm at DB
 *
 * @param - firm from request for updating in DB
 * @return updated firm
 */
    Firm updateFirm(Firm firm);

    /**
     * Receive firm from DB by name
     * @param name - firm name
     * @return list of firms
     */
    List<Firm> getFirmListByName(String name);
}