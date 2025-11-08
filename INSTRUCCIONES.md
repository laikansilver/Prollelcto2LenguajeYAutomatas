# INSTRUCCIONES RÁPIDAS - Compilador Web CRUD

## 🚀 INICIO RÁPIDO

### Para ejecutar el IDE:
```
Hacer doble clic en: IniciarGUI.bat
```

### Para compilar por consola:
```powershell
java -cp "..\ANTLR\antlr-3.5.2-complete.jar;." test codigo_prueba.txt salida
```

---

## 📝 SINTAXIS DEL LENGUAJE

```
Inicio pagina
    linea simple
    titulo "Título de la página"
    menu opciones
    seccion imagenes
        imagen1.jpg
        imagen2.png
    texto "Texto descriptivo aquí"
    crud inicio
        bdd NombreBaseDatos
        tabla NombreTabla
            campo Campo1
            campo Campo2
        fintabla
    crud fin
    seccion acercade
        domicilio: "Dirección"
        telefono: "Teléfono"
        email: "correo@mail.com"
fin pagina
```

---

## 🔧 SI NECESITAS RECOMPILAR

```powershell
# 1. Compilar gramática (solo si la modificaste)
java -jar "..\ANTLR\antlr-3.5.2-complete.jar" WebPageLanguage.g

# 2. Compilar clases Java
javac -cp "..\ANTLR\antlr-3.5.2-complete.jar;." *.java
```

---

## 📂 ARCHIVOS GENERADOS

Después de compilar obtendrás:
- `salida.html` - Página web completa
- `salida.css` - Estilos CSS
- `salida_crud.txt` - Especificación para PHP (Unidad 4)

---

## ✅ CARACTERÍSTICAS

✔️ Generación automática de HTML5 + CSS3  
✔️ Validación sintáctica  
✔️ IDE gráfico intuitivo  
✔️ Especificación CRUD para implementación futura  
✔️ Vista previa en navegador  

---

Ver **README.md** para documentación completa.
