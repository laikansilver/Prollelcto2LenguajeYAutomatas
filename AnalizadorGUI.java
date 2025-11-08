import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import org.antlr.runtime.*;

public class AnalizadorGUI extends JFrame {
    private JTextArea areaCodigoFuente;
    private JTextArea areaResultados;
    private JTextArea areaHTML;
    private JTextArea areaCSS;
    private JTextArea areaCRUD;
    private JButton btnCompilar;
    private JButton btnLimpiar;
    private JButton btnAbrir;
    private JButton btnGuardar;
    private JButton btnVerHTML;
    private JTabbedPane tabbedPane;
    private String ultimoArchivo = "codigo_prueba.txt";
    
    public AnalizadorGUI() {
        setTitle("Compilador de Lenguaje Web CRUD - Ejercicio 10");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        cargarEjemplo();
    }
    
    private void initComponents() {
        // Panel principal con BorderLayout
        setLayout(new BorderLayout(10, 10));
        
        // ===== PANEL SUPERIOR: Título y botones =====
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBorder(new EmptyBorder(10, 10, 5, 10));
        
        JLabel lblTitulo = new JLabel("Compilador de Lenguaje Web CRUD", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(41, 128, 185));
        panelSuperior.add(lblTitulo, BorderLayout.NORTH);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        btnAbrir = new JButton("Abrir Archivo");
        btnAbrir.setIcon(UIManager.getIcon("FileView.directoryIcon"));
        btnAbrir.addActionListener(e -> abrirArchivo());
        
        btnGuardar = new JButton("Guardar Archivo");
        btnGuardar.setIcon(UIManager.getIcon("FileView.floppyDriveIcon"));
        btnGuardar.addActionListener(e -> guardarArchivo());
        
        btnCompilar = new JButton("Compilar");
        btnCompilar.setIcon(UIManager.getIcon("OptionPane.okIcon"));
        btnCompilar.setBackground(new Color(46, 204, 113));
        btnCompilar.setForeground(Color.WHITE);
        btnCompilar.setFocusPainted(false);
        btnCompilar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCompilar.addActionListener(e -> compilar());
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setIcon(UIManager.getIcon("FileView.fileIcon"));
        btnLimpiar.addActionListener(e -> limpiar());
        
        btnVerHTML = new JButton("Ver en Navegador");
        btnVerHTML.setIcon(UIManager.getIcon("FileView.computerIcon"));
        btnVerHTML.setBackground(new Color(52, 152, 219));
        btnVerHTML.setForeground(Color.WHITE);
        btnVerHTML.setFocusPainted(false);
        btnVerHTML.addActionListener(e -> abrirEnNavegador());
        
        panelBotones.add(btnAbrir);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCompilar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnVerHTML);
        
        panelSuperior.add(panelBotones, BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.NORTH);
        
        // ===== PANEL CENTRAL: Split con código fuente y resultados =====
        JSplitPane splitPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPrincipal.setDividerLocation(550);
        splitPrincipal.setResizeWeight(0.5);
        
        // Panel izquierdo: Código fuente
        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setBorder(new EmptyBorder(5, 10, 10, 5));
        
        JLabel lblCodigoFuente = new JLabel("Código Fuente (Lenguaje Web CRUD)");
        lblCodigoFuente.setFont(new Font("Arial", Font.BOLD, 14));
        panelIzquierdo.add(lblCodigoFuente, BorderLayout.NORTH);
        
        areaCodigoFuente = new JTextArea();
        areaCodigoFuente.setFont(new Font("Consolas", Font.PLAIN, 13));
        areaCodigoFuente.setTabSize(4);
        areaCodigoFuente.setLineWrap(true);
        areaCodigoFuente.setWrapStyleWord(true);
        JScrollPane scrollCodigo = new JScrollPane(areaCodigoFuente);
        scrollCodigo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelIzquierdo.add(scrollCodigo, BorderLayout.CENTER);
        
        splitPrincipal.setLeftComponent(panelIzquierdo);
        
