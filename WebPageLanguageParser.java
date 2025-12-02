// $ANTLR 3.5.2 WebPageLanguage.g 2025-12-01 10:22:19

    import java.io.*;
    import java.util.List;
    import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class WebPageLanguageParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "STRING", "WS", 
		"':'", "'Inicio'", "'acercade'", "'bdd'", "'campo'", "'crud'", "'doble'", 
		"'domicilio'", "'email'", "'fin'", "'fintabla'", "'imagenes'", "'inicio'", 
		"'linea'", "'menu'", "'opciones'", "'pagina'", "'seccion'", "'simple'", 
		"'tabla'", "'telefono'", "'texto'", "'titulo'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int COMMENT=4;
	public static final int ID=5;
	public static final int STRING=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public WebPageLanguageParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public WebPageLanguageParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return WebPageLanguageParser.tokenNames; }
	@Override public String getGrammarFileName() { return "WebPageLanguage.g"; }


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



	// $ANTLR start "pagina"
	// WebPageLanguage.g:154:1: pagina : 'Inicio' 'pagina' ( elemento )+ 'fin' 'pagina' ;
	public final void pagina() throws RecognitionException {
		try {
			// WebPageLanguage.g:155:5: ( 'Inicio' 'pagina' ( elemento )+ 'fin' 'pagina' )
			// WebPageLanguage.g:155:9: 'Inicio' 'pagina' ( elemento )+ 'fin' 'pagina'
			{
			match(input,9,FOLLOW_9_in_pagina29); 
			match(input,24,FOLLOW_24_in_pagina31); 
			 
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
			        
			// WebPageLanguage.g:169:9: ( elemento )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==13||(LA1_0 >= 21 && LA1_0 <= 22)||LA1_0==25||(LA1_0 >= 29 && LA1_0 <= 30)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// WebPageLanguage.g:169:10: elemento
					{
					pushFollow(FOLLOW_elemento_in_pagina53);
					elemento();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input,17,FOLLOW_17_in_pagina65); 
			match(input,24,FOLLOW_24_in_pagina67); 

			            html.append("    </div>\n");
			            html.append("</body>\n");
			            html.append("</html>\n");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pagina"



	// $ANTLR start "elemento"
	// WebPageLanguage.g:178:1: elemento : ( linea | titulo | menu | seccionImagenes | texto | crud | seccionAcercaDe );
	public final void elemento() throws RecognitionException {
		try {
			// WebPageLanguage.g:179:5: ( linea | titulo | menu | seccionImagenes | texto | crud | seccionAcercaDe )
			int alt2=7;
			switch ( input.LA(1) ) {
			case 21:
				{
				alt2=1;
				}
				break;
			case 30:
				{
				alt2=2;
				}
				break;
			case 22:
				{
				alt2=3;
				}
				break;
			case 25:
				{
				int LA2_4 = input.LA(2);
				if ( (LA2_4==19) ) {
					alt2=4;
				}
				else if ( (LA2_4==10) ) {
					alt2=7;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 29:
				{
				alt2=5;
				}
				break;
			case 13:
				{
				alt2=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// WebPageLanguage.g:179:9: linea
					{
					pushFollow(FOLLOW_linea_in_elemento96);
					linea();
					state._fsp--;

					}
					break;
				case 2 :
					// WebPageLanguage.g:180:9: titulo
					{
					pushFollow(FOLLOW_titulo_in_elemento106);
					titulo();
					state._fsp--;

					}
					break;
				case 3 :
					// WebPageLanguage.g:181:9: menu
					{
					pushFollow(FOLLOW_menu_in_elemento116);
					menu();
					state._fsp--;

					}
					break;
				case 4 :
					// WebPageLanguage.g:182:9: seccionImagenes
					{
					pushFollow(FOLLOW_seccionImagenes_in_elemento126);
					seccionImagenes();
					state._fsp--;

					}
					break;
				case 5 :
					// WebPageLanguage.g:183:9: texto
					{
					pushFollow(FOLLOW_texto_in_elemento136);
					texto();
					state._fsp--;

					}
					break;
				case 6 :
					// WebPageLanguage.g:184:9: crud
					{
					pushFollow(FOLLOW_crud_in_elemento146);
					crud();
					state._fsp--;

					}
					break;
				case 7 :
					// WebPageLanguage.g:185:9: seccionAcercaDe
					{
					pushFollow(FOLLOW_seccionAcercaDe_in_elemento156);
					seccionAcercaDe();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "elemento"



	// $ANTLR start "linea"
	// WebPageLanguage.g:188:1: linea : ( 'linea' 'simple' | 'linea' 'doble' );
	public final void linea() throws RecognitionException {
		try {
			// WebPageLanguage.g:189:5: ( 'linea' 'simple' | 'linea' 'doble' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==21) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==26) ) {
					alt3=1;
				}
				else if ( (LA3_1==14) ) {
					alt3=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// WebPageLanguage.g:189:9: 'linea' 'simple'
					{
					match(input,21,FOLLOW_21_in_linea175); 
					match(input,26,FOLLOW_26_in_linea177); 

					            html.append("        <hr>\n");
					        
					}
					break;
				case 2 :
					// WebPageLanguage.g:193:9: 'linea' 'doble'
					{
					match(input,21,FOLLOW_21_in_linea197); 
					match(input,14,FOLLOW_14_in_linea199); 

					            html.append("        <hr style=\"border-top: 4px double #333;\">\n");
					        
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "linea"



	// $ANTLR start "titulo"
	// WebPageLanguage.g:199:1: titulo : 'titulo' STRING ;
	public final void titulo() throws RecognitionException {
		Token STRING1=null;

		try {
			// WebPageLanguage.g:200:5: ( 'titulo' STRING )
			// WebPageLanguage.g:200:9: 'titulo' STRING
			{
			match(input,30,FOLLOW_30_in_titulo228); 
			STRING1=(Token)match(input,STRING,FOLLOW_STRING_in_titulo230); 

			            String tituloTexto = (STRING1!=null?STRING1.getText():null);
			            tituloTexto = tituloTexto.substring(1, tituloTexto.length()-1); // Quitar comillas
			            html.append("        <h1>" + tituloTexto + "</h1>\n");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "titulo"



	// $ANTLR start "menu"
	// WebPageLanguage.g:208:1: menu : 'menu' 'opciones' ;
	public final void menu() throws RecognitionException {
		try {
			// WebPageLanguage.g:209:5: ( 'menu' 'opciones' )
			// WebPageLanguage.g:209:9: 'menu' 'opciones'
			{
			match(input,22,FOLLOW_22_in_menu259); 
			match(input,23,FOLLOW_23_in_menu261); 

			            html.append("        <nav class=\"menu\">\n");
			            html.append("            <ul>\n");
			            html.append("                <li><a href=\"#inicio\">Inicio</a></li>\n");
			            html.append("                <li><a href=\"#productos\">Productos</a></li>\n");
			            html.append("                <li><a href=\"#servicios\">Servicios</a></li>\n");
			            html.append("                <li><a href=\"#contacto\">Contacto</a></li>\n");
			            html.append("            </ul>\n");
			            html.append("        </nav>\n");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "menu"



	// $ANTLR start "seccionImagenes"
	// WebPageLanguage.g:222:1: seccionImagenes : 'seccion' 'imagenes' ( imagen )+ ;
	public final void seccionImagenes() throws RecognitionException {
		try {
			// WebPageLanguage.g:223:5: ( 'seccion' 'imagenes' ( imagen )+ )
			// WebPageLanguage.g:223:9: 'seccion' 'imagenes' ( imagen )+
			{
			match(input,25,FOLLOW_25_in_seccionImagenes291); 
			match(input,19,FOLLOW_19_in_seccionImagenes293); 

			            html.append("        <div class=\"imagenes\">\n");
			        
			// WebPageLanguage.g:227:9: ( imagen )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==ID) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// WebPageLanguage.g:227:10: imagen
					{
					pushFollow(FOLLOW_imagen_in_seccionImagenes315);
					imagen();
					state._fsp--;

					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}


			            html.append("        </div>\n");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "seccionImagenes"



	// $ANTLR start "imagen"
	// WebPageLanguage.g:233:1: imagen : ID ;
	public final void imagen() throws RecognitionException {
		Token ID2=null;

		try {
			// WebPageLanguage.g:234:5: ( ID )
			// WebPageLanguage.g:234:9: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_imagen346); 

			            String nombreImg = (ID2!=null?ID2.getText():null);
			            html.append("            <img src=\"" + nombreImg + "\" alt=\"Imagen\">\n");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "imagen"



	// $ANTLR start "texto"
	// WebPageLanguage.g:241:1: texto : 'texto' STRING ;
	public final void texto() throws RecognitionException {
		Token STRING3=null;

		try {
			// WebPageLanguage.g:242:5: ( 'texto' STRING )
			// WebPageLanguage.g:242:9: 'texto' STRING
			{
			match(input,29,FOLLOW_29_in_texto375); 
			STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_texto377); 

			            String textoContenido = (STRING3!=null?STRING3.getText():null);
			            textoContenido = textoContenido.substring(1, textoContenido.length()-1);
			            html.append("        <div class=\"texto\">\n");
			            html.append("            <p>" + textoContenido + "</p>\n");
			            html.append("        </div>\n");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "texto"



	// $ANTLR start "crud"
	// WebPageLanguage.g:252:1: crud : 'crud' 'inicio' bdd ( tabla )+ 'crud' 'fin' ;
	public final void crud() throws RecognitionException {
		try {
			// WebPageLanguage.g:253:5: ( 'crud' 'inicio' bdd ( tabla )+ 'crud' 'fin' )
			// WebPageLanguage.g:253:9: 'crud' 'inicio' bdd ( tabla )+ 'crud' 'fin'
			{
			match(input,13,FOLLOW_13_in_crud406); 
			match(input,20,FOLLOW_20_in_crud408); 

			            html.append("        <div class=\"crud-section\">\n");
			            html.append("            <h2>Sección CRUD</h2>\n");
			            html.append("            <p><em>Esta sección será implementada con PHP en la Unidad 4</em></p>\n");
			            campos.clear();
			        
			pushFollow(FOLLOW_bdd_in_crud428);
			bdd();
			state._fsp--;

			// WebPageLanguage.g:261:9: ( tabla )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==27) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// WebPageLanguage.g:261:10: tabla
					{
					pushFollow(FOLLOW_tabla_in_crud439);
					tabla();
					state._fsp--;

					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			match(input,13,FOLLOW_13_in_crud451); 
			match(input,17,FOLLOW_17_in_crud453); 

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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "crud"



	// $ANTLR start "bdd"
	// WebPageLanguage.g:282:1: bdd : 'bdd' ID ;
	public final void bdd() throws RecognitionException {
		Token ID4=null;

		try {
			// WebPageLanguage.g:283:5: ( 'bdd' ID )
			// WebPageLanguage.g:283:9: 'bdd' ID
			{
			match(input,11,FOLLOW_11_in_bdd482); 
			ID4=(Token)match(input,ID,FOLLOW_ID_in_bdd484); 

			            currentDatabase = (ID4!=null?ID4.getText():null);
			            html.append("            <p><strong>Base de Datos:</strong> " + currentDatabase + "</p>\n");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "bdd"



	// $ANTLR start "tabla"
	// WebPageLanguage.g:290:1: tabla : 'tabla' ID ( campo )+ 'fintabla' ;
	public final void tabla() throws RecognitionException {
		Token ID5=null;

		try {
			// WebPageLanguage.g:291:5: ( 'tabla' ID ( campo )+ 'fintabla' )
			// WebPageLanguage.g:291:9: 'tabla' ID ( campo )+ 'fintabla'
			{
			match(input,27,FOLLOW_27_in_tabla513); 
			ID5=(Token)match(input,ID,FOLLOW_ID_in_tabla515); 

			            currentTable = (ID5!=null?ID5.getText():null);
			            html.append("            <p><strong>Tabla:</strong> " + currentTable + "</p>\n");
			            html.append("            <p><strong>Campos:</strong></p>\n");
			            html.append("            <ul>\n");
			        
			// WebPageLanguage.g:298:9: ( campo )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==12) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// WebPageLanguage.g:298:10: campo
					{
					pushFollow(FOLLOW_campo_in_tabla536);
					campo();
					state._fsp--;

					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match(input,18,FOLLOW_18_in_tabla548); 

			            html.append("            </ul>\n");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "tabla"



	// $ANTLR start "campo"
	// WebPageLanguage.g:305:1: campo : 'campo' ID ;
	public final void campo() throws RecognitionException {
		Token ID6=null;

		try {
			// WebPageLanguage.g:306:5: ( 'campo' ID )
			// WebPageLanguage.g:306:9: 'campo' ID
			{
			match(input,12,FOLLOW_12_in_campo577); 
			ID6=(Token)match(input,ID,FOLLOW_ID_in_campo579); 

			            String nombreCampo = (ID6!=null?ID6.getText():null);
			            campos.add(nombreCampo);
			            html.append("                <li>" + nombreCampo + "</li>\n");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "campo"



	// $ANTLR start "seccionAcercaDe"
	// WebPageLanguage.g:314:1: seccionAcercaDe : 'seccion' 'acercade' ( infoAcercaDe )+ ;
	public final void seccionAcercaDe() throws RecognitionException {
		try {
			// WebPageLanguage.g:315:5: ( 'seccion' 'acercade' ( infoAcercaDe )+ )
			// WebPageLanguage.g:315:9: 'seccion' 'acercade' ( infoAcercaDe )+
			{
			match(input,25,FOLLOW_25_in_seccionAcercaDe608); 
			match(input,10,FOLLOW_10_in_seccionAcercaDe610); 

			            html.append("        <div class=\"acercade\">\n");
			            html.append("            <h2>Acerca de</h2>\n");
			        
			// WebPageLanguage.g:320:9: ( infoAcercaDe )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 15 && LA7_0 <= 16)||LA7_0==28) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// WebPageLanguage.g:320:10: infoAcercaDe
					{
					pushFollow(FOLLOW_infoAcercaDe_in_seccionAcercaDe631);
					infoAcercaDe();
					state._fsp--;

					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}


			            html.append("        </div>\n");
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "seccionAcercaDe"



	// $ANTLR start "infoAcercaDe"
	// WebPageLanguage.g:326:1: infoAcercaDe : ( 'domicilio' ':' STRING | 'telefono' ':' STRING | 'email' ':' STRING );
	public final void infoAcercaDe() throws RecognitionException {
		Token STRING7=null;
		Token STRING8=null;
		Token STRING9=null;

		try {
			// WebPageLanguage.g:327:5: ( 'domicilio' ':' STRING | 'telefono' ':' STRING | 'email' ':' STRING )
			int alt8=3;
			switch ( input.LA(1) ) {
			case 15:
				{
				alt8=1;
				}
				break;
			case 28:
				{
				alt8=2;
				}
				break;
			case 16:
				{
				alt8=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// WebPageLanguage.g:327:9: 'domicilio' ':' STRING
					{
					match(input,15,FOLLOW_15_in_infoAcercaDe662); 
					match(input,8,FOLLOW_8_in_infoAcercaDe664); 
					STRING7=(Token)match(input,STRING,FOLLOW_STRING_in_infoAcercaDe666); 

					            String domicilio = (STRING7!=null?STRING7.getText():null);
					            domicilio = domicilio.substring(1, domicilio.length()-1);
					            html.append("            <p><strong>Domicilio:</strong> " + domicilio + "</p>\n");
					        
					}
					break;
				case 2 :
					// WebPageLanguage.g:333:9: 'telefono' ':' STRING
					{
					match(input,28,FOLLOW_28_in_infoAcercaDe686); 
					match(input,8,FOLLOW_8_in_infoAcercaDe688); 
					STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_infoAcercaDe690); 

					            String telefono = (STRING8!=null?STRING8.getText():null);
					            telefono = telefono.substring(1, telefono.length()-1);
					            html.append("            <p><strong>Teléfono:</strong> " + telefono + "</p>\n");
					        
					}
					break;
				case 3 :
					// WebPageLanguage.g:339:9: 'email' ':' STRING
					{
					match(input,16,FOLLOW_16_in_infoAcercaDe710); 
					match(input,8,FOLLOW_8_in_infoAcercaDe712); 
					STRING9=(Token)match(input,STRING,FOLLOW_STRING_in_infoAcercaDe714); 

					            String email = (STRING9!=null?STRING9.getText():null);
					            email = email.substring(1, email.length()-1);
					            html.append("            <p><strong>Email:</strong> " + email + "</p>\n");
					        
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "infoAcercaDe"

	// Delegated rules



	public static final BitSet FOLLOW_9_in_pagina29 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_pagina31 = new BitSet(new long[]{0x0000000062602000L});
	public static final BitSet FOLLOW_elemento_in_pagina53 = new BitSet(new long[]{0x0000000062622000L});
	public static final BitSet FOLLOW_17_in_pagina65 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_pagina67 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_linea_in_elemento96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_titulo_in_elemento106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_menu_in_elemento116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_seccionImagenes_in_elemento126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_texto_in_elemento136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_crud_in_elemento146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_seccionAcercaDe_in_elemento156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_linea175 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_linea177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_linea197 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_linea199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_titulo228 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_STRING_in_titulo230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_menu259 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_menu261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_seccionImagenes291 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_seccionImagenes293 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_imagen_in_seccionImagenes315 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_ID_in_imagen346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_texto375 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_STRING_in_texto377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_crud406 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_crud408 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_bdd_in_crud428 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_tabla_in_crud439 = new BitSet(new long[]{0x0000000008002000L});
	public static final BitSet FOLLOW_13_in_crud451 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_crud453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_bdd482 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_bdd484 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_tabla513 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_tabla515 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_campo_in_tabla536 = new BitSet(new long[]{0x0000000000041000L});
	public static final BitSet FOLLOW_18_in_tabla548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_campo577 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_campo579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_seccionAcercaDe608 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_seccionAcercaDe610 = new BitSet(new long[]{0x0000000010018000L});
	public static final BitSet FOLLOW_infoAcercaDe_in_seccionAcercaDe631 = new BitSet(new long[]{0x0000000010018002L});
	public static final BitSet FOLLOW_15_in_infoAcercaDe662 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_infoAcercaDe664 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_STRING_in_infoAcercaDe666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_infoAcercaDe686 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_infoAcercaDe688 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_STRING_in_infoAcercaDe690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_infoAcercaDe710 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_infoAcercaDe712 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_STRING_in_infoAcercaDe714 = new BitSet(new long[]{0x0000000000000002L});
}
