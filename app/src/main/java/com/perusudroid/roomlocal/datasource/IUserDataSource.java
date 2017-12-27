package com.perusudroid.roomlocal.datasource;

/**
 * Created by perusu on 11/11/17.
 */


import com.perusudroid.roomlocal.dao.UserModel;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Access point for managing user data.
 */
public interface IUserDataSource {

    /**
     * Gets the user from the data source.
     *
     * @return the user from the data source.
     */
    Flowable<UserModel> getUser();


    /**
     * Gets the user from the data source.
     *
     * @return the user from the data source in list
     */
    Flowable<List<UserModel>> getAllUser();


    /**
     * Gets the user from the data source.
     * @param dish_id - based on id , data will be fetched
     * @return the user from the data source in list based on
     */
    Flowable<List<UserModel>> getUserByDishId(String dish_id);


    /**
     * Inserts the user into the data source, or, if this is an existing user, updates it.
     *
     * @param user the user to be inserted
     */
    void insertUsers(UserModel... user);


    /**
     * Inserts the user into the data source, or, if this is an existing user, updates it.
     *
     * @param user the user to be inserted or updated.
     */
    void insertOrUpdateUser(UserModel user);


    /**
     * Deletes all users from the data source.
     */
    void deleteAllUsers();
}