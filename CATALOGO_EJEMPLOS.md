# 📚 CATÁLOGO DE EJEMPLOS

## Archivos de ejemplo disponibles en el proyecto

---

### 1. **codigo_prueba.txt** ⭐ (Principal)
**Tema:** Sistema de gestión empresarial  
**Base de datos:** Empresa  
**Tabla:** Productos  
**Campos:** Nombre, Precio, Clave, Descripcion, Stock  
**Elementos:** Título, menú, imágenes, texto, CRUD, acerca de  

---

### 2. **codigo_ejemplo.txt**
**Tema:** Página de reportes de ahorro  
**Base de datos:** Empresa  
**Tabla:** Productos  
**Campos:** Nombre, Precio, Clave, Descripcion  
**Elementos:** Título, menú, imágenes, texto, CRUD, acerca de  

---

### 3. **ejemplo_inventario.txt**
**Tema:** Sistema de inventario online  
**Base de datos:** TiendaOnline  
**Tabla:** Inventario  
**Campos:** CodigoProducto, NombreProducto, Categoria, PrecioCompra, PrecioVenta, Stock, Proveedor, FechaIngreso  
**Elementos:** Título, línea doble, menú, imágenes, texto, CRUD complejo, acerca de  

---

### 4. **ejemplo_biblioteca.txt** ⭐ (Avanzado - 2 CRUDs)
**Tema:** Biblioteca virtual  
**Base de datos:** BibliotecaDB  
**Tablas:**
- Libros (ISBN, Titulo, Autor, Editorial, AñoPublicacion, Categoria, Disponibles)
- Usuarios (NumeroSocio, Nombre, Email, Telefono, FechaRegistro)  
**Elementos:** Múltiples CRUD, imágenes, texto descriptivo, acerca de  

---

## 🎯 Cómo usar estos ejemplos

### **En la GUI:**
1. Abrir `IniciarGUI.bat`
2. Clic en "Abrir Archivo"
3. Seleccionar cualquier ejemplo
4. Clic en "Compilar"
5. Ver resultado en pestañas

### **Por consola:**
```powershell
# Ejemplo 1
java -cp "..\ANTLR\antlr-3.5.2-complete.jar;." test codigo_prueba.txt resultado1

# Ejemplo 2
java -cp "..\ANTLR\antlr-3.5.2-complete.jar;." test ejemplo_inventario.txt resultado2

# Ejemplo 3 (Avanzado)
java -cp "..\ANTLR\antlr-3.5.2-complete.jar;." test ejemplo_biblioteca.txt resultado3
```

---

## 💡 Ideas para crear tus propios ejemplos

### **Temas sugeridos:**
- 🏥 Sistema hospitalario (Pacientes, Citas, Médicos)
- 🏫 Sistema escolar (Alumnos, Calificaciones, Materias)
- 🚗 Agencia de autos (Vehiculos, Ventas, Clientes)
- 🍕 Restaurante (Menu, Pedidos, Mesas)
- 🏨 Hotel (Reservaciones, Habitaciones, Huespedes)
- 🎬 Cine (Peliculas, Funciones, Boletos)
- 💪 Gimnasio (Miembros, Rutinas, Pagos)
- 📱 Tienda de electrónica (Productos, Ventas, Garantias)

---

## 🎨 Elementos que puedes combinar

```
✅ linea simple / linea doble
✅ titulo "Tu título aquí"
✅ menu opciones
✅ seccion imagenes + lista de imágenes
✅ texto "Tu texto aquí"
✅ crud inicio ... crud fin (puedes tener varios)
✅ seccion acercade (domicilio, telefono, email)
```

---

## 📝 Plantilla básica

```
Inicio pagina
    titulo "Tu Título"
    linea simple
    menu opciones
    texto "Descripción de tu sitio"
    crud inicio
        bdd TuBaseDeDatos
        tabla TuTabla
            campo Campo1
            campo Campo2
            campo Campo3
        fintabla
    crud fin
    seccion acercade
        domicilio: "Tu dirección"
        telefono: "Tu teléfono"
        email: "tu@email.com"
fin pagina
```

---

## ✨ Tips para mejores resultados

1. **Nombres descriptivos:** Usa nombres claros para base de datos y tablas
2. **Múltiples tablas:** Puedes tener varios bloques `crud inicio...crud fin`
3. **Imágenes:** Asegúrate que los nombres de imagen tengan extensión (.jpg, .png)
4. **Textos:** Usa comillas dobles `"texto"` para todos los strings
5. **Estructura:** Mantén la indentación para mejor legibilidad

---

¡Experimenta y crea tus propios ejemplos! 🚀
