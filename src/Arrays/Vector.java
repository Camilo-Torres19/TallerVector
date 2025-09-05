package Arrays;

public class Vector {

    private int A[];
    private int tam;
    private int cantidad;

    public Vector(int tamaño) {
        this.A = new int[tamaño];
        this.tam = tamaño;
        this.cantidad = 0;
    }

    //  Metodos de Inserccion
    public void insertar_inicio(int dato) {
        if (this.tam == this.cantidad) {
            System.out.println("Error: Vector lleno (desbordamiento)");
            return;
        }

        for (int k = this.cantidad - 1; k >= 0; k--) {
            A[k + 1] = A[k];
        }

        A[0] = dato;
        this.cantidad++;
    }

    public void insertar_final(int dato) {
        if (this.tam == this.cantidad) {
            System.out.println("Error: Vector lleno (desbordamiento)");
            return;
        }

        A[cantidad] = dato;
        this.cantidad++;
    }

    public void insertar_posicion(int dato, int pos) {
        if (this.tam == this.cantidad) {
            System.out.println("Error: Vector lleno (desbordamiento)");
            return;
        }

        if (pos < 0 || pos > this.cantidad) {
            System.out.println("Error: Posición inválida");
            return;
        }

        for (int k = this.cantidad - 1; k >= pos; k--) {
            A[k + 1] = A[k];
        }

        A[pos] = dato;
        this.cantidad++;
    }

    public void insertar_antes_posicion(int dato, int pos) {
        if (pos < 1 || pos > this.cantidad) {
            System.out.println("Error: Posición inválida para insertar antes");
            return;
        }
        insertar_posicion(dato, pos - 1);
    }

    public void insertar_despues_posicion(int dato, int pos) {
        if (pos < 0 || pos >= this.cantidad) {
            System.out.println("Error: Posición inválida para insertar después");
            return;
        }
        insertar_posicion(dato, pos + 1);
    }

    //Metodos de Eliminacion.
    public void eliminar_inicio() {
        if (this.cantidad == 0) {
            System.out.println("Error: Vector vacío (subdesbordamiento)");
            return;
        }

        for (int k = 0; k < this.cantidad - 1; k++) {
            A[k] = A[k + 1];
        }
        System.out.println("Eliminacion al Inicio realizada");
        this.cantidad--;
    }

    public void eliminar_final() {
        if (this.cantidad == 0) {
            System.out.println("Error: Vector vacío (subdesbordamiento)");
            return;
        }
        System.out.println("Eliminacion al Final realizada");
        this.cantidad--;
    }

