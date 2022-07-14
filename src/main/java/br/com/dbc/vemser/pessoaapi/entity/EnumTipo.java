package br.com.dbc.vemser.pessoaapi.entity;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
public enum EnumTipo {

        RESIDENCIAL(1),
        COMERCIAL(2);

        EnumTipo(Integer tipo) {
            this.tipo = tipo;
        }

        private Integer tipo;

        public Integer getTipo() {
            return tipo;
        }

        public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}

