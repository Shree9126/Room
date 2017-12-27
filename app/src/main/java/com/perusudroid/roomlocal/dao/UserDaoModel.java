package com.perusudroid.roomlocal.dao;

import android.arch.lifecycle.ViewModel;

import com.perusudroid.roomlocal.datasource.IUserDataSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.internal.operators.completable.CompletableFromAction;

/**
 * Created by perusu on 11/11/17.
 */

public class UserDaoModel extends ViewModel {

    private final IUserDataSource mIUserDataSource;

    private UserModel mUserModel;

    public UserDaoModel(IUserDataSource mIUserDataSource) {
        this.mIUserDataSource = mIUserDataSource;
    }

/*
    */
/**
     * Get the user name of the user.
     *
     * @return a {@link Flowable} that will emit every time the user name has been updated.
     *//*

    public Flowable<String> getUserName() {
        return mIUserDataSource.getUser()
                // for every emission of the user, get the user name
                .map(userModel -> {
                    mUserModel = userModel;
                    return userModel.get_userName();
                });

    }
*/


    /**
     * Get all users from db
     *
     * @return a {@link Flowable} that will emit every time the user name has been updated.
     */
    public Flowable<List<UserModel>> getAllUsers() {

        return mIUserDataSource.getAllUser();
    }


    /**
     * Get users based on ID
     *
     * @return a {@link Flowable} that will emit every time the user name has been updated.
     */

    public Flowable<List<UserModel>> getUsersById(String dish_id) {

        return mIUserDataSource.getUserByDishId(dish_id);
    }



    /**
     * @param user - Insert UserModel class directly
     *
     * @return a {@link Completable} that completes when the user name is updated
     */

    public Completable inserUser(final UserModel... user) {
        return new CompletableFromAction(() -> {

            mIUserDataSource.insertUsers(user);
        });
    }


    /**
     *
     * @return a {@link Completable}
     */


    public Completable deleteAll() {
        return new CompletableFromAction(() -> {

            mIUserDataSource.deleteAllUsers();
        });
    }


}