    public void eliminar_dato(int dato) {
        if (this.cantidad == 0) {
            System.out.println("Error: Vector vacío (subdesbordamiento)");
            return;
        }

        int pos = -1;
        for (int k = 0; k < this.cantidad; k++) {
            if (A[k] == dato) {
                pos = k;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Error: Dato no encontrado");
            return;
        }

        eliminar_posicion(pos);
    }

    public void eliminar_posicion(int pos) {
        if (this.cantidad == 0) {
            System.out.println("Error: Vector vacío (subdesbordamiento)");
            return;
        }

        if (pos < 0 || pos >= this.cantidad) {
            System.out.println("Error: Posición inválida");
            return;
        }

        for (int k = pos; k < this.cantidad - 1; k++) {
            A[k] = A[k + 1];
        }
        System.out.println("Eliminacion de Dato realizada");
        this.cantidad--;
    }
    //Metodos de Busqueda

    public void buscar_lineal(int dato) {
        if (this.cantidad == 0) {
            System.out.println("El vector está vacío");
            return;
        }

        for (int k = 0; k < this.cantidad; k++) {
            if (A[k] == dato) {
                System.out.println("Dato " + dato + " encontrado en la posición: " + k);
                return;
            }
        }

        System.out.println("Dato " + dato + " no encontrado en el vector");
    }

    public void buscar_derecha_izquierda(int dato) {
        if (this.cantidad == 0) {
            System.out.println("El vector está vacío");
            return;
        }

        System.out.println("Buscando de derecha a izquierda...");
        for (int k = this.cantidad - 1; k >= 0; k--) {
            if (A[k] == dato) {
                System.out.println("Dato " + dato + " encontrado en la posición: " + k);
                return;
            }
        }

        System.out.println("Dato " + dato + " no encontrado en el vector");
    }

    public void buscar_izquierda_derecha(int dato) {
        if (this.cantidad == 0) {
            System.out.println("El vector está vacío");
            return;
        }

        System.out.println("Buscando de izquierda a derecha...");
        for (int k = 0; k < this.cantidad; k++) {
            if (A[k] == dato) {
                System.out.println("Dato " + dato + " encontrado en la posición: " + k);
                return;
            }
        }

        System.out.println("Dato " + dato + " no encontrado en el vector");
    }

    public void busquedaBinaria(int dato) {
        if (this.cantidad == 0) {
            System.out.println("Vector vacío");
            return;
        }

        if (!estaOrdenado()) {
            System.out.println(" Vector no está ordenado. Ordenando primero...");
            ordenar_seleccion();
            mostrar();
        }

        int inicio = 0;
        int fin = this.cantidad - 1;
        int comparaciones = 0;

        while (inicio <= fin) {
            comparaciones++;
            int medio = inicio + (fin - inicio) / 2;

            System.out.println("Comparación " + comparaciones + ": Verificando posición " + medio + " (valor: " + A[medio] + ")");

            if (A[medio] == dato) {
                System.out.println("¡Dato " + dato + " encontrado en la posición " + medio + " después de " + comparaciones + " comparaciones!");
                return;
            } else if (A[medio] < dato) {
                System.out.println("El dato buscado es mayor. Buscando en la mitad derecha...");
                inicio = medio + 1;
            } else {
                System.out.println("El dato buscado es menor. Buscando en la mitad izquierda...");
                fin = medio - 1;
            }
        }

        System.out.println("Dato " + dato + " no encontrado después de " + comparaciones + " comparaciones");
    }

    //Metodos de Ordenamiento.
    public void ordenar_seleccion() {
        if (this.cantidad <= 1) {
            System.out.println("Vector vacio o con un solo elemento, no necesita ordenacion");
            return;
        }

        System.out.println("Ordenando vector usando ordenacion por seleccion...");

        for (int i = 0; i < cantidad - 1; i++) {
            int indiceMin = i;

            for (int j = i + 1; j < cantidad; j++) {
                if (A[j] < A[indiceMin]) {
                    indiceMin = j;
                }
            }

            if (indiceMin != i) {
                int temp = A[i];
                A[i] = A[indiceMin];
                A[indiceMin] = temp;
            }
        }

        System.out.println("Vector ordenado correctamente");
    }

    public void ordenar_burbuja() {
        if (this.cantidad <= 1) {
            System.out.println("Vector vacio o con un solo elemento, no necesita ordenacion");
            return;
        }

        System.out.println("Ordenando vector usando ordenacion burbuja...");

        for (int i = 0; i < cantidad - 1; i++) {
            boolean intercambio = false;

            for (int j = 0; j < cantidad - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    // Intercambio
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    intercambio = true;
                }
            }

            if (!intercambio) {
                break;
            }
        }

        System.out.println("Vector ordenado correctamente");
    }

    public void ordenar_insercion() {
        if (this.cantidad <= 1) {
            System.out.println("Vector vacio o con un solo elemento, no necesita ordenacion");
            return;
        }

        System.out.println("Ordenando vector usando ordenacion por insercion...");

        for (int i = 1; i < cantidad; i++) {
            int clave = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] > clave) {
                A[j + 1] = A[j];
                j--;
            }

