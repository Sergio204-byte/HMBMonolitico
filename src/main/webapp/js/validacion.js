/**
 * 
 */

function validarIntento() {
    let intento = document.getElementById("intento").value;
    
    if (intento === "" || isNaN(intento) || intento < 1 || intento > 100) {
        alert("¡Cuidado! Debes ingresar un número válido entre 1 y 100.");
        return false; // Detiene el envío del formulario
    }
    return true; // Permite que lServletos datos viajen al 
}