package com.example.ExamWork.controller;

import com.example.ExamWork.dto.ResponseMessageAPI;
import com.example.ExamWork.dto.UserDto;
import com.example.ExamWork.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.ExamWork.enums.ResultCode;
import com.example.ExamWork.enums.ResultCodeAPI;

import java.util.List;
@Tag(name = "Booking", description = "Тут находятся все роуты связанные для работы с пользователями")
@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @Operation(summary = "Этот роут возвращает всех пользователей")

    @GetMapping("/all")
    public ResponseMessageAPI<List<UserDto>> getAllUsers() {
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

    @Operation(summary = "Этот роут возвращает пользователей по айди")

    @GetMapping("/{id}")
    public ResponseMessageAPI<UserDto> findById(@PathVariable Long id) {
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

    @Operation(summary = "Этот роут добавляет пользователей")

    @PostMapping
    public Long save(@RequestBody UserDto dto) {
        try {
            return service.save(dto);

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return -1L;
        }
    }

    @Operation(summary = "Этот роут удаляет пользователей")

    @DeleteMapping
    public void delete(@RequestParam Long id) {
         service.deleteById(id);
    }
}