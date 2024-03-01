package com.example.ExamWork.controller;

import com.example.ExamWork.dto.BookingDto;
import com.example.ExamWork.dto.ResponseMessageAPI;
import com.example.ExamWork.enums.ResultCode;

import com.example.ExamWork.enums.ResultCodeAPI;
import com.example.ExamWork.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Booking", description = "Тут находятся все роуты связанные для работы с бронированием парковками")

@RestController
@RequestMapping("api/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService service;

    @Operation(summary = "Этот роут делает бронь парковок по айди пользователей и по айди номеров парковки")

    @PostMapping("/book")
    public BookingDto bookParking(@RequestParam Long userId, @RequestParam Long parkingSpotid) {
        return service.bookingParkingSpot(userId, parkingSpotid);
    }
    @Operation(summary = "Этот роут возвращает все брони")

    @GetMapping("/all")
    public ResponseMessageAPI<List<BookingDto>> getAllBooking() {
        try {
            return new ResponseMessageAPI<>(
                    service.getAll(),
                    ResultCodeAPI.SUCCESS.name(),
                    null,
                    "success",
                    ResultCode.OK.getHttpCode()
            );

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return new ResponseMessageAPI<>(
                    null,
                    ResultCodeAPI.FAIL.name(),
                    exception.getClass().getSimpleName(),
                    exception.getMessage(),
                    ResultCode.NOT_FOUND.getHttpCode()
            );
        } catch (Exception e) {
            System.out.printf("BookController: getAllBooks() %s%n", e);
            return new ResponseMessageAPI<>(
                    null,
                    ResultCodeAPI.EXCEPTION.name(), e.getClass().getSimpleName(),
                    "Ошибка при получении всех книг книги",
                    ResultCode.FAIL.getHttpCode()
            );
        }
    }
    @Operation(summary = "Этот роут возвращает брони по айди")

    @GetMapping("/{id}")
    public ResponseMessageAPI<BookingDto> findById(@PathVariable Long id) {
        try {
            return new ResponseMessageAPI<>(
                    service.findById(id),
                    ResultCodeAPI.SUCCESS.name(),
                    null,
                    "success",
                    ResultCode.OK.getHttpCode());

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return new ResponseMessageAPI<>(
                    null,
                    ResultCodeAPI.FAIL.name(),
                    exception.getClass().getSimpleName(),
                    exception.getMessage(),
                    ResultCode.NOT_FOUND.getHttpCode()
            );
        } catch (Exception e) {
            System.out.printf("BookController: findById() %s%n", e);
            return new ResponseMessageAPI<>(
                    null,
                    ResultCodeAPI.EXCEPTION.name(), e.getClass().getSimpleName(),
                    "Ошибка при получении книги по айди " + id,
                    ResultCode.FAIL.getHttpCode()
            );
        }
    }
    @Operation(summary = "Этот роут сохраняет брони")

    @PostMapping("/save")
    public Long save(@RequestBody BookingDto dto) {
        try {
            return service.save(dto);

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return -1L;
        }
    }
    @Operation(summary = "Этот роут освобождает парковку по айди парковки")

    @PostMapping("/release")
    public void releaseBooking(@RequestParam Integer parkingId){
        service.releaseBooking(parkingId);
    }

    @Operation(summary = "Этот роут удаляет бронь")

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.deleteById(id);
    }
}
