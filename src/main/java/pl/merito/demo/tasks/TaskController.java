package pl.merito.demo.tasks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    public TaskController(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/list")
    public String getAllTasks(Model model) {
        List<Task> tasks = taskRepository.findByCompletedFalseOrderByDueDateAsc();
        model.addAttribute("tasks", tasks);
        return "tasks/list";
    }

    @GetMapping("/add")
    public String showAddTaskForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("task", new Task());
        return "tasks/add";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        task.setCreatedAt(LocalDateTime.now());
        taskRepository.save(task);
        return "redirect:/tasks/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable Long id, Model model) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + id));
        model.addAttribute("task", task);
        model.addAttribute("categories", categoryRepository.findAll());
        return "tasks/edit";
    }
    @PostMapping("/edit/")
    public String editTask(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/tasks/list";
    }

    // Add this method to TaskController
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks/list";
    }
}
