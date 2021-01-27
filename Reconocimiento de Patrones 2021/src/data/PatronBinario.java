package data;


public class PatronBinario {
        private int[] VectorC;
	private int[] Clase;
	private int[] ClaseResultante;

	public PatronBinario(int[] Vector, int[] Clase, int[] ClaseResultante) {
		this.VectorC = Vector;
		this.Clase = Clase;
		this.ClaseResultante = ClaseResultante;
	}

    public int[] getVectorC() {
        return VectorC;
    }

    public void setVectorC(int[] VectorC) {
        this.VectorC = VectorC;
    }

    public int[] getClase() {
        return Clase;
    }

    public void setClase(int[] Clase) {
        this.Clase = Clase;
    }

    public int[] getClaseResultante() {
        return ClaseResultante;
    }

    public void setClaseResultante(int[] ClaseResultante) {
        this.ClaseResultante = ClaseResultante;
    }
    
    public String imprimirVector (){
        String aux= "";
        for(int j=0; j<this.VectorC.length;j++){
                        aux+=" |"+this.VectorC[j]+"|\n";
                    }
        return aux;
    }
     public String imprimirClaseResultante (){
        String aux= "";
        for(int j=0; j<this.ClaseResultante.length;j++){
                        aux+=" |"+this.ClaseResultante[j]+"|\n";
                    }
        return aux;
    }

}