package B04.PaqB04;
public class Puerto extends Contenedores{
    private final int nFilas=10;
    private final int nColumnas=12;
    private Contenedores[][] matriz = new Contenedores[nFilas][nColumnas];
    public void inicializar(){
        for(int f=0;f<nFilas;f++){
            for (int c=0;c<nColumnas;c++){
                matriz[f][c]=new Contenedores();
            }
        }
    }
    public void agregarContenedor(Contenedores nuevo){
        if (nuevo.getPrioridad() == 1){
            for(int f=0;f<nFilas;f++){
                //Usamos la prioridad para comprobar si está libre o no
                if(matriz[f][0].getPrioridad() < 1){
                    matriz[f][0]=new Contenedores(nuevo);
                    f=nFilas;
                }
            }
        } else if (nuevo.getPrioridad() == 2) {
            for(int f=0;f<nFilas;f++){
                if(matriz[f][1].getPrioridad() < 1){
                    matriz[f][1]=new Contenedores(nuevo);
                    f=nFilas;
                }
            }
        } else if (nuevo.getPrioridad() == 3) {
            for(int c=2;c<nColumnas;c++){
                for(int f=0;f<nFilas;f++){
                    if(matriz[f][c].getPrioridad() < 1){
                        matriz[f][c]=new Contenedores(nuevo);
                        c=nColumnas;
                        f=nFilas;
                    }
                }
            }
        }
    }
    public void desapilar(int columna){
        if(columna<1){
            columna=1;
            System.out.println("Columna errónea, se elegirá la 1ª columna");
        }
        else if(columna>nColumnas){
            columna=nColumnas;
            System.out.println("Columna errónea, se eligirá la "+nColumnas+"º columna");
        }
        for (int f=nFilas-1;f>=0;f--){
            if(matriz[f][columna-1].getPrioridad() >= 1){
                matriz[f][columna-1].setPrioridadCero();//Ponemos la prioridad a 0 para indicar que está libre
                f=-1;
            }
        }
    }
    public String toString() {
        String hub="\nOCUPACION DEL HUB\n|";
        for (int f = nFilas-1; f >= 0; f--) {
            for (int c = 0; c < nColumnas; c++) {
                if(matriz[f][c].getPrioridad()<1){
                    hub=hub+" |";
                }
                else{
                    hub=hub+"X|";
                }
            }
            hub=hub+"\n|";
        }

        hub=hub.substring(0,hub.length()-1)+"\nLEYENDA:\t|X|: Ocupado\t| |: Libre \n";
        return hub;
        
    }
    public int mostrarDatos(int ident){
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nColumnas;j++) {
                if (matriz[i][j].getIdentificador()==ident){
                    System.out.println("Peso: "+ matriz[i][j].getPeso() + "  País: "+ matriz[i][j].getPais()+ "  Prioridad: "+ matriz[i][j].getPrioridad()
                            + "  Descripción: "+ matriz[i][j].getDescripcion()+ " De: "+matriz[i][j].getEnvia()+ " Para: "+matriz[i][j].getRecibe());
                    return 0;
                }
            }
        }
        System.out.println("No se encuentra ningún contenedor en el puerto con ese Identificador");
        return 0;
    }
    
    public int numPais(String pais){
        int n=0;
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nColumnas; j++) {
                if (matriz[i][j].getPais()==pais){
                    if (matriz[i][j].getPrioridad()>0){
                        n++;
                    }
                }
            }

        }
        return n;
    }
}
