package com.example.darkSide_Hotel.service;

import com.example.darkSide_Hotel.entity.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public interface IRoomService {

    Room addNewRoom(MultipartFile photo,
                    String roomType,
                    BigDecimal roomPrice) throws SQLException, IOException;
}
