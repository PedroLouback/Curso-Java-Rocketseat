package br.com.pedrolouback.todolist.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/*
 * ID
 * Usuário (user_id)
 * Descrição
 * Titulo
 * Data de início
 * Data de término
 * Prioridade
 */

@Data // Facilita a utilização de Getters e Setters
@Entity(name = "tb_tasks") // Cria a tabela de tarefas no BD
public class TaskModel {

    @Id // Define que o id seja a chave primária
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50) //Limita a qtd de caracteres do title (50 caracteres)
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    private UUID idUser;

    @CreationTimestamp // Define o horário da criação da tarefa
    private LocalDateTime createdAt;

    public void setTitle(String title) throws Exception{
        if (title.length() > 50){
            throw new Exception("O título deve conter no máximo 50 caracteres");
        }
        this.title = title;
    }

}
