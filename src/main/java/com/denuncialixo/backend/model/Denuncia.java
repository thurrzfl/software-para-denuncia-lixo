// Desenvolvido por: Arthur
// Data: 21/05/2026

package com.denuncialixo.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "denuncias")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String localizacao;

    private String foto;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public enum Status {
        PENDENTE,
        EM_ANALISE,
        RESOLVIDO
    }
}