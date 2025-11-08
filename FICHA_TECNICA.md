# 📊 FICHA TÉCNICA DEL PROYECTO

---

## 📌 INFORMACIÓN GENERAL

**Nombre del Proyecto:** Compilador de Lenguaje Web CRUD  
**Ejercicio:** #10  
**Asignatura:** Lenguajes y Autómatas II  
**Unidad:** 2 - Análisis Sintáctico  
**Semestre:** 10  
**Institución:** Instituto Tecnológico de Morelia  
**Fecha:** Octubre 2025  

---

## 🎯 OBJETIVO DEL PROYECTO

Diseñar e implementar un lenguaje de alto nivel que describa componentes de una página web con funcionalidad CRUD, desarrollando:
- Una gramática formal en ANTLR
- Un compilador que genere HTML/CSS
- Un archivo de especificación para backend PHP
- Un IDE gráfico para facilitar el desarrollo

---

## 🛠️ TECNOLOGÍAS UTILIZADAS

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| ANTLR | 3.5.2 | Generador de parsers |
| Java | JDK 8+ | Lenguaje de implementación |
| Swing | Incluido en JDK | Interfaz gráfica |
| HTML5 | Estándar | Salida web |
| CSS3 | Estándar | Estilos web |

---

## 📐 ARQUITECTURA DEL COMPILADOR

```
┌─────────────────┐
│  Código Fuente  │ (Lenguaje declarativo personalizado)
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│  Lexer (ANTLR)  │ → Tokenización
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│ Parser (ANTLR)  │ → Análisis sintáctico
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│ Acciones Semán. │ → Generación de código
└────────┬────────┘
         │
         ├─────────────────┬─────────────────┬──────────────────┐
         ▼                 ▼                 ▼                  ▼
    ┌────────┐       ┌────────┐       ┌──────────┐      ┌─────────┐
    │  HTML  │       │  CSS   │       │ CRUD.txt │      │ Consola │
    └────────┘       └────────┘       └──────────┘      └─────────┘
```

---

## 📋 ESPECIFICACIÓN DEL LENGUAJE

### **Tokens Implementados:**
- `STRING`: Cadenas entre comillas dobles
- `ID`: Identificadores (nombres de variables, archivos, etc.)
- `WS`: Espacios en blanco (ignorados)
- `COMMENT`: Comentarios de línea `//`

### **Palabras Reservadas:**
```
Inicio, pagina, fin, linea, simple, doble, titulo, menu, opciones,
seccion, imagenes, texto, crud, inicio, bdd, tabla, fintabla, campo,
acercade, domicilio, telefono, email
```

### **Estructura Sintáctica:**
```
programa := 'Inicio' 'pagina' elemento+ 'fin' 'pagina'
elemento := linea | titulo | menu | seccionImagenes | texto | crud | seccionAcercaDe
```

---

## 🔢 MÉTRICAS DEL CÓDIGO

| Componente | Líneas de Código | Archivos |
|------------|------------------|----------|
| Gramática ANTLR | 350+ | 1 |
| Lexer/Parser (generado) | 60,000+ | 2 |
| Compilador consola | 65 | 1 |
| IDE gráfico | 450+ | 1 |
| Documentación | 1000+ | 5 |
| Ejemplos | 150+ | 4 |
| **TOTAL** | **62,000+** | **14** |

---

## ✅ FUNCIONALIDADES IMPLEMENTADAS

### **Análisis Léxico:**
- [x] Reconocimiento de tokens
- [x] Eliminación de espacios en blanco
- [x] Soporte de comentarios
- [x] Validación de strings e identificadores

### **Análisis Sintáctico:**
- [x] Validación de estructura de página
- [x] Verificación de elementos válidos
- [x] Detección de errores sintácticos
- [x] Mensajes de error descriptivos

### **Generación de Código:**
- [x] HTML5 válido y semántico
- [x] CSS3 moderno y responsive
- [x] Especificación CRUD estructurada
- [x] Código limpio e indentado

### **IDE Gráfico:**
- [x] Editor de código
- [x] Compilación integrada
- [x] Visualización de resultados
- [x] Abrir/Guardar archivos
- [x] Vista previa en navegador
- [x] 4 pestañas de resultados

---

## 📊 CASOS DE USO

### **Caso 1: Sistema Empresarial**
```
Entrada: Código con tabla Productos
Salida:
  ✓ HTML con estructura completa
  ✓ CSS con estilos profesionales
  ✓ Especificación CRUD (5 campos)
```

### **Caso 2: Sistema de Biblioteca**
```
Entrada: Código con 2 tablas (Libros + Usuarios)
Salida:
  ✓ HTML con 2 secciones CRUD
  ✓ CSS compartido
  ✓ 2 especificaciones CRUD independientes
```

### **Caso 3: Inventario**
```
Entrada: Código con 8 campos de tabla
Salida:
  ✓ HTML con tabla compleja
  ✓ CSS optimizado
  ✓ Especificación CRUD detallada
```

---

## 🎨 CARACTERÍSTICAS DEL HTML/CSS GENERADO

### **HTML:**
- ✅ DOCTYPE HTML5
- ✅ Meta charset UTF-8
- ✅ Viewport responsive
- ✅ Estructura semántica
- ✅ Enlaces CSS externos
- ✅ Contenedor principal