        // Panel derecho: Tabs con resultados
        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBorder(new EmptyBorder(5, 5, 10, 10));
        
        JLabel lblResultados = new JLabel("Resultados de la Compilación");
        lblResultados.setFont(new Font("Arial", Font.BOLD, 14));
        panelDerecho.add(lblResultados, BorderLayout.NORTH);
        
        tabbedPane = new JTabbedPane();
        
        // Tab 1: Resultados de compilación
        areaResultados = new JTextArea();
        areaResultados.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaResultados.setEditable(false);
        areaResultados.setBackground(new Color(250, 250, 250));
        JScrollPane scrollResultados = new JScrollPane(areaResultados);
        tabbedPane.addTab("📋 Consola", scrollResultados);
        
        // Tab 2: HTML generado
        areaHTML = new JTextArea();
        areaHTML.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaHTML.setEditable(false);
        areaHTML.setBackground(new Color(250, 250, 250));
        JScrollPane scrollHTML = new JScrollPane(areaHTML);
        tabbedPane.addTab("🌐 HTML", scrollHTML);
        
        // Tab 3: CSS generado
        areaCSS = new JTextArea();
        areaCSS.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaCSS.setEditable(false);
        areaCSS.setBackground(new Color(250, 250, 250));
        JScrollPane scrollCSS = new JScrollPane(areaCSS);
        tabbedPane.addTab("🎨 CSS", scrollCSS);
        
        // Tab 4: Especificación CRUD
        areaCRUD = new JTextArea();
        areaCRUD.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaCRUD.setEditable(false);
        areaCRUD.setBackground(new Color(250, 250, 250));
        JScrollPane scrollCRUD = new JScrollPane(areaCRUD);
        tabbedPane.addTab("💾 CRUD Spec", scrollCRUD);
        
        panelDerecho.add(tabbedPane, BorderLayout.CENTER);
        splitPrincipal.setRightComponent(panelDerecho);
        
        add(splitPrincipal, BorderLayout.CENTER);
        
