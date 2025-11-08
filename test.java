import org.antlr.runtime.*;
import java.io.*;

public class test {
    public static void main(String[] args) {
        try {
            String archivoEntrada = "codigo_prueba.txt";
            String archivoSalida = "pagina";
            
            // Verificar argumentos
            if (args.length >= 1) {
                archivoEntrada = args[0];
            }
            if (args.length >= 2) {
                archivoSalida = args[1];
            }
            
            System.out.println("=== Compilador de Lenguaje Web CRUD ===");
            System.out.println("Archivo de entrada: " + archivoEntrada);
            System.out.println("Archivo de salida: " + archivoSalida);
            System.out.println("========================================\n");
            
            // Crear el flujo de entrada
            CharStream input = new ANTLRFileStream(archivoEntrada);
            
            // Crear el lexer
            WebPageLanguageLexer lexer = new WebPageLanguageLexer(input);
            
            // Crear el flujo de tokens
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            // Crear el parser
            WebPageLanguageParser parser = new WebPageLanguageParser(tokens);
            
            // Analizar el programa
            System.out.println("Analizando código fuente...\n");
            parser.pagina();
            
            // Verificar si hubo errores
            if (parser.getNumberOfSyntaxErrors() == 0) {
                System.out.println("\n✓ Análisis sintáctico completado sin errores\n");
                
                // Generar archivos de salida
                parser.guardarArchivos(archivoSalida);
                
                System.out.println("\n✓ Compilación exitosa!");
                System.out.println("\nPuedes abrir " + archivoSalida + ".html en tu navegador para ver el resultado.");
            } else {
                System.err.println("\n✗ Se encontraron " + parser.getNumberOfSyntaxErrors() + " error(es) de sintaxis");
                System.exit(1);
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        } catch (RecognitionException e) {
            System.err.println("Error de reconocimiento: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
