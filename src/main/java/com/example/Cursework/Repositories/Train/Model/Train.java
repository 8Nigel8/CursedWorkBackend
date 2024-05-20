package com.example.Cursework.Repositories.Train.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "trainnumber",unique = true)
    @NotBlank(message = "Train number can not be empty")
    private String trainNumber;
    @Column(name = "type")
    @NotBlank(message = "Type of train can not be empty")
    private String type;
}
