package com.example.ExamWork.controller;

import com.example.ExamWork.dto.ParkingSpotsDto;
import com.example.ExamWork.dto.ResponseMessageAPI;
import com.example.ExamWork.enums.ResultCode;
import com.example.ExamWork.enums.ResultCodeAPI;
import com.example.ExamWork.enums.TypeParkingSpots;
import com.example.ExamWork.service.ParkingSpotsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Booking", description = "Тут находятся все роуты связанные для работы с парковками")

@RequiredArgsConstructor
@RestController
@RequestMapping("api/parking-spots")
public class ParkingSpotsController {
    private final ParkingSpotsService service;
    @Operation(summary = "Этот роут возвращает все парковки")

    @GetMapping("/all")
    public ResponseMessageAPI<List<ParkingSpotsDto>> getAllParkingPalace() {
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
                    "Error",
                    ResultCode.FAIL.getHttpCode()
            );
        }
    }

    @Operation(summary = "Этот роут возвращает парковки по айди")

    @GetMapping("/{id}")
    public ResponseMessageAPI<ParkingSpotsDto> findById(@PathVariable Long id) {
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

    @Operation(summary = "Этот роут добавляет парковку ")

    @PostMapping
    public Long save(@RequestBody ParkingSpotsDto dto) {
        try {
            return service.save(dto);

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return -1L;
        }
    }
    @Operation(summary = "Этот роут фильтрует список парковок по типам")

    @GetMapping("/spots/{type}")
    public List<ParkingSpotsDto> getParkingSpotsByType(@PathVariable TypeParkingSpots type) {
        return service.getParkingSpotsByType(type);
    }


    @Operation(summary = "Этот роут удаляет парковки")

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.deleteById(id);
    }
}
