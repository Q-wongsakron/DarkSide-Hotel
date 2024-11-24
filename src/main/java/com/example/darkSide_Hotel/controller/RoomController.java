package com.example.darkSide_Hotel.controller;

import com.example.darkSide_Hotel.entity.Room;
import com.example.darkSide_Hotel.response.RoomResponse;
import com.example.darkSide_Hotel.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final IRoomService roomService;

    public RoomController(IRoomService roomService){
        this.roomService = roomService;
    }

    // create method add new room to database
    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("photo")MultipartFile photo,
            @RequestParam("roomType")String roomType,
            @RequestParam("roomPrice")BigDecimal roomPrice) throws SQLException, IOException {
        Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
        // conver room to roomResponse grape property from data base response
        RoomResponse response = new RoomResponse(
                savedRoom.getId(),
                savedRoom.getRoomType(),
                savedRoom.getRoomPrice());

        // return response to our homepage
        return ResponseEntity.ok(response);
    }
}
