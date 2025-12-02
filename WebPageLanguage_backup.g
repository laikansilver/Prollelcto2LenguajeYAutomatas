grammar WebPageLanguage;

@header {
    import java.io.*;
    import java.util.List;
    import java.util.ArrayList;
}

@members {
    // Variables para generar HTML y CSS
    StringBuilder html = new StringBuilder();
    StringBuilder css = new StringBuilder();
    StringBuilder crudSpec = new StringBuilder();
    String currentDatabase = "";
    String currentTable = "";
    List<String> campos = new ArrayList<String>();
    
    // Método para obtener el HTML generado
    public String getHTML() {
        return html.toString();
    }
    
    // Método para obtener el CSS generado
    public String getCSS() {
        return css.toString();
    }
    
    // Método para obtener la especificación CRUD
    public String getCRUDSpec() {
        return crudSpec.toString();
    }
    
    // Método para guardar archivos
    public void guardarArchivos(String baseFileName) {
        try {
            // Guardar HTML
            FileWriter htmlFile = new FileWriter(baseFileName + ".html");
            htmlFile.write(html.toString());
            htmlFile.close();
            
            // Guardar CSS
            FileWriter cssFile = new FileWriter(baseFileName + ".css");
            cssFile.write(css.toString());
            cssFile.close();
            
            // Guardar especificación CRUD
            if (crudSpec.length() > 0) {
                FileWriter crudFile = new FileWriter(baseFileName + "_crud.txt");
                crudFile.write(crudSpec.toString());
                crudFile.close();
            }
            
            System.out.println("Archivos generados exitosamente:");
            System.out.println("- " + baseFileName + ".html");
            System.out.println("- " + baseFileName + ".css");
            if (crudSpec.length() > 0) {
                System.out.println("- " + baseFileName + "_crud.txt");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar archivos: " + e.getMessage());
        }
    }
    
    // Método para inicializar CSS base
    private void inicializarCSS() {
        css.append("/* CSS Generado Automáticamente */\n\n");
        css.append("* {\n");
        css.append("    margin: 0;\n");
        css.append("    padding: 0;\n");
        css.append("    box-sizing: border-box;\n");
        css.append("}\n\n");
        css.append("body {\n");
        css.append("    font-family: Arial, sans-serif;\n");
        css.append("    line-height: 1.6;\n");
        css.append("    background-color: #f4f4f4;\n");
        css.append("    padding: 20px;\n");
        css.append("}\n\n");
        css.append(".container {\n");
        css.append("    max-width: 1200px;\n");
        css.append("    margin: 0 auto;\n");
        css.append("    background: white;\n");
        css.append("    padding: 20px;\n");
        css.append("    box-shadow: 0 0 10px rgba(0,0,0,0.1);\n");
        css.append("}\n\n");
        css.append("hr {\n");
        css.append("    border: none;\n");
        css.append("    border-top: 2px solid #333;\n");
        css.append("    margin: 20px 0;\n");
        css.append("}\n\n");
        css.append("h1 {\n");
        css.append("    color: #333;\n");
        css.append("    text-align: center;\n");
        css.append("    margin: 20px 0;\n");
        css.append("}\n\n");
        css.append(".menu {\n");
        css.append("    background: #333;\n");
        css.append("    padding: 10px;\n");
        css.append("    margin: 20px 0;\n");
        css.append("}\n\n");
        css.append(".menu ul {\n");
        css.append("    list-style: none;\n");
        css.append("    display: flex;\n");
        css.append("    justify-content: center;\n");
        css.append("}\n\n");
        css.append(".menu li {\n");
        css.append("    margin: 0 15px;\n");
        css.append("}\n\n");
        css.append(".menu a {\n");
        css.append("    color: white;\n");
        css.append("    text-decoration: none;\n");
        css.append("    padding: 5px 10px;\n");
        css.append("}\n\n");
        css.append(".menu a:hover {\n");
        css.append("    background: #555;\n");
        css.append("}\n\n");
        css.append(".imagenes {\n");
        css.append("    display: flex;\n");
        css.append("    justify-content: center;\n");
        css.append("    gap: 20px;\n");
        css.append("    margin: 20px 0;\n");
        css.append("    flex-wrap: wrap;\n");
        css.append("}\n\n");
        css.append(".imagenes img {\n");
        css.append("    max-width: 300px;\n");
        css.append("    height: auto;\n");
        css.append("    border-radius: 5px;\n");
        css.append("    box-shadow: 0 2px 5px rgba(0,0,0,0.2);\n");
        css.append("}\n\n");
        css.append(".texto {\n");
        css.append("    margin: 20px 0;\n");
        css.append("    padding: 15px;\n");
        css.append("    background: #f9f9f9;\n");
        css.append("    border-left: 4px solid #333;\n");
        css.append("}\n\n");
        css.append(".crud-section {\n");
        css.append("    margin: 30px 0;\n");
        css.append("    padding: 20px;\n");
        css.append("    border: 2px solid #ddd;\n");
        css.append("    border-radius: 5px;\n");
        css.append("}\n\n");
        css.append(".acercade {\n");
        css.append("    margin-top: 40px;\n");
        css.append("    padding: 20px;\n");
        css.append("    background: #e9e9e9;\n");
        css.append("    border-radius: 5px;\n");
        css.append("}\n\n");
        css.append(".acercade p {\n");
        css.append("    margin: 10px 0;\n");
        css.append("}\n\n");
    }
}

// Regla principal
pagina
    :   'Inicio' 'pagina' 
        { 
            html.append("<!DOCTYPE html>\n");
            html.append("<html lang=\"es\">\n");
            html.append("<head>\n");
            html.append("    <meta charset=\"UTF-8\">\n");
            html.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            html.append("    <title>Página Generada</title>\n");
            html.append("    <link rel=\"stylesheet\" href=\"pagina.css\">\n");
            html.append("</head>\n");
            html.append("<body>\n");
            html.append("    <div class=\"container\">\n");
            inicializarCSS();
        }
        (elemento)+
        'fin' 'pagina'
        {
            html.append("    </div>\n");
            html.append("</body>\n");
            html.append("</html>\n");
        }
    ;

elemento
    :   linea
    |   titulo
    |   menu
    |   seccionImagenes
    |   texto
    |   crud
    |   seccionAcercaDe
    ;

linea
    :   'linea' 'simple'
        {
            html.append("        <hr>\n");
        }
    |   'linea' 'doble'
        {
            html.append("        <hr style=\"border-top: 4px double #333;\">\n");
        }
    ;

titulo
    :   'titulo' STRING
        {
            String tituloTexto = $STRING.text;
            tituloTexto = tituloTexto.substring(1, tituloTexto.length()-1); // Quitar comillas
            html.append("        <h1>" + tituloTexto + "</h1>\n");
        }
    ;

menu
    :   'menu' 'opciones' 
        {
            html.append("        <nav class=\"menu\">\n");
            html.append("            <ul>\n");
            html.append("                <li><a href=\"#inicio\">Inicio</a></li>\n");
            html.append("                <li><a href=\"#productos\">Productos</a></li>\n");
            html.append("                <li><a href=\"#servicios\">Servicios</a></li>\n");
            html.append("                <li><a href=\"#contacto\">Contacto</a></li>\n");
            html.append("            </ul>\n");
            html.append("        </nav>\n");
        }
    ;

seccionImagenes
    :   'seccion' 'imagenes' 
        {
            html.append("        <div class=\"imagenes\">\n");
        }
        (imagen)+
        {
            html.append("        </div>\n");
        }
    ;

imagen
    :   ID
        {
            String nombreImg = $ID.text;
            html.append("            <img src=\"" + nombreImg + "\" alt=\"Imagen\">\n");
        }
    ;

texto
    :   'texto' STRING
        {
            String textoContenido = $STRING.text;
            textoContenido = textoContenido.substring(1, textoContenido.length()-1);
            html.append("        <div class=\"texto\">\n");
            html.append("            <p>" + textoContenido + "</p>\n");
            html.append("        </div>\n");
        }
    ;

crud
    :   'crud' 'inicio'
        {
            html.append("        <div class=\"crud-section\">\n");
            html.append("            <h2>Sección CRUD</h2>\n");
            html.append("            <p><em>Esta sección será implementada con PHP en la Unidad 4</em></p>\n");
            campos.clear();
        }
        bdd
        (tabla)+
        'crud' 'fin'
        {
            html.append("        </div>\n");
            // Generar especificación CRUD
            crudSpec.append("=== ESPECIFICACIÓN CRUD ===\n\n");
            crudSpec.append("Base de Datos: " + currentDatabase + "\n");
            crudSpec.append("Tabla: " + currentTable + "\n");
            crudSpec.append("Campos:\n");
            for (String campo : campos) {
                crudSpec.append("  - " + campo + "\n");
            }
            crudSpec.append("\n");
            crudSpec.append("Operaciones requeridas:\n");
            crudSpec.append("  - CREATE (Insertar)\n");
            crudSpec.append("  - READ (Consultar)\n");
            crudSpec.append("  - UPDATE (Actualizar)\n");
            crudSpec.append("  - DELETE (Eliminar)\n");
        }
    ;

bdd
    :   'bdd' ID
        {
            currentDatabase = $ID.text;
            html.append("            <p><strong>Base de Datos:</strong> " + currentDatabase + "</p>\n");
        }
    ;

tabla
    :   'tabla' ID
        {
            currentTable = $ID.text;
            html.append("            <p><strong>Tabla:</strong> " + currentTable + "</p>\n");
            html.append("            <p><strong>Campos:</strong></p>\n");
            html.append("            <ul>\n");
        }
        (campo)+
        'fintabla'
        {
            html.append("            </ul>\n");
        }
    ;

campo
    :   'campo' ID
        {
            String nombreCampo = $ID.text;
            campos.add(nombreCampo);
            html.append("                <li>" + nombreCampo + "</li>\n");
        }
    ;

seccionAcercaDe
    :   'seccion' 'acercade'
        {
            html.append("        <div class=\"acercade\">\n");
            html.append("            <h2>Acerca de</h2>\n");
        }
        (infoAcercaDe)+
        {
            html.append("        </div>\n");
        }
    ;

infoAcercaDe
    :   'domicilio' ':' STRING
        {
            String domicilio = $STRING.text;
            domicilio = domicilio.substring(1, domicilio.length()-1);
            html.append("            <p><strong>Domicilio:</strong> " + domicilio + "</p>\n");
        }
    |   'telefono' ':' STRING
        {
            String telefono = $STRING.text;
            telefono = telefono.substring(1, telefono.length()-1);
            html.append("            <p><strong>Teléfono:</strong> " + telefono + "</p>\n");
        }
    |   'email' ':' STRING
        {
            String email = $STRING.text;
            email = email.substring(1, email.length()-1);
            html.append("            <p><strong>Email:</strong> " + email + "</p>\n");
        }
    ;

// TOKENS (ANTLR 3 syntax)
STRING  :   '"' ( ~('"'|'\r'|'\n') )* '"' ;
ID      :   ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'.')* ;
WS      :   (' '|'\t'|'\r'|'\n')+ { $channel = HIDDEN; } ;
COMMENT :   '//' (~('\r'|'\n'))* { $channel = HIDDEN; } ;
