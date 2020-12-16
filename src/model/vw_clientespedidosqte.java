/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author bioha
 */
public class vw_clientespedidosqte {

    private String nomeContato;
    private String endereco;
    private String cidade;
    private int idOrdem;
    private int qtde;
    private Date dataOrdem;

    public vw_clientespedidosqte() {
    }

    public vw_clientespedidosqte(String nomeContato, String endereco, String cidade, int idOrdem, int qtde, Date dataOrdem) {
        this.nomeContato = nomeContato;
        this.endereco = endereco;
        this.cidade = cidade;
        this.idOrdem = idOrdem;
        this.qtde = qtde;
        this.dataOrdem = dataOrdem;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Date getDataOrdem() {
        return dataOrdem;
    }

    public void setDataOrdem(Date dataOrdem) {
        this.dataOrdem = dataOrdem;
    }

}
