package br.com.oficialcastro.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.oficialcastro.todolist.user.CreateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50)
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;
    
    private UUID idUser;

    @CreateTimestamp
    private LocalDateTime createdAt;

    public void setTitle(String title) throws Exception {
        if(title.length() > 50) {
            throw new Exception("O campo title deve conte no máximo 50 caracteres");
        }
        this.title = title;
    }
}
