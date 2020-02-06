package com.example.vine;
import java.io.Serializable;

    public class Usuario implements Serializable {
        private Integer id;
        private String nome;
        private String senha;

        public void jogo(String nome, String senha){
            this.nome = nome;
            this.senha = senha;
        }

        public void jogo(String nome){
            this.nome = nome;
        }

        @Override
        public String toString() {
            return nome.toString();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

    }
