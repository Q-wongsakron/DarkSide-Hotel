package com.example.darkSide_Hotel.response;

import com.example.darkSide_Hotel.entity.Room;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

@Data
@NoArgsConstructor
public class RoomResponse {

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked, byte[] photoBytes) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;

        // it gets string byte from database and then convert encode it to a re photo that display  for user
        this.photo = photoBytes != null ? Base64.getEncoder().encodeToString(photoBytes) : null;

        //this.bookings = bookings;
    }

    // select information return to front end
    private Long id;

    private String roomType;

    private BigDecimal roomPrice;

    private boolean isBooked;

    private String photo;

    private List<BookingResponse>bookings;

}
