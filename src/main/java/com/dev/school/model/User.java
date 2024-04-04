package com.dev.school.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String username;
    @NotBlank(message = "Le mot de passe")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    @Pattern(regexp = ".*\\d.*", message = "Le mot de passe doit contenir au moins un chiffre")
    @Pattern(regexp = ".*\\p{Lower}.*", message = "Le mot de passe doit contenir au moins une lettre minuscule")
    @Pattern(regexp = ".*\\p{Upper}.*", message = "Le mot de passe doit contenir au moins une lettre majuscule")
    @Pattern(regexp = ".*\\p{Punct}.*", message = "Le mot de passe doit contenir au moins un symbole")
    private String password;
}
