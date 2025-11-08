# Ejercicio 10: Compilador de Lenguaje Web CRUD

**Proyecto:** Generador de aplicación local web CRUD basado en gramática  
**Asignatura:** Lenguajes y Autómatas II  
**Tecnología:** ANTLR 3.5.2  
**Fecha:** Octubre 2025

---

## 📋 Descripción del Proyecto

Este proyecto implementa un **compilador de lenguaje de alto nivel** que genera páginas web con funcionalidad CRUD (Create, Read, Update, Delete). El compilador traduce un lenguaje declarativo simple a HTML, CSS y especificaciones para implementación PHP.

### Características principales:
- ✅ Gramática completa en ANTLR 3.5.2
- ✅ Generación automática de HTML5 + CSS3
- ✅ Especificación de base de datos y tablas para CRUD
- ✅ IDE gráfico con editor y visualización de resultados
- ✅ Validación sintáctica del código fuente

---

## 🎯 Componentes del Lenguaje

El lenguaje soporta los siguientes elementos:

### 1. **Estructura de Página**
```
Inicio pagina
    [elementos...]
fin pagina
```

### 2. **Líneas divisorias**
```
linea simple    // Genera <hr>
linea doble     // Genera <hr> con estilo doble
```

### 3. **Títulos**
```
titulo "Texto del título"    // Genera <h1>
```

### 4. **Menú de navegación**
```
menu opciones    // Genera menú con opciones predefinidas
```

### 5. **Sección de Imágenes**
```
seccion imagenes
    logo.jpg
    banner.png
    foto.jpg
```

### 6. **Texto**
```
texto "Este es un párrafo que aparecerá en la página"
```

### 7. **Sección CRUD** (Principal)
```
crud inicio
    bdd NombreBaseDatos
    tabla NombreTabla
        campo Campo1
        campo Campo2
        campo Campo3
    fintabla
crud fin
```

### 8. **Sección Acerca De**
```
seccion acercade
    domicilio: "Dirección completa"
    telefono: "Número de teléfono"
    email: "correo@ejemplo.com"
```

---

## 📂 Estructura de Archivos

```
ejercico10/
│
├── WebPageLanguage.g           # Gramática ANTLR 3.5.2
├── WebPageLanguageLexer.java   # Lexer generado
├── WebPageLanguageParser.java  # Parser generado
├── WebPageLanguage.tokens      # Tokens generados
│
├── test.java                   # Compilador por consola
├── AnalizadorGUI.java          # IDE gráfico (Swing)
│
├── codigo_prueba.txt           # Archivo de ejemplo
├── IniciarGUI.bat              # Script para ejecutar la GUI
│
├── salida.html                 # HTML generado (después de compilar)
├── salida.css                  # CSS generado
└── salida_crud.txt             # Especificación CRUD
```

---

## 🚀 Instrucciones de Uso

### **Opción 1: Ejecutar la GUI (Recomendado)**

1. **Doble clic en `IniciarGUI.bat`**
   - Se abrirá la interfaz gráfica del compilador

2. **En la GUI:**
   - **Escribir o cargar código** en el panel izquierdo
   - **Presionar "Compilar"** para procesar el código
   - **Ver resultados** en las pestañas:
     - 📋 Consola: Mensajes de compilación
     - 🌐 HTML: Código HTML generado
     - 🎨 CSS: Estilos CSS generados
     - 💾 CRUD Spec: Especificación de base de datos
   - **Presionar "Ver en Navegador"** para abrir el HTML en el navegador

3. **Botones disponibles:**
   - `Abrir Archivo`: Cargar un archivo .txt con código fuente
   - `Guardar Archivo`: Guardar el código actual
   - `Compilar`: Generar HTML, CSS y especificación CRUD
   - `Limpiar`: Limpiar todos los campos
   - `Ver en Navegador`: Abrir el HTML generado

### **Opción 2: Compilar por consola**

```powershell
# Compilar un archivo específico
java -cp "..\ANTLR\antlr-3.5.2-complete.jar;." test codigo_prueba.txt salida

# Esto generará:
#   - salida.html
#   - salida.css
#   - salida_crud.txt
```

### **Opción 3: Regenerar el compilador (si modificas la gramática)**

```powershell
# 1. Compilar gramática
java -jar "..\ANTLR\antlr-3.5.2-complete.jar" WebPageLanguage.g

# 2. Compilar clases Java
javac -cp "..\ANTLR\antlr-3.5.2-complete.jar;." WebPageLanguageLexer.java WebPageLanguageParser.java test.java

# 3. Compilar GUI
javac -cp "..\ANTLR\antlr-3.5.2-complete.jar;." AnalizadorGUI.java
```

---

## 📝 Ejemplo de Código

