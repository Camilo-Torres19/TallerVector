package Arrays;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opcion;
        int pos = 0;
        int numero = 0;
        int datoNuevo = 0;
        Vector vector = new Vector(10);
        Scanner sc = new Scanner(System.in);

        do {
            menu_de_opciones();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: 
                    menu_Insercion();
                    int opcionInsercion = sc.nextInt();

                    switch (opcionInsercion) {
                        case 1:
                            System.out.println("Ingrese el numero a insertar al vector");
                            numero = sc.nextInt();
                            vector.insertar_inicio(numero);
                            break;
                        case 2:
                            System.out.println("Ingrese el numero a insertar al vector");
                            numero = sc.nextInt();
                            vector.insertar_final(numero);
                            break;
                        case 3:
                            System.out.println("Indique la posicion (0 a " + (vector.getTamaño()) + ")");
                            pos = sc.nextInt();
                            System.out.println("Ingrese el numero a insertar al vector");
                            numero = sc.nextInt();
                            vector.insertar_antes_posicion(numero, pos);
                            break;
                        case 4:
                            System.out.println("Indique la posicion (0 a " + (vector.getTamaño() - 1) + ")");
                            pos = sc.nextInt();
                            System.out.println("Ingrese el numero a insertar al vector");
                            numero = sc.nextInt();
                            vector.insertar_despues_posicion(numero, pos);
                            break;
                        case 5:
                            System.out.println("Indique la posicion (0 a " + vector.getTamaño() + ")");
                            pos = sc.nextInt();
                            System.out.println("Ingrese el numero a insertar al vector");
                            numero = sc.nextInt();
                            vector.insertar_posicion(numero, pos);
                            break;
                        case 6:
                            System.out.println("Regresando al menu principal...");
                            break;
                        default:
                            System.out.println("Opcion Invalida");
                    }
                    break;

                case 2: 
                    menu_Eliminar();
                    int opcionEliminar = sc.nextInt();

                    switch (opcionEliminar) {
                        case 1:
                            vector.eliminar_inicio();
                            break;
                        case 2:
                            vector.eliminar_final();
                            break;
                        case 3:
                            System.out.println("Indique la posicion (0 a " + (vector.getTamaño() - 1) + ")");
                            pos = sc.nextInt();
                            vector.eliminar_posicion(pos);
                            break;
                        case 4:
                            System.out.println("Ingrese el dato a eliminar del vector");
                            numero = sc.nextInt();
                            vector.eliminar_dato(numero);
                            break;
                        case 5:
                            System.out.println("Regresando al menu principal...");
                            break;
                        default:
                            System.out.println("Opcion Invalida");
                    }
                    break;
                    
                case 3: 
                    menu_Buscar();
                    int opcionBuscar = sc.nextInt();

                    switch (opcionBuscar) {
                        case 1:
                            System.out.println("Ingrese dato a buscar.");
                            numero = sc.nextInt();
                            vector.buscar_lineal(numero);
                            break;
                        case 2:
                            System.out.println("Ingrese dato a buscar.");
                            numero = sc.nextInt();
                            vector.busquedaBinaria(numero);
                            break;
                        case 3:
                            System.out.println("Ingrese dato a buscar.");
                            numero = sc.nextInt();
                            vector.buscar_derecha_izquierda(numero);
                            break;
                        case 4:
                            System.out.println("Ingrese dato a buscar.");
                            numero = sc.nextInt();
                            vector.buscar_izquierda_derecha(numero);
                            break;
                        case 5:
                            System.out.println("Regresando al menu principal...");
                            break;
                        default:
                            System.out.println("Opcion Invalida");
                    }
                    break;
                    
                case 4: 
                    menu_Ordenar();
                    int opcionOrdenar = sc.nextInt();
                    
                    switch (opcionOrdenar) {
                        case 1:
                            vector.ordenar_seleccion();
                            vector.mostrar();
                            break;
                        case 2:
                            vector.ordenar_burbuja();
                            vector.mostrar();
                            break;
                        case 3:
                            vector.ordenar_insercion();
                            vector.mostrar();
                            break;
                        case 4:
                            vector.ordenar_quicksort();
                            vector.mostrar();
                            break;
                        case 5:
                            System.out.println("Regresando al menu principal...");
                            break;
                        default:
                            System.out.println("Opcion Invalida");
                    }
                    break;

                case 5: 
                    menu_Modificar();
                    int opcionModificar = sc.nextInt();
                    
                    switch (opcionModificar) {
                        case 1:
                            System.out.println("Indique la posicion a modificar (0 a " + (vector.getTamaño() - 1) + ")");
                            pos = sc.nextInt();
                            System.out.println("Ingrese el nuevo valor");
                            datoNuevo = sc.nextInt();
                            vector.modificar_dato_por_posicion(datoNuevo, pos);
                            break;
                        case 2:
                            System.out.println("Ingrese el dato a modificar");
                            numero = sc.nextInt();
                            System.out.println("Ingrese el nuevo valor");
                            datoNuevo = sc.nextInt();
                            vector.modificar_primera_ocurrencia(numero, datoNuevo);
                            break;
                        case 3:
                            System.out.println("Ingrese el dato a modificar");
                            numero = sc.nextInt();
                            System.out.println("Ingrese el nuevo valor");
                            datoNuevo = sc.nextInt();
                            vector.modificar_todas_ocurrencias(numero, datoNuevo);
                            break;
                        case 4:
                            System.out.println("Regresando al menu principal...");
                            break;
                        default:
                            System.out.println("Opcion Invalida");
                    }
                    break;

                case 6: 
                    menu_Recorrer();
                    int opcionRecorrer = sc.nextInt();
                    
                    switch (opcionRecorrer) {
                        case 1:
                            vector.mostrar();
                            break;
                        case 2:
                            vector.recorrer_hacia_adelante();
                            break;
                        case 3:
                            vector.recorrer_hacia_atras();
                            break;
                        case 4:
                            System.out.println("Regresando al menu principal...");
                            break;
                        default:
                            System.out.println("Opcion Invalida");
                    }
                    break;
                    
                case 7: 
                    System.out.println("¡Gracias por usar el programa!");
                    break;
                    
                default:
                    System.out.println("Opcion Invalida");
            }

        } while (opcion != 7);
        
        sc.close();
    }

    public static void menu_de_opciones() {
        System.out.println("  MENU PRINCIPAL ");
        System.out.println("1. Insercion");
        System.out.println("2. Eliminar");
        System.out.println("3. Buscar");
        System.out.println("4. Ordenar");
        System.out.println("5. Modificar");
        System.out.println("6. Recorrer");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public static void menu_Insercion() {
        System.out.println(" MENU INSERCION ");
        System.out.println("1. Al Inicio");
        System.out.println("2. Al final");
        System.out.println("3. Antes de posicion");
        System.out.println("4. Despues de posicion");
        System.out.println("5. En posicion especifica");
        System.out.println("6. Regresar");
        System.out.print("Seleccione una opcion: ");
    }

    public static void menu_Eliminar() {
        System.out.println(" MENU ELIMINACION ");
        System.out.println("1. Al Inicio");
        System.out.println("2. Al final");
        System.out.println("3. Por posicion");
        System.out.println("4. Por dato");
        System.out.println("5. Regresar");
        System.out.print("Seleccione una opcion: ");
    }

    public static void menu_Buscar() {
        System.out.println(" MENU BUSCAR ");
        System.out.println("1. Busqueda Lineal");
        System.out.println("2. Busqueda Binaria");
        System.out.println("3. Derecha a Izquierda");
        System.out.println("4. Izquierda a Derecha");
        System.out.println("5. Regresar");
        System.out.print("Seleccione una opcion: ");
    }

    public static void menu_Ordenar() {
        System.out.println(" MENU ORDENAR ");
        System.out.println("1. Ordenamiento por Seleccion");
        System.out.println("2. Ordenamiento Burbuja");
        System.out.println("3. Ordenamiento por Insercion");
        System.out.println("4. QuickSort");
        System.out.println("5. Regresar");
        System.out.print("Seleccione una opcion: ");
    }

    public static void menu_Modificar() {
        System.out.println(" MENU MODIFICAR ");
        System.out.println("1. Modificar por posicion");
        System.out.println("2. Modificar primera ocurrencia");
        System.out.println("3. Modificar todas las ocurrencias");
        System.out.println("4. Regresar");
        System.out.print("Seleccione una opcion: ");
    }

    public static void menu_Recorrer() {
        System.out.println(" MENU RECORRER ");
        System.out.println("1. Mostrar vector");
        System.out.println("2. Recorrer hacia adelante");
        System.out.println("3. Recorrer hacia atras");
        System.out.println("4. Mostrar estadisticas");
        System.out.println("5. Regresar");
        System.out.print("Seleccione una opcion: ");
    }
}