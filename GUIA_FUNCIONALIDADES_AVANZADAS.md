# 🎨 Ejemplos Avanzados - Colores, Enlaces y Tablas Interactivas

## 📋 Descripción General

Este proyecto demuestra cómo implementar **tres funcionalidades avanzadas** en páginas web generadas con WebPageLanguage:

1. **🎨 Personalización de Colores** (fondo y texto)
2. **🔗 Enlaces a Sitios Externos**  
3. **📊 Tabla Interactiva** con registro y modificación de datos en tiempo real

## 📂 Archivos Incluidos

### 1. `ejemplo_colores_enlaces.txt`
Código fuente que genera una página con:
- Colores de fondo personalizados (degradados y sólidos)
- Enlaces externos clickeables
- Múltiples secciones con diferentes estilos

**Cómo ejecutar:**
```powershell
java -cp ".;C:\ANTLR\antlr-3.5.2-complete.jar" test ejemplo_colores_enlaces.txt demo_colores
start demo_colores.html
```

### 2. `tabla_interactiva.html`
Página HTML standalone con tabla completamente funcional que permite:
- ✅ Agregar registros
- ✅ Editar registros existentes
- ✅ Eliminar registros
- ✅ Persistencia en localStorage (los datos se guardan en el navegador)
- ✅ Estadísticas en tiempo real

**Cómo usar:**
```powershell
start tabla_interactiva.html
```

## 🎨 Funcionalidad 1: Colores Personalizados

### Sintaxis Actual (usando `texto`)

Para cambiar colores de fondo y texto, usa HTML inline dentro de `texto`:

```
texto "<div style='padding:20px;background:#2ecc71;color:white;border-radius:10px;margin:20px 0'><h3 style='color:white'>Título Verde</h3><p>Contenido con fondo verde</p></div>"
```

### Ejemplos de Colores

#### Degradado Azul-Morado
```
texto "<div style='background:linear-gradient(135deg,#667eea,#764ba2);color:white;padding:20px;border-radius:10px'><h3>Título</h3><p>Contenido</p></div>"
```

#### Fondo Verde (#2ecc71)
```
texto "<div style='background:#2ecc71;color:white;padding:20px'><p>Información positiva</p></div>"
```

#### Fondo Rojo (#e74c3c)
```
texto "<div style='background:#e74c3c;color:white;padding:20px'><p>Alerta o advertencia</p></div>"
```

#### Fondo Naranja (#f39c12)
```
texto "<div style='background:#f39c12;color:white;padding:20px'><p>Atención importante</p></div>"
```

### Paleta de Colores Recomendada

| Color | Código | Uso Recomendado |
|-------|--------|-----------------|
| Verde | `#2ecc71` | Éxito, confirmación |
| Rojo | `#e74c3c` | Errores, advertencias |
| Azul | `#3498db` | Información general |
| Naranja | `#f39c12` | Precaución, atención |
| Morado | `#9b59b6` | Destacados especiales |
| Gris | `#95a5a6` | Información secundaria |

## 🔗 Funcionalidad 2: Enlaces Externos

### Sintaxis

```
texto "<p style='padding:15px;background:#e8f4f8;border-left:4px solid #2196F3'><strong>Nombre:</strong> <a href='https://www.ejemplo.com' target='_blank'>Visitar Sitio</a></p>"
```

### Ejemplos Reales

#### Google
```
texto "<p style='padding:15px;background:#e8f4f8'><strong>Google:</strong> <a href='https://www.google.com' target='_blank'>Buscar</a></p>"
```

#### GitHub
```
texto "<p style='padding:15px;background:#e8f4f8'><strong>GitHub:</strong> <a href='https://www.github.com' target='_blank'>Repositorios</a></p>"
```

#### YouTube
```
texto "<p style='padding:15px;background:#e8f4f8'><strong>YouTube:</strong> <a href='https://www.youtube.com' target='_blank'>Videos</a></p>"
```

### Parámetros del Enlace

- `href='URL'` - Dirección del enlace
- `target='_blank'` - Abre en nueva pestaña
- `style='...'` - Estilos CSS personalizados

## 📊 Funcionalidad 3: Tabla Interactiva

### Características

✅ **Agregar Registros**
- Formulario con múltiples campos
- Validación de datos requeridos
- ID autoincremental

✅ **Editar Registros**
- Modal prompt para cada campo
- Actualización en tiempo real
- Conserva ID original

✅ **Eliminar Registros**
- Confirmación antes de eliminar
- Actualización inmediata de la tabla

✅ **Persistencia de Datos**
- Los datos se guardan en localStorage del navegador
- Se recuperan automáticamente al recargar la página
- No requiere base de datos externa

✅ **Estadísticas**
- Total de registros
- Último ID generado
- Actualización automática

### Estructura de la Tabla

```javascript
{
    id: 1,                          // Autoincremental
    matricula: "18120123",          // Campo personalizado
    nombre: "Juan",                 // Campo personalizado
    apellido: "Pérez",              // Campo personalizado
    carrera: "Sistemas",            // Campo personalizado
    promedio: "8.5",                // Campo personalizado
    correo: "juan@ejemplo.com"      // Campo personalizado
}
```

