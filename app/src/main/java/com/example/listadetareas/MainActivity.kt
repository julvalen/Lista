import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetareas.R
import com.example.listadetareas.Task

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewTasks: RecyclerView
    private lateinit var editTextTask: EditText
    private lateinit var buttonAdd: Button
    private val taskList = mutableListOf<Task>()
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewTasks = findViewById(R.id.recyclerViewTasks)
        editTextTask = findViewById(R.id.editTextTask)
        buttonAdd = findViewById(R.id.buttonAdd)

        taskAdapter = TaskAdapter(taskList)
        recyclerViewTasks.adapter = taskAdapter
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)

        buttonAdd.setOnClickListener {
            val taskTitle = editTextTask.text.toString()
            if (taskTitle.isNotEmpty()) {
                val task = Task(taskList.size, taskTitle, false)
                taskList.add(task)
                taskAdapter.notifyDataSetChanged()
                editTextTask.text.clear()
            }
        }
    }
}