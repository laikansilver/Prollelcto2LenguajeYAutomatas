# 📋 Caso de Prueba Completo - WebPageLanguage

## 🎯 Objetivo
Este caso de prueba demuestra **todas las funcionalidades** implementadas en la gramática `WebPageLanguage.g`, generando un sistema web completo con múltiples componentes HTML/CSS.

## 📂 Archivos
- **Entrada:** `caso_prueba_completo.txt`
- **Salida:** 
  - `prueba_completa.html` - Página web generada
  - `prueba_completa.css` - Estilos (copiado de pagina.css)
  - `prueba_completa_crud.txt` - Especificaciones CRUD

## 🔧 Funcionalidades Probadas

### 1️⃣ **Título (`titulo`)**
```
titulo "Sistema de Gestión Escolar - Demostración Completa"
```
- ✅ Genera un `<h1>` con el texto especificado
- ✅ Centrado y estilizado según el CSS

### 2️⃣ **Líneas Separadoras (`linea`)**
```
linea simple    → <hr>
linea doble     → <hr style="border-top: 4px double #333;">
```
- ✅ `linea simple`: línea horizontal sencilla
- ✅ `linea doble`: línea horizontal doble más gruesa

### 3️⃣ **Menú de Navegación (`menu opciones`)**
```
menu opciones
```
- ✅ Genera navegación con enlaces: Inicio, Productos, Servicios, Contacto
- ✅ Estilo con fondo oscuro y links blancos
- ✅ Hover interactivo

### 4️⃣ **Texto Descriptivo (`texto`)**
```
texto "Bienvenido al sistema integral..."
```
- ✅ Genera bloques de texto en `<div class="texto">`
- ✅ Fondo gris claro con borde izquierdo de acento
- ✅ Múltiples bloques de texto en diferentes secciones

### 5️⃣ **Galería de Imágenes (`seccion imagenes`)**
```
seccion imagenes
    estudiante1.jpg
    estudiante2.jpg
    estudiante3.jpg
    laboratorio.jpg
    biblioteca.jpg
```
- ✅ Genera contenedor flexbox `.imagenes`
- ✅ Cada imagen con `<img>` individual
- ✅ Responsive con `flex-wrap`
- ✅ Sombras y bordes redondeados

### 6️⃣ **Sistema CRUD - Estudiantes (`crud`)**
```
crud inicio
    bdd estudiantes_db
    tabla Estudiantes
    campo matricula
    campo nombre
    campo apellido
    campo carrera
    campo semestre
    campo promedio
    campo correo
    campo telefono_contacto
    fintabla
crud fin
```
- ✅ Genera sección visual con información de BD y tabla
- ✅ Lista de campos en formato `<ul><li>`
- ✅ Genera especificación CRUD en archivo separado
- ✅ Documenta operaciones: CREATE, READ, UPDATE, DELETE

### 7️⃣ **Sistema CRUD - Profesores**
```
crud inicio
    bdd profesores_db
    tabla Profesores
    campo id_profesor
    campo nombre_completo
    campo especialidad
    campo departamento
    campo antiguedad
    fintabla
crud fin
```
- ✅ Segundo módulo CRUD independiente
- ✅ Base de datos y tabla diferentes
- ✅ Especificación acumulada en archivo _crud.txt

### 8️⃣ **Sección Acerca De (`seccion acercade`)**
```
seccion acercade
    domicilio : "Avenida Tecnológico 1500..."
    telefono : "443-312-1570"
    email : "contacto@tecnm-morelia.edu.mx"
```
- ✅ Genera sección informativa con fondo gris
- ✅ Tres tipos de información soportados: domicilio, telefono, email
- ✅ Formato con etiquetas en negrita

## 📊 Resultado HTML Generado

El archivo HTML contiene la siguiente estructura:

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="pagina.css">
</head>
<body>
    <div class="container">
        <!-- Título principal -->
        <h1>Sistema de Gestión Escolar...</h1>
        
        <!-- Línea separadora -->
        <hr>
        
        <!-- Menú de navegación -->
        <nav class="menu">...</nav>
        
        <!-- Línea doble -->
        <hr style="...">
        
        <!-- Texto descriptivo -->
        <div class="texto"><p>...</p></div>
        
        <!-- Galería de imágenes -->
        <div class="imagenes">
            <img src="estudiante1.jpg">
            ...
        </div>
        
        <!-- CRUD Estudiantes -->
        <div class="crud-section">
            <h2>Sección CRUD</h2>
            <p><strong>Base de Datos:</strong> estudiantes_db</p>
            <p><strong>Tabla:</strong> Estudiantes</p>
            <ul>
                <li>matricula</li>
                ...
            </ul>
        </div>
        
        <!-- CRUD Profesores -->
        <div class="crud-section">...</div>
        
        <!-- Sección Acerca De -->
        <div class="acercade">
            <h2>Acerca de</h2>
            <p><strong>Domicilio:</strong> ...</p>
            <p><strong>Teléfono:</strong> ...</p>
            <p><strong>Email:</strong> ...</p>
        </div>
        
        <!-- Texto final -->
        <div class="texto">...</div>
    </div>
</body>
</html>
```

## 📄 Especificación CRUD Generada

El archivo `prueba_completa_crud.txt` contiene dos especificaciones:

**Módulo 1: Estudiantes**
- Base de Datos: `estudiantes_db`
- Tabla: `Estudiantes`
- 8 campos definidos
- Operaciones CRUD completas

**Módulo 2: Profesores**
- Base de Datos: `profesores_db`
- Tabla: `Profesores`
- 5 campos definidos
- Operaciones CRUD completas

## 🚀 Cómo Ejecutar

```powershell
# Compilar si es necesario
javac -encoding UTF-8 -cp ".;C:\ANTLR\antlr-3.5.2-complete.jar" *.java

# Ejecutar el caso de prueba
java -cp ".;C:\ANTLR\antlr-3.5.2-complete.jar" test caso_prueba_completo.txt prueba_completa

# Abrir en navegador
start prueba_completa.html
```

## ✅ Validación

**Resultado esperado:**
```
? Análisis sintáctico completado sin errores

Archivos generados exitosamente:
- prueba_completa.html
- prueba_completa.css
- prueba_completa_crud.txt

? Compilación exitosa!
```

## 📝 Notas Importantes

1. **Sintaxis CRUD:** Siempre requiere `fintabla` después de los campos
2. **Sintaxis Acerca De:** Solo acepta `domicilio`, `telefono` y `email` (no otros campos como `horario`)
3. **Nombres de archivos:** Las imágenes deben ser nombres simples (sin `https://` o caracteres especiales en el token ID)
4. **Múltiples CRUD:** Se pueden definir múltiples secciones CRUD, todas se acumulan en el archivo _crud.txt

## 🎨 Características Visuales

- **Layout responsive** con max-width de 1200px
- **Flexbox** para galería de imágenes
- **Sombras y bordes redondeados** en imágenes
- **Menú interactivo** con hover effects
- **Separadores visuales** (líneas simples y dobles)
- **Secciones CRUD** con bordes y padding
- **Sección informativa** con fondo distintivo

## 🔮 Uso Futuro

Este caso de prueba sirve como:
- ✅ **Plantilla** para nuevos proyectos
- ✅ **Referencia** de sintaxis correcta
- ✅ **Prueba de regresión** al modificar la gramática
- ✅ **Ejemplo educativo** para nuevos usuarios
