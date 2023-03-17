package com.example.customtrackingapp.data

import androidx.room.*

//TODO: Look into the use of FLOW
@Dao
public interface bmDao{
    @Query("SELECT * FROM bowel_movements")
    fun getAll(): List<BowelMovement>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<BowelMovement>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg bms: BowelMovement)

    @Delete
    fun delete(bowelMovement: BowelMovement)
}