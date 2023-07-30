/**
 * 
 */
  function cerrarSesion() {
	  console.log("apretando el boton de cerrar sesion")
    window.location.href = "logout";
  }

    function confirmarYCerrarSesion() {
      if (confirm("¿Estás seguro de que deseas salir?")) {
        cerrarSesion();
      }
      // Si el usuario cancela el mensaje de confirmación, no cerrará sesión.
      return false;
    }


function validarFormulario(e) { // Agrega el parámetro 'e' para capturar el evento
  e.preventDefault(); // Previene el envío del formulario por defecto

  const nombreInput = document.getElementById('nombre');
  const detalleInput = document.getElementById('detalle');
  const lugarInput = document.getElementById('lugar');
  const asistentesInput = document.getElementById('cantidadAsistentes');

  const nombreValue = nombreInput.value.trim();
  const detalleValue = detalleInput.value.trim();
  const lugarValue = lugarInput.value.trim();
  const asistentesValue = asistentesInput.value.trim();
  
  console.log(nombreValue);
  console.log(detalleValue);
  console.log(lugarValue);
  console.log(asistentesValue);
  

  if (nombreValue.length < 3 || nombreValue.length > 50) {
    mostrarError(nombreInput, 'El nombre debe tener entre 3 y 50 caracteres');
    return; // Detiene la ejecución de la función si hay un error
  }

  if (detalleValue.length < 10 || detalleValue.length > 200) {
    mostrarError(detalleInput, 'El detalle debe tener entre 10 y 200 caracteres');
    return;
  }

  if (lugarValue.length < 10 || lugarValue.length > 50) {
    mostrarError(lugarInput, 'El lugar debe tener entre 10 y 50 caracteres');
    return;
  }

  if (isNaN(asistentesValue) || parseInt(asistentesValue) < 0 || parseInt(asistentesValue) >= 1000) {
    mostrarError(asistentesInput, 'La cantidad de asistentes debe ser un número entero menor que 1000');
    return;
  }

  // Si no hay errores, puedes enviar el formulario aquí
  document.querySelector('form').submit();
}

function mostrarError(input, mensaje) {
  const formControl = input.parentElement;
  let errorMensaje = formControl.querySelector('.error-mensaje');

  if (!errorMensaje) {
    errorMensaje = document.createElement('div');
    errorMensaje.className = 'error-mensaje';
    formControl.appendChild(errorMensaje);
  }

  errorMensaje.innerText = mensaje;
  formControl.className = 'form-control error';
}

  // Obtenemos la URL actual
  var currentURL = window.location.href;

  // Verificamos si la URL contiene '/inicio.jsp'
  if (currentURL.indexOf('/inicio.jsp') !== -1) {
    // Si es así, agregamos la clase 'active' al enlace correspondiente
    document.getElementById('inicio-link').classList.add('active');
    console.log("conexion a inicio");
  }
  
  

function mostrarCampos() {
        var tipoUsuario = document.getElementsByName("tipo")[0].value;

        // Ocultar todos los campos
        var campos = document.getElementsByClassName("cliente-fields");
        for (var i = 0; i < campos.length; i++) {
            campos[i].classList.add("hidden");
        }

        campos = document.getElementsByClassName("administrativo-fields");
        for (var i = 0; i < campos.length; i++) {
            campos[i].classList.add("hidden");
        }

        campos = document.getElementsByClassName("profesional-fields");
        for (var i = 0; i < campos.length; i++) {
            campos[i].classList.add("hidden");
        }

        // Mostrar solo el campo correspondiente al tipo de usuario seleccionado
        if (tipoUsuario === "Cliente") {
            campos = document.getElementsByClassName("cliente-fields");
        } else if (tipoUsuario === "Administrativo") {
            campos = document.getElementsByClassName("administrativo-fields");
        } else if (tipoUsuario === "Profesional") {
            campos = document.getElementsByClassName("profesional-fields");
        }

        for (var i = 0; i < campos.length; i++) {
            campos[i].classList.remove("hidden");
        }
    }

    var urlActual = window.location.href;
    var elementosNav = document.getElementsByClassName('nav-link');

    for (var i = 0; i < elementosNav.length; i++) {
      var elemento = elementosNav[i];
      var urlElemento = elemento.getAttribute('href');

      if (urlActual.includes(urlElemento)) {
        elemento.classList.add('active');
      }
    }

