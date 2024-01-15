package maksim.nk.projectmanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "reports")
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "hours_spent")
    private Integer hoursSpent;

    @Column(name = "report_date")
    private Date reportDate;

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Long getTaskId() {
        return task != null ? task.getTaskId() : null;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Long getProjectId() {
        return project != null ? project.getProjectId() : null;
    }

    public Report() {
    }
}
