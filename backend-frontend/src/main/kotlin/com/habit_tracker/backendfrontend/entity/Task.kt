package com.habit_tracker.backendfrontend.entity

import java.util.*
import kotlin.collections.ArrayList

class Task (
    var taskid: String,
    var name: String,
    var description: String,
    var tags: ArrayList<Tag>,
    var datetime: Date
)