        // Panel inferior: Información
        JPanel panelInferior = new JPanel();
        panelInferior.setBorder(new EmptyBorder(5, 10, 10, 10));
        JLabel lblInfo = new JLabel("Ejercicio 10 - Compilador Web CRUD | ANTLR 3.5.2 | Lenguajes y Autómatas II");
        lblInfo.setFont(new Font("Arial", Font.ITALIC, 11));
        lblInfo.setForeground(Color.GRAY);
        panelInferior.add(lblInfo);
        add(panelInferior, BorderLayout.SOUTH);
    }
    
    private void cargarEjemplo() {
        String ejemplo = "Inicio pagina\n" +
                        "    linea simple\n" +
                        "    titulo \"Página de reportes de ahorro\"\n" +
                        "    linea simple\n" +
                        "    menu opciones\n" +
                        "    seccion imagenes\n" +
                        "        logocorporativo.jpg\n" +
                        "        lema.jpg\n" +
                        "        marca.jpg\n" +
                        "    texto \"Bienvenidos a nuestro sistema de gestión empresarial.\"\n" +
                        "    crud inicio\n" +
                        "        bdd Empresa\n" +
                        "        tabla Productos\n" +
                        "            campo Nombre\n" +
                        "            campo Precio\n" +
                        "            campo Clave\n" +
                        "        fintabla\n" +
                        "    crud fin\n" +
                        "    seccion acercade\n" +
                        "        domicilio: \"Av Heroes de Nocupétaro 1234\"\n" +
                        "        telefono: \"4431234567\"\n" +
                        "fin pagina\n";
        areaCodigoFuente.setText(ejemplo);
    }
    
    private void compilar() {
        try {
            btnCompilar.setEnabled(false);
            areaResultados.setText("=== Iniciando compilación ===\n\n");
            
            // Guardar código en archivo temporal
            String codigoFuente = areaCodigoFuente.getText();
            FileWriter fw = new FileWriter("temp_codigo.txt");
            fw.write(codigoFuente);
            fw.close();
            
            // Crear el flujo de entrada
            CharStream input = new ANTLRFileStream("temp_codigo.txt");
            
            // Crear el lexer
            WebPageLanguageLexer lexer = new WebPageLanguageLexer(input);
            
            // Crear el flujo de tokens
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            // Crear el parser
            WebPageLanguageParser parser = new WebPageLanguageParser(tokens);
            
            // Analizar el programa
            areaResultados.append("✓ Analizando código fuente...\n");
            parser.pagina();
            
            // Verificar errores
            if (parser.getNumberOfSyntaxErrors() == 0) {
                areaResultados.append("✓ Análisis sintáctico completado sin errores\n\n");
                
                // Generar archivos
                parser.guardarArchivos("salida");
                
                // Mostrar HTML generado
                areaHTML.setText(leerArchivo("salida.html"));
                
                // Mostrar CSS generado
                areaCSS.setText(leerArchivo("salida.css"));
                
                // Mostrar especificación CRUD
                String crudContent = leerArchivo("salida_crud.txt");
                areaCRUD.setText(crudContent.isEmpty() ? "No se generó especificación CRUD" : crudContent);
                
                areaResultados.append("=== ¡COMPILACIÓN EXITOSA! ===\n\n");
                areaResultados.append("Archivos generados:\n");
                areaResultados.append("  • salida.html\n");
                areaResultados.append("  • salida.css\n");
                areaResultados.append("  • salida_crud.txt\n\n");
                areaResultados.append("Puedes ver el HTML generado en la pestaña correspondiente.\n");
                
                tabbedPane.setSelectedIndex(1); // Cambiar a tab HTML
                
                JOptionPane.showMessageDialog(this,
                    "Compilación exitosa!\n\nArchivos generados correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
                    
            } else {
                areaResultados.append("\n✗ ERROR: Se encontraron " + parser.getNumberOfSyntaxErrors() + 
                                    " error(es) de sintaxis\n");
                JOptionPane.showMessageDialog(this,
                    "Se encontraron errores de sintaxis.\nRevise la consola para más detalles.",
                    "Error de compilación",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception ex) {
            areaResultados.append("\n✗ ERROR: " + ex.getMessage() + "\n");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Error durante la compilación:\n" + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            btnCompilar.setEnabled(true);
        }
    }
    
    private String leerArchivo(String nombreArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            StringBuilder sb = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            return "";
        }
    }
    
    private void limpiar() {
        areaCodigoFuente.setText("");
        areaResultados.setText("");
        areaHTML.setText("");
        areaCSS.setText("");
        areaCRUD.setText("");
    }
    
    private void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setDialogTitle("Abrir archivo de código");
        int result = fileChooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = fileChooser.getSelectedFile();
                ultimoArchivo = archivo.getAbsolutePath();
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                StringBuilder sb = new StringBuilder();
                String linea;
                while ((linea = br.readLine()) != null) {
                    sb.append(linea).append("\n");
                }
                br.close();
                areaCodigoFuente.setText(sb.toString());
                areaResultados.append("Archivo cargado: " + archivo.getName() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                    "Error al abrir el archivo:\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void guardarArchivo() {
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setDialogTitle("Guardar archivo de código");
        int result = fileChooser.showSaveDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = fileChooser.getSelectedFile();
                FileWriter fw = new FileWriter(archivo);
                fw.write(areaCodigoFuente.getText());
                fw.close();
                areaResultados.append("Archivo guardado: " + archivo.getName() + "\n");
                JOptionPane.showMessageDialog(this,
                    "Archivo guardado exitosamente.",
                    "Guardado",
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                    "Error al guardar el archivo:\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void abrirEnNavegador() {
        try {
            File htmlFile = new File("salida.html");
            if (!htmlFile.exists()) {
                JOptionPane.showMessageDialog(this,
                    "Primero debes compilar el código para generar el archivo HTML.",
                    "Archivo no encontrado",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(htmlFile.toURI());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Error al abrir el navegador:\n" + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            AnalizadorGUI gui = new AnalizadorGUI();
            gui.setVisible(true);
        });
    }
}
