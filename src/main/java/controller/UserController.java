package controller;

import com.example.ExamWork.entity.Booking;
import com.example.ExamWork.entity.User;
import com.example.ExamWork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/booking")
@RequiredArgsConstructor
public class UserController {
    private  final UserService service;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAll();
    }
    @GetMapping("findById/{id}")
    public Optional<User> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        service.deleteById(id);
    }

}
