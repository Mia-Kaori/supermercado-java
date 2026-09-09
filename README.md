# Interfaz Supermercado

Aplicación Java con interfaz gráfica (dos ventanas) para gestionar la compra y devolución de productos de un supermercado. Los productos se gestionan mediante arrays, no con variables independientes.

## Ventanas

- **Ventana 1**: selección de producto (p. ej. checkboxes tipo `macarrones.isSelected()`) y cantidad, con botones para **Comprar** y **Devolver**.
- **Ventana 2**: resumen con las unidades acumuladas por producto y el importe total.

## Funcionamiento

- **Comprar**: suma la cantidad indicada al concepto correspondiente en la ventana 2 y actualiza el importe total.
- **Devolver**: resta la cantidad indicada del concepto correspondiente y actualiza el importe total.
- Si se intenta devolver más unidades de las que hay registradas, se muestra una ventana emergente indicando que no es posible (mostrando cuántas quedan) y no se resta nada.

## Estructura de datos

- Array de productos/etiquetas (nombre, precio, etc.).
- Array paralelo con el índice de cada producto para identificar su posición al comprar/devolver.

## Autor

**Kaori** — DAW 2025/2026  
[GitHub](https://github.com/Mia-Kaori)