```
Inicio pagina
    linea simple
    titulo "Página de Reportes de Ahorro"
    linea simple
    menu opciones
    seccion imagenes
        logocorporativo.jpg
        lema.jpg
        marca.jpg
    texto "Bienvenidos a nuestro sistema de gestión empresarial. Aquí podrá administrar todos los productos de su empresa de manera eficiente."
    crud inicio
        bdd Empresa
        tabla Productos
            campo Nombre
            campo Precio
            campo Clave
            campo Descripcion
            campo Stock
        fintabla
    crud fin
    texto "Gracias por utilizar nuestro sistema. Para más información, consulte la sección de contacto."
    seccion acercade
        domicilio: "Av Heroes de Nocupétaro 1234"
        telefono: "4431234567"
        email: "contacto@empresa.com"
fin pagina
```

---

## 🎨 Salida Generada

### **HTML (salida.html)**
- Página HTML5 completa
- Estructura semántica
- Responsive (viewport meta tag)
- Vinculado al CSS externo

### **CSS (salida.css)**
- Estilos modernos y limpios
- Diseño responsivo
- Menú de navegación estilizado
- Galería de imágenes con flexbox
- Secciones bien diferenciadas

### **CRUD Spec (salida_crud.txt)**
```
=== ESPECIFICACIÓN CRUD ===

Base de Datos: Empresa
Tabla: Productos
Campos:
  - Nombre
  - Precio
  - Clave
  - Descripcion
  - Stock

Operaciones requeridas:
  - CREATE (Insertar)
  - READ (Consultar)
  - UPDATE (Actualizar)
  - DELETE (Eliminar)
```

---

## 🔧 Requisitos

- ✅ Java JDK 8 o superior
- ✅ ANTLR 3.5.2 (incluido en `../ANTLR/antlr-3.5.2-complete.jar`)
- ✅ Sistema operativo: Windows, Linux o macOS
- ✅ Navegador web moderno (para visualizar resultados)

---

## 📚 Conceptos Aplicados

### **Lenguajes y Autómatas:**
- Diseño de gramáticas libres de contexto
- Análisis léxico (tokenización)
- Análisis sintáctico (parsing)
- Acciones semánticas embebidas

### **Compilación:**
- Traducción de lenguaje de alto nivel a HTML/CSS
- Generación de código intermedio (especificación CRUD)
- Validación sintáctica

### **Ingeniería de Software:**
- Separación de responsabilidades (Lexer, Parser, Generador)
- Interfaz gráfica de usuario (Swing)
- Manejo de errores y excepciones

---

## 🎓 Notas para el Proyecto

### **Unidad 2 (Actual):**
✅ Gramática completa  
✅ Generación de HTML/CSS  
✅ IDE funcional  
✅ Especificación CRUD (archivo .txt)  

### **Unidad 4 (Futuro):**
🔜 Implementación del CRUD en PHP  
🔜 Conexión a base de datos MySQL  
🔜 Operaciones Create, Read, Update, Delete  

---

## 🎯 Personalización

Puedes extender el lenguaje agregando:

### **En la gramática (`WebPageLanguage.g`):**
- Nuevos elementos (formularios, tablas, etc.)
- Más estilos CSS personalizados
- Validación de datos
- Tipos de campo (int, varchar, date)

### **Ejemplo de extensión:**
```antlr
formulario
    :   'formulario' ID
        { html.append("<form id=\"" + $ID.text + "\">\n"); }
        (campoFormulario)+
        { html.append("</form>\n"); }
    ;

campoFormulario
    :   'input' tipo ID STRING
        { /* Generar input HTML */ }
    ;
```

---

## 🐛 Solución de Problemas

### **Error: "Cannot find symbol WebPageLanguageLexer"**
- Asegúrate de haber compilado la gramática primero
- Verifica que los archivos `.java` generados existan

### **Error de codificación (tildes incorrectas)**
- El archivo debe guardarse en UTF-8
- Alternativamente, usa `\u00XX` para caracteres especiales

### **La GUI no abre**
- Verifica que Java esté instalado: `java -version`
- Asegúrate de tener permisos de ejecución

---

## 👥 Equipo de Desarrollo

Este proyecto puede ser desarrollado en equipos de **máximo 3 estudiantes**.

### **División de trabajo sugerida:**
1. **Diseño de gramática** y casos de prueba
2. **Implementación de GUI** y manejo de archivos
3. **Generación de HTML/CSS** y documentación

---

## 📅 Cronograma

- ✅ **Unidad 2:** Diseño e implementación del compilador
- 🔜 **Unidad 4:** Implementación del backend PHP + CRUD

---

## 📖 Referencias

- **ANTLR 3.5.2 Documentation:** [https://www.antlr3.org/](https://www.antlr3.org/)
- **HTML5 Specification:** [https://html.spec.whatwg.org/](https://html.spec.whatwg.org/)
- **CSS3 Reference:** [https://developer.mozilla.org/es/docs/Web/CSS](https://developer.mozilla.org/es/docs/Web/CSS)

---

## 📞 Soporte

Para dudas o problemas, consulta con tu profesor de **Lenguajes y Autómatas II**.

---

**¡Éxito con tu proyecto! 🚀**