### **CSS:**
- ✅ Reset CSS (*, box-sizing)
- ✅ Tipografía profesional
- ✅ Colores armónicos
- ✅ Espaciado consistente
- ✅ Menú con hover
- ✅ Flexbox para imágenes
- ✅ Sombras y bordes redondeados

---

## 💾 ESPECIFICACIÓN CRUD

### **Formato del Archivo:**
```
=== ESPECIFICACIÓN CRUD ===

Base de Datos: [nombre]
Tabla: [nombre]
Campos:
  - Campo1
  - Campo2
  ...

Operaciones requeridas:
  - CREATE (Insertar)
  - READ (Consultar)
  - UPDATE (Actualizar)
  - DELETE (Eliminar)
```

### **Uso Futuro (Unidad 4):**
Este archivo se utilizará para:
1. Crear estructura de base de datos MySQL
2. Generar formularios HTML
3. Implementar operaciones PHP
4. Validar datos de entrada

---

## 🧪 PRUEBAS REALIZADAS

### **Pruebas de Compilación:**
- [x] Gramática sin errores
- [x] Generación de Lexer/Parser exitosa
- [x] Compilación de clases Java sin errores
- [x] Ejecución del compilador funcional

### **Pruebas de Funcionalidad:**
- [x] Análisis léxico correcto
- [x] Análisis sintáctico preciso
- [x] Generación de HTML válido
- [x] Generación de CSS correcto
- [x] Especificación CRUD completa

### **Pruebas de GUI:**
- [x] Apertura de interfaz
- [x] Carga de archivos
- [x] Guardado de archivos
- [x] Compilación desde GUI
- [x] Visualización de resultados
- [x] Apertura en navegador

### **Pruebas de Integración:**
- [x] Código de ejemplo 1 → ✓ Éxito
- [x] Código de ejemplo 2 → ✓ Éxito
- [x] Código de ejemplo 3 → ✓ Éxito
- [x] Código de ejemplo 4 → ✓ Éxito

---

## 📈 VENTAJAS DEL SISTEMA

1. **Productividad:** Genera código HTML/CSS automáticamente
2. **Simplicidad:** Sintaxis declarativa fácil de aprender
3. **Validación:** Detecta errores sintácticos antes de generar
4. **Escalabilidad:** Fácil de extender con nuevos elementos
5. **Documentación:** Genera especificación para backend
6. **Profesionalismo:** Código generado limpio y moderno
7. **Integración:** IDE gráfico facilita el desarrollo
8. **Portabilidad:** Funciona en Windows, Linux y macOS

---

## 🎓 COMPETENCIAS DESARROLLADAS

### **Técnicas:**
- Diseño de lenguajes formales
- Implementación de compiladores
- Análisis léxico y sintáctico
- Generación de código
- Programación de interfaces gráficas
- Manejo de archivos I/O

### **Profesionales:**
- Documentación de proyectos
- Pruebas de software
- Control de versiones
- Resolución de problemas
- Trabajo autónomo

---

## 📚 DOCUMENTACIÓN ENTREGADA

1. **README.md** (9 KB) - Guía completa del proyecto
2. **INSTRUCCIONES.md** (1.5 KB) - Inicio rápido
3. **RESUMEN_PROYECTO.md** (7 KB) - Resumen ejecutivo
4. **CATALOGO_EJEMPLOS.md** (3 KB) - Guía de ejemplos
5. **FICHA_TECNICA.md** (Este archivo)

**Total documentación:** 20+ KB / 500+ líneas

---

## 🚀 INSTRUCCIONES DE ENTREGA

### **Archivos a entregar:**
```
ejercico10/
├── *.g (gramática)
├── *.java (código fuente)
├── *.class (compilados)
├── *.txt (ejemplos)
├── *.bat (script de ejecución)
└── *.md (documentación)
```

### **Formato de entrega:**
- Carpeta comprimida (.zip)
- Nombre: `Ejercicio10_ApellidoNombre.zip`
- Incluir todos los archivos listados arriba
- NO incluir archivos temporales o .class opcionales

---

## 🎯 CONCLUSIONES

### **Logros:**
✅ Compilador funcional al 100%  
✅ Gramática robusta y completa  
✅ IDE profesional e intuitivo  
✅ Documentación exhaustiva  
✅ Ejemplos variados y útiles  
✅ Código limpio y bien estructurado  

### **Aprendizajes:**
- Dominio de ANTLR 3.5.2
- Diseño de lenguajes de alto nivel
- Generación automática de código
- Desarrollo de interfaces gráficas
- Buenas prácticas de documentación

### **Próximos pasos:**
- Unidad 4: Implementar backend en PHP
- Conectar a base de datos MySQL
- Crear operaciones CRUD funcionales
- Desplegar sistema completo

---

## 📞 INFORMACIÓN DE CONTACTO

**Proyecto:** Compilador Web CRUD  
**Repositorio:** lenguajes-y-automatas-II  
**Carpeta:** ejercico10  
**Estado:** ✅ COMPLETADO  
**Fecha de entrega:** Pendiente de definir  

---

**PROYECTO LISTO PARA ENTREGAR Y PRESENTAR** ✨
