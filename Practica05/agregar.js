function leer() {
    return document.getElementById("todo").value
}

function agregar() {
    if(!buscar()){
    nodo = document.createElement("li")
    texto = document.createTextNode(leer())
    nodo.appendChild(texto)
    document.getElementById("lista").appendChild(nodo)
    }
}

function buscar(){
    listaTodo = document.getElementsByTagName("li")
    for (const elemento of listaTodo) {
        if (elemento.textContent == leer()){
            console.log("Existe",elemento)
            window.alert("Existe el elemento en la lista")
            return true
        }
    }

}