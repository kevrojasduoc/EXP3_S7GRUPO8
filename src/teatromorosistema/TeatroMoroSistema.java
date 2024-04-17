package teatromorosistema;

import java.util.ArrayList;
import java.util.Scanner;

public class TeatroMoroSistema {
    
    class PreciosTeatro{   
        static int precioEntradaVip = 20000;
        static int precioEntradaPlatea = 15000;
        static int precioEntradaGeneral = 10000;
        static int totalEntradasVendidas = 0;

        static int descuentoEstudiante = 10;
        static int descuentoTerceraEdad = 15;
        static int noDescuento = 0;
        static String entradaTipoBoleta = "";
        static String tipoPromoBoleta = "";
    }

    class AsientosTeatro{
        //asientos de teatro: true = disponibles y false = no disponibles, validacion de asientos y numeros
        static String nombreAsientoTeatro0 = "Asiento 1 ";
        static String nombreAsientoTeatro1 = "Asiento 2 ";
        static String nombreAsientoTeatro2 = "Asiento 3 ";
        static String nombreAsientoTeatro3 = "Asiento 4 ";
        static String nombreAsientoTeatro4 = "Asiento 5 ";
        static boolean asientoTeatro0 = true;
        static boolean asientoTeatro1 = true;
        static boolean asientoTeatro2 = true;
        static boolean asientoTeatro3 = true;
        static boolean asientoTeatro4 = true;
        static int numAsiento = 0;
        static boolean validarAsiento = false;
        static String ubicacionAsiento = "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> entradasTeatro = new ArrayList<>();
        boolean salir = false;
        
        String entradaVip = "[1]-VIP";
        String entradaPlatea = "[2]-PLATEA";
        String entradaGeneral = "[3]-GENERAL";
        String promo1Estudiante = "[1]-Promo Estudiante 10%: ";
        String promo2TerceraEdad = "[2]-Promo Tercera Edad 15%: ";
        String noPromo = "[3] No aplica promocion"; 
        
        int tipoPromo;
        int precioFinal = 0;
        int entradaCostoBase = 0;
        
