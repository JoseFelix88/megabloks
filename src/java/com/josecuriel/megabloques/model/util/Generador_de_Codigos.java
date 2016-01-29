package com.josecuriel.megabloques.model.util;

public class Generador_de_Codigos {

  
    /*
     * getCodigoAleatorioEstandar    
     * @return String
     */
    public String getCodigoAleatorioEstandar() {

        String codigoAleatorio = "";

        for (int i = 0; i < 2; i++) {

            if (i % 2 == 0) {
                codigoAleatorio = (codigoAleatorio + this.getAleatorionLetras());
            } else {
                codigoAleatorio = (codigoAleatorio + this.getAleatorionNumeros(0, 9));
            }
        }

        return codigoAleatorio;
    }

    /*
     * getAleatorionNumeros    
     * @param  num_01
     * @param  num_02
     * @return int
     */
    public int getAleatorionNumeros(int num_01, int num_02) {
        if (num_02 < num_01) {
            return (int) ((num_02 - num_01 + 1) * Math.random() + num_01);
        } else {
            return (int) ((num_01 - num_02 + 1) * Math.random() + num_02);
        }
    }

    /*
     * getAleatorionLetras    
     * @return int
     */
    private String getAleatorionLetras() {

        String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        int numLetraRandon = this.getAleatorionNumeros(1, 26);
        String letra = abecedario[numLetraRandon];

        return letra;
    }

     public String getCodigoAleatorioNumerico() {

        String codigoAleatorio = "";

        for (int i = 0; i < 8; i++) {

            if (i % 2 == 0) {
                codigoAleatorio = (codigoAleatorio + this.getAleatorionNumeros(0, 9));
            } else {
                codigoAleatorio = (codigoAleatorio + this.getAleatorionNumeros(0, 9));
            }
        }

        return codigoAleatorio;
    }

}
