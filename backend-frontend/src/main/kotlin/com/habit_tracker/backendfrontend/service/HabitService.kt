package com.habit_tracker.backendfrontend.service

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.*
import com.google.firebase.cloud.FirestoreClient
import com.habit_tracker.backendfrontend.entity.Habit
import org.springframework.stereotype.Service
import java.lang.NullPointerException


@Service
class HabitService {
    companion object {
        const val COLLECTION_NAME = "habits"
    }

    fun saveHabit(habit: Habit): String {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()

        val colRef: CollectionReference = dbFirestore.collection(COLLECTION_NAME)//.document(habit.documentId)
        val result: ApiFuture<DocumentReference> = colRef.add(habit)

        return result.get().id
    }

    fun getHabit(documentId: String): Habit? {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()

        val docRef: DocumentReference = dbFirestore.collection(COLLECTION_NAME).document(documentId)
        val future: ApiFuture<DocumentSnapshot> = docRef.get()
        val document: DocumentSnapshot = future.get()

        var habit: Habit? = null

        if (document.exists()) {
            habit = document.toObject(Habit::class.java)

            return habit
        }

        return null
    }
}