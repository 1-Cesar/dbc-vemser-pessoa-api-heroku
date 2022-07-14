package br.com.dbc.vemser.pessoaapi.service;


public enum EnumEmail {
    CREATE(1), PUT(2), DELETE(3);

    EnumEmail(Integer tipo) {
        this.tipo = tipo;
    }

    private Integer tipo;
}
