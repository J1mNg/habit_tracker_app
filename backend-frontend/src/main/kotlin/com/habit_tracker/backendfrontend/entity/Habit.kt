package com.habit_tracker.backendfrontend.entity

import jakarta.persistence.Id

class Habit (
    @Id
    var habitId: String,
    var name: String,
    var description: String,
    var tags: ArrayList<Tag>,
    var days: ArrayList<Day>,
    var time: Time,
    var customTime: String?,
)