package com.TKNIKA.curso0.TODO

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.TKNIKA.curso0.R
import com.TKNIKA.curso0.TODO.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TODOActivity : AppCompatActivity() {

    private val categories = listOf(
        Business,
        Other,
        Personal
    )

    private val tasks = mutableListOf(
        Task ("PruebaBusiness", Business),
        Task ("PruebaPersonal", Personal),
        Task ("PruebaOther", Other)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var fabAddTask : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todoactivity)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog(){
        val dialog = Dialog (this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text){
                    getString(R.string.Todo_category_business) -> Business
                    getString(R.string.Todo_category_personal) -> Personal
                    else -> Other
                }

                tasks.add(Task(currentTask,currentCategory))
                updateTask()
                dialog.hide()
            }

        }

        dialog.show()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) {position -> updateCategories(position)}
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks) {position -> onItemSelected(position)}
        rvTasks.layoutManager =
            LinearLayoutManager(this)       //como es vertical no hay que poner nada más
        rvTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position:Int){
        tasks[position].isSelected =!tasks[position].isSelected
        updateTask()
    }

    private fun updateCategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTask()
    }

    private fun updateTask(){
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }
}