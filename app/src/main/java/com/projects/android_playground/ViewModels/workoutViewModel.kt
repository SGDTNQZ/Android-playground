import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.android_playground.MainApplication
import com.projects.android_playground.entities.WorkoutEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class WorkoutViewModel : ViewModel() {

    private val workoutDao = MainApplication.database.getWorkoutDao()

    val workoutList: LiveData<List<WorkoutEntity>> = workoutDao.getWorkout()

    fun addWorkout(bodyPart: String) {
        // Run database operation on a background thread
        viewModelScope.launch(Dispatchers.IO) {
            workoutDao.addWorkout(
                WorkoutEntity(
                    bodyPart = bodyPart,
                    createdAt = Date(System.currentTimeMillis())
                )
            )
        }
    }

    fun deleteWorkout(id: Int) {
        // Run delete operation on a background thread
        viewModelScope.launch(Dispatchers.IO) {
            workoutDao.deleteWorkout(id)
        }
    }
}
