package com.mycompany.crud.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author professor
 */
@Entity
@Table(name = "animal")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "animal_seq")
    @SequenceGenerator(name = "animal_seq",
                       sequenceName = "animal_seq",
                       initialValue = 1000,
                       allocationSize = 1)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    private float peso;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Transient
    private int idade;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "zoo_fk", referencedColumnName = "zoo_id")
    private Zoologico zoologico;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "especie_fk", referencedColumnName = "especie_id")
    private Especie especie;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }    

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public Zoologico getZoologico() {
        return zoologico;
    }

    public void setZoologico(Zoologico zoologico) {
        this.zoologico = zoologico;
    }
    
    @Override
    public String toString() {
        return "Animal{" + "nome=" + nome + ", peso=" + peso + '}';
    }
}