        do{
            System.out.println("""
                                [1] Venta de Entradas
                                [2] Imprimir boleta
                                [3] Resumen de ventas
                                [0] Salir del sistema
                                Ingresar opcion:""");
            int opmenu = scanner.nextInt();
            switch(opmenu){
                case 1 ->{
                    System.out.println(entradaVip); //1
                    System.out.println(entradaPlatea);//2
                    System.out.println(entradaGeneral);//3
                    System.out.println("Ingresar entrada deseada: ");
                    int tipoEntrada = scanner.nextInt();
                    switch(tipoEntrada){
                        case 1,2,3 ->{
                            System.out.println(promo1Estudiante + "descuento: " + PreciosTeatro.descuentoEstudiante + "%");
                            System.out.println(promo2TerceraEdad + "descuento: " + PreciosTeatro.descuentoTerceraEdad + "%");
                            System.out.println(noPromo);
                            System.out.println("Ingrese la promo deseada: ");
                            tipoPromo = scanner.nextInt();
                            if (tipoPromo == 1 || tipoPromo == 2 || tipoPromo == 3){                               
                                System.out.println("Disponibilidad de asientos:");
                                System.out.println(AsientosTeatro.nombreAsientoTeatro0 + (AsientosTeatro.asientoTeatro0 ? "Disponible" : "Ocupado"));
                                System.out.println(AsientosTeatro.nombreAsientoTeatro1 + (AsientosTeatro.asientoTeatro1 ? "Disponible" : "Ocupado"));
                                System.out.println(AsientosTeatro.nombreAsientoTeatro2 + (AsientosTeatro.asientoTeatro2 ? "Disponible" : "Ocupado"));
                                System.out.println(AsientosTeatro.nombreAsientoTeatro3  + (AsientosTeatro.asientoTeatro3 ? "Disponible" : "Ocupado"));
                                System.out.println(AsientosTeatro.nombreAsientoTeatro4 + (AsientosTeatro.asientoTeatro4 ? "Disponible" : "Ocupado"));                               
                                System.out.println("Ingrese el asiento: ");
                                AsientosTeatro.numAsiento = scanner.nextInt();  
                                switch (AsientosTeatro.numAsiento){
                                    case 1 ->{
                                        AsientosTeatro.validarAsiento = AsientosTeatro.asientoTeatro0;
                                        AsientosTeatro.ubicacionAsiento = AsientosTeatro.nombreAsientoTeatro0;
                                        AsientosTeatro.asientoTeatro0 = false;
                                    }
                                    case 2 ->{
                                        AsientosTeatro.validarAsiento = AsientosTeatro.asientoTeatro1;
                                        AsientosTeatro.ubicacionAsiento = AsientosTeatro.nombreAsientoTeatro1;
                                        AsientosTeatro.asientoTeatro1 = false;
                                    }
                                    case 3 ->{
                                        AsientosTeatro.validarAsiento = AsientosTeatro.asientoTeatro2;
                                        AsientosTeatro.ubicacionAsiento = AsientosTeatro.nombreAsientoTeatro2;
                                        AsientosTeatro.asientoTeatro2 = false;
                                    }
                                    case 4 ->{
                                        AsientosTeatro.validarAsiento = AsientosTeatro.asientoTeatro3;
                                        AsientosTeatro.ubicacionAsiento = AsientosTeatro.nombreAsientoTeatro3;
                                        AsientosTeatro.asientoTeatro3 = false;
                                    }
                                    case 5 ->{
                                        AsientosTeatro.validarAsiento = AsientosTeatro.asientoTeatro4;
                                        AsientosTeatro.ubicacionAsiento = AsientosTeatro.nombreAsientoTeatro4;
                                        AsientosTeatro.asientoTeatro4 = false;
                                    }
                                    default -> System.out.println("Asiento no disponible");
                                }//end switch numAsiento
                                if ((AsientosTeatro.validarAsiento) && tipoEntrada == 1 && tipoPromo == 1){ //validacion entrada VIP + ESTUDIANTE
                                    System.out.println(promo1Estudiante + "Descuento: " + PreciosTeatro.descuentoEstudiante + "%");
                                    precioFinal = PreciosTeatro.precioEntradaVip - (PreciosTeatro.descuentoEstudiante*PreciosTeatro.precioEntradaVip)/100;
                                    System.out.println("Precio final " + precioFinal);                                   
                                    PreciosTeatro.entradaTipoBoleta = entradaVip;
                                    PreciosTeatro.tipoPromoBoleta = promo1Estudiante;
                                    entradaCostoBase = PreciosTeatro.precioEntradaVip;
                                    entradasTeatro.add("Tipo de Entrada: "+PreciosTeatro.entradaTipoBoleta+"\n"+"Costo Base: "+entradaCostoBase+"\n"+"Descuento Aplicado: "+PreciosTeatro.tipoPromoBoleta+"\n"+"Ubicacion: "+AsientosTeatro.ubicacionAsiento+"\n"+"Costo Final: "+ precioFinal);
                                }else if ((AsientosTeatro.validarAsiento) && tipoEntrada == 1 && tipoPromo == 2){ //validacion entrada VIP + TERCERA EDAD
                                    System.out.println(promo2TerceraEdad + "Descuento: " + PreciosTeatro.descuentoTerceraEdad + "%");
                                    precioFinal = PreciosTeatro.precioEntradaVip - (PreciosTeatro.descuentoTerceraEdad*PreciosTeatro.precioEntradaVip)/100;
                                    System.out.println("Precio final " + precioFinal);
                                    PreciosTeatro.entradaTipoBoleta = entradaVip;
                                    PreciosTeatro.tipoPromoBoleta = promo2TerceraEdad; 
                                    entradaCostoBase = PreciosTeatro.precioEntradaVip;
                                    entradasTeatro.add("Tipo de Entrada: "+PreciosTeatro.entradaTipoBoleta+"\n"+"Costo Base: "+entradaCostoBase+"\n"+"Descuento Aplicado: "+PreciosTeatro.tipoPromoBoleta+"\n"+"Ubicacion: "+AsientosTeatro.ubicacionAsiento+"\n"+"Costo Final: "+ precioFinal);       
                                }else if((AsientosTeatro.validarAsiento) && tipoEntrada == 1 && tipoPromo == 3){ //validacion entrada vip + no descuentos
                                    System.out.println(noPromo + "Descuento: " + PreciosTeatro.noDescuento+"%");
                                    precioFinal = PreciosTeatro.precioEntradaVip;
                                    System.out.println("Precio Final: " + precioFinal);
                                    PreciosTeatro.entradaTipoBoleta = entradaVip;
                                    PreciosTeatro.tipoPromoBoleta = noPromo;
                                    entradaCostoBase = PreciosTeatro.precioEntradaVip;
                                    entradasTeatro.add("Tipo de Entrada: "+PreciosTeatro.entradaTipoBoleta+"\n"+"Costo Base: "+entradaCostoBase+"\n"+"Descuento Aplicado: "+PreciosTeatro.tipoPromoBoleta+"\n"+"Ubicacion: "+AsientosTeatro.ubicacionAsiento+"\n"+"Costo Final: "+ precioFinal);                                   
                                }else if((AsientosTeatro.validarAsiento) && tipoEntrada == 2 && tipoPromo == 1){ //validacion entrada platea + estudiantes
                                    System.out.println(promo1Estudiante + "Descuento: " + PreciosTeatro.descuentoEstudiante + "%");
                                    precioFinal = PreciosTeatro.precioEntradaPlatea - (PreciosTeatro.descuentoEstudiante*PreciosTeatro.precioEntradaPlatea)/100;
                                    System.out.println("Precio final " + precioFinal);                                   
                                    PreciosTeatro.entradaTipoBoleta = entradaPlatea;
                                    PreciosTeatro.tipoPromoBoleta = promo1Estudiante;
                                    entradaCostoBase = PreciosTeatro.precioEntradaPlatea;
                                    entradasTeatro.add("Tipo de Entrada: "+PreciosTeatro.entradaTipoBoleta+"\n"+"Costo Base: "+entradaCostoBase+"\n"+"Descuento Aplicado: "+PreciosTeatro.tipoPromoBoleta+"\n"+"Ubicacion: "+AsientosTeatro.ubicacionAsiento+"\n"+"Costo Final: "+ precioFinal);                                                                      
                                }else if((AsientosTeatro.validarAsiento) && tipoEntrada == 2 && tipoPromo == 2){ //validaicon entrada platea + tercera edad
                                    System.out.println(promo2TerceraEdad + "Descuento: " + PreciosTeatro.descuentoTerceraEdad + "%");
                                    precioFinal = PreciosTeatro.precioEntradaPlatea - (PreciosTeatro.descuentoTerceraEdad*PreciosTeatro.precioEntradaPlatea)/100;
                                    System.out.println("Precio final " + precioFinal);                      
                                    PreciosTeatro.entradaTipoBoleta = entradaPlatea;
                                    PreciosTeatro.tipoPromoBoleta = promo2TerceraEdad;
                                    entradaCostoBase = PreciosTeatro.precioEntradaPlatea;
                                    entradasTeatro.add("Tipo de Entrada: "+PreciosTeatro.entradaTipoBoleta+"\n"+"Costo Base: "+entradaCostoBase+"\n"+"Descuento Aplicado: "+PreciosTeatro.tipoPromoBoleta+"\n"+"Ubicacion: "+AsientosTeatro.ubicacionAsiento+"\n"+"Costo Final: "+ precioFinal);                                                                      
                                }else if((AsientosTeatro.validarAsiento) && tipoEntrada == 2 && tipoPromo == 3){ //validacion entrada plata + no descuento
                                    System.out.println(noPromo + "Descuento: " + PreciosTeatro.noDescuento+"%");
                                    precioFinal = PreciosTeatro.precioEntradaPlatea;
                                    System.out.println("Precio Final: " + precioFinal);
                                    PreciosTeatro.entradaTipoBoleta = entradaPlatea;
                                    PreciosTeatro.tipoPromoBoleta = noPromo;
                                    entradaCostoBase = PreciosTeatro.precioEntradaPlatea;
                                    entradasTeatro.add("Tipo de Entrada: "+PreciosTeatro.entradaTipoBoleta+"\n"+"Costo Base: "+entradaCostoBase+"\n"+"Descuento Aplicado: "+PreciosTeatro.tipoPromoBoleta+"\n"+"Ubicacion: "+AsientosTeatro.ubicacionAsiento+"\n"+"Costo Final: "+ precioFinal);                                   
                                }else if((AsientosTeatro.validarAsiento) && tipoEntrada == 3 && tipoPromo == 1){ //valiacion entrada general + estudiantes
                                    System.out.println(promo1Estudiante + "Descuento: " + PreciosTeatro.descuentoEstudiante + "%");
                                    precioFinal = PreciosTeatro.precioEntradaGeneral - (PreciosTeatro.descuentoEstudiante*PreciosTeatro.precioEntradaGeneral)/100;
                                    System.out.println("Precio final " + precioFinal);                                   
                                    PreciosTeatro.entradaTipoBoleta = entradaGeneral;
                                    PreciosTeatro.tipoPromoBoleta = promo1Estudiante;
                                    entradaCostoBase = PreciosTeatro.precioEntradaGeneral;
                                    entradasTeatro.add("Tipo de Entrada: "+PreciosTeatro.entradaTipoBoleta+"\n"+"Costo Base: "+entradaCostoBase+"\n"+"Descuento Aplicado: "+PreciosTeatro.tipoPromoBoleta+"\n"+"Ubicacion: "+AsientosTeatro.ubicacionAsiento+"\n"+"Costo Final: "+ precioFinal);                    
                                }else if((AsientosTeatro.validarAsiento) && tipoEntrada == 3 && tipoPromo == 2){ //validacion entrada general + tercera edad
                                    System.out.println(promo2TerceraEdad + "Descuento: " + PreciosTeatro.descuentoTerceraEdad + "%");
                                    precioFinal = PreciosTeatro.precioEntradaGeneral - (PreciosTeatro.descuentoTerceraEdad*PreciosTeatro.precioEntradaGeneral)/100;
                                    System.out.println("Precio final " + precioFinal);                      
                                    PreciosTeatro.entradaTipoBoleta = entradaGeneral;
                                    PreciosTeatro.tipoPromoBoleta = promo2TerceraEdad;
                                    entradaCostoBase = PreciosTeatro.precioEntradaGeneral;
                                    entradasTeatro.add("Tipo de Entrada: "+PreciosTeatro.entradaTipoBoleta+"\n"+"Costo Base: "+entradaCostoBase+"\n"+"Descuento Aplicado: "+PreciosTeatro.tipoPromoBoleta+"\n"+"Ubicacion: "+AsientosTeatro.ubicacionAsiento+"\n"+"Costo Final: "+ precioFinal);    
                                }else if((AsientosTeatro.validarAsiento) && tipoEntrada == 3 && tipoPromo == 3){ //validacion entrada general + no descuento
                                    System.out.println(noPromo + "Descuento: " + PreciosTeatro.noDescuento+"%");
                                    precioFinal = PreciosTeatro.precioEntradaGeneral;
                                    System.out.println("Precio Final: " + precioFinal);
                                    PreciosTeatro.entradaTipoBoleta = entradaGeneral;
                                    PreciosTeatro.tipoPromoBoleta = noPromo;
                                    entradaCostoBase = PreciosTeatro.precioEntradaGeneral;
                                    entradasTeatro.add("Tipo de Entrada: "+PreciosTeatro.entradaTipoBoleta+"\n"+"Costo Base: "+entradaCostoBase+"\n"+"Descuento Aplicado: "+PreciosTeatro.tipoPromoBoleta+"\n"+"Ubicacion: "+AsientosTeatro.ubicacionAsiento+"\n"+"Costo Final: "+ precioFinal);                                   
                                }else{
                                    System.out.println("Ingrese una opcion valida...");
                                }
                            }//end if tipoPromo
                            else{
                                System.out.println("Ingrese una opcion valida...");
                            }                           
                        }//end case 1,2,3
                     default -> System.out.println("Ingrese una opcion valida...");
                    }//end switch tipoEntrada       
                }//end case 1 switch opmenu
                case 2 ->{
                    System.out.println("#####################################");
                    System.out.println("       BOLETA TEATRO MORO            ");
                    System.out.println("#####################################");
                    System.out.println("Detalle:");
                    System.out.println("Entrada: " + PreciosTeatro.entradaTipoBoleta);
                    System.out.println("Descuento: " + PreciosTeatro.tipoPromoBoleta);                  
                    System.out.println("Ubicacion: " + AsientosTeatro.ubicacionAsiento);
                    System.out.println("Total a pagar:" + precioFinal);                   
                    System.out.println("#####################################");
                    System.out.println("Gracias por su visita al Teatro Moro ");
                    System.out.println("#####################################");
                }//end case 2 switch opmenu
                case 3 ->{
                    System.out.println("Resumen de boletas");
                    System.out.println("#########################################");
                    for (int i=0; i< entradasTeatro.size();i++){
                        System.out.println((i + 1) + ":" + entradasTeatro.get(i));
                        System.out.println("#########################################");
                    }
                    PreciosTeatro.totalEntradasVendidas = entradasTeatro.size();
                    System.out.println("Total de boletas: " + PreciosTeatro.totalEntradasVendidas);
                }
                case 0 ->{
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                }
                default ->{
                    System.out.println("Ingrese una opcion valida...");
                }
            }//end switch opmenu
        }while(!salir);
        scanner.close();
    }//end main
}//end class