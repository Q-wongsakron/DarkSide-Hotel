package com.example.darkSide_Hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Lazy;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "room_price")
    private BigDecimal roomPrice;

    private boolean isBooked = false;

    // Large object
    @Lob
    private Blob photo;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;

    // initialize the booking to an empty array
    // when it new room added to database at that initial stage the room
    // has not be booked so if query all room at moments
    // it error non pointer exception because at this point it null
    // and this is moment " private List<BookedRoom> bookings;"
    // this container here is going to hold an empty array that can query
    public Room(){
        this.bookings = new ArrayList<>();
    }

    // method help add booking
    public void addBooking(BookedRoom booking){
        // check exception
        if (bookings == null){
            bookings = new ArrayList<>();
        }
        // not null add booking object to bookings list
        bookings.add(booking);
        booking.setRoom(this);
        isBooked = true;

        String bookingCode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(bookingCode);
    }
}
