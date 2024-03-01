package controller;

import com.example.ExamWork.entity.Booking;
import com.example.ExamWork.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService service;


    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return service.getAll();
    }
    @GetMapping("findById/{id}")
    public Optional<Booking> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
         service.deleteById(id);
    }


}
