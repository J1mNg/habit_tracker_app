package com.habit_tracker.backendfrontend.control

import com.habit_tracker.backendfrontend.entity.Habit
import com.habit_tracker.backendfrontend.service.HabitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@RestController
@RequestMapping("/api")
class HabitController(@Autowired val habitService: HabitService) {

    @PostMapping("/create")
    fun saveHabit(@RequestBody habit: Habit): String {
        return habitService.saveHabit(habit)
    }

    @GetMapping("/get")
    fun getHabit(@RequestParam documentId: String): Habit? {
        return habitService.getHabit(documentId)
    }

}