### Funciones JavaScript Principales

#### agregarEstudiante()
```javascript
function agregarEstudiante() {
    // Crea un objeto con los datos del formulario
    // Valida campos requeridos
    // Agrega al array
    // Guarda en localStorage
    // Actualiza la vista
}
```

#### editarEstudiante(index)
```javascript
function editarEstudiante(index) {
    // Muestra prompts para cada campo
    // Actualiza el objeto en el array
    // Guarda cambios
    // Actualiza la tabla
}
```

#### eliminarEstudiante(index)
```javascript
function eliminarEstudiante(index) {
    // Confirma la acción
    // Elimina del array
    // Guarda cambios
    // Actualiza la tabla
}
```

## 🚀 Ejemplo Completo Integrado

Archivo: `ejemplo_colores_enlaces.txt`

```
Inicio pagina

titulo "Sistema Web Avanzado"

texto "Bienvenido"

// COLORES PERSONALIZADOS
texto "<div style='background:#2ecc71;color:white;padding:20px'>Fondo Verde</div>"

// ENLACES EXTERNOS
texto "<p><a href='https://www.google.com' target='_blank'>Google</a></p>"

// CRUD TRADICIONAL
crud inicio
    bdd mi_base
    tabla Estudiantes
    campo matricula
    campo nombre
    fintabla
crud fin

fin pagina
```

## 🎯 Casos de Uso

### 1. Página Corporativa
- Colores del tema de la empresa
- Enlaces a redes sociales
- Formulario de contacto interactivo

### 2. Sistema Escolar
- Tabla de estudiantes editable
- Enlaces a recursos educativos
- Secciones con colores por área

### 3. E-commerce
- Productos con colores llamativos
- Enlaces a páginas de compra
- Tabla de inventario actualizable

### 4. Blog Personal
- Secciones con fondos personalizados
- Enlaces a artículos externos
- Comentarios en tabla interactiva

## 💡 Tips y Mejores Prácticas

### Colores
1. Usa contraste adecuado (texto claro en fondo oscuro)
2. Mantén una paleta consistente (máximo 5 colores)
3. Usa degradados con moderación
4. Prueba en diferentes pantallas

### Enlaces
1. Siempre usa `target='_blank'` para sitios externos
2. Añade estilos hover para mejor UX
3. Usa iconos cuando sea posible
4. Agrupa enlaces relacionados

### Tablas
1. Valida datos antes de agregar
2. Proporciona feedback visual
3. Confirma acciones destructivas (eliminar)
4. Mantén el código JavaScript limpio y documentado
5. Considera límites de localStorage (generalmente 5-10 MB)

## 🔧 Personalización

### Cambiar Campos de la Tabla

Edita `tabla_interactiva.html`:

1. **HTML del formulario** (líneas 85-103)
2. **Encabezados de tabla** (líneas 110-120)  
3. **Objeto JavaScript** (líneas 140-148)
4. **Función agregarEstudiante** (líneas 140-170)

### Cambiar Estilos

Modifica la sección `<style>` (líneas 7-150):
- Colores principales
- Tamaños de fuente
- Espaciados
- Sombras y bordes

## 📝 Notas Importantes

1. **localStorage** tiene límite de almacenamiento (varía por navegador)
2. Los datos son **locales al navegador** (no se sincronizan entre dispositivos)
3. Limpiar caché del navegador **eliminará los datos**
4. Para producción, considera usar una base de datos real

## 🎓 Ejercicios Propuestos

1. Agrega más campos a la tabla (teléfono, fecha de nacimiento)
2. Implementa búsqueda/filtrado de registros
3. Añade ordenamiento por columnas
4. Exporta los datos a CSV
5. Implementa paginación para muchos registros
6. Agrega validación de formato de email
7. Crea gráficas con los datos (usando Chart.js)

## ✅ Checklist de Funcionalidades

- [x] Colores de fondo personalizados
- [x] Colores de texto personalizados
- [x] Degradados CSS
- [x] Enlaces externos funcionales
- [x] Tabla con agregar registros
- [x] Tabla con editar registros
- [x] Tabla con eliminar registros
- [x] Persistencia localStorage
- [x] Estadísticas en tiempo real
- [x] Diseño responsive
- [x] Validación de formularios
- [x] Confirmación de acciones

## 📚 Recursos Adicionales

- [MDN Web Docs - CSS Colors](https://developer.mozilla.org/es/docs/Web/CSS/color)
- [MDN Web Docs - HTML Links](https://developer.mozilla.org/es/docs/Web/HTML/Element/a)
- [MDN Web Docs - localStorage](https://developer.mozilla.org/es/docs/Web/API/Window/localStorage)
- [Google Fonts](https://fonts.google.com/)
- [Coolors - Paletas de Colores](https://coolors.co/)

---

**Creado por:** Sistema WebPageLanguage  
**Fecha:** Diciembre 2025  
**Versión:** 2.0
