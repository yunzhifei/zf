package com.myfirst.dao;

import com.myfirst.entitis.HotelOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 * yun zhi fei
 */
@Mapper
public interface IHotelOderDao {
    String TABLE_NAME = " hotelOrder ";
    String INSERT_FIELD = " hotelId,personNumber,userId,isDelete,payState,orderState ";
    String SELECT_FIELD = "id, " + INSERT_FIELD;

    @Insert({"insert into " + TABLE_NAME + " ( " + INSERT_FIELD + " ) values ( " + "#{hotelId}, " +
            "#{personNumber}, " + "#{userId}, " + "#{isDelete}, " + "#{payState}, " + "#{orderState} )"})
    int addHotelOrder(HotelOrder hotelOrder);

    @Select({"select " + SELECT_FIELD + " from " + TABLE_NAME + " where userId=#{userId}"})
    List<HotelOrder> findAllHotelOrderByUserId(@Param("userId") int userId);

    @Update({"update " + TABLE_NAME + " set payState=1 " + "where id=#{id}"})
    int updateHotelOrderPayStateById(@Param("id") int id);


    @Select({"select " + INSERT_FIELD + " from " + TABLE_NAME + " where payState=0 " + " and userId=#{userId}"})
    List<HotelOrder> selectUserUnPayHotelOrderByUserId(@Param("userId") int userId);

    @Select({"select " + INSERT_FIELD + " from " + TABLE_NAME + " where payState=1 " + " and userId=#{userId}"})
    List<HotelOrder> selectUserPayedHotelOrderByUserId(@Param("userId") int userId);
}
