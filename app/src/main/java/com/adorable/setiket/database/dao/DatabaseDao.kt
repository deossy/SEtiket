package com.adorable.setiket.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adorable.setiket.model.ModelDatabase

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM tbl_travel")
    fun getAllData(): LiveData<List<ModelDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg modelDatabases: ModelDatabase)

    @Query("DELETE FROM tbl_travel WHERE uid= :uid")
    fun deleteDataById(uid: Int)
}