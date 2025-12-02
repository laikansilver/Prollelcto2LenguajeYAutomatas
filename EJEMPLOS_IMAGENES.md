# Ejemplos con Imágenes

## Archivos de ejemplo creados:

### 1. ejemplo_con_imagenes.txt
- Muestra 3 imágenes en galería normal
- Usa: `producto1.jpg`, `producto2.jpg`, `producto3.jpg`

### 2. ejemplo_carrusel.txt  
- Muestra 5 imágenes (más de 3 activa automáticamente el carrusel)
- Usa: `banner1.jpg` a `banner5.jpg`

## Cómo usar:

### Opción 1: Con imágenes reales
1. Coloca tus imágenes (JPG, PNG) en la carpeta del proyecto
2. Asegúrate que los nombres coincidan con los del ejemplo
3. Ejecuta el compilador

### Opción 2: Con imágenes placeholder online
Modifica el HTML generado (salida.html) y reemplaza las rutas de imagen con URLs de placeholder:

```html
<!-- Reemplaza -->
<img src="producto1.jpg" alt="Imagen">

<!-- Por -->
<img src="https://via.placeholder.com/800x400/FF6B6B/FFFFFF?text=Producto+1" alt="Imagen">
```

## URLs de placeholder útiles:

- `https://via.placeholder.com/800x400/FF6B6B/FFFFFF?text=Texto+Aqui`
- `https://picsum.photos/800/400` (imágenes aleatorias)
- `https://dummyimage.com/800x400/000/fff&text=Mi+Texto`

## Compilar los ejemplos:

```batch
# Ejemplo con 3 imágenes (galería normal)
java -cp ".;C:\ANTLR\antlr-3.5.2-complete.jar" test ejemplo_con_imagenes.txt demo1

# Ejemplo con 5 imágenes (carrusel automático) 
java -cp ".;C:\ANTLR\antlr-3.5.2-complete.jar" test ejemplo_carrusel.txt demo2
```

## Diferencia entre galería y carrusel:

- **2-3 imágenes**: Se muestran en galería horizontal
- **4+ imágenes**: Se activa automáticamente el carrusel con:
  - Botones de navegación (< >)
  - Indicadores (puntos)
  - Avance automático cada 5 segundos
  - Animaciones suaves

## Nota:
El carrusel se genera automáticamente cuando hay más de 3 imágenes en la sección de imágenes.