            A[j + 1] = clave;
        }

        System.out.println("Vector ordenado correctamente");
    }

    public void ordenar_quicksort() {
        if (this.cantidad <= 1) {
            System.out.println("Vector vacio o con un solo elemento, no necesita ordenacion");
            return;
        }

        System.out.println("Ordenando vector usando QuickSort...");
        quicksort(0, cantidad - 1);
        System.out.println("Vector ordenado correctamente");
    }

    private void quicksort(int bajo, int alto) {
        if (bajo < alto) {
            int pi = particion(bajo, alto);

            quicksort(bajo, pi - 1);
            quicksort(pi + 1, alto);
        }
    }

    private int particion(int bajo, int alto) {
        int pivote = A[alto];
        int i = (bajo - 1);

        for (int j = bajo; j < alto; j++) {
            if (A[j] < pivote) {
                i++;

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[alto];
        A[alto] = temp;

        return i + 1;
    }

    private boolean estaOrdenado() {
        for (int i = 1; i < cantidad; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }
    //Metodos de Modificacion.

    public void modificar_dato_por_posicion(int nuevoDato, int pos) {
        if (this.cantidad == 0) {
            System.out.println("Error: Vector vacío");
            return;
        }

        if (pos < 0 || pos >= this.cantidad) {
            System.out.println("Error: Posición inválida");
            return;
        }

        int datoAnterior = A[pos];
        A[pos] = nuevoDato;
        System.out.println("Dato en posición " + pos + " modificado de " + datoAnterior + " a " + nuevoDato);
    }

    public void modificar_primera_ocurrencia(int datoViejo, int datoNuevo) {
        if (this.cantidad == 0) {
            System.out.println("Error: Vector vacío");
            return;
        }

        for (int k = 0; k < this.cantidad; k++) {
            if (A[k] == datoViejo) {
                A[k] = datoNuevo;
                System.out.println("Primera ocurrencia de " + datoViejo + " modificada a " + datoNuevo + " en posición " + k);
                return;
            }
        }

        System.out.println("Dato " + datoViejo + " no encontrado en el vector");
    }

    public void modificar_todas_ocurrencias(int datoViejo, int datoNuevo) {
        if (this.cantidad == 0) {
            System.out.println("Error: Vector vacío");
            return;
        }

        int contador = 0;
        for (int k = 0; k < this.cantidad; k++) {
            if (A[k] == datoViejo) {
                A[k] = datoNuevo;
                contador++;
            }
        }

        if (contador > 0) {
            System.out.println("Se modificaron " + contador + " ocurrencias de " + datoViejo + " a " + datoNuevo);
        } else {
            System.out.println("Dato " + datoViejo + " no encontrado en el vector");
        }
    }

    // Metodos que recorren el Vector.
    public void recorrer_hacia_adelante() {
        if (this.cantidad == 0) {
            System.out.println("El vector está vacio");
            return;
        }

        System.out.println("Recorrido hacia adelante:");
        for (int k = 0; k < this.cantidad; k++) {
            System.out.println("Posicion " + k + ": " + A[k]);
        }
    }

    public void recorrer_hacia_atras() {
        if (this.cantidad == 0) {
            System.out.println("El vector está vacio");
            return;
        }

        System.out.println("Recorrido hacia atras:");
        for (int k = this.cantidad - 1; k >= 0; k--) {
            System.out.println("Posición " + k + ": " + A[k]);
        }
    }

    public void mostrar() {
        if (this.cantidad == 0) {
            System.out.println("El vector esta vacio");
        } else {
            System.out.print("Vector [" + cantidad + " elementos]: ");
            for (int k = 0; k < this.cantidad; k++) {
                System.out.print("[" + this.A[k] + "]");
            }
            System.out.println();
        }
    }

    public int getTamaño() {
        return this.cantidad;
    }

    public boolean estaVacio() {
        return this.cantidad == 0;
    }

    public boolean estaLleno() {
        return this.cantidad == this.tam;
    }

}
