package com.example.bit603_a3_zackhaynes;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface UserDao {

    @Insert
    void addUser(User user);

    @Query("SELECT * FROM USERS")
    List<User> getUsers();

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);

}
