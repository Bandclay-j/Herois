package br.com.senac.herois.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "herois")
public class SuperHeroi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String apelido;

    @Column
    private String superPoder;

    @Column
    private String fraqueza;

    @Column
    private String historiaOrigem;

    @Column
    private Date primeiraAparicao;

    @Column
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "equipe_id", referencedColumnName = "id")
    private Equipe equipe;

    public SuperHeroi() {}

    public SuperHeroi(int id, String nome, String apelido, String superPoder, String fraqueza, String historiaOrigem,
            Date primeiraAparicao, Equipe equipe, String imagem) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.superPoder = superPoder;
        this.fraqueza = fraqueza;
        this.historiaOrigem = historiaOrigem;
        this.primeiraAparicao = primeiraAparicao;
        this.equipe = equipe;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getApelido() {
        return apelido;
    }
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    public String getSuperPoder() {
        return superPoder;
    }
    public void setSuperPoder(String superPoder) {
        this.superPoder = superPoder;
    }
    public String getFraqueza() {
        return fraqueza;
    }
    public void setFraqueza(String fraqueza) {
        this.fraqueza = fraqueza;
    }
    public String getHistoriaOrigem() {
        return historiaOrigem;
    }
    public void setHistoriaOrigem(String historiaOrigem) {
        this.historiaOrigem = historiaOrigem;
    }
    public Date getPrimeiraAparicao() {
        return primeiraAparicao;
    }
    public void setPrimeiraAparicao(Date primeiraAparicao) {
        this.primeiraAparicao = primeiraAparicao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Equipe getEquipe() {
        if (this.equipe != null) {
            this.equipe.setSuperHeroi(null);
        }
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String exibeDados() {
        return "SuperHéroi: " + getNome() + 
               "\nApelido: " + getApelido() + 
               "\nSuper Poder: " + getSuperPoder() + 
               "\nFraqueza: " + getFraqueza() + 
               "\nHistória de Origem: " + getHistoriaOrigem() + 
               "\nPrimeira Aparição: " + getPrimeiraAparicao() +
               "\nImagem: " + (getImagem() != null ? "Sim" : "Não") +
               "\nEquipe: " + (getEquipe() != null ? getEquipe().getNome() : "Sem equipe");
    }
}
