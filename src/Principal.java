import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        String menu = """
                         ***************************************
                         Sea bienvenido/a al Conversor de Moneda
                         1) Dolar =>> Peso Argentino
                         2) Peso Argentino =>> Dolar
                         3) Dolar =>> Real Brasileño
                         4) Real Brasileño =>> Dolar
                         5) Dolar =>> Peso Colombiano
                         6) Peso Colombiano =>> Dolar
                         7) Salir
                         Elija una opción valida
                         ***************************************
                      """;
        try {
            while (true){
                Double valorAConvertir;
                Double razonDeCambio = (double) 0;
                Moneda moneda = consulta.buscaMoneda("USD");
                Double valorConvertido;
                String codigoConvertir = "";

                System.out.println(menu);

                var opcion = lectura.nextInt();

                if (opcion == 7){
                    System.out.println("Cambio de moneda finalizado");
                    break;
                }

                switch (opcion){
                    case 1:
                        moneda = consulta.buscaMoneda("USD");
                        razonDeCambio = moneda.conversion_rates().get("ARS").getAsDouble();
                        codigoConvertir = "ARS";
                        break;
                    case 2:
                        moneda = consulta.buscaMoneda("ARS");
                        razonDeCambio = moneda.conversion_rates().get("USD").getAsDouble();
                        codigoConvertir = "USD";
                        break;
                    case 3:
                        moneda = consulta.buscaMoneda("USD");
                        razonDeCambio = moneda.conversion_rates().get("BRL").getAsDouble();
                        codigoConvertir = "BRL";
                        break;
                    case 4:
                        moneda = consulta.buscaMoneda("BRL");
                        razonDeCambio = moneda.conversion_rates().get("USD").getAsDouble();
                        codigoConvertir = "USD";
                        break;
                    case 5:
                        moneda = consulta.buscaMoneda("USD");
                        razonDeCambio = moneda.conversion_rates().get("COP").getAsDouble();
                        codigoConvertir = "COP";
                        break;
                    case 6:
                        moneda = consulta.buscaMoneda("COP");
                        razonDeCambio = moneda.conversion_rates().get("USD").getAsDouble();
                        codigoConvertir = "USD";
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }

                if(opcion<7 && opcion>0){
                    System.out.println("Ingresa el valor que deseas convertir: ");
                    valorAConvertir = lectura.nextDouble();
                    valorConvertido = valorAConvertir * razonDeCambio;
                    System.out.println("El valor " + valorAConvertir + " " + moneda.base_code() +
                            " corresponde al valor final de =>>> " + valorConvertido + codigoConvertir);
                }
            }
        } catch (InputMismatchException e){
            System.out.println("El dato ingresado no es un número");
            System.out.println("Programa finalizado");
        }
    }